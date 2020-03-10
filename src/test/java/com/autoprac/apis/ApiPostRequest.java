package com.autoprac.apis;

import java.io.IOException;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.autoprac.common.Base;
import com.autoprac.common.CommomMethods;
import com.autoprac.common.ExcelUtil;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiPostRequest extends Base{

	protected static String filePath = projectPath+"//testDataFiles//TestApis.xlsx";

	@Test(priority = 1)
	public static void setExcel() throws IOException {
		ExcelUtil.getExcel(filePath);
	}

	@SuppressWarnings("unchecked")
	@Test(priority = 2, dataProvider = "apitestdata")
	public static void postDetails(String sno, String description, String apiurl, String page, String email, String job, String name, String password, String responsedata, String responseCode) {

		//API URl
		RestAssured.baseURI = apiurl;

		//Request Object
		RequestSpecification httpRequest = RestAssured.given();

		//Request payload
		JSONObject requestparms = new JSONObject();

		requestparms.put("email", email);
		requestparms.put("job", job);
		requestparms.put("name", name);
		requestparms.put("password", password);
		
		
		httpRequest.header("Content-Type","application/json");

		//Attach above data to request
		httpRequest.body(requestparms.toJSONString());

		//Post Request
		Response response = httpRequest.request(Method.POST,page);

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


	@DataProvider
	public Object[][] apitestdata() throws IOException{
		ExcelUtil.getSheet(1);
		return ExcelUtil.getData();
	}
}
