package com.andersen.algoritms;

import java.util.ArrayList;

public class Recursion {

	public static void main(String[] args) {
		System.out.println(fib(9));

	}

	public static int fib(int n) {
		if (n <= 1) {
			return n;
		} else {
			return fib(n - 1) + fib(n - 2);
		}
	}
	
	
}
