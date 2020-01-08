package com.revature.models;

public class ReimStatus {

	private int status_id;
	private String reim_status;
	
	public ReimStatus() {
		super();
	}

	public ReimStatus(int status_id, String reim_status) {
		super();
		this.status_id = status_id;
		this.reim_status = reim_status;
	}

	public int getStatus_id() {
		return status_id;
	}

	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}

	public String getReim_status() {
		return reim_status;
	}

	public void setReim_status(String reim_status) {
		this.reim_status = reim_status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reim_status == null) ? 0 : reim_status.hashCode());
		result = prime * result + status_id;
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
		ReimStatus other = (ReimStatus) obj;
		if (reim_status == null) {
			if (other.reim_status != null)
				return false;
		} else if (!reim_status.equals(other.reim_status))
			return false;
		if (status_id != other.status_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReimStatus [status_id=" + status_id + ", reim_status=" + reim_status + "]";
	}	
}
