package com.andersen.concurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Semaphore;

public class CarThread implements Runnable {

	private String name;
	private Semaphore sem;
	private ArrayList<Boolean> parkingPlace;
	private int parkingPlaceNumber;

	public CarThread(String name, ArrayList<Boolean> parkingPlace, Semaphore sem) {
		super();
		this.name = name;
		this.parkingPlace = parkingPlace;
		this.sem = sem;
		new Thread(this).start();
	}

	@Override
	public void run() {
		System.out.println("Car " + name + " is created");
		System.out.println("Car " + name + " wants to enter the parking...");
		try {
			sem.acquire();
			System.out.println("Car " + name + " has entered parking");
			synchronized (parkingPlace) {
				for (int i = 0; i < 3; i++) {
					System.out.println(name+ " is searching...place "+i);
					if (parkingPlace.get(i).equals(false)) {
						parkingPlaceNumber = i;
						parkingPlace.set(i, true);
						System.out.println("Car " + name + " has entered place #" + i);
						break;
					}
				}
			}
			Thread.sleep(2000);
			synchronized (parkingPlace) {
				parkingPlace.set(parkingPlaceNumber, false);
				sem.release();
				System.out.println("Car " + name + " has left place #" + parkingPlaceNumber);
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
