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
@Table(name="game_systems")
public class GameSystem  implements Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer gs_id;
	
	@NotEmpty
	@Column(name="manuf_id")
	private Integer manufId;
	
	
	@NotEmpty
	@Column(name="gs_name")
	private String gsName;
	
	
	@NotEmpty
	@Column(name="gs_descr")
	private String gsDescr;


	public Integer getGs_id() {
		return gs_id;
	}


	public void setGs_id(Integer gs_id) {
		this.gs_id = gs_id;
	}


	public Integer getManufId() {
		return manufId;
	}


	public void setManufId(Integer manufId) {
		this.manufId = manufId;
	}


	public String getGsName() {
		return gsName;
	}


	public void setGsName(String gsName) {
		this.gsName = gsName;
	}


	public String getGsDescr() {
		return gsDescr;
	}


	public void setGsDescr(String gsDescr) {
		this.gsDescr = gsDescr;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gsDescr == null) ? 0 : gsDescr.hashCode());
		result = prime * result + ((gsName == null) ? 0 : gsName.hashCode());
		result = prime * result + ((gs_id == null) ? 0 : gs_id.hashCode());
		result = prime * result + ((manufId == null) ? 0 : manufId.hashCode());
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
		GameSystem other = (GameSystem) obj;
		if (gsDescr == null) {
			if (other.gsDescr != null)
				return false;
		} else if (!gsDescr.equals(other.gsDescr))
			return false;
		if (gsName == null) {
			if (other.gsName != null)
				return false;
		} else if (!gsName.equals(other.gsName))
			return false;
		if (gs_id == null) {
			if (other.gs_id != null)
				return false;
		} else if (!gs_id.equals(other.gs_id))
			return false;
		if (manufId == null) {
			if (other.manufId != null)
				return false;
		} else if (!manufId.equals(other.manufId))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "GameSystem [gs_id=" + gs_id + ", manufId=" + manufId + ", gsName=" + gsName + ", gsDescr=" + gsDescr
				+ "]";
	}


	
}
