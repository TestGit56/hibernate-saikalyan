package com.google.bean;

public class CountryBean {
	
	private StateBean stateBean = null;
	 
	
	public void getInfo()
	{
		System.out.println("Welcome To india From Country");
		stateBean.getInfo();
	}
	

}
