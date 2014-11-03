package com.ooad.project.class_scheduler.action;

import java.util.ArrayList;
import java.util.Map;

import com.ooad.project.class_scheduler.bean.Course;
import com.ooad.project.class_scheduler.bean.User;
import com.ooad.project.class_scheduler.model.CourseModel;
import com.ooad.project.class_scheduler.model.UserModel;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private User user;
	private UserModel userModel; 
	private CourseModel courseModel;
	private Map<String, Object> session;
	private ArrayList<Course> courseList;
	
	
	public HomeAction() {
		userModel = new UserModel();
		courseModel = new CourseModel();
		courseList = new ArrayList<Course>();
		session = ActionContext.getContext().getSession();
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	public ArrayList<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(ArrayList<Course> courseList) {
		this.courseList = courseList;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		user = userModel.fetchUserByUsername((String) session.get("current_user"));
		courseList = courseModel.fetchCourses();
		return super.execute();
	}
}
