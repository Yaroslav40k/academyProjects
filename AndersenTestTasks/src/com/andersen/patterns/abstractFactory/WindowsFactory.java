package com.andersen.patterns.abstractFactory;

public class WindowsFactory implements AbstarctFactory {

	@Override
	public Window createWindow() {
		return new WindowsWindow();
	}

	@Override
	public Button createButton() {
		return new WindowsButton();
	}



}
