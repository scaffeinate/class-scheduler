package com.ooad.project.class_scheduler.model;

import com.ooad.project.class_scheduler.bean.Session;
import com.ooad.project.class_scheduler.bean.User;
import com.ooad.project.class_scheduler.dao.UserDao;

public class UserModel {
	
	private UserDao userDao;
	
	public UserModel() {
		userDao = new UserDao();
	}
	
	public boolean insertData(User user) {
		return userDao.insertData(user);
	}
	
	public User fetchUserById(int id) {
		return userDao.fetchUserById(id);
	}
	
	public User checkCredentials(Session sessionBean) {
		return userDao.checkCredentails(sessionBean);
	}
}
