package com.ooad.project.class_scheduler.action;

import java.util.ArrayList;
import java.util.Map;

import com.ooad.project.class_scheduler.bean.Course;
import com.ooad.project.class_scheduler.bean.User;
import com.ooad.project.class_scheduler.model.CourseModel;
import com.ooad.project.class_scheduler.model.UserModel;
import com.opensymphony.xwork2.ActionContext;

public class ValidateCourseSelectionAction extends HomeAction{

	private static final long serialVersionUID = 1L;
	private ArrayList<Course> courseList;
	private ArrayList<String> courseSelectionList;
	private CourseModel courseModel;
	private UserModel userModel; 
	private Map<String, Object> session;
	private User user;
	private String courseParams;
	
	public String getCourseParams() {
		return courseParams;
	}

	public void setCourseParams(String courseParams) {
		this.courseParams = courseParams;
	}

	public ValidateCourseSelectionAction() {
		courseList = new ArrayList<Course>();
		courseModel = new CourseModel();
		userModel = new UserModel();
		session = ActionContext.getContext().getSession();
		courseSelectionList = new ArrayList<String>();
	}
	
	public ArrayList<String> getCourseSelectionList() {
		return courseSelectionList;
	}

	public void setCourseSelectionList(ArrayList<String> courseSelectionList) {
		this.courseSelectionList = courseSelectionList;
	}

	public ArrayList<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(ArrayList<Course> courseList) {
		this.courseList = courseList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {
		user = userModel.fetchUserByUsername((String) session.get("current_user"));
		courseList = courseModel.fetchCourses();
		if(courseSelectionList.size() == 0) {
			addActionError(getText("errors.course.select"));
			return ERROR;
		} else if(courseSelectionList.size() >= 4) {
			addActionError(getText("errors.course.limit"));
			return ERROR;
		} else {
			StringBuilder strBuilder = new StringBuilder();
			int i=0;
			for(String str:courseSelectionList) {
				i++;
				strBuilder.append(str);
				if(i != courseSelectionList.size())
					strBuilder.append("&");
			}
			
			setCourseParams(strBuilder.toString());
			
			return SUCCESS;
		}
	}
}
