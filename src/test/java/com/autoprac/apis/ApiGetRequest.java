package com.autoprac.apis;

import java.io.IOException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.autoprac.common.Base;
import com.autoprac.common.ExcelUtil;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class ApiGetRequest extends Base{
	
	protected static String filePath = projectPath+"//testDataFiles//TestApis.xlsx";
	
	@BeforeSuite
	public static void beforeSuite() throws IOException {
		ExcelUtil.getExcel(filePath);
	}
	
	@Test(dataProvider = "apitestdata")
	public static void getDetails(String apiurl, String apiparameter) throws IOException {
		//API URl
		RestAssured.baseURI = apiurl;
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object
		Response response = httpRequest.request(Method.GET,apiparameter);
		
		//Print
		String responseBody = response.getBody().asString();
		log.info(apiurl+apiparameter);
		ExcelUtil.writeIntoExcel(filePath, responseBody);

	}
	
	
	
	@DataProvider
	public Object[][] apitestdata() throws IOException{
		ExcelUtil.getSheet(0);
		return ExcelUtil.getData();
	}
}
