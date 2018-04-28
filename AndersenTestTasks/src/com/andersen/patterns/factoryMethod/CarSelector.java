package com.andersen.patterns.factoryMethod;

public class CarSelector {
	
	public Car createCar(CarType type) {
		
		Car car = null;
		
		switch (type) {
		case URBAN:			
			car = new UrbanCar();
			break;
		case OFFROAD:			
			car = new OffroadCar();
			break;
		case SPORT:			
			car = new SportCar();
			break;
		}
		return car;
	}

}
