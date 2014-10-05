package com.ooad.project.class_scheduler.model;

import com.ooad.project.class_scheduler.bean.User;
import com.ooad.project.class_scheduler.dao.RegisterDao;

public class UserModel {
	
	private RegisterDao registerUser;
	
	public UserModel() {
		registerUser = new RegisterDao();
	}
	
	public boolean insertData(User user) {
		return registerUser.insertData(user);
	}
}
