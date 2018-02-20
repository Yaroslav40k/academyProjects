package com.miniworkshop.springmvc.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="orders")
public class Order {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int order_id;
	
	@NotEmpty
	@Column(name="customer_id", nullable=false)
	private int customerId;
	
	@NotEmpty
	@Column(name="painter_id", nullable=false)
	private int painterId;
		
	@NotEmpty
	@Column(name="order_date ", nullable=false)
	private Timestamp orderDate ;

	@NotEmpty
	@Column(name="required_date", nullable=false)
	private Timestamp requiredDate;

	@NotEmpty
	@Column(name="finished_date ", nullable=false)
	private Timestamp finishedDate ;
	
	@NotEmpty
	@Column(name="ship_adress_id", nullable=false)
	private int shipadressId;
	
	@NotEmpty
	@Column(name="order_status", nullable=false)
	private String orderStatus;

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getPainterId() {
		return painterId;
	}

	public void setPainterId(int painterId) {
		this.painterId = painterId;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public Timestamp getRequiredDate() {
		return requiredDate;
	}

	public void setRequiredDate(Timestamp requiredDate) {
		this.requiredDate = requiredDate;
	}

	public Timestamp getFinishedDate() {
		return finishedDate;
	}

	public void setFinishedDate(Timestamp finishedDate) {
		this.finishedDate = finishedDate;
	}

	public int getShipadressId() {
		return shipadressId;
	}

	public void setShipadressId(int shipadressId) {
		this.shipadressId = shipadressId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerId;
		result = prime * result + ((finishedDate == null) ? 0 : finishedDate.hashCode());
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + ((orderStatus == null) ? 0 : orderStatus.hashCode());
		result = prime * result + order_id;
		result = prime * result + painterId;
		result = prime * result + ((requiredDate == null) ? 0 : requiredDate.hashCode());
		result = prime * result + shipadressId;
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
		Order other = (Order) obj;
		if (customerId != other.customerId)
			return false;
		if (finishedDate == null) {
			if (other.finishedDate != null)
				return false;
		} else if (!finishedDate.equals(other.finishedDate))
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (orderStatus == null) {
			if (other.orderStatus != null)
				return false;
		} else if (!orderStatus.equals(other.orderStatus))
			return false;
		if (order_id != other.order_id)
			return false;
		if (painterId != other.painterId)
			return false;
		if (requiredDate == null) {
			if (other.requiredDate != null)
				return false;
		} else if (!requiredDate.equals(other.requiredDate))
			return false;
		if (shipadressId != other.shipadressId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", customerId=" + customerId + ", painterId=" + painterId
				+ ", orderDate=" + orderDate + ", requiredDate=" + requiredDate + ", finishedDate=" + finishedDate
				+ ", shipadressId=" + shipadressId + ", orderStatus=" + orderStatus + "]";
	}



}
