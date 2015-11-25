package com.yash.training.tmp.domain;

import java.io.Serializable;

public class TrainerMenu implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String seeAllTrainees="See All Trainees";
	private String seeTrainingSchedule ="See Training Schedule";
	private String setPoc = "Set Poc";
	private String perfomanceSheet = "Performance Sheet";
	
	public String getSeeAllTrainees() {
		return seeAllTrainees;
	}
	public void setSeeAllTrainees(String seeAllTrainees) {
		this.seeAllTrainees = seeAllTrainees;
	}
	public String getSeeTrainingSchedule() {
		return seeTrainingSchedule;
	}
	public void setSeeTrainingSchedule(String seeTrainingSchedule) {
		this.seeTrainingSchedule = seeTrainingSchedule;
	}
	public String getSetPoc() {
		return setPoc;
	}
	public void setSetPoc(String setPoc) {
		this.setPoc = setPoc;
	}
	public String getPerfomanceSheet() {
		return perfomanceSheet;
	}
	public void setPerfomanceSheet(String perfomanceSheet) {
		this.perfomanceSheet = perfomanceSheet;
	}

}
