package com.andersen.borisovExample;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		while(true)
		{
			Thread.sleep(5000);
		context.getBean(Repeater.class).repeat();
		}

	}

}
