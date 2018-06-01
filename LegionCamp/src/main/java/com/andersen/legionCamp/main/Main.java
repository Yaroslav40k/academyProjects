package com.andersen.legionCamp.main;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.andersen.legionCamp.configuration.ApplicationConfig;
import com.andersen.legionCamp.entities.campPopulation.Evocatus;
import com.andersen.legionCamp.entities.campPopulation.Legionarius;


public class Main {

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml"); 
		Legionarius legionary = (Legionarius) appContext.getBean("Triarius");
		legionary.speak();
		legionary.move();
		legionary.fight();
		Evocatus evocatus = (Evocatus) appContext.getBean("Evocatus");
		evocatus.speak();
		evocatus.getSkill().useSkill();
	}

}
