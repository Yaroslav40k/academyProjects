package com.andersen.patterns.command;

public class LawyerTheInvoker {
	Command bootToTheHead;
	Command swordToTheHead;
	
	
	public void setBootToTheHead(Command bootToTheHead) {
		this.bootToTheHead = bootToTheHead;
	}
	public void setSwordToTheHead(Command swordToTheHead) {
		this.swordToTheHead = swordToTheHead;
	}

	
	public void bootCommand() {
		bootToTheHead.execute();
	}
	

	public void swordCommand() {
		swordToTheHead.execute();
	}

	
	

}
