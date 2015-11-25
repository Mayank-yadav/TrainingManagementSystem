package com.yash.training.tmp.service;

import javax.ejb.Local;

import com.yash.training.tmp.domain.Subheading;
import com.yash.training.tmp.domain.User;

@Local
public interface SubheadingBeanServiceLocal {

	public int getHeadingid(User user,String heading_text);
	public void saveSubheadingService(Subheading subheading);
	
	
}
