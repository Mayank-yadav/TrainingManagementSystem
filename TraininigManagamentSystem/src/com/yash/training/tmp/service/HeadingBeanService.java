package com.yash.training.tmp.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import com.yash.training.tmp.domain.Courses;
import com.yash.training.tmp.domain.Heading;
import com.yash.training.tmp.domain.User;
import com.yash.training.tmp.util.DBUtil;

/**
 * Session Bean implementation class HeadingService
 */
@Stateless
@LocalBean
public class HeadingBeanService implements HeadingBeanServiceLocal {

    /**
     * Default constructor. 
     */
    public HeadingBeanService() {
        // TODO Auto-generated constructor stub
    }

	public void saveHeadingService(Heading heading) {
		// TODO Auto-generated method stub
		System.out.println("Inside service");
		
		String query = "INSERT INTO HEADING (HEADING_TEXT,course_id) VALUES ('"
				+ heading.getHeading_text() + "','"+heading.getCourse_id()+"')";
		
		DBUtil.update(query);
 		
	}

	@Override
	public List<String> getHeadings() throws SQLException {
		// TODO Auto-generated method stub
		
		String query="Select * from heading ";
		System.out.println(query);
		ResultSet result=DBUtil.select(query);
		List<String> list=new ArrayList<>();
		
		while(result.next()){
			list.add(result.getString("heading_text"));

		}
		
		System.out.println(list);
		
		return list;
	}

	@Override
	public int getCourseid(User user,String course_title) {
		String query="Select * from courses where user_id='"+user.getUser_id()+"' and course_title='"+course_title+"'";
		ResultSet resultset=DBUtil.select(query);
		int courseid=0;
		try {
			while(resultset.next()){
				courseid=resultset.getInt("course_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return courseid;
	}
	
	
}
