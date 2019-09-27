package com.google.bean;

public class CountryBean {
	
	private StateBean stateBean = null;
	
	
	public void setStateBean(StateBean stateBean) {
		this.stateBean = stateBean;
	}

public StateBean getStateBean() {
		return stateBean;
	}

public void getInfo()
	{
		System.out.println("From countryBean Welcome");
		stateBean.getInfo();
	}


}
