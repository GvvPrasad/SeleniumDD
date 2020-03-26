package com.autoprac.apis;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.autoprac.common.Base;


public class ReadJson extends Base{
	
	private static String filePath = projectPath+"//testDataFiles//TestJson.json";
	
	@Test
	public static void getJsonData() throws IOException, ParseException {
		JSONParser jsonparser = new JSONParser();
		FileReader reader = new FileReader(filePath);
		
		Object obj = jsonparser.parse(reader);
		
		JSONObject empobj = (JSONObject) obj;
		
		String firstname = (String) empobj.get("firstName");
		System.out.println(firstname);
		
		JSONArray array = (JSONArray) empobj.get("address");
		System.out.println(array);
		
		for (int i = 0; i < array.size(); i++) {
			JSONObject address = (JSONObject) array.get(i);
			
			String street = (String) address.get("street");
			String city = (String) address.get("city");
			String state = (String) address.get("state");
			
			System.out.println("street: " + street);
			System.out.println("city: " + city);
			System.out.println("state: " + state);
		}
	}
}