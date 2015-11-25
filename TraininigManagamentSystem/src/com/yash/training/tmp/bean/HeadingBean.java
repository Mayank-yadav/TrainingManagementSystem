package com.yash.training.tmp.bean;



import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.yash.training.tmp.domain.Courses;
import com.yash.training.tmp.domain.Heading;
import com.yash.training.tmp.domain.User;
import com.yash.training.tmp.service.HeadingBeanService;
import com.yash.training.tmp.service.HeadingBeanServiceLocal;

@ManagedBean
@SessionScoped
public class HeadingBean {

	@EJB
	HeadingBeanServiceLocal headingService;
	String course_title;
	String heading_text;
	int heading_id;
	
	public int getHeading_id() {
		return heading_id;
	}

	public void setHeading_id(int heading_id) {
		this.heading_id = heading_id;
	}

	List<Courses> courses;
	List<String> headings;
	
	int course_id;

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

	public String headingSave() {
		System.out.println("-------------inside save code--------------");
		Heading heading = new Heading();
        User user=(User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loggedinuser");
       System.out.println(course_title);
        course_id=headingService.getCourseid(user,course_title);
		System.out.println(heading_text);
		System.out.println(course_id);
		heading.setCourse_id(course_id);
		heading.setHeading_text(heading_text);

		headingService.saveHeadingService(heading);

		return "createdetailcourse";
	}
	
	public String getCourse_title() {
		return course_title;
	}

	public void setCourse_title(String course_title) {
		this.course_title = course_title;
	}

	public List<String> getAllHeadings(){
		System.out.println("inside getheadings()");
		try {
			
			headings=headingService.getHeadings();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return headings;
		
	}
	
	
	
	
	

}
