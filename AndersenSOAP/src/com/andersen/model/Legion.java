package com.andersen.model;

/*
 *  Legion class bean
 *  
 */

public class Legion {

	private String legionName;
	private String founder;
	private int strength;

	public Legion() {
	}

	public String getLegionName() {
		return legionName;
	}

	public void setLegionName(String legionName) {
		this.legionName = legionName;
	}

	public String getFounder() {
		return founder;
	}

	public void setFounder(String founder) {
		this.founder = founder;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((founder == null) ? 0 : founder.hashCode());
		result = prime * result + ((legionName == null) ? 0 : legionName.hashCode());
		result = prime * result + strength;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Legion other = (Legion) obj;
		if (founder == null) {
			if (other.founder != null)
				return false;
		} else if (!founder.equals(other.founder))
			return false;
		if (legionName == null) {
			if (other.legionName != null)
				return false;
		} else if (!legionName.equals(other.legionName))
			return false;
		if (strength != other.strength)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Legion [legionName=" + legionName + ", founder=" + founder + ", strength=" + strength + "]";
	}

}
