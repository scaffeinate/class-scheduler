package com.ooad.project.class_scheduler.model;

import com.ooad.project.class_scheduler.bean.User;
import com.ooad.project.class_scheduler.dao.Register;

public class UserModel {
	
	private Register registerUser;
	
	public UserModel() {
		registerUser = new Register();
	}
	
	public boolean insertData(User user) {
		return registerUser.insertData(user);
	}
}
