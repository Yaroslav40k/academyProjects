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
@Table(name="bases")
public class Base  implements Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer baseId;
	
	@NotEmpty
	@Column(name="base_type")
	private String baseType;
	
	
	@NotEmpty
	@Column(name="base_size")
	private String baseSize;
	
	
	@NotEmpty
	@Column(name="base_manufacturer")
	private String base_manufacturer;


	public Integer getBaseId() {
		return baseId;
	}


	public void setBaseId(Integer baseId) {
		this.baseId = baseId;
	}


	public String getBaseType() {
		return baseType;
	}


	public void setBaseType(String baseType) {
		this.baseType = baseType;
	}


	public String getBaseSize() {
		return baseSize;
	}


	public void setBaseSize(String baseSize) {
		this.baseSize = baseSize;
	}


	public String getBase_manufacturer() {
		return base_manufacturer;
	}


	public void setBase_manufacturer(String base_manufacturer) {
		this.base_manufacturer = base_manufacturer;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((baseId == null) ? 0 : baseId.hashCode());
		result = prime * result + ((baseSize == null) ? 0 : baseSize.hashCode());
		result = prime * result + ((baseType == null) ? 0 : baseType.hashCode());
		result = prime * result + ((base_manufacturer == null) ? 0 : base_manufacturer.hashCode());
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
		Base other = (Base) obj;
		if (baseId == null) {
			if (other.baseId != null)
				return false;
		} else if (!baseId.equals(other.baseId))
			return false;
		if (baseSize == null) {
			if (other.baseSize != null)
				return false;
		} else if (!baseSize.equals(other.baseSize))
			return false;
		if (baseType == null) {
			if (other.baseType != null)
				return false;
		} else if (!baseType.equals(other.baseType))
			return false;
		if (base_manufacturer == null) {
			if (other.base_manufacturer != null)
				return false;
		} else if (!base_manufacturer.equals(other.base_manufacturer))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Base [baseId=" + baseId + ", baseType=" + baseType + ", baseSize=" + baseSize + ", base_manufacturer="
				+ base_manufacturer + "]";
	}



	
}
