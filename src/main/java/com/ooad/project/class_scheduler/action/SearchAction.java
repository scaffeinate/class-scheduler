package com.ooad.project.class_scheduler.action;

import java.util.ArrayList;
import java.util.Map;

import com.ooad.project.class_scheduler.bean.Course;
import com.ooad.project.class_scheduler.bean.User;
import com.ooad.project.class_scheduler.model.CourseModel;
import com.ooad.project.class_scheduler.model.UserModel;
import com.opensymphony.xwork2.ActionContext;

public class SearchAction extends HomeAction{
	

	private static final long serialVersionUID = 1L;
	private ArrayList<Course> courseList;
	private CourseModel courseModel;
	private UserModel userModel; 
	private Map<String, Object> session;
	private String searchString;
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public SearchAction() {
		courseList = new ArrayList<Course>();
		courseModel = new CourseModel();
		userModel = new UserModel();
		session = ActionContext.getContext().getSession();
	}
	
	public CourseModel getCourseModel() {
		return courseModel;
	}

	public void setCourseModel(CourseModel courseModel) {
		this.courseModel = courseModel;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public ArrayList<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(ArrayList<Course> courseList) {
		this.courseList = courseList;
	}

	@Override
	public String execute() throws Exception {
		user = userModel.fetchUserByUsername((String) session.get("current_user"));
		courseList = courseModel.searchCourses(searchString);
		return SUCCESS;
	}
}
