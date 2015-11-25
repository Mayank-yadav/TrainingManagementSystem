package com.yash.training.tmp.domain;

import java.io.Serializable;

public class Status implements  Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4300212422313254375L;
	int status_id;
	int status;
	
	public int getStatus_id() {
		return status_id;
	}
	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}
