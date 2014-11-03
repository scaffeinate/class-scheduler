package com.ooad.project.class_scheduler.action;

import com.opensymphony.xwork2.ActionSupport;

public class ForgotPasswordAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String email;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
}
