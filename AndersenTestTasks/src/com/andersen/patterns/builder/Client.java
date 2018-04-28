package com.andersen.patterns.builder;

public class Client {

	public static void main(String[] args) {
		Director director = new Director();
		AbstractBuilder builder = new BloodAngelBuilder();
		director.setBuilder(builder);
		director.constructMarine();
		Marine marine = director.getmarine();
		System.out.println(marine);

	}

}
