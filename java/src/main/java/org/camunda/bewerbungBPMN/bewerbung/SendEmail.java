package org.camunda.bewerbungBPMN.bewerbung;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

	public static void sendEmail(String subject, String content, String email) throws MessagingException
	{
		final String username = "testjava159@gmail.com";
	    final String password = "javatest!123";

	    Properties props = new Properties();
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.port", "587");

	    Session session = Session.getInstance(props,
	      new javax.mail.Authenticator() {
	        protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username, password);
	        }
	      });
	    
	    try {

	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress("testjava159@gmail.com"));
	        message.setRecipients(Message.RecipientType.TO,
	            InternetAddress.parse(email));
	        message.setSubject(subject);
	        message.setText(content);

	        Transport.send(message);

	        System.out.println("E-Mail wurde erfolgreich gesendet!");

	    } catch (MessagingException e) {
	        throw new RuntimeException(e);
	    }    
	}

	
}