package com.miniworkshop.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "order_details")

public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer order_detail_id;

	@NotNull
	@Column(name = "order_id", nullable = false)
	private Integer orderId;

	@NotNull
	@Column(name = "miniature_id", nullable = false)
	private Integer miniatureId;

	@Column(name = "minis_quantity", nullable = false)
	private String minisQuantity;

	@Column(name = "minis_avg_price", nullable = false)
	private Double minisAvgPrice;

	@Column(name = "minis_color_scheme", nullable = false)
	private String minisColorScheme;

	@Column(name = "minis_base_scheme", nullable = false)
	private String minisBaseScheme;

	@Column(name = "minis_inventory ", nullable = false)
	private String minisInventory;

	@Column(name = "minis_inventory_op", nullable = false)
	private String minisInventoryOp;

	@Column(name = "minis_add_details", nullable = false)
	private String minisAddDetails;

	public Integer getOrder_detail_id() {
		return order_detail_id;
	}

	public void setOrder_detail_id(Integer order_detail_id) {
		this.order_detail_id = order_detail_id;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getMiniatureId() {
		return miniatureId;
	}

	public void setMiniatureId(Integer miniatureId) {
		this.miniatureId = miniatureId;
	}

	public String getMinisQuantity() {
		return minisQuantity;
	}

	public void setMinisQuantity(String minisQuantity) {
		this.minisQuantity = minisQuantity;
	}

	public Double getMinisAvgPrice() {
		return minisAvgPrice;
	}

	public void setMinisAvgPrice(Double minisAvgPrice) {
		this.minisAvgPrice = minisAvgPrice;
	}

	public String getMinisColorScheme() {
		return minisColorScheme;
	}

	public void setMinisColorScheme(String minisColorScheme) {
		this.minisColorScheme = minisColorScheme;
	}

	public String getMinisBaseScheme() {
		return minisBaseScheme;
	}

	public void setMinisBaseScheme(String minisBaseScheme) {
		this.minisBaseScheme = minisBaseScheme;
	}

	public String getMinisInventory() {
		return minisInventory;
	}

	public void setMinisInventory(String minisInventory) {
		this.minisInventory = minisInventory;
	}

	public String getMinisInventoryOp() {
		return minisInventoryOp;
	}

	public void setMinisInventoryOp(String minisInventoryOp) {
		this.minisInventoryOp = minisInventoryOp;
	}

	public String getMinisAddDetails() {
		return minisAddDetails;
	}

	public void setMinisAddDetails(String minisAddDetails) {
		this.minisAddDetails = minisAddDetails;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((miniatureId == null) ? 0 : miniatureId.hashCode());
		result = prime * result + ((minisAddDetails == null) ? 0 : minisAddDetails.hashCode());
		result = prime * result + ((minisAvgPrice == null) ? 0 : minisAvgPrice.hashCode());
		result = prime * result + ((minisBaseScheme == null) ? 0 : minisBaseScheme.hashCode());
		result = prime * result + ((minisColorScheme == null) ? 0 : minisColorScheme.hashCode());
		result = prime * result + ((minisInventory == null) ? 0 : minisInventory.hashCode());
		result = prime * result + ((minisInventoryOp == null) ? 0 : minisInventoryOp.hashCode());
		result = prime * result + ((minisQuantity == null) ? 0 : minisQuantity.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((order_detail_id == null) ? 0 : order_detail_id.hashCode());
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
		OrderDetails other = (OrderDetails) obj;
		if (miniatureId == null) {
			if (other.miniatureId != null)
				return false;
		} else if (!miniatureId.equals(other.miniatureId))
			return false;
		if (minisAddDetails == null) {
			if (other.minisAddDetails != null)
				return false;
		} else if (!minisAddDetails.equals(other.minisAddDetails))
			return false;
		if (minisAvgPrice == null) {
			if (other.minisAvgPrice != null)
				return false;
		} else if (!minisAvgPrice.equals(other.minisAvgPrice))
			return false;
		if (minisBaseScheme == null) {
			if (other.minisBaseScheme != null)
				return false;
		} else if (!minisBaseScheme.equals(other.minisBaseScheme))
			return false;
		if (minisColorScheme == null) {
			if (other.minisColorScheme != null)
				return false;
		} else if (!minisColorScheme.equals(other.minisColorScheme))
			return false;
		if (minisInventory == null) {
			if (other.minisInventory != null)
				return false;
		} else if (!minisInventory.equals(other.minisInventory))
			return false;
		if (minisInventoryOp == null) {
			if (other.minisInventoryOp != null)
				return false;
		} else if (!minisInventoryOp.equals(other.minisInventoryOp))
			return false;
		if (minisQuantity == null) {
			if (other.minisQuantity != null)
				return false;
		} else if (!minisQuantity.equals(other.minisQuantity))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (order_detail_id == null) {
			if (other.order_detail_id != null)
				return false;
		} else if (!order_detail_id.equals(other.order_detail_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderDetails [order_detail_id=" + order_detail_id + ", orderId=" + orderId + ", miniatureId=" + miniatureId + ", minisQuantity=" + minisQuantity + ", minisAvgPrice=" + minisAvgPrice
				+ ", minisColorScheme=" + minisColorScheme + ", minisBaseScheme=" + minisBaseScheme + ", minisInventory=" + minisInventory + ", minisInventoryOp=" + minisInventoryOp
				+ ", minisAddDetails=" + minisAddDetails + "]";
	}

}
