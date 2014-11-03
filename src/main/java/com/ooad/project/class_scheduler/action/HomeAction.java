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
	
	private String courseParams;
	private String searchString;
	private ArrayList<Course> courseList;
	private ArrayList<String> courseSelectionList;
	
	
	public HomeAction() {
		userModel = new UserModel();
		courseModel = new CourseModel();
		courseList = new ArrayList<Course>();
		courseSelectionList = new ArrayList<String>();
		session = ActionContext.getContext().getSession();
	}
	
	public ArrayList<String> getCourseSelectionList() {
		return courseSelectionList;
	}

	public void setCourseSelectionList(ArrayList<String> courseSelectionList) {
		this.courseSelectionList = courseSelectionList;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
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

	public String getCourseParams() {
		return courseParams;
	}

	public void setCourseParams(String courseParams) {
		this.courseParams = courseParams;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		user = userModel.fetchUserByUsername((String) session.get("current_user"));
		courseList = courseModel.fetchCourses();
		return super.execute();
	}
	
	public String searchCourses() throws Exception {
		courseList = courseModel.searchCourses(searchString);
		return SUCCESS;
	}
	
	public String validateCourseSelection() throws Exception {
		
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
