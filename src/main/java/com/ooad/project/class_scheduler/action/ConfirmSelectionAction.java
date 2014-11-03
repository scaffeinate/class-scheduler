package com.ooad.project.class_scheduler.action;

import com.opensymphony.xwork2.ActionSupport;

public class ConfirmSelectionAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String itemId;
		
	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(itemId);
		return super.execute();
	}
}
