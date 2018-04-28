package com.andersen.patterns.command;

public class Client {

	public static void main(String[] args) {

		LawyerTheInvoker lawyer = new LawyerTheInvoker();
		HeadTheReceiver head = new HeadTheReceiver();

		lawyer.setSwordToTheHead(new SwordCommand(head));
		lawyer.setBootToTheHead(new BootCommand(head));
		lawyer.bootCommand();
		lawyer.swordCommand();

	}
}
