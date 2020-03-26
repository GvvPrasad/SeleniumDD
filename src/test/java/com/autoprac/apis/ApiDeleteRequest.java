package com.autoprac.apis;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.autoprac.common.Base;
import com.autoprac.utilities.ExcelUtil;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class ApiDeleteRequest extends Base{

	//Global variables
	private static String filePath = projectPath+"//testDataFiles//TestApis.xlsx";

	@Test(priority = 1)
	public static void setExcel() throws IOException {
		ExcelUtil.getExcel(filePath);
	}


	@SuppressWarnings("unused")
	@Test(priority = 2, dataProvider = "apitestdata")
	public static void getDetails(String sno, String description, String baseurl, String page, String id, String responsedata, String responseCode) throws IOException {

		//API URl
		RestAssured.baseURI = baseurl;

		//Request Object
		RequestSpecification httpRequest = RestAssured.given();

		//Response Object
		Response response = httpRequest.request(Method.DELETE,page+id);

		//Get Response Body
		String responseBody = response.getBody().asString();

		//Get Response Code
		int statusCode = response.getStatusCode();
	}


	@DataProvider
	public Object[][] apitestdata() throws IOException{
		ExcelUtil.getSheet(3);
		return ExcelUtil.getData();
	}
}
