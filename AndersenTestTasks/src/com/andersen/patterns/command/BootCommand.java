package com.andersen.patterns.command;

public class BootCommand implements Command {
	
	BootTheReceiver boot;
		

	public BootCommand(BootTheReceiver boot) {
		super();
		this.boot = boot;
	}

	@Override
	public void execute() {
		System.out.println("It`s a boot command, i give command to the boot!");
		boot.action();

	}

	@Override
	public void undo() {
		System.out.println("Returning boot...");

	}

}
