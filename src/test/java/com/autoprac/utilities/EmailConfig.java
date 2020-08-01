package com.autoprac.utilities;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.testng.annotations.Test;

import com.autoprac.config.ObjectRespo;
import com.autoprac.config.PropertiesFile;


public class EmailConfig extends ObjectRespo{	
	
	@Test
	public static void email(){	
					
		// Create object of Property file
		Properties props = new Properties();
		PropertiesFile.GetProperties();
		
		// this will set host of server
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "587");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", "587");

		// This will handle the complete authentication
		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(ObjectRespo.senderMail, ObjectRespo.senderPassword);
			}
		});

		try {
			// Create object of MimeMessage class
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(ObjectRespo.senderMail));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(ObjectRespo.receiverMail));

			// Add the subject 
			message.setSubject(ObjectRespo.mailSubject);

			// Create object to add content
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(ObjectRespo.mailContent);

			
			// Create another object to add Attachment
			MimeBodyPart messageBodyPart1 = new MimeBodyPart();
			DataSource source = new FileDataSource(ReportsGeneration.htmlReport);
			messageBodyPart1.setDataHandler(new DataHandler(source));
			messageBodyPart1.setFileName(ReportsGeneration.htmlReport);
			
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
			DataSource source1 = new FileDataSource(ReportsGeneration.excelReport);
			messageBodyPart2.setDataHandler(new DataHandler(source1));
			messageBodyPart2.setFileName(ReportsGeneration.excelReport);
					
			// Create object of MimeMultipart class
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			//multipart.addBodyPart(messageBodyPart1);
			//multipart.addBodyPart(messageBodyPart2);

			// set the content
			message.setContent(multipart);

			// finally send the email
			Transport.send(message);

			System.out.println("=====Email Sent=====");

		} catch (MessagingException e) {
			System.out.println("=====Email did not Sent=====");
			throw new RuntimeException(e);
		}
	}
}