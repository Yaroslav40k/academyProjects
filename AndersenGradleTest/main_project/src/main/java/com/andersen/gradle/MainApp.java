package com.andersen.gradle;

import org.apache.log4j.Logger;

public class MainApp {
	
	private static final Logger LOG = Logger.getLogger(MainApp.class);

	public static void main(String[] args) throws InterruptedException {
		
		LOG.info("Application started");
		Simple simple = new Simple();
		System.out.println("Simple value is " +simple.getValue());
		MainApp app = new MainApp();
		app.initGradle("Some very strange config");
		Thread.sleep(2000);
		System.out.println("Finish!");
		LOG.info("Application finished");
	}
	
	public  String initGradle(String inputConfig) {
		return inputConfig + " has been loaded, Gradle is ok!";
	}
}
