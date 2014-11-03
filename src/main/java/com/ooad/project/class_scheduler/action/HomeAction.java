package com.ooad.project.class_scheduler.action;

import java.util.ArrayList;
import java.util.Map;

import com.ooad.project.class_scheduler.bean.User;
import com.ooad.project.class_scheduler.model.UserModel;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private User user;
	private UserModel userModel;
	private Map<String, Object> session;
	
	private ArrayList<String> fruits;
	private String yourFruits;
	
	public HomeAction() {
		userModel = new UserModel();
		session = ActionContext.getContext().getSession();
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList<String> getFruits() {
		return fruits;
	}
 
	public void setFruits(ArrayList<String> fruits) {
		this.fruits = fruits;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		user = userModel.fetchUserByUsername((String) session.get("current_user"));
		fruits = new ArrayList<String>();
		fruits.add("Apple");
		fruits.add("Banana");
		fruits.add("Orange");
		fruits.add("Watermelon");
		return super.execute();
	}
	
	public String getYourFruits() {
		return yourFruits;
	}
 
	public void setYourFruits(String yourFruits) {
		this.yourFruits = yourFruits;
	}
}
