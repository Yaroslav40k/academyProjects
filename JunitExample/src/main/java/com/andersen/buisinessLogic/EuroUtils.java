package com.andersen.buisinessLogic;

import java.math.BigDecimal;

public class EuroUtils {

	private EuroUtils() {
	}

	/**
	 * Converts USD to Euro,using 1.21 Exchange Rate
	 *
	 * @param usdSum
	 *            USD amount,prepared for conversion.
	 */
	public static BigDecimal convertUSDToEuro(BigDecimal usdSum) {
		BigDecimal euroToUSDExchangeRate = new BigDecimal(1.21);
		return usdSum.multiply(euroToUSDExchangeRate).setScale(2, BigDecimal.ROUND_DOWN);
	}

	/**
	 * Compare Euro Zone debit with Gonduras debit
	 *
	 * @param currentEuroZoneSize
	 *            total amount of countries in Euro Zone .
	 */
	public static boolean isEuroZoneDebitBig(int currentEuroZoneSize) {
		BigDecimal gondurasDebit = new BigDecimal(99999);
		BigDecimal euroDebitPerCountry = new BigDecimal(1000);
		BigDecimal euroDebit = euroDebitPerCountry.multiply(new BigDecimal(currentEuroZoneSize));
		if (euroDebit.compareTo(gondurasDebit) >= 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Converts Euro to seashells ,using 0.001 Exchange Rate
	 *
	 * @param euro
	 *            Euro amount,prepared for conversion.
	 */
	public static double convertEuroToSeashells(BigDecimal euro) {
		BigDecimal euroToSeaShellsExchangeRate = new BigDecimal(0.001);
		return euro.multiply(euroToSeaShellsExchangeRate).doubleValue();
	}

	/**
	 * Separates euro input by simple numbers and puts them in the array
	 * Scale by default is set to 2.
	 * @param euro Euro amount,prepared for input.
	 * @param scale numbers after dot .
	 * @param roundType choose from  BigDecimal.class.
	 */
	public static int[] toArray(BigDecimal euro,int scale, int roundType) {
		BigDecimal tempDecimal = euro.setScale(scale, roundType);
		String tempString= tempDecimal.toString();
		StringBuilder euroString = new StringBuilder(tempString.substring(0, euro.toString().indexOf('.')) + tempString.substring(tempString.indexOf('.')+1)) ;
		int[] euroIntsArray = new int[euroString.length()];
		for (int i = 0; i < euroString.length(); i++) {
			euroIntsArray[i] = Integer.parseInt(Character.toString(euroString.charAt(i)));
		}
		return euroIntsArray;
	}
}
