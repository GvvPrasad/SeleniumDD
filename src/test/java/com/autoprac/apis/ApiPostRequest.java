package com.autoprac.apis;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiPostRequest {

	@Test
	public static void postCustomerDetails() {
		//API URl
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";

		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Request payload
		JSONObject requestparms = new JSONObject();
		
		requestparms.put("FirstName", "gvv");
		requestparms.put("LastName", "Jh");
		requestparms.put("UserName", "Johnjh");
		requestparms.put("Password", "John123");
		requestparms.put("Email", "gvv@gmail.com");
		
		httpRequest.header("Content-Type","application/json");
		
		//Attach above data to request
		httpRequest.body(requestparms.toJSONString());
		
		//Response Object
		Response response = httpRequest.request(Method.POST,"/register");

		//Print
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
	}
}
