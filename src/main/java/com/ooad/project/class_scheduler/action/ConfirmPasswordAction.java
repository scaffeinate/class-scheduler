package com.ooad.project.class_scheduler.action;

import com.ooad.project.class_scheduler.bean.User;
import com.ooad.project.class_scheduler.model.UserModel;
import com.ooad.project.class_scheduler.util.EncryptUtil;
import com.opensymphony.xwork2.ActionSupport;

public class ConfirmPasswordAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

	private String token, password, password_confirmation;
	private EncryptUtil encryptUtil;
	private UserModel userModel;
	
	public ConfirmPasswordAction() {
		encryptUtil = new EncryptUtil();
		userModel = new UserModel();
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
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

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

	public String updatePassword() throws Exception {
		String email = encryptUtil.deceodeBase64(token);
		User user;
		if((user = userModel.fetchUserByEmail(email)) != null && isValid() && password.equals(password_confirmation)) {
			user.setPassword(password);
			if(userModel.updateUser(user)){
				addActionMessage(getText("message.update.success"));
				return SUCCESS;
			} else {
				addActionError(getText("message.update.error"));
				return ERROR;
			}
		} else if(!isValid()){
			return INPUT;
		} else {
			addActionError("Sorry the user could not be verified");
			return ERROR;
		}
	}
	
	public boolean isValid() {
		// TODO Auto-generated method stub
		boolean valid = true;
		
		if(getPassword().trim().length() == 0) {
			addFieldError("password", getText("errors.password.required"));
			valid = false;
		}
		if(getPassword_confirmation().trim().length() == 0) {
			addFieldError("password_confirmation", getText("errors.password_confirmation.required"));
			valid = false;
		}
		
		return valid;
	}
	
}
