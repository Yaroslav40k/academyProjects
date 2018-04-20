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
@Table(name="manufacturers")
public class Manufacturer {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer manuf_id;

	
	@NotEmpty
	@Column(name="manuf_name")
	private String manufName;
	
	@NotEmpty
	@Column(name="manuf_country")
	private String manufCountry;
	
	
	@NotEmpty
	@Column(name="manuf_website")
	private String manufWebsite;
	
	
	@NotEmpty
	@Column(name="manuf_descr")
	private String manufDescr;
	
	@NotEmpty
	@Column(name="manuf_logo_link")
	private String manufLogoLink;

	public Integer getManuf_id() {
		return manuf_id;
	}

	public void setManuf_id(Integer manuf_id) {
		this.manuf_id = manuf_id;
	}

	public String getManufName() {
		return manufName;
	}

	public void setManufName(String manufName) {
		this.manufName = manufName;
	}

	public String getManufCountry() {
		return manufCountry;
	}

	public void setManufCountry(String manufCountry) {
		this.manufCountry = manufCountry;
	}

	public String getManufWebsite() {
		return manufWebsite;
	}

	public void setManufWebsite(String manufWebsite) {
		this.manufWebsite = manufWebsite;
	}

	public String getManufDescr() {
		return manufDescr;
	}

	public void setManufDescr(String manufDescr) {
		this.manufDescr = manufDescr;
	}

	public String getManufLogoLink() {
		return manufLogoLink;
	}

	public void setManufLogoLink(String manufLogoLink) {
		this.manufLogoLink = manufLogoLink;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((manufCountry == null) ? 0 : manufCountry.hashCode());
		result = prime * result + ((manufDescr == null) ? 0 : manufDescr.hashCode());
		result = prime * result + ((manufLogoLink == null) ? 0 : manufLogoLink.hashCode());
		result = prime * result + ((manufName == null) ? 0 : manufName.hashCode());
		result = prime * result + ((manufWebsite == null) ? 0 : manufWebsite.hashCode());
		result = prime * result + ((manuf_id == null) ? 0 : manuf_id.hashCode());
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
		Manufacturer other = (Manufacturer) obj;
		if (manufCountry == null) {
			if (other.manufCountry != null)
				return false;
		} else if (!manufCountry.equals(other.manufCountry))
			return false;
		if (manufDescr == null) {
			if (other.manufDescr != null)
				return false;
		} else if (!manufDescr.equals(other.manufDescr))
			return false;
		if (manufLogoLink == null) {
			if (other.manufLogoLink != null)
				return false;
		} else if (!manufLogoLink.equals(other.manufLogoLink))
			return false;
		if (manufName == null) {
			if (other.manufName != null)
				return false;
		} else if (!manufName.equals(other.manufName))
			return false;
		if (manufWebsite == null) {
			if (other.manufWebsite != null)
				return false;
		} else if (!manufWebsite.equals(other.manufWebsite))
			return false;
		if (manuf_id == null) {
			if (other.manuf_id != null)
				return false;
		} else if (!manuf_id.equals(other.manuf_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Manufacturer [manuf_id=" + manuf_id + ", manufName=" + manufName + ", manufCountry=" + manufCountry
				+ ", manufWebsite=" + manufWebsite + ", manufDescr=" + manufDescr + ", manufLogoLink=" + manufLogoLink
				+ "]";
	}


	
	

}
