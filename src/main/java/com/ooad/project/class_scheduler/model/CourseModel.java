package com.ooad.project.class_scheduler.model;

import java.util.ArrayList;

import com.ooad.project.class_scheduler.bean.Course;
import com.ooad.project.class_scheduler.dao.CourseDao;

public class CourseModel {
	private CourseDao courseDao;
	
	public CourseModel() {
		courseDao = new CourseDao();
	}

	public ArrayList<Course> fetchCourses() {
		return courseDao.fetchCourses();
	}
	
	public ArrayList<Course> fetchSelectedCourses(ArrayList<Integer> selection) {
		return courseDao.fetchSelectedCourses(selection);
	}

	public ArrayList<Course> searchCourses(String searchString) {
		// TODO Auto-generated method stub
		return courseDao.searchCourses(searchString);
	}
}
