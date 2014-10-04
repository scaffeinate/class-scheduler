package com.ooad.project.class_scheduler.action;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String username = "", password = "";

	public String execute() {
		if(this.username.equals("user123") && this.password.equals("admin123")){
			return SUCCESS;
		} else {
			addActionError(getText("errors.login"));
			return ERROR;
		}
	}

	
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		super.validate();
	}



	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
