package com.autoprac.apis;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.autoprac.common.Base;
import com.autoprac.common.CommomMethods;
import com.autoprac.utilities.ExcelUtil;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class ApiDeleteRequest extends Base{
	
	protected static String filePath = projectPath+"//testDataFiles//TestApis.xlsx";
	
	@Test(priority = 1)
	public static void setExcel() throws IOException {
		ExcelUtil.getExcel(filePath);
	}
	
	
	@Test(priority = 2, dataProvider = "apitestdata")
	public static void getDetails(String sno, String description, String apiurl, String page, String id, String responsedata, String responseCode) throws IOException {
		
		//API URl
		RestAssured.baseURI = apiurl;
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object
		Response response = httpRequest.request(Method.DELETE,page+id);
		
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
		ExcelUtil.getSheet(3);
		return ExcelUtil.getData();
	}
}
