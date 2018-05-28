package com.andersen.legionCamp.main;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.andersen.legionCamp.configuration.ApplicationConfig;
import com.andersen.legionCamp.entities.campPopulation.Legionarius;


public class Main {

	public static void main(String[] args) {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(ApplicationConfig.class); 
		Legionarius legionary = appContext.getBean(Legionarius.class);
		System.out.println(legionary);

	}

}
