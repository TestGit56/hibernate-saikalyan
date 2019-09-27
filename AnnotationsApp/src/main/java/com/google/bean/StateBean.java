package com.google.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName="singleton")
public class StateBean {
	
	
	
	
	public void getInfo()
	{
		System.out.println("From stateBean");
	}

}
