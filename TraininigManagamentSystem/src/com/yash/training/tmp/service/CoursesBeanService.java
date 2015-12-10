package com.yash.training.tmp.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.yash.training.tmp.domain.Courses;
import com.yash.training.tmp.domain.DetailsPrint;
import com.yash.training.tmp.domain.Heading;
import com.yash.training.tmp.domain.Subheading;
import com.yash.training.tmp.domain.User;
import com.yash.training.tmp.util.DBUtil;

/**
 * Session Bean implementation class CoursesBeanService
 */
@Stateless
@LocalBean
public class CoursesBeanService implements CoursesBeanServiceLocal {

    /**
     * Default constructor. 
     */
    public CoursesBeanService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String saveCourses(Courses courses) {
		System.out.println("inside savecourses");
		String query="Insert into courses (course_title,description,reference_code,image,status_id) values ("
				+ "'"+courses.getCourse_title()
				+ "','"+courses.getDescription()
				+ "','"+courses.getReference_code()
				+ "','image"
				+ "','"+courses.getStatus()
				+ "')";
		System.out.println(query);
		DBUtil.update(query);
		return "courses saved successfully";
	}

	@Override
	public List<String> getUserCoursetext(User user) {
		System.out.println("inside getusertext");
		String query="Select * From courses where user_id='"+user.getUser_id()+"'";
		System.out.println(query);
		List<String> coursetext=new ArrayList<>();
		ResultSet resultSet=DBUtil.select(query);
		try {
			while(resultSet.next()){
				coursetext.add(resultSet.getString("course_title"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(coursetext);
		return coursetext;
	}

	public List<Courses> getAllCoursesService() {
		// TODO Auto-generated method stub

		String query = "SELECT * FROM COURSES";

		ResultSet resultSet = DBUtil.select(query);

		List<Courses> listOfCourses = new ArrayList<>();

		try {
			while (resultSet.next()) {
				Courses courses = new Courses();
				courses.setCourse_id(resultSet.getInt("course_id"));
				courses.setCourse_title(resultSet.getString("course_title"));
				courses.setDescription(resultSet.getString("description"));
				courses.setReference_code(resultSet.getString("reference_code"));
				courses.setStatus(resultSet.getInt("status_id"));
				if(resultSet.getInt("status_id") == 1){
					courses.setButton_value("Deactivate");
					System.out.println("button values"+courses.getButton_value());
				}
				
				if(resultSet.getInt("status_id") == 0){
					courses.setButton_value("Activate");
					System.out.println(courses.getButton_value());
				}
				
				listOfCourses.add(courses);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listOfCourses;

	}

	
	public List<DetailsPrint> getCoursesDetailsService(int course_id) {
		// TODO Auto-generated method stub
		
		String query = "SELECT c.course_title, c.reference_code, h.heading_text, s.subheading, s.completion_status FROM courses AS c , heading AS h , subheading AS s WHERE c.course_id=h.course_id AND h.heading_id= h.heading_id";
		//String query = "SELECT * FROM COURSES";
		String query1="Select * from courses where course_id='"+course_id+"'";
		String query2="Select * from heading where course_id='"+course_id+"'";
		ResultSet resultSet = DBUtil.select(query);
		ResultSet resultSet1 = DBUtil.select(query1);
		ResultSet resultSet2 = DBUtil.select(query2);

		System.out.println(query1);
		
		List<DetailsPrint> detailsOfCourses = new ArrayList<>();
		List<Heading> headings=new ArrayList<>();
		List<Subheading> subheadings=new ArrayList<>();
		
		
		  try {
	            while(resultSet.next()){
	                /*Courses courses = new Courses();
	            
	                courses.setCourseTitle(resultSet.getString("COURSE_TITLE"));
	                courses.setReferenceCode(resultSet.getString("REFERENCE_CODE"));
	                
	                detailsOfCourses.add(courses);*/
	            	
	            	
	            	/*DetailsPrint detailsPrint = new DetailsPrint();
	            	
	            	detailsPrint.setCourseTitle(resultSet.getString("COURSE_TITLE"));
	            	detailsPrint.setReferenceCode(resultSet.getString("REFERENCE_CODE"));
	            	detailsPrint.setHeading_text(resultSet.getString("HEADING_TEXT"));
	            	detailsPrint.setSubheading(resultSet.getString("SUBHEADING"));
	            	detailsPrint.setCompletion_status(resultSet.getString("COMPLETION_STATUS"));
	           	detailsOfCourses.add(detailsPrint);*/
	                
	            }
	            System.out.println("------Start while-------");
	            while(resultSet1.next()){
	            	System.out.println("------------inside details----------------");
	            	DetailsPrint detailsPrint1=new DetailsPrint();
	            	detailsPrint1.setCourseTitle(resultSet1.getString("COURSE_TITLE"));
	            	detailsPrint1.setReferenceCode(resultSet1.getString("REFERENCE_CODE"));
	            	while(resultSet2.next()){
	            		
	            		Heading heading=new Heading();
	            		heading.setHeading_text(resultSet2.getString("heading_text"));
	            		heading.setHeading_id((resultSet2.getInt("heading_id")));
	            		System.out.println("inside heading"+heading.getHeading_id());
	            		String query3="Select * from subheading where heading_id='"+heading.getHeading_id()+"'";
	            		ResultSet resultSet3 = DBUtil.select(query3);
	            		while(resultSet3.next()){
	            			Subheading subheading=new Subheading();
	            			subheading.setSubheadin(resultSet3.getString("subheading"));
	            			subheading.setSubheading_id(resultSet3.getInt("subheading_id"));
	            			subheading.setCompletion_status(resultSet3.getString("completion_status"));
	            			subheadings.add(subheading);
	            			System.out.println("subheading"+subheading);
	            			System.out.println("subheadings"+subheadings);
	            		}
	            		
	            		heading.setSubheading(subheadings);
	            		headings.add(heading);
	            		System.out.println("heading"+heading);
            			System.out.println("headings"+headings);
            			
	            	}	            	
	            	
	            	detailsPrint1.setHeadingList(headings);
	            	detailsOfCourses.add(detailsPrint1);
	            		
	            	
	            	
	            }
	            
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        System.out.println(detailsOfCourses);
	        return detailsOfCourses;
		
	}

	@Override
	public int getStatus(int selecetedCourse_id) {
		String query = "SELECT status_id FROM COURSES WHERE COURSE_ID = " +selecetedCourse_id ;
		int status = 0;
		ResultSet resultSet = DBUtil.select(query);
			try {
				while(resultSet.next()){
				if(resultSet.getInt(1) == 1){
					
				}
				else{
					status = 1;
				}
			 } 
		   }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return status;
	}

	@Override
	public void changeStatusMethod(int status, int selectedCourse_id) {
		String query = "UPDATE courses SET status_id = " +status + " WHERE COURSE_ID = " + selectedCourse_id;
		  try {
			DBUtil.update(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public int getTotalActiveCourses() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteCourse(int selectedCourse_id) {
		// TODO Auto-generated method stub
		String query="Delete  from courses where course_id="+selectedCourse_id;
		DBUtil.update(query);
		System.out.println("-----------courses deleted successfully---------------");
	}
	

	
	

	

}
