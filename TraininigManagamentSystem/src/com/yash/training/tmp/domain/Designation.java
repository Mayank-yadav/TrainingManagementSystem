package com.yash.training.tmp.domain;

import java.io.Serializable;

public class Designation implements  Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8408246606005226637L;
	int user_designationid;
	int designation;
	
	public int getUser_designationid() {
		return user_designationid;
	}
	public void setUser_designationid(int user_designationid) {
		this.user_designationid = user_designationid;
	}
	
	public int getDesignation() {
		return designation;
	}
	public void setDesignation(int designation) {
		this.designation = designation;
	}
	
	

}
