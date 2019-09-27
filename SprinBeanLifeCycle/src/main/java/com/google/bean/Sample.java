package com.google.bean;

public class Sample {
	
	private String message = null;
	
	public Sample()
	{
		System.out.println("Instantiation phase Spring bean Object created");
	}
	
	
	public void setMessage(String message) {
		this.message = message;
	}


	public void init()
	{
		System.out.println("\n\nIntializationPhase after creating Object");
	}
	
	public void service()
	{
		System.out.println("\n\nThe Object is ready to give Services   ::"+message);
	}
	
	public void destroy()
	{
		System.out.println("Deallocation loigics will be Written in here");
	}

}
