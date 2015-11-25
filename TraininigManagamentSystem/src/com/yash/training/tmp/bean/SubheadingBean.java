package com.yash.training.tmp.bean;



import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.yash.training.tmp.domain.Subheading;
import com.yash.training.tmp.domain.User;
import com.yash.training.tmp.service.SubheadingBeanService;

@ManagedBean
@SessionScoped
public class SubheadingBean {
	String heading_text;
	int heading_id;
	String subheadin;
	String completion_status;

	@EJB
	SubheadingBeanService subheadingService;
	public int getHeading_id() {
		return heading_id;
	}

	public String getHeading_text() {
		return heading_text;
	}

	public void setHeading_text(String heading_text) {
		this.heading_text = heading_text;
	}

	public void setHeading_id(int heading_id) {
		this.heading_id = heading_id;
	}

	
	public String getSubheadin() {
		return subheadin;
	}

	public void setSubheadin(String subheadin) {
		this.subheadin = subheadin;
	}

	
	
	public String getCompletion_status() {
		return completion_status;
	}

	public void setCompletion_status(String completion_status) {
		this.completion_status = completion_status;
	}

	public String saveSubheading(){
		
		Subheading subheading = new Subheading(); 
		
		System.out.println("our status"+completion_status);
		System.out.println("heading:"+heading_text);
        User user=(User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loggedinuser");
        heading_id=subheadingService.getHeadingid(user, heading_text);
		System.out.println(heading_id);
		subheading.setHeading_id(heading_id);
		subheading.setSubheadin(subheadin);
		subheading.setCompletion_status(completion_status);
		
		subheadingService.saveSubheadingService(subheading);
		
		return "createdetailcourse";
	}
	
	
	
	
	
	
}
