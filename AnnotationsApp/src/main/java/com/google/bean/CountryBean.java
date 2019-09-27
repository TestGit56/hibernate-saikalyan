package com.google.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CountryBean {
	
	private StateBean stateBean = null;
	
	@Autowired
	public void setStateBean(StateBean stateBean) {
		this.stateBean = stateBean;
	}



   public void getInfo()
	{
		System.out.println("From countryBean Welcome");
		stateBean.getInfo();
	}


}
