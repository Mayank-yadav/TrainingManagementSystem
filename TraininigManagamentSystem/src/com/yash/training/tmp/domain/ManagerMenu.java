package com.yash.training.tmp.domain;

import java.io.Serializable;

public class ManagerMenu implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String addTrainingPlan= "Add Training Plan";
	private String seeAllTrainers = "See All Trainers";
	private String removeTrainer = "Remove Trainer";
	private String testResult = "Test Result";
	
	public String getAddTrainingPlan() {
		return addTrainingPlan;
	}
	public void setAddTrainingPlan(String addTrainingPlan) {
		this.addTrainingPlan = addTrainingPlan;
	}
	public String getSeeAllTrainers() {
		return seeAllTrainers;
	}
	public void setSeeAllTrainers(String seeAllTrainers) {
		this.seeAllTrainers = seeAllTrainers;
	}
	public String getRemoveTrainer() {
		return removeTrainer;
	}
	public void setRemoveTrainer(String removeTrainer) {
		this.removeTrainer = removeTrainer;
	}
	public String getTestResult() {
		return testResult;
	}
	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}

}
