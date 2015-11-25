package com.yash.training.tmp.domain;

import java.io.Serializable;

public class TraineeMenu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String seePocs = "See Poc's";
	private String seeTestResults ="See Test Results";
	private String applyForLeave ="Apply For Leave";
	private String sendFeedback = "Send Feedback";
	
	public String getSeePocs() {
		return seePocs;
	}
	public void setSeePocs(String seePocs) {
		this.seePocs = seePocs;
	}
	public String getSeeTestResults() {
		return seeTestResults;
	}
	public void setSeeTestResults(String seeTestResults) {
		this.seeTestResults = seeTestResults;
	}
	public String getApplyForLeave() {
		return applyForLeave;
	}
	public void setApplyForLeave(String applyForLeave) {
		this.applyForLeave = applyForLeave;
	}
	public String getSendFeedback() {
		return sendFeedback;
	}
	public void setSendFeedback(String sendFeedback) {
		this.sendFeedback = sendFeedback;
	}

}
