package com.autoprac.apis;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.autoprac.common.Base;
import com.autoprac.common.CommomMethods;
import com.autoprac.utilities.ExcelUtil;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class ApiAllRequest extends Base{

	protected static String filePath = projectPath+"//testDataFiles//TestApis.xlsx";
	protected static Response response = null;
	protected static RequestSpecification httpRequest;

	@Test(priority = 1)
	public static void setExcel() throws IOException {
		ExcelUtil.getExcel(filePath);
	}


	@Test(priority = 2, dataProvider = "apiTestData")
	public static void getDetails(String sno, String description, String apiurl, String page, String id, String method, String email, String job, String name, String password, String responsedata, String responseCode) throws IOException {

		//API URl
		RestAssured.baseURI = apiurl; 

		//Request Object
		httpRequest = RestAssured.given(); 

		if (method.equalsIgnoreCase("get")) {
			response = httpRequest.request(Method.GET,page+id);
		} else if(method.equalsIgnoreCase("post")) {
			postAndPut(email, job, name, password);
			response = httpRequest.request(Method.POST,page);
		} else if (method.equalsIgnoreCase("put")) {
			postAndPut(email, job, name, password);
			response = httpRequest.request(Method.PUT,page+id);
		} else if (method.equalsIgnoreCase("delete")) {
			response = httpRequest.request(Method.DELETE,page+id);
		}else {
			System.out.println("Not a valid input method");
		}

		//Get Response Body
		String responseBody = response.getBody().asString();

		//Get Response Code
		int statusCode = response.getStatusCode();
		String responseCode2 = Integer.toString(statusCode);

		boolean data = CommomMethods.compareValues(responseBody, responsedata);
		boolean code = CommomMethods.compareValues(responseCode2, responseCode);

		if ((data && code) == true) {
			System.out.println("Api Pass");
		} else {
			System.out.println("Api Fail");
		}
	}


	//Post and Put 
	@SuppressWarnings("unchecked")
	public static void postAndPut(String email, String job, String name, String password) {
		//Request payload
		JSONObject requestparms = new JSONObject();

		requestparms.put("email", email);
		requestparms.put("job", job);
		requestparms.put("name", name);
		requestparms.put("password", password);

		httpRequest.header("Content-Type","application/json");

		//Attach above data to request
		httpRequest.body(requestparms.toJSONString());
	}

	@DataProvider
	public Object[][] apiTestData() throws IOException{
		ExcelUtil.getSheet(3);
		return ExcelUtil.getData();
	}
}
