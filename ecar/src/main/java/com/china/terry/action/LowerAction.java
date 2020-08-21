package com.china.terry.action;

public class LowerAction {
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String execute(){
		return this.msg.toLowerCase();
	}

}
