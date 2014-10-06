package com.ooad.project.class_scheduler.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ActionContext.getContext().getSession().remove("current_user");
		ActionContext.getContext().getSession().remove("login");
		addActionMessage(getText("message.logout.success"));
		return SUCCESS;
	}
	
}
