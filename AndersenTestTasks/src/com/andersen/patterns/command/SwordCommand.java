package com.andersen.patterns.command;

public class SwordCommand implements Command {
	
	private HeadTheReceiver head;
	

	public SwordCommand(HeadTheReceiver head) {
		super();
		this.head = head;
	}

	@Override
	public void execute() {
		System.out.println("It`s a sword command");
		head.actionTwo();

	}

	@Override
	public void undo() {
		System.out.println("Returning sword...");

	}

}
