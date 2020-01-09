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
			String browserName = Prop.getProperty("Browser");
			String urlLink = Prop.getProperty("Url");
			Base.browserName = browserName;
			Base.urlLink = urlLink;
			
			//Mail
			String SenderMail = Prop.getProperty("SenderMailId");
			String SenderPassword = Prop.getProperty("SenderMailPassword");
			String ReceiverMail = Prop.getProperty("ReceiverMailId");
			EmailReports.SenderMail = SenderMail;
			EmailReports.SenderPassword = SenderPassword;
			EmailReports.ReceiverMail = ReceiverMail;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		// End of getting data from properties file


	}
}
