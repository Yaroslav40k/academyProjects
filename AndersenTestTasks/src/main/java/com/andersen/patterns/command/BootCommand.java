package com.andersen.patterns.command;

public class BootCommand implements Command {
	
	private HeadTheReceiver head;
		

	public BootCommand(HeadTheReceiver head) {
		super();
		this.head = head;
	}

	@Override
	public void execute() {
		System.out.println("It`s a boot command");
		head.actionOne();

	}

	@Override
	public void undo() {
		System.out.println("Returning boot...");

	}

}
