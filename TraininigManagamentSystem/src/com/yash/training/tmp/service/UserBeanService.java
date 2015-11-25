package com.yash.training.tmp.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.yash.training.tmp.domain.Designation;
import com.yash.training.tmp.domain.User;
import com.yash.training.tmp.util.DBUtil;
import com.yash.training.tmp.util.DButil;

@Stateless
@LocalBean
public class UserBeanService implements UserBeanServiceLocal {

	@Inject 
	User user;
	
	@Override
	public String authencticateUser(String userName,String password) throws Exception {
		ResultSet resultSet;
		// TODO Auto-generated method stub
		System.out.println("inside UserServiceBean:"+userName);
		String query="Select * from user where username='"+userName+"' AND Password='"+password+"'";
		resultSet=DBUtil.select(query);
		if(resultSet.next()){
				return	"success";
		}
			else{
				String query1="Select * from user where username='"+userName+"'";
				String query2="Select * from user where password='"+password+"'";
				System.out.println(query1);
				System.out.println(query2);

				ResultSet result1=DBUtil.select(query1);
				ResultSet result2=DBUtil.select(query2);
				
					if(result1.next()){
						return "invalid Password";
					}
				
					else if(result2.next()){
						return "invalid username";
					}
				
					return "invalid username and password";		
			}
		
		
		
		
		
		/*String query1="Select * from user where Username='"+user.getUsername()+"'";
		String query2="Select * from user where Password='"+user.getPassword()+"'";
		System.out.println(query1);
		System.out.println(query2);
		ResultSet result1=DBUtil.select(query1);
		ResultSet result2=DBUtil.select(query2);
		System.out.println("authenticate1:"+result1);
		System.out.println("authencticate2:"+result2);
		try {
			while(result1.next()){
				 username=result1.getString("username");
				 password=result1.getString("password");
				
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(username.equals(user.getUsername())&&password.equals(user.getPassword())){
			return "success";
		}
		else if()
		return false;*/
	}

	public UserBeanService(){
		
	}

	@Override
	public void registerUser(User user, int designation) throws Exception {
		System.out.println("inside registerUser()");
		String query="Insert into user(user_name,user_contact,user_email_id,user_designationid_fk,user_role,user_status,username,password) values(' "
				+ user.getUser_name()
				+ "','"
				+ user.getUser_contact()
				+ "','"
				+user.getUser_email_id()
				+ "','"
				+ designation
				+ "','2"
				
				+ "','1','"
				
				+ user.getUsername()
				+ "','"
				+ user.getPassword()
				
				+ "')";
		System.out.println(query);
		DBUtil.update(query);
		
	}

	

	@Override
	public User getUserDetails(String userName, String password) throws SQLException {
		String query="Select * from user where username='"+userName+"'and password='"+password+"'";
		ResultSet resultset=DBUtil.select(query);
		while(resultset.next()){
			String name=resultset.getString("user_name");
			user.setUser_name(name);
			int d_id=resultset.getInt("user_designationid_fk");
			user.setDesination_id(d_id);
			user.setUser_id(resultset.getInt("user_id"));
			
			System.out.println("------------------D_ID-----------------------" +d_id);
		}
		
		return user;
	}

	@Override
	public int getCourseCount(int user_id) {

		String query="SELECT COUNT(course_title) AS count FROM courses where user_id= "+user_id;
		ResultSet resultset=DBUtil.select(query);
		int count=0;
		try {
			while(resultset.next()){
				count=resultset.getInt("count");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	

}

