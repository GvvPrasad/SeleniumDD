package com.autoprac.apis;

import java.io.IOException;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.autoprac.common.Base;
import com.autoprac.utilities.ExcelUtil;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class ApiPutRequest extends Base{

	private static String filePath = projectPath+"//testDataFiles//TestApis.xlsx";

	@Test(priority = 1)
	public static void setExcel() throws IOException {
		ExcelUtil.getExcel(filePath);
	}

	
	@SuppressWarnings({ "unchecked", "unused" })
	@Test(priority = 2, dataProvider = "apitestdata")
	public static void postDetails(String sno, String description, String baseurl, String page, String id, String email, String job, String name, String password, String responsedata, String responseCode) {

		//API URl
		RestAssured.baseURI = baseurl;

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
		Response response = httpRequest.request(Method.PUT,page+id);

		//Get Response Body
		String responseBody = response.getBody().asString();

		//Get Response Code
		int statusCode = response.getStatusCode();
	}


	@DataProvider
	public Object[][] apitestdata() throws IOException{
		ExcelUtil.getSheet(2);
		return ExcelUtil.getData();
	}
}