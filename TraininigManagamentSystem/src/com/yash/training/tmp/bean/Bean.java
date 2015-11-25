package com.yash.training.tmp.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
@ManagedBean
	 @ViewScoped
	public class Bean {

	    private boolean enabled;

	    public void toggle() {
	        enabled = !enabled;
	    }

		public boolean isEnabled() {
			return enabled;
		}

		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}

	  

	}

