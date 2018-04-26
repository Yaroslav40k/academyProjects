package com.andersen.patterns.decorator;

public class MiniatureFactory {

	public static void main(String[] args) {
			 		
		Paintable lemanRuss = new Miniature("Leman Russ",100);
		Paintable raider = new Miniature("Raider",100);
		
		lemanRuss = new Base(lemanRuss,"Sand", 5);
		lemanRuss = new Magnet(lemanRuss, "Each Weapon Magnetised", 20);
		
		
		System.out.println(lemanRuss.getDescription());
		System.out.println(raider.getDescription());
		
		
		

	}

}
