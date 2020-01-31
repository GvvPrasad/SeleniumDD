package com.autoprac.config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.Test;

import com.autoprac.common.Base;
import com.autoprac.testscripts.CheckOut;

public class AppConfig {

	//Properties Object
	static Properties prop = new Properties();
	static String projectPath = System.getProperty("user.dir");

	//Get Data from AppProperties.properties file
	@Test(priority=0)
	public static void getProperties() {
		try {
			InputStream Input = new FileInputStream(projectPath+"/src/test/java/com/autoprac/config/AppProperties.properties");
			prop.load(Input);
			
			//Application 
			Base.browserName = prop.getProperty("Browser");
			Base.urlLink = prop.getProperty("Url");
			
			//Application Login
			CheckOut.emailid = prop.getProperty("EmialId");
			CheckOut.password = prop.getProperty("Password");
			
			//Mail
			EmailReports.senderMail = prop.getProperty("SenderMailId");
			EmailReports.senderPassword = prop.getProperty("SenderMailPassword");
			EmailReports.receiverMail = prop.getProperty("ReceiverMailId");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		// End of getting data from properties file


	}
}
