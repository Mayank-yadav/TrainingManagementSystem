package com.yash.training.tmp.domain;

import java.io.Serializable;
import java.util.List;

public class Heading implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3678236824368895394L;
	
		int heading_id;
		public int getHeading_id() {
			return heading_id;
		}

		public void setHeading_id(int heading_id) {
			this.heading_id = heading_id;
		}

		String heading_text;
		int course_id;
		List<Subheading> subheading; 
		
		public List<Subheading> getSubheading() {
			return subheading;
		}

		public void setSubheading(List<Subheading> subheading) {
			this.subheading = subheading;
		}

		public int getCourse_id() {
			return course_id;
		}

		public void setCourse_id(int course_id) {
			this.course_id = course_id;
		}

		public String getHeading_text() {
			return heading_text;
		}

		public void setHeading_text(String heading_text) {
			this.heading_text = heading_text;
		}
	}


