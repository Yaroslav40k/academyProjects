package com.andersen.patterns.builder;

public class Marine {
	
	private String chapter;
	private String role;
	private int wounds;
	
	
	public String getChapter() {
		return chapter;
	}
	public void setChapter(String chapter) {
		this.chapter = chapter;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getWounds() {
		return wounds;
	}
	public void setWounds(int wounds) {
		this.wounds = wounds;
	}
	@Override
	public String toString() {
		return "Marine [chapter=" + chapter + ", role=" + role + ", wounds=" + wounds + "]";
	}
	
	
	

}
