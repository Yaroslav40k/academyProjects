package com.andersen.hibernate.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * Represents ancient roman leader instance
 * 			params :id , name, power , money, legions list
 * 			uses Second level cache			
 */

@Entity
@Table(name = "leaders")
@Cacheable
public class LeaderWithAnnotations {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="leader_id")
	private int leaderId;
	
	@Column(name = "leader_name")
	private String leaderName;
	
	@Column(name = "leader_power")
	private int leaderPower;
	
	@Column(name = "leader_money")
	private int leaderMoney;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="leader")
	private Set<LegionWithAnnotations> legions = new HashSet<LegionWithAnnotations>(0);


	public LeaderWithAnnotations() {
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


	public Set<LegionWithAnnotations> getLegions() {
		return legions;
	}

	public void setLegions(Set<LegionWithAnnotations> legions) {
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
		LeaderWithAnnotations other = (LeaderWithAnnotations) obj;
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
