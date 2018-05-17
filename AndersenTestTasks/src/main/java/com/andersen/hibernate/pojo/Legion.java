package com.andersen.hibernate.pojo;

import java.io.Serializable;

/*
 * Represents ancient roman Legion instance
 * 			params :id , name, leader id
 * 					
 */
public class Legion implements Serializable {

	private int legioId;
	private Leader leader;
	private String legioName;

	public Legion() {
	}

	

	public int getLegioId() {
		return legioId;
	}



	public void setLegioId(int legioId) {
		this.legioId = legioId;
	}



	public Leader getLeader() {
		return leader;
	}



	public void setLeader(Leader leader) {
		this.leader = leader;
	}



	public String getLegioName() {
		return legioName;
	}



	public void setLegioName(String legioName) {
		this.legioName = legioName;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((legioName == null) ? 0 : legioName.hashCode());
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
		if (legioName == null) {
			if (other.legioName != null)
				return false;
		} else if (!legioName.equals(other.legioName))
			return false;
		return true;
	}

}
