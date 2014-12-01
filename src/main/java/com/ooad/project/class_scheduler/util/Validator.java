package com.ooad.project.class_scheduler.util;


public class Validator implements FormValidatorStrategy {

	public boolean validate(String str) {
		// TODO Auto-generated method stub
		if(str != null && !str.trim().equals("")) {
			return true;
		} else {
			return false;
		}
	}
}
