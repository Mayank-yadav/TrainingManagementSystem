package com.yash.training.tmp.service;

import java.sql.SQLException;

import javax.ejb.Local;

import com.yash.training.tmp.domain.Designation;
import com.yash.training.tmp.domain.User;
@Local
public interface UserBeanServiceLocal {
	public String authencticateUser(String userName,String password) throws Exception;
	public void registerUser(User user,int designation) throws Exception;
	public User getUserDetails(String userName,String password) throws SQLException;
	public int getCourseCount(int user_id);
}
