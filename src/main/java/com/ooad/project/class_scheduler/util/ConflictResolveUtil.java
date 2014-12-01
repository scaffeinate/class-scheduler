package com.ooad.project.class_scheduler.util;

import java.util.ArrayList;

import com.ooad.project.class_scheduler.bean.Course;

public class ConflictResolveUtil {

	public boolean detectConflicts(ArrayList<Course> selectedCourses) {
		// TODO Auto-generated method stub

		Course first = selectedCourses.get(0), 
				second = selectedCourses.get(1), third = selectedCourses.get(2);

		return checkConflict(first, second) ||
				checkConflict(first, third) ||
				checkConflict(second, third);
	}

	private boolean checkConflict(Course c1, Course c2) {
		// TODO Auto-generated method stub

		String day1 = c1.getDay1();
		String day2 = c1.getDay2();
		String cday1 = c2.getDay1();
		String cday2 = c2.getDay2();

		float startTime = Float.parseFloat(c1.getStarttime());
		float endTime = Float.parseFloat(c1.getEndtime());
		float cstartTime = Float.parseFloat(c2.getStarttime());
		float cendTime = Float.parseFloat(c2.getEndtime());

		System.out.println(c1.getCoursename() + " " + c2.getCoursename());
		
		if(day1.equals(cday1) || day1.equals(cday2) || day2.equals(cday2)) {
			System.out.println("Inside this block");
			if(startTime < cstartTime && endTime < cstartTime) {
				System.out.println("Inside this block 1");
				return false;
			} else if(startTime > cstartTime && startTime > cendTime) {
				System.out.println("Inside this block 2");
				return false;
			}
		} else {
			return false;
		}

		return true;
	}

}
