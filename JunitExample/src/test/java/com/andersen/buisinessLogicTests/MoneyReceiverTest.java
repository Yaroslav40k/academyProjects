package com.andersen.buisinessLogicTests;

import org.junit.Test;

import com.andersen.buisinessLogic.MoneyReceiver;
import static org.junit.Assert.*;

public class MoneyReceiverTest {
	
	@Test
	public void  receiveEuroTest() {
		MoneyReceiver receiver = new MoneyReceiver();
		assertEquals("100 euro received", receiver.receiveEuro(100));
	}

}
