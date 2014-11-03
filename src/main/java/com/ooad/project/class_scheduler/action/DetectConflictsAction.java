package com.ooad.project.class_scheduler.action;

import java.util.ArrayList;

import com.ooad.project.class_scheduler.bean.Course;
import com.ooad.project.class_scheduler.model.CourseModel;


public class DetectConflictsAction extends ConfirmSelectionAction {

	private static final long serialVersionUID = 1L;
	private String itemId;
	private CourseModel courseModel;
	private ArrayList<Course> selectedCourses;

	public DetectConflictsAction() {
		courseModel = new CourseModel();
		selectedCourses = new ArrayList<Course>();
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Integer> values = new ArrayList<Integer>();
		System.out.println(itemId);
		for(String str:itemId.split("&")){
			values.add(Integer.parseInt(str));
		}
		selectedCourses = courseModel.fetchSelectedCourses(values);
		System.out.println(selectedCourses.size());
		return SUCCESS;
	}


}
