package com.autoprac.apis;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiGetRequest {
	
	@Test
	public static void getWeatherDetails() {
		//API URl
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object
		Response response = httpRequest.request(Method.GET,"/Hyderabad");
		
		//Print
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
	}
}
