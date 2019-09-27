package com.google.bean;

public class CountryBean {

	private StateBean stateBean = null;
	
	
	public void getInfo()
	{
	
		stateBean.getInfo();
		System.out.println("From CountryBean");
		
	}


	public void setStateBean(StateBean stateBean) {
		this.stateBean = stateBean;
	}
	
	
	
}
