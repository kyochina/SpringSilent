package com.china.terry.action;

public class UppAction {
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String exectue(){
		return this.msg.toUpperCase();
	}

}
