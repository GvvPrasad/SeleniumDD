package com.autoprac.apis;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.autoprac.config.ObjectRespo;
import com.autoprac.testscripts.Base;
import com.autoprac.utilities.ExcelUtil;

import io.restassured.RestAssured;
import io.restassured.http.Method;


public class ApiTestExcel extends Base{
	
	
	@SuppressWarnings("unused")
	@Test(priority = 0, dataProvider = "apiTestData")
	public static void getDetails(String sno, String description, String baseurl, String page, String id, String method, String email, String job, String name, String password, String responsedata, String responseCode, String result) throws IOException {

		//API URl
		RestAssured.baseURI = baseurl; 

		//Request Object
		httpRequest = RestAssured.given(); 

		String requestmethod = method.toLowerCase();

		switch (requestmethod) {
		case "get":
			response = httpRequest.request(Method.GET,page+id);
			break;
		case "post":
			postAndPut(email, job, name, password);
			response = httpRequest.request(Method.POST,page);
			break;
		case "put":
			postAndPut(email, job, name, password);
			response = httpRequest.request(Method.PUT,page+id);
			break;
		case "delete":
			response = httpRequest.request(Method.DELETE,page+id);
			break;
		default:
			System.out.println("not a valid method");
			break;
		}
		//Get Response Body
		String responseBody = response.getBody().asString();

		//Get Response Code
		int statusCode = response.getStatusCode();
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
		ExcelUtil.getExcel(ObjectRespo.apiFilePath);
		ExcelUtil.getSheet(3);
		return ExcelUtil.getData();
	}
}