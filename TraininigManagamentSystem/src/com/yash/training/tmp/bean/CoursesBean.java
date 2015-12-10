package com.yash.training.tmp.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.yash.training.tmp.domain.Courses;
import com.yash.training.tmp.domain.DetailsPrint;
import com.yash.training.tmp.domain.Heading;
import com.yash.training.tmp.domain.Subheading;
import com.yash.training.tmp.domain.User;
import com.yash.training.tmp.service.CoursesBeanServiceLocal;

@ManagedBean
@SessionScoped
public class CoursesBean {

	private int course_id;
	private String course_title;
	private String description;
	private String reference_code;
	private String upload;
	private String status;
	private int allActiveCoursesCount;
	private int allCurrentCoursesCount;
	private int selectedCourse_id;
	List<Courses> courseList = new ArrayList<>();
	public int getAllActiveCoursesCount() {
		return allActiveCoursesCount;
	}

	public void setAllActiveCoursesCount(int allActiveCoursesCount) {
		this.allActiveCoursesCount = allActiveCoursesCount;
	}

	public int getAllCurrentCoursesCount() {
		return allCurrentCoursesCount;
	}

	public void setAllCurrentCoursesCount(int allCurrentCoursesCount) {
		this.allCurrentCoursesCount = allCurrentCoursesCount;
	}

	public int getSelectedCourse_id() {
		return selectedCourse_id;
	}

	public void setSelectedCourse_id(int selectedCourse_id) {
		this.selectedCourse_id = selectedCourse_id;
	}

	private List<String> coursetitles;

	public List<Courses> getCourseList() {
		
		
		
		return courseList;
	}

	public void setCourseList(List<Courses> courseList) {
		this.courseList = courseList;
	}

	public List<DetailsPrint> getCourseDetailsList() {
		
		
		return courseDetailsList;
	}

	public void setCourseDetailsList(List<DetailsPrint> courseDetailsList) {
		this.courseDetailsList = courseDetailsList;
	}

	List<DetailsPrint> courseDetailsList = new ArrayList<>();

	public List<String> getCoursetitles() {
		return coursetitles;
	}

	public void setCoursetitles(List<String> coursetitles) {
		this.coursetitles = coursetitles;
	}

	@EJB
	CoursesBeanServiceLocal coursesbeanservice;

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCourse_title() {
		return course_title;
	}

	public void setCourse_title(String course_title) {
		this.course_title = course_title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReference_code() {
		return reference_code;
	}

	public void setReference_code(String reference_code) {
		this.reference_code = reference_code;
	}

	public String getUpload() {
		return upload;
	}

	public void setUpload(String upload) {
		this.upload = upload;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String save() {
		System.out.println("inside save()");
		Courses courses = new Courses();
		courses.setCourse_title(course_title);
		courses.setDescription(description);
		courses.setReference_code(reference_code);
		if (status == "true") {
			courses.setStatus(1);
		} else {
			courses.setStatus(0);
		}
		courses.setUpload(upload);
		System.out.println("" + courses.getStatus());
		coursesbeanservice.saveCourses(courses);
		return "createcourse.xhtml";
	}

	public List<String> getCourseTitle() {
		System.out.println("inside coursetitle");
		User user = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loggedinuser");
		System.out.println("" + user.getUser_id());
		coursetitles = coursesbeanservice.getUserCoursetext(user);
		System.out.println(coursetitles);

		return coursetitles;

	}

	public String displayDetails() {
		System.out.println("getting details:course" + course_id);
		courseDetailsList = coursesbeanservice.getCoursesDetailsService(course_id);

		System.out.println("---------Going to details page--------------" + courseDetailsList);

		for (DetailsPrint print : courseDetailsList) {
			System.out.println(print.getCourseTitle());
			for (Heading h : print.getHeadingList()) {
				System.out.println(h.getHeading_text());
				for (Subheading s : h.getSubheading()) {
					System.out.println(s.getSubheadin());
				}

			}

		}

		return "details";

	}

	public String printCourses() {

		courseList = coursesbeanservice.getAllCoursesService();

		return "course";
	}
	
	public void changeStatusMethod(){
		System.out.println(selectedCourse_id+"------changeStatusmethod()------------");
		int receivedStatus = coursesbeanservice.getStatus(selectedCourse_id);
		coursesbeanservice.changeStatusMethod(receivedStatus,selectedCourse_id);
		printCourses();
		
	}
	
	public String deleteCourse(){
		System.out.println("--------Delete Courses---------:"+selectedCourse_id);
		coursesbeanservice.deleteCourse(selectedCourse_id);
		
		return "course.xhtml";
	}
	

}
