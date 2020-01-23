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

public class EmailReports {

	//Mail Variables
	public static String SenderMail;
	public static String SenderPassword;
	public static String ReceiverMail;

	public static void main(String[] args) {

		AppConfig.GetProperties();

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
				return new PasswordAuthentication(SenderMail, SenderPassword);
			}
		});

		try {

			// Create object of MimeMessage class
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(SenderMail));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(ReceiverMail));

			// Add the subject 
			message.setSubject("Testing Mail through");

			// Create object to add content
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText("This is message body using java");

			// Mention the file which you want to send
			String filename = "E:\\Dump\\dummyPDF.pdf";
			String filename1 = "E:\\Dump\\Sample.docx";
			String filename2 = "E:\\Dump\\black.jpeg";

			// Create another object to add Attachment
			MimeBodyPart messageBodyPart1 = new MimeBodyPart();
			DataSource source = new FileDataSource(filename);
			messageBodyPart1.setDataHandler(new DataHandler(source));
			messageBodyPart1.setFileName(filename);
			
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
			DataSource source1 = new FileDataSource(filename2);
			messageBodyPart2.setDataHandler(new DataHandler(source1));
			messageBodyPart2.setFileName(filename2);
			
			// Create object of MimeMultipart class
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			multipart.addBodyPart(messageBodyPart1);
			multipart.addBodyPart(messageBodyPart2);

			
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