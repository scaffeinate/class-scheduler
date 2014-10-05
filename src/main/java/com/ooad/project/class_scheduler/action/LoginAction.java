package com.ooad.project.class_scheduler.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;
	private String username, password;
	private Map<String, Object> session;
	
	public String execute() {
		if(this.username.equals("user123") && this.password.equals("admin123")){
			session = ActionContext.getContext().getSession();
			session.put("current_user", username);
			return SUCCESS;
		} else {
			addActionError(getText("errors.login"));
			return ERROR;
		}
	}
	
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		if(getUsername().trim().length() == 0) {
			addFieldError("username", getText("errors.username.required"));
		}
		
		if(getPassword().trim().length() == 0) {
			addFieldError("password", getText("errors.password.required"));
		}
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

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
}
