package com.ooad.project.class_scheduler.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtil {

	private Properties properties;
	private Session session;

	public EmailUtil() {
		properties = new Properties();
		setMailerProperties();
		session = Session.getInstance(getProperties(), new GmailAuthenticator("ooad.utd3@gmail.com", "adminooad"));
	}

	private void setMailerProperties() {
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.socketFactory.port", "587");
		properties.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "587");
	}

	public boolean sendForgotPassword(String email, String subject, String body) {

		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress("ooad.utd3@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, 
					InternetAddress.parse(email));
			message.setSubject(subject);
			message.setText(body);
			Transport.send(message);
			return true;
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}
}
