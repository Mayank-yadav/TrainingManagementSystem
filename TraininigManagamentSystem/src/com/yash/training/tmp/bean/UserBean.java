package com.yash.training.tmp.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import com.yash.training.tmp.domain.Designation;
import com.yash.training.tmp.domain.ManagerMenu;
import com.yash.training.tmp.domain.TraineeMenu;
import com.yash.training.tmp.domain.TrainerMenu;
import com.yash.training.tmp.domain.User;
import com.yash.training.tmp.service.UserBeanServiceLocal;


@ManagedBean
@SessionScoped
public class UserBean {
	

	@Inject
	ManagerMenu managerMenu;

	@Inject
	TrainerMenu trainerMenu;

	@Inject
	TraineeMenu traineeMenu;

	@EJB
	UserBeanServiceLocal userbeanservice;
	private String userName="Guest";
	private String password="Password";
	private String name;
	private String contact;
	private int designation;
	private int user_id;
	private int course_count;
	
	public int getCourse_count() {
		return course_count;
	}
	public void setCourse_count(int course_count) {
		this.course_count = course_count;
	}
	List<String> populateList = new ArrayList<>();

	
	
	
	public List<String> getPopulateList() {
		return populateList;
	}
	public void setPopulateList(List<String> populateList) {
		this.populateList = populateList;
	}
	public int getDesignation() {
		return designation;
	}
	public void setDesignation(int designation) {
		this.designation = designation;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private String email;
	

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getCourseCount(int User_id){
		course_count=userbeanservice.getCourseCount(User_id);
		
		System.out.println("-------done counting---------");
		return course_count;
	}
	
	
	public String LoginAction() throws Exception{
		System.out.println("inside login");
		User users=new User();
		users.setUsername(userName);
		users.setPassword(password);
		System.out.println("login"+users);
		
		String message=userbeanservice.authencticateUser(userName,password);
		if(message.equals("success")){
			
	        FacesContext context = FacesContext.getCurrentInstance();
			 User user=userbeanservice.getUserDetails(userName, password);
			 	user_id=user.getUser_id();
	            context.getExternalContext().getSessionMap().put("loggedinuser", user);
	            getCourseCount(user_id);
			 setName(user.getUser_name());
				int d_id = user.getDesination_id();
				if (d_id == 1) {
					populateList.add(managerMenu.getAddTrainingPlan());
					populateList.add(managerMenu.getRemoveTrainer());
					populateList.add(managerMenu.getTestResult());
					populateList.add(managerMenu.getSeeAllTrainers());

					System.out.println("this is manager");
				}

				if (d_id == 2) {

					populateList.add(trainerMenu.getSetPoc());
					populateList.add(trainerMenu.getPerfomanceSheet());
					populateList.add(trainerMenu.getSeeAllTrainees());
					populateList.add(trainerMenu.getSeeTrainingSchedule());
					
					for (String mList : populateList)
						System.out.println("--------------" + mList + "----------------------");

					System.out.println("this is trainer");
				}
				if (d_id == 3) {

					populateList.add(traineeMenu.getApplyForLeave());
					populateList.add(traineeMenu.getSeePocs());
					populateList.add(traineeMenu.getSeeTestResults());
					populateList.add(traineeMenu.getSendFeedback());
					
					for (String mList : populateList)
						System.out.println("--------------" + mList + "----------------------");

					System.out.println("this is trainee");
				}

			
			
			return "topmenu.xhtml";
		}
		else{
			return "index?err="+message+" faces-redirect=true";
		}
		//index?err=invalid username or password faces-redirect=true
		
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String registrationAction() throws Exception{
		System.out.println("inside registration"+designation);
		User user=new User();
		user.setUser_name(name);
		user.setUsername(userName);
		user.setPassword(password);
		user.setUser_email_id(email);
		user.setUser_contact(contact);
	
		userbeanservice.registerUser(user, designation);
		return "index.xhtml";
		
	}
	
	
	public String logout() {
		HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
				.getSession(false);
		httpSession.invalidate();
		System.out.println("System invalidated");
		return "index.xhtml";
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	

	
}
