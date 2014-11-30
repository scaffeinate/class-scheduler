package com.ooad.project.class_scheduler.action;

import com.ooad.project.class_scheduler.bean.User;
import com.ooad.project.class_scheduler.model.UserModel;
import com.ooad.project.class_scheduler.util.EncryptUtil;
import com.opensymphony.xwork2.ActionSupport;

public class ConfirmUserAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String token;
	private UserModel userModel;
	private EncryptUtil encryptUtil;
	
	public ConfirmUserAction() {
		userModel = new UserModel();
		encryptUtil = new EncryptUtil();
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
		User user;
		
		if((user = userModel.fetchUserByEmail(email)) != null) {
			user.setConfirmed(true);
			userModel.updateUser(user);
			return SUCCESS;
		} else {
			addActionError("Sorry the user could not be verified");
			return ERROR;
		}
	}

}
