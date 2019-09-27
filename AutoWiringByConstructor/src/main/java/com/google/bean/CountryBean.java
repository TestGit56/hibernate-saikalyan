package com.google.bean;

public class CountryBean {
	
	
	private StateBean stateBean = null;
	
	
	



	public CountryBean(StateBean stateBean) {
		super();
		this.stateBean = stateBean;
	}






	public void getInfo()
	{
		System.out.println("From CountryBean Welcome");
		stateBean.getInfo();
	}

}
