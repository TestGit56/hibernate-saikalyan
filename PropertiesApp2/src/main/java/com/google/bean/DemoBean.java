package com.google.bean;

public class DemoBean {
	
	private String username = null;
	private String password = null;
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "DemoBean [username=" + username + ", password=" + password + "]";
	}
	public void getInfo()
	{
		System.out.println("From SampleBean");
	}

}
