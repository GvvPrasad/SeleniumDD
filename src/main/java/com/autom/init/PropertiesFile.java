package com.autom.init;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.Test;

import com.autom.init.ObjectRespo;

public class PropertiesFile{

	//Properties Object
	static Properties Prop = new Properties();

	//Get Data from config.properties file
	@Test
	public static void GetProperties() {
		try {
			InputStream Input = new FileInputStream(ObjectRespo.emailProperties);
			Prop.load(Input);

			//Application property values
			ObjectRespo.browser = Prop.getProperty("browser"); 
			ObjectRespo.url = Prop.getProperty("url");

			//DataBase property values
			ObjectRespo.dbUrl = Prop.getProperty("dburl");
			ObjectRespo.dbUser = Prop.getProperty("dbusername");
			ObjectRespo.dbPassword = Prop.getProperty("dbpassword");

			//Email property values
			ObjectRespo.senderMail = Prop.getProperty("sendermail");
			ObjectRespo.senderPassword = Prop.getProperty("senderpassword");
			ObjectRespo.receiverMail = Prop.getProperty("receivermail");
			ObjectRespo.mailSubject = Prop.getProperty("subject");
			ObjectRespo.mailContent = Prop.getProperty("content");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}
	// End of getting data from properties file
}