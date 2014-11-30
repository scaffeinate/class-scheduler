package com.ooad.project.class_scheduler.action;

import com.ooad.project.class_scheduler.model.UserModel;
import com.ooad.project.class_scheduler.util.EmailUtil;
import com.ooad.project.class_scheduler.util.EncryptUtil;
import com.opensymphony.xwork2.ActionSupport;

public class ForgotPasswordAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String email;
	private EmailUtil emailUtil;
	private UserModel userModel;

	public ForgotPasswordAction() {
		emailUtil = new EmailUtil();
		userModel = new UserModel();
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
		if(userModel.fetchUserByEmail(email) != null) {
			String forgotPasswordText = getText("messages.forgot.text") + "\n" + 
					"follow this link: " +
					"http://localhost:8080/class-scheduler/ChangePassword?token=" + new EncryptUtil().generateBase64(email);
		
			emailUtil.sendForgotPassword(email, getText("messages.forgot.password"), forgotPasswordText);        
			return SUCCESS;
		} else {
			addActionError(getText("errors.user.not_found"));
			return ERROR;
		}
	}
}
