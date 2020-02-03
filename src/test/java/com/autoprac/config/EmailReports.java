package com.autoprac.config;

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

public class EmailReports{

	//Mail Variables
	static String senderMail;
	static String senderPassword;
	static String receiverMail;
	static String mailSubject;
	static String mailContent;
	static String projectPath = System.getProperty("user.dir");
	static String filename = projectPath+"/Logs/application.log";

	public static void main(String[] args) {

		AppConfig.getProperties();

		// Create object of Property file
		Properties props = new Properties();

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
				return new PasswordAuthentication(senderMail, senderPassword);
			}
		});

		try {

			// Create object of MimeMessage class
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(senderMail));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(receiverMail));

			// Add the subject 
			message.setSubject(mailSubject);

			// Create object to add content
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(mailContent);

			// Create another object to add Attachment
			MimeBodyPart messageBodyPart1 = new MimeBodyPart();
			DataSource source = new FileDataSource(filename);
			messageBodyPart1.setDataHandler(new DataHandler(source));
			messageBodyPart1.setFileName(filename);
					
			// Create object of MimeMultipart class
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			multipart.addBodyPart(messageBodyPart1);

			// set the content
			message.setContent(multipart);

			// finally send the email
			Transport.send(message);

			System.out.println("=====Email Sent=====");

		} catch (MessagingException e) {

			throw new RuntimeException(e);

		}

	}
}