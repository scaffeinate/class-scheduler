package com.ooad.project.class_scheduler.action;

import java.util.ArrayList;

import com.ooad.project.class_scheduler.bean.Course;
import com.ooad.project.class_scheduler.model.CourseModel;
import com.ooad.project.class_scheduler.util.ConflictResolveUtil;
import com.opensymphony.xwork2.ActionSupport;

public class ConfirmSelectionAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String itemId;
	private CourseModel courseModel;
	private ArrayList<Course> selectedCourses;
	private ConflictResolveUtil conflictResolveUtil;
	
	public ConfirmSelectionAction() {
		courseModel = new CourseModel();
		selectedCourses = new ArrayList<Course>();
		conflictResolveUtil = new ConflictResolveUtil();
	}
	
	public ArrayList<Course> getSelectedCourses() {
		return selectedCourses;
	}

	public void setSelectedCourses(ArrayList<Course> selectedCourses) {
		this.selectedCourses = selectedCourses;
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
		
		for(String str:itemId.split("&")){
			values.add(Integer.parseInt(str));
		}
		
		selectedCourses = courseModel.fetchSelectedCourses(values);
		if(conflictResolveUtil.detectConflicts(selectedCourses)){
			addActionError(getText("errors.course.conflict"));
			String[] tempStr = conflictResolveUtil.getConflictsStr().split("\n");
			for(String str:tempStr) {
				addActionError(str);
			}
			return ERROR;
		} else {
			addActionMessage(getText("errors.course.success"));
			return SUCCESS;
		}
	}
}
