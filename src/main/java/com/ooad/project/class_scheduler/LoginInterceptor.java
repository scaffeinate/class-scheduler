package com.ooad.project.class_scheduler;

import java.util.Map;

import org.apache.struts2.interceptor.I18nInterceptor;

import com.opensymphony.xwork2.ActionInvocation;

public class LoginInterceptor extends I18nInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> session = invocation.getInvocationContext().getSession();
		if(session == null || session.get("current_user") == null) {
			return "login";
		} else {
			return invocation.invoke();
		}
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}
}
