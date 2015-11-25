package com.yash.training.tmp.service;


import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.yash.training.tmp.domain.Subheading;
import com.yash.training.tmp.domain.User;
import com.yash.training.tmp.util.DBUtil;

/**
 * Session Bean implementation class SubheadingService
 */
@Stateless
@LocalBean
public class SubheadingBeanService implements SubheadingBeanServiceLocal {

    /**
     * Default constructor. 
     */
    public SubheadingBeanService() {
        // TODO Auto-generated constructor stub
    }

	public void saveSubheadingService(Subheading subheading) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO SUBHEADING (HEADING_ID,SUBHEADING,COMPLETION_STATUS) VALUES ('"+ subheading.getHeading_id() + "','"+ subheading.getSubheadin() + "','"+ subheading.getCompletion_status() + "')";
		
		DBUtil.update(query);
	}

	@Override
	public int getHeadingid(User user,String heading_text) {
		// TODO Auto-generated method stub
		String query="Select * from heading where heading_text='"+heading_text+"'";
		ResultSet resultset=DBUtil.select(query);
		int heading_id = 0;
		try {
			while(resultset.next()){
				heading_id=resultset.getInt("heading_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return heading_id;
	}

}

