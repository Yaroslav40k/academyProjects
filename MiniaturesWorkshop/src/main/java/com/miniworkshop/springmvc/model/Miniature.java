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
@Table(name="miniatures")

public class Miniature implements Serializable {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer miniature_id;
	
	@NotEmpty
	@Column(name="faction_id")
	private Integer factionId;
	
	@NotEmpty
	@Column(name="miniature_name", nullable=false)
	private String miniatureName;
		
	@NotEmpty
	@Column(name="miniature_type", nullable=false)
	private String miniatureType;

	@NotEmpty
	@Column(name="miniature_size", nullable=false)
	private String miniatureSize;

	@NotEmpty
	@Column(name="miniature_base_id", nullable=false)
	private Integer miniatureBaseId;
	
	@NotEmpty
	@Column(name="miniature_low_price", nullable=false)
	private Double miniatureLowPrice;
	
	@NotEmpty
	@Column(name="miniature_mid_price", nullable=false)
	private Double miniatureMidPrice;
	
	@NotEmpty
	@Column(name="miniature_high_price", nullable=false)
	private Double miniatureHighPrice;
	
	@NotEmpty
	@Column(name="miniature_low_pt_d", nullable=false)
	private Integer miniatureLowPD;
	
	@NotEmpty
	@Column(name="miniature_mid_pt_d", nullable=false)
	private Integer miniatureMidPD;
	
	@NotEmpty
	@Column(name="miniature_high_pt_d", nullable=false)
	private Integer miniatureHighPD;
	
	@NotEmpty
	@Column(name="miniature_painting_count", nullable=false)
	private Integer miniaturePaintingCount;

	public Integer getMiniature_id() {
		return miniature_id;
	}

	public void setMiniature_id(Integer miniature_id) {
		this.miniature_id = miniature_id;
	}

	public Integer getFactionId() {
		return factionId;
	}

	public void setFactionId(Integer factionId) {
		this.factionId = factionId;
	}

	public String getMiniatureName() {
		return miniatureName;
	}

	public void setMiniatureName(String miniatureName) {
		this.miniatureName = miniatureName;
	}

	public String getMiniatureType() {
		return miniatureType;
	}

	public void setMiniatureType(String miniatureType) {
		this.miniatureType = miniatureType;
	}

	public String getMiniatureSize() {
		return miniatureSize;
	}

	public void setMiniatureSize(String miniatureSize) {
		this.miniatureSize = miniatureSize;
	}

	public Integer getMiniatureBaseId() {
		return miniatureBaseId;
	}

	public void setMiniatureBaseId(Integer miniatureBaseId) {
		this.miniatureBaseId = miniatureBaseId;
	}

	public Double getMiniatureLowPrice() {
		return miniatureLowPrice;
	}

	public void setMiniatureLowPrice(Double miniatureLowPrice) {
		this.miniatureLowPrice = miniatureLowPrice;
	}

	public Double getMiniatureMidPrice() {
		return miniatureMidPrice;
	}

	public void setMiniatureMidPrice(Double miniatureMidPrice) {
		this.miniatureMidPrice = miniatureMidPrice;
	}

	public Double getMiniatureHighPrice() {
		return miniatureHighPrice;
	}

	public void setMiniatureHighPrice(Double miniatureHighPrice) {
		this.miniatureHighPrice = miniatureHighPrice;
	}

	public Integer getMiniatureLowPD() {
		return miniatureLowPD;
	}

	public void setMiniatureLowPD(Integer miniatureLowPD) {
		this.miniatureLowPD = miniatureLowPD;
	}

	public Integer getMiniatureMidPD() {
		return miniatureMidPD;
	}

	public void setMiniatureMidPD(Integer miniatureMidPD) {
		this.miniatureMidPD = miniatureMidPD;
	}

	public Integer getMiniatureHighPD() {
		return miniatureHighPD;
	}

	public void setMiniatureHighPD(Integer miniatureHighPD) {
		this.miniatureHighPD = miniatureHighPD;
	}

	public Integer getMiniaturePaintingCount() {
		return miniaturePaintingCount;
	}

