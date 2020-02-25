package com.autoprac.testscripts;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiTest {
	
	@Test
	public static void userList() {
		Response data = RestAssured.get("https://reqres.in/api/users?page=2");
		String apidata = data.asString();
		System.out.println(apidata);
	}
}
