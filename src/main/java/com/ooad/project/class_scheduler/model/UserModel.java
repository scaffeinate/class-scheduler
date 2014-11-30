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

	public User fetchUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.fetchUserByUsername(username);
	}
	
	public User fetchUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.fetchUserByEmail(email);
	}

	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}

	public boolean checkConfirmed(String username) {
		// TODO Auto-generated method stub
		return userDao.fetchUserByUsername(username).isConfirmed();
	}
}
