package com.ooad.project.class_scheduler.action;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.ooad.project.class_scheduler.util.EmailUtil;
import com.ooad.project.class_scheduler.util.GmailAuthenticator;
import com.opensymphony.xwork2.ActionSupport;

public class ForgotPasswordAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String email;
	private EmailUtil emailUtil;

	public ForgotPasswordAction() {
		emailUtil = new EmailUtil();
		emailUtil.setMailerProperties();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Session session = Session.getInstance(emailUtil.getProperties(), new GmailAuthenticator("ooad.utd3@gmail.com", "adminooad"));
		
		Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("ooad.utd3@gmail.com"));
        message.setRecipients(Message.RecipientType.TO, 
           InternetAddress.parse(email));
        message.setSubject("Test");
        message.setText("Body");
        Transport.send(message);
        
		return SUCCESS;
	}
}
