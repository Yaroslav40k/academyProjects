package com.andersen.BorisovsSpringExample;
import static org.junit.Assert.*;
import java.io.IOException;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.andersen.borisovExample.Repeater;
import com.andersen.borisovExample.RepeaterImpl;

public class RepeaterTest {

	@Test
	public void repeaterTest() throws IOException, InterruptedException {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

	}
}
