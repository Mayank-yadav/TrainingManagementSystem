package com.yash.training.tmp.domain;

import java.io.Serializable;




import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.yash.training.tmp.domain.Subheading;
import com.yash.training.tmp.service.SubheadingBeanService;

@ManagedBean
@SessionScoped
public class Subheading implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8704613408546291853L;
	int heading_id;
	String subheadin;
	String completion_status;
	int subheading_id;
	
	public int getSubheading_id() {
		return subheading_id;
	}

	public void setSubheading_id(int subheading_id) {
		this.subheading_id = subheading_id;
	}

	public int getHeading_id() {
		return heading_id;
	}

	public void setHeading_id(int heading_id2) {
		this.heading_id = heading_id2;
	}

	
	public String getSubheadin() {
		return subheadin;
	}

	public void setSubheadin(String subheadin) {
		this.subheadin = subheadin;
	}

	
	
	public String getCompletion_status() {
		return completion_status;
	}

	public void setCompletion_status(String completion_status) {
		this.completion_status = completion_status;
	}

	
}
