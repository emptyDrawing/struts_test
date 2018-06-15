package com.bit.struts2.action;

import com.opensymphony.xwork2.Action;

public class DefaultAction implements Action {

	@Override
	public String execute() throws Exception {
		return this.SUCCESS;
	}

}
