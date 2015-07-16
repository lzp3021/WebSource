package com.lzp.common;

public class DatagridMsg {
	private boolean isError = false;
	private String msg;
	
	public DatagridMsg() {
	}
	public DatagridMsg(boolean isError,String msg) {
		this.isError = isError;
		this.msg = msg;
	}
	public boolean isError() {
		return isError;
	}
	public void setError(boolean isError) {
		this.isError = isError;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
