package com.andersen.gradle;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MainAppTest {
	
	MainApp app;
	
	@Before
	public void initMainApp() {
       app = new MainApp();  
	}

	@Test
	public void gradleInitTest() {
        String gradleConfig = "Some very strange config";
        String expectedOutput = "Some very strange config has been loaded, Gradle is ok!";
        String gradleInitResult = app.initGradle(gradleConfig);
        assertEquals ("Wrong gradle configuration!",expectedOutput,gradleInitResult);
	}
}
