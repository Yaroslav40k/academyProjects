package com.andersen.patterns.command;

public class Client {
	
	public static void main(String[] args) {
		
		LawyerTheInvoker lawyer = new LawyerTheInvoker();
		
		BootTheReceiver boot = new BootTheReceiver();
		lawyer.setCommand(new BootCommand(boot));
		lawyer.getCommand().execute();
		lawyer.getCommand().undo();

		
		SwordTheReceiver sword  = new SwordTheReceiver();
		lawyer.setCommand(new SwordCommand(sword));
		lawyer.getCommand().execute();
		
	}
}
