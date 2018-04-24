package com.andersen.concurrent;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(3);
	}

}

class somePoorThread {
	private String name;
	private CyclicBarrier barrier;
	
	
	public somePoorThread(String name, CyclicBarrier barrier) {
		super();
		this.name = name;
		this.barrier = barrier;
	}
}
