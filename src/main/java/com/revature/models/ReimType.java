package com.revature.models;

public class ReimType {
	
	private int type_id;
	private String reim_type;
	
	
	public ReimType() {	
		super();
	}
	
	public ReimType(int type_id, String reim_type) {
		super();
		this.type_id = type_id;
		this.reim_type = reim_type;
	}

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	public String getReim_type() {
		return reim_type;
	}

	public void setReim_type(String reim_type) {
		this.reim_type = reim_type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reim_type == null) ? 0 : reim_type.hashCode());
		result = prime * result + type_id;
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
		ReimType other = (ReimType) obj;
		if (reim_type == null) {
			if (other.reim_type != null)
				return false;
		} else if (!reim_type.equals(other.reim_type))
			return false;
		if (type_id != other.type_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReimType [type_id=" + type_id + ", reim_type=" + reim_type + "]";
	}
	
	
	
	

}
