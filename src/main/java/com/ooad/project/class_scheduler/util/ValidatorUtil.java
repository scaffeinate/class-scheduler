package com.ooad.project.class_scheduler.util;


public class ValidatorUtil {
	private FormValidatorStrategy strategy;
	
	public ValidatorUtil(FormValidatorStrategy strategy) {
		this.strategy = strategy;
	}
	
	public boolean checkValid(String str) {
		return strategy.validate(str);
	}
}
