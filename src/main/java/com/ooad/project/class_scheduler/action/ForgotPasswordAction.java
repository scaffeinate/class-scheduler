package com.ooad.project.class_scheduler.action;

import com.ooad.project.class_scheduler.util.EmailUtil;
import com.opensymphony.xwork2.ActionSupport;

public class ForgotPasswordAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String email;
	private EmailUtil emailUtil;

	public ForgotPasswordAction() {
		emailUtil = new EmailUtil();
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
		emailUtil.sendForgotPassword(email, getText("messages.forgot.password"), getText("messages.forgot.text"));        
		return SUCCESS;
	}
}
