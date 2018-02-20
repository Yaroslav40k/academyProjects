package com.miniworkshop.springmvc.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="factions")
public class Faction implements Serializable {
	
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer faction_id;
	
	@NotEmpty
	@Column(name="gs_id")
	private Integer gsId;
	
	
	@NotEmpty
	@Column(name="faction_name")
	private String factionName;
	
	
	@NotEmpty
	@Column(name="faction_descr")
	private String factionDescr;


	public Integer getFaction_id() {
		return faction_id;
	}


	public void setFaction_id(Integer faction_id) {
		this.faction_id = faction_id;
	}


	public Integer getGsId() {
		return gsId;
	}


	public void setGsId(Integer gsId) {
		this.gsId = gsId;
	}


	public String getFactionName() {
		return factionName;
	}


	public void setFactionName(String factionName) {
		this.factionName = factionName;
	}


	public String getFactionDescr() {
		return factionDescr;
	}


	public void setFactionDescr(String factionDescr) {
		this.factionDescr = factionDescr;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((factionDescr == null) ? 0 : factionDescr.hashCode());
		result = prime * result + ((factionName == null) ? 0 : factionName.hashCode());
		result = prime * result + ((faction_id == null) ? 0 : faction_id.hashCode());
		result = prime * result + ((gsId == null) ? 0 : gsId.hashCode());
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
		Faction other = (Faction) obj;
		if (factionDescr == null) {
			if (other.factionDescr != null)
				return false;
		} else if (!factionDescr.equals(other.factionDescr))
			return false;
		if (factionName == null) {
			if (other.factionName != null)
				return false;
		} else if (!factionName.equals(other.factionName))
			return false;
		if (faction_id == null) {
			if (other.faction_id != null)
				return false;
		} else if (!faction_id.equals(other.faction_id))
			return false;
		if (gsId == null) {
			if (other.gsId != null)
				return false;
		} else if (!gsId.equals(other.gsId))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Faction [faction_id=" + faction_id + ", gsId=" + gsId + ", factionName=" + factionName
				+ ", factionDescr=" + factionDescr + "]";
	}



}
