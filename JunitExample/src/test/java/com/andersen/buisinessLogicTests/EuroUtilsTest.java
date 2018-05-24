package com.andersen.buisinessLogicTests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.andersen.buisinessLogic.EuroUtils;

/*
 * Tests for   EuroUtils class
 * comments just for me, to remember details
 */
public class EuroUtilsTest {

	private BigDecimal input;
	private static String veryLargeString;
	private static double seashellsExpected = 14.346540000000001;

	// invoked once before all tests in this class, method must be STATIC!
	@BeforeClass
	public static void setUpClass() {
		veryLargeString = new BigInteger(16384, new Random()).toString();
	}

	// invoked before each test
	@Before
	public void setUp() {
		input = new BigDecimal(14346.54);
	}

	@Test
	public void usdToEuroConversionTest() {
		BigDecimal euroExpected = new BigDecimal(17359.31).setScale(2, BigDecimal.ROUND_DOWN);
		assertEquals("Wrong output euro value", euroExpected, EuroUtils.convertUSDToEuro(input));
	}

	@Test
	public void euroZoneDebitTest() {
		int europeCountries = 27;
		assertFalse("Wrong! Gonduras is bigger!", EuroUtils.isEuroZoneDebitBig(europeCountries));
	}

	@Test
	public void euroToSeashellsConversionTest() {
		double seashellsExpected = 14.346540000000001;
		assertEquals("Wrong output seashells value", seashellsExpected, EuroUtils.convertEuroToSeashells(input), 0.01);
	}

	@Test
	public void euroToArrayTest() {
		int roundScale = 2;
		int roundType = BigDecimal.ROUND_DOWN;
		int[] expected = { 1, 4, 3, 4, 6, 5, 4 };
		assertArrayEquals("Wrong array", expected, EuroUtils.toArray(input, roundScale, roundType));
	}

	@Test(expected = NullPointerException.class)
	public void nullPointerExceptionTest() {
		EuroUtils.convertEuroToSeashells(null);
	}

	// invoked after each test
	@After
	public void tearDown() {
		input = null;
	}

	// invoked once after all tests in this class, method must be STATIC!
	@AfterClass
	public static void tearDownClass() {
		veryLargeString = "";
		seashellsExpected = 0;
	}

}
