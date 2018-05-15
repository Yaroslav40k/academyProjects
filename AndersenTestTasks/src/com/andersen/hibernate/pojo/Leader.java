package com.andersen.hibernate.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/*
 * Represents ancient roman leader instance
 * 			params :id , name, power , money, legions list
 * 					
 */
public class Leader implements Serializable {

	private int leaderId;
	private String leaderName;
	private int leaderPower;
	private int leaderMoney;

	public Leader() {
	}

	public int getLeaderId() {
		return leaderId;
	}

	public void setLeaderId(int leaderId) {
		this.leaderId = leaderId;
	}

	public String getLeaderName() {
		return leaderName;
	}

	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}

	public int getLeaderPower() {
		return leaderPower;
	}

	public void setLeaderPower(int leaderPower) {
		this.leaderPower = leaderPower;
	}

	public int getLeaderMoney() {
		return leaderMoney;
	}

	public void setLeaderMoney(int leaderMoney) {
		this.leaderMoney = leaderMoney;
	}

	private Set<Legion> legions = new HashSet<Legion>(0);

	public Set<Legion> getLegions() {
		return legions;
	}

	public void setLegions(Set<Legion> legions) {
		this.legions = legions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + leaderMoney;
		result = prime * result + ((leaderName == null) ? 0 : leaderName.hashCode());
		result = prime * result + leaderPower;
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
		Leader other = (Leader) obj;
		if (leaderMoney != other.leaderMoney)
			return false;
		if (leaderName == null) {
			if (other.leaderName != null)
				return false;
		} else if (!leaderName.equals(other.leaderName))
			return false;
		if (leaderPower != other.leaderPower)
			return false;
		return true;
	}

}
