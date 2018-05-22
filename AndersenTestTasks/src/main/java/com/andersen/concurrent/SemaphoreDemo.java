package com.andersen.concurrent;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

	private static ArrayList<Boolean> parkingPlace = new ArrayList<>();
	private static Semaphore semaphore = new Semaphore(2, true);

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			parkingPlace.add(false);

		}

		try {
			CarThread bmw = new CarThread("BMW", parkingPlace, semaphore);
			Thread.sleep(400);
			CarThread alfaRomeo = new CarThread("AlfaRomeo", parkingPlace, semaphore);
			Thread.sleep(400);
			CarThread lada = new CarThread("Lada Vesta", parkingPlace, semaphore);
			Thread.sleep(400);
			CarThread zaporosets = new CarThread("ZAZ 969", parkingPlace, semaphore);
			Thread.sleep(400);
			CarThread belaz = new CarThread("BELAZ", parkingPlace, semaphore);
			Thread.sleep(400);
		} catch (Exception e) {

		}
	}
}
