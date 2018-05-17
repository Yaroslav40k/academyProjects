package com.andersen.patterns.factoryMethod;

public class Client {

	
	public static void main(String[] args) {
		CarSelector selector = new CarSelector();
		Car a = selector.createCar(CarType.SPORT);
		Car b = selector.createCar(CarType.OFFROAD);
		Car c = selector.createCar(CarType.URBAN);
		
		a.print();
		b.print();
		c.print();
	}
}
