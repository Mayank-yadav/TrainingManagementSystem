package com.yash.training.tmp.service;

import java.util.List;

import javax.ejb.Local;

import com.yash.training.tmp.domain.Courses;
import com.yash.training.tmp.domain.DetailsPrint;
import com.yash.training.tmp.domain.User;

@Local
public interface CoursesBeanServiceLocal {

	public String saveCourses(Courses courses);
	public List<String> getUserCoursetext(User user);
	public List<Courses> getAllCoursesService();
	public List<DetailsPrint> getCoursesDetailsService(int course_id);
	public int getStatus(int selecetedCourse_id);
	public void changeStatusMethod(int status,int selectedCourse_id);
	public int getTotalActiveCourses();
	public void deleteCourse(int selectedCourse_id);
}
