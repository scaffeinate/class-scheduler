package com.ooad.project.class_scheduler.action;

import java.util.Map;

import com.ooad.project.class_scheduler.bean.User;
import com.ooad.project.class_scheduler.model.UserModel;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ProfileAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private User user;
	private UserModel userModel;
	private Map<String, Object> session;
	private String name, email, username, password, track, school;
	
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

	public ProfileAction() {
		user = new User();
		userModel = new UserModel();
		session = ActionContext.getContext().getSession();
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		user = userModel.fetchUserByUsername((String) session.get("current_user"));
		setName(user.getName());
		setEmail(user.getEmail());
		setTrack(user.getTrack());
		setSchool(user.getSchool());
		setUsername(user.getUsername());
		setPassword(user.getPassword());
		return super.execute();
	}
	
	public String updateProfile() throws Exception {
		user.setName(name);
		user.setEmail(email);
		user.setUsername(username);
		user.setPassword(password);
		user.setTrack(track);
		user.setSchool(school);
		if(isValid() && userModel.updateUser(user)){
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public boolean isValid() {
		// TODO Auto-generated method stub
		boolean valid = true;
		
		if(getName().trim().length() == 0) {
			addFieldError("name", getText("errors.name.required"));
			valid = false;
		}
		if(getEmail().trim().length() == 0) {
			addFieldError("email", getText("errors.email.required"));
			valid = false;
		}
		if(getTrack().trim().length() == 0) {
			addFieldError("track", getText("errors.track.required"));
			valid = false;
		}
		if(getSchool().trim().length() == 0) {
			addFieldError("school", getText("errors.school.required"));
			valid = false;
		}
		if(getUsername().trim().length() == 0) {
			addFieldError("username", getText("errors.username.required"));
			valid = false;
		}
		if(getPassword().trim().length() == 0) {
			addFieldError("password", getText("errors.password.required"));
			valid = false;
		}
		
		return valid;
	}
}
