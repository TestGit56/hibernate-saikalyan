package com.google.bean;

import java.util.Properties;

public class SampleBEan {
	private String username =null;
	private String password =null;
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void getInfo()
	{
		System.out.println("From SampleBean");
	}
	@Override
	public String toString() {
		return "SampleBEan [username=" + username + ", password=" + password + "]";
	}
	


}
