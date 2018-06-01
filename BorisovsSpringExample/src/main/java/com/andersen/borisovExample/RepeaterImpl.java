package com.andersen.borisovExample;

import javax.annotation.PostConstruct;

@Profiling
public class RepeaterImpl implements Repeater {

	@InjectRandomSpeed(min=1,max=10)
	private int speed;
	
	private String action;
	
	public RepeaterImpl() {
		System.out.println("PHASE 1");
	}
	
	@PostConstruct
	public void init(){
		System.out.println("PHASE 2");
	}	
	
	@PostProxy
	public void repeat() {
		System.out.println("PHASE 3");
        System.out.println("Action :  " + action); 
        System.out.println("Trukk speed : "+speed);
	}

	public void setAction(String action) {
		this.action = action;
	}
	
	

}
