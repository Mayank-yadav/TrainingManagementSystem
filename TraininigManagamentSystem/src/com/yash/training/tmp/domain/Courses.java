package com.yash.training.tmp.domain;

import java.io.Serializable;

public class Courses implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1376721975232292388L;
private int course_id;
private String course_title;
private String description;
private String reference_code;
private String upload;
private int status;
private String button_value;
public String getButton_value() {
	return button_value;
}
public void setButton_value(String button_value) {
	this.button_value = button_value;
}
public int getCourse_id() {
	return course_id;
}
public void setCourse_id(int course_id) {
	this.course_id = course_id;
}
public String getCourse_title() {
	return course_title;
}
public void setCourse_title(String course_title) {
	this.course_title = course_title;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getReference_code() {
	return reference_code;
}
public void setReference_code(String reference_code) {
	this.reference_code = reference_code;
}
public String getUpload() {
	return upload;
}
public void setUpload(String upload) {
	this.upload = upload;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
}
