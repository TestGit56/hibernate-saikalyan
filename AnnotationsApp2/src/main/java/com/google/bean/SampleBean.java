package com.google.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class SampleBean {
	
	private String message = null;

	@Value(value = "Demo on PostConstruct and preDerstroy methods")
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	public SampleBean() {
		System.out.println("\n\n object created and depedency injection");
		
	}

  
	public void init()
	{
	  
		System.out.println("\n\n intializationPhase ");
		
	}
	
	
	

}
