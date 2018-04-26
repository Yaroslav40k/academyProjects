package com.andersen.patterns.command;

public class SwordCommand implements Command {
	
	SwordTheReceiver sword;
	

	public SwordCommand(SwordTheReceiver sword) {
		super();
		this.sword = sword;
	}

	@Override
	public void execute() {
		System.out.println("It`s a sword command, i give command to the sword!");
		sword.action();

	}

	@Override
	public void undo() {
		System.out.println("Returning sword...");

	}

}
