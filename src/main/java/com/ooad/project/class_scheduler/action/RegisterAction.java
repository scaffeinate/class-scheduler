package com.ooad.project.class_scheduler.action;

import com.ooad.project.class_scheduler.bean.User;
import com.ooad.project.class_scheduler.model.UserModel;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name, email, username, password, 
	password_confirmation, track, school;
	private User user;
	private UserModel userModel;
	
	public RegisterAction() {
		user = new User();
		userModel = new UserModel();
	}
	
	public String execute() {
		user.setName(name);
		user.setEmail(email);
		user.setUsername(username);
		user.setPassword(password);
		user.setTrack(track);
		user.setSchool(school);
		
		if(userModel.insertData(user)) {
			addActionMessage(getText("message.register.success"));
			return SUCCESS;
		} else {
			return ERROR;
		}
		
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub
		if(getName().trim().length() == 0) {
			addFieldError("name", getText("errors.name.required"));
		}
		if(getEmail().trim().length() == 0) {
			addFieldError("email", getText("errors.email.required"));
		}
		if(getTrack().trim().length() == 0) {
			addFieldError("track", getText("errors.track.required"));
		}
		if(getSchool().trim().length() == 0) {
			addFieldError("school", getText("errors.school.required"));
		}
		if(getUsername().trim().length() == 0) {
			addFieldError("username", getText("errors.username.required"));
		}
		if(getPassword().trim().length() == 0) {
			addFieldError("password", getText("errors.password.required"));
		}
		if(getPassword_confirmation().trim().length() == 0) {
			addFieldError("password_confirmation", getText("errors.password_confirmation.required"));
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPassword_confirmation() {
		return password_confirmation;
	}

	public void setPassword_confirmation(String password_confirmation) {
		this.password_confirmation = password_confirmation;
	}

	public String getTrack() {
		return track;
	}

	public void setTrack(String track) {
		this.track = track;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
}
