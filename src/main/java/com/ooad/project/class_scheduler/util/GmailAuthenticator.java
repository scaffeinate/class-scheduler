package com.ooad.project.class_scheduler.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class GmailAuthenticator extends Authenticator{

	private String email, password;
	
	public GmailAuthenticator(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		// TODO Auto-generated method stub
		return new PasswordAuthentication(email, password);
	}

}