	public void setMiniaturePaintingCount(Integer miniaturePaintingCount) {
		this.miniaturePaintingCount = miniaturePaintingCount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((factionId == null) ? 0 : factionId.hashCode());
		result = prime * result + ((miniatureBaseId == null) ? 0 : miniatureBaseId.hashCode());
		result = prime * result + ((miniatureHighPD == null) ? 0 : miniatureHighPD.hashCode());
		result = prime * result + ((miniatureHighPrice == null) ? 0 : miniatureHighPrice.hashCode());
		result = prime * result + ((miniatureLowPD == null) ? 0 : miniatureLowPD.hashCode());
		result = prime * result + ((miniatureLowPrice == null) ? 0 : miniatureLowPrice.hashCode());
		result = prime * result + ((miniatureMidPD == null) ? 0 : miniatureMidPD.hashCode());
		result = prime * result + ((miniatureMidPrice == null) ? 0 : miniatureMidPrice.hashCode());
		result = prime * result + ((miniatureName == null) ? 0 : miniatureName.hashCode());
		result = prime * result + ((miniaturePaintingCount == null) ? 0 : miniaturePaintingCount.hashCode());
		result = prime * result + ((miniatureSize == null) ? 0 : miniatureSize.hashCode());
		result = prime * result + ((miniatureType == null) ? 0 : miniatureType.hashCode());
		result = prime * result + ((miniature_id == null) ? 0 : miniature_id.hashCode());
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
		Miniature other = (Miniature) obj;
		if (factionId == null) {
			if (other.factionId != null)
				return false;
		} else if (!factionId.equals(other.factionId))
			return false;
		if (miniatureBaseId == null) {
			if (other.miniatureBaseId != null)
				return false;
		} else if (!miniatureBaseId.equals(other.miniatureBaseId))
			return false;
		if (miniatureHighPD == null) {
			if (other.miniatureHighPD != null)
				return false;
		} else if (!miniatureHighPD.equals(other.miniatureHighPD))
			return false;
		if (miniatureHighPrice == null) {
			if (other.miniatureHighPrice != null)
				return false;
		} else if (!miniatureHighPrice.equals(other.miniatureHighPrice))
			return false;
		if (miniatureLowPD == null) {
			if (other.miniatureLowPD != null)
				return false;
		} else if (!miniatureLowPD.equals(other.miniatureLowPD))
			return false;
		if (miniatureLowPrice == null) {
			if (other.miniatureLowPrice != null)
				return false;
		} else if (!miniatureLowPrice.equals(other.miniatureLowPrice))
			return false;
		if (miniatureMidPD == null) {
			if (other.miniatureMidPD != null)
				return false;
		} else if (!miniatureMidPD.equals(other.miniatureMidPD))
			return false;
		if (miniatureMidPrice == null) {
			if (other.miniatureMidPrice != null)
				return false;
		} else if (!miniatureMidPrice.equals(other.miniatureMidPrice))
			return false;
		if (miniatureName == null) {
			if (other.miniatureName != null)
				return false;
		} else if (!miniatureName.equals(other.miniatureName))
			return false;
		if (miniaturePaintingCount == null) {
			if (other.miniaturePaintingCount != null)
				return false;
		} else if (!miniaturePaintingCount.equals(other.miniaturePaintingCount))
			return false;
		if (miniatureSize == null) {
			if (other.miniatureSize != null)
				return false;
		} else if (!miniatureSize.equals(other.miniatureSize))
			return false;
		if (miniatureType == null) {
			if (other.miniatureType != null)
				return false;
		} else if (!miniatureType.equals(other.miniatureType))
			return false;
		if (miniature_id == null) {
			if (other.miniature_id != null)
				return false;
		} else if (!miniature_id.equals(other.miniature_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Miniature [miniature_id=" + miniature_id + ", factionId=" + factionId + ", miniatureName="
				+ miniatureName + ", miniatureType=" + miniatureType + ", miniatureSize=" + miniatureSize
				+ ", miniatureBaseId=" + miniatureBaseId + ", miniatureLowPrice=" + miniatureLowPrice
				+ ", miniatureMidPrice=" + miniatureMidPrice + ", miniatureHighPrice=" + miniatureHighPrice
				+ ", miniatureLowPD=" + miniatureLowPD + ", miniatureMidPD=" + miniatureMidPD + ", miniatureHighPD="
				+ miniatureHighPD + ", miniaturePaintingCount=" + miniaturePaintingCount + "]";
	}

	
}
