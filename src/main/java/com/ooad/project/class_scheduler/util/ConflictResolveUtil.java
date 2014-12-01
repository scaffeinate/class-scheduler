package com.ooad.project.class_scheduler.util;

import java.util.ArrayList;

import com.ooad.project.class_scheduler.bean.Course;

public class ConflictResolveUtil {

	private StringBuilder strBuilder;
	private String conflictsStr;

	public boolean detectConflicts(ArrayList<Course> selectedCourses) {
		// TODO Auto-generated method stub

		Course first = selectedCourses.get(0), 
				second = selectedCourses.get(1), third = selectedCourses.get(2);

		boolean b1 = false, b2 = false, b3 = false;
		
		strBuilder = new StringBuilder();
		
		if(checkConflict(first, second)) {
			strBuilder.append("[First] conflicts [Second]\n");
			b1 = true;
		}
		
		if(checkConflict(first, third)) {
			strBuilder.append("[First] conflicts [Third]\n");
			b2 = true;
		}
		
		if(checkConflict(second, third)) {
			strBuilder.append("[Second] conflicts [Third]");
			b3 = true;
		}
		
		setConflictsStr(strBuilder.toString());
		
		return b1 || b2 || b3;
	}
	
	public ArrayList<Course> suggestedCourses(ArrayList<Course> selectedCourses) {
		ArrayList<Course> resultList = new ArrayList<Course>();
		
		
		
		return resultList;
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
		
		if(day1.equals(cday1) || day1.equals(cday2) || day2.equals(cday2)) {
			if(startTime < cstartTime && endTime < cstartTime) {
				return false;
			} else if(startTime > cstartTime && startTime > cendTime) {
				return false;
			}
		} else {
			return false;
		}

		return true;
	}

	
	public String getConflictsStr() {
		return conflictsStr;
	}

	public void setConflictsStr(String conflictsStr) {
		this.conflictsStr = conflictsStr;
	}
}
