package com.ooad.project.class_scheduler.util;

import com.ooad.project.class_scheduler.bean.Session;
import com.ooad.project.class_scheduler.model.UserModel;


public class UserLoginFacade {
	
	private UserModel userModel;
	
	public UserLoginFacade() {
		userModel = new UserModel();
	}
	
	public boolean checkUser(Session sessionBean) {
		return userModel.checkCredentials(sessionBean) != null &&
				userModel.checkConfirmed(sessionBean.getUsername());
	}
}
