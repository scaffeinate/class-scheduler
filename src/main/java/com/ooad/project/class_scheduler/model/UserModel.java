package com.ooad.project.class_scheduler.model;

import com.ooad.project.class_scheduler.bean.User;
import com.ooad.project.class_scheduler.dao.UserDao;

public class UserModel {
	
	private UserDao registerUser;
	
	public UserModel() {
		registerUser = new UserDao();
	}
	
	public boolean insertData(User user) {
		return registerUser.insertData(user);
	}
}
