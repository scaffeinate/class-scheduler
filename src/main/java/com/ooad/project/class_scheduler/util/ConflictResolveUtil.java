package com.ooad.project.class_scheduler.util;

import java.util.ArrayList;

import com.ooad.project.class_scheduler.bean.Course;

public class ConflictResolveUtil {

	public boolean detectConflicts(ArrayList<Course> selectedCourses) {
		// TODO Auto-generated method stub
		for(Course c:selectedCourses){
			for(Course course:selectedCourses) {
				if(!c.equals(course)){
					if(checkConflict(c, course))
						return true;
				}
			}
		}
		
		return false;
	}

	private boolean checkConflict(Course first, Course second) {
		// TODO Auto-generated method stub
		/*if(!first.getDays().equals(second.getDays()) || 
				Float.parseFloat(first.getStarttime().replace(":", ".").replace("am", "").replace("pm", "")) < Float.parseFloat(second.getStarttime().replace(":", ".").replace("am", "").replace("pm", "")) || 
				Float.parseFloat(first.getEndtime().replace(":", ".").replace("am", "").replace("pm", "")) > Float.parseFloat(second.getEndtime().replace(":", ".").replace("am", "").replace("pm", "")))
			return false;*/
		return true;
	}

}
