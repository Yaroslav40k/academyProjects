package com.andersen.hibernate.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table (name = "slaves")
public class SlaveWithAnnotations {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="slave_id")
	private int slaveId;
	
	@Column(name = "slave_name")
	private String slaveName;
	
	public SlaveWithAnnotations() {
		// TODO Auto-generated constructor stub
	}

	public String getSlaveName() {
		return slaveName;
	}

	public void setSlaveName(String slaveName) {
		this.slaveName = slaveName;
	}

	public int getSlaveId() {
		return slaveId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((slaveName == null) ? 0 : slaveName.hashCode());
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
		SlaveWithAnnotations other = (SlaveWithAnnotations) obj;
		if (slaveName == null) {
			if (other.slaveName != null)
				return false;
		} else if (!slaveName.equals(other.slaveName))
			return false;
		return true;
	}
	
	

}
