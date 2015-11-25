package com.yash.training.tmp.domain;

import java.util.List;

public class DetailsPrint {

	String courseTitle;
	String referenceCode;
	String heading_text;
	String subheading;
	String completion_status;
	List<Heading> headingList;
	
	
	

	public void setHeadingList(List<Heading> headingList) {
		this.headingList = headingList;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public List<Heading> getHeadingList() {
		return headingList;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getReferenceCode() {
		return referenceCode;
	}

	public void setReferenceCode(String referenceCode) {
		this.referenceCode = referenceCode;
	}

	public String getHeading_text() {
		return heading_text;
	}

	public void setHeading_text(String heading_text) {
		this.heading_text = heading_text;
	}

	public String getSubheading() {
		return subheading;
	}

	public void setSubheading(String subheading) {
		this.subheading = subheading;
	}

	public String getCompletion_status() {
		return completion_status;
	}

	public void setCompletion_status(String completion_status) {
		this.completion_status = completion_status;
	}

}