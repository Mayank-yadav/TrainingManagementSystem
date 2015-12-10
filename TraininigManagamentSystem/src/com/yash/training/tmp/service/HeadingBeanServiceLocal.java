package com.yash.training.tmp.service;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Local;

import com.yash.training.tmp.domain.Courses;
import com.yash.training.tmp.domain.Heading;
import com.yash.training.tmp.domain.User;

@Local
public interface HeadingBeanServiceLocal {
	public void saveHeadingService(Heading heading);
	public List<String> getHeadings( ) throws SQLException;
	public int getCourseid(User user,String course_title);
	
}
