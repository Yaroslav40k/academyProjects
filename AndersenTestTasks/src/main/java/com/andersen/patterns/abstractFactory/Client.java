package com.andersen.patterns.abstractFactory;

public class Client {

	
	public static void main(String[] args) {
		AbstarctFactory factory = new WindowsFactory();
		Button button = factory.createButton();
		Window window = factory.createWindow();
		button.print();
		window.print();
		
		factory = new LinuxFactory();
		button = factory.createButton();
		window = factory.createWindow();
		button.print();
		window.print();
	}
}
