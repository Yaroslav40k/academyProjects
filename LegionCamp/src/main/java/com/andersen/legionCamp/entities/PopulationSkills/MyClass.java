package com.andersen.legionCamp.entities.PopulationSkills;

public class MyClass {
	
	private int x;

	public void setX(int x) {
		this.x = x;
	}

public static final void xi( ){

}
	@Override
	public boolean equals(Object obj) {
		
		setX(5);
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyClass other = (MyClass) obj;
		if (x != other.x)
			return false;
		return true;
	}
	
	

}
