package com.ooad.project.class_scheduler.action;

import com.ooad.project.class_scheduler.model.UserModel;
import com.ooad.project.class_scheduler.util.EncryptUtil;
import com.opensymphony.xwork2.ActionSupport;

public class ChangePasswordAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String token;
	private EncryptUtil encryptUtil;
	private UserModel userModel;
	
	public ChangePasswordAction() {
		encryptUtil = new EncryptUtil();
		userModel = new UserModel();
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String email = encryptUtil.deceodeBase64(token);
		if(userModel.fetchUserByEmail(email) != null) {
			return SUCCESS;
		} else {
			addActionError("Sorry the user could not be verified");
			return ERROR;
		}
	}
}
