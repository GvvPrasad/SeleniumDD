package com.autoprac.utilities;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.Test;

import com.autoprac.common.Base;


public class AppConfig {

	//Properties Object
	static Properties prop = new Properties();
	static String projectPath = System.getProperty("user.dir");
	static String propertiesPath = projectPath+"/src/test/java/com/autoprac/config/";

	
	//Get Data from AppProperties.properties file
	@Test(priority=0)
	public static void getProperties() {
		try {
			InputStream applicationProp = new FileInputStream(propertiesPath+"AppProperties.properties");
			prop.load(applicationProp);
			
			InputStream emailProp = new FileInputStream(propertiesPath+"EmailProperties.properties");
			prop.load(emailProp);
			
			//Application 
			Base.browserName = prop.getProperty("Browser");
			Base.urlLink = prop.getProperty("Url");
			
			//Mail
			EmailConfig.senderMail = prop.getProperty("SenderMailId");
			EmailConfig.senderPassword = prop.getProperty("SenderMailPassword");
			EmailConfig.receiverMail = prop.getProperty("ReceiverMailId");
			EmailConfig.mailSubject = prop.getProperty("MailSubject");
			EmailConfig.mailContent = prop.getProperty("MailContent");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		// End of getting data from properties file
	}
}
