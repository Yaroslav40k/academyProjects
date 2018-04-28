package com.andersen.patterns.abstractFactory;

public class LinuxFactory implements AbstarctFactory {

	@Override
	public Window createWindow() {
		return new LinuxWindow();
	}

	@Override
	public Button createButton() {
		return new LinuxButton();
	}



}
