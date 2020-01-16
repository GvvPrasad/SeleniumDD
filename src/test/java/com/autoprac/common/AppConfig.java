package com.autoprac.common;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.Test;

import com.autoprac.config.EmailReports;

public class AppConfig {

	//Properties Object
	static Properties Prop = new Properties();
	static String ProjectPath = System.getProperty("user.dir");

	//Get Data from AppProperties.properties file
	@Test(priority=0)
	public static void GetProperties() {
		try {
			InputStream Input = new FileInputStream(ProjectPath+"/src/test/java/com/autoprac/config/AppProperties.properties");
			Prop.load(Input);
			
			//Application 
			Base.browserName = Prop.getProperty("Browser");
			Base.urlLink = Prop.getProperty("Url");
			
			//Mail
			EmailReports.SenderMail = Prop.getProperty("SenderMailId");
			EmailReports.SenderPassword = Prop.getProperty("SenderMailPassword");
			EmailReports.ReceiverMail = Prop.getProperty("ReceiverMailId");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		// End of getting data from properties file


	}
}
