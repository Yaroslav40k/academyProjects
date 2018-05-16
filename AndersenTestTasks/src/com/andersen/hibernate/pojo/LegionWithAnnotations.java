package com.andersen.hibernate.pojo;


import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * Represents ancient roman Legion instance
 * 			params :id , name, leader id
 * 			uses Second level cache		
 */
@Entity
@Table(name = "legions")
@Cacheable
public class LegionWithAnnotations {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="legio_id")
	private int legioId;

	@ManyToOne (fetch = FetchType.LAZY )
	@JoinColumn(name = "leader_id")
	private LeaderWithAnnotations leader;

	@Column(name = "legio_name")
	private String legioName;

	public LegionWithAnnotations() {
	}

	public int getLegioId() {
		return legioId;
	}

	public LeaderWithAnnotations getLeader() {
		return leader;
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
		LegionWithAnnotations other = (LegionWithAnnotations) obj;
		if (legioName == null) {
			if (other.legioName != null)
				return false;
		} else if (!legioName.equals(other.legioName))
			return false;
		return true;
	}

}
