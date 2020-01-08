package com.revature.models;

public class Role {
	
	private int role_id;
	private int emp_id;
	private String role_name;
	private String role_desc;
	public Role() {
		super();
	}
	public Role(int role_id, int emp_id, String role_name, String role_desc) {
		super();
		
		this.role_id = role_id;
		this.emp_id = emp_id;
		this.role_name = role_name;
		this.role_desc = role_desc;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getRole_desc() {
		return role_desc;
	}
	public void setRole_desc(String role_desc) {
		this.role_desc = role_desc;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + emp_id;
		result = prime * result + ((role_desc == null) ? 0 : role_desc.hashCode());
		result = prime * result + role_id;
		result = prime * result + ((role_name == null) ? 0 : role_name.hashCode());
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
		Role other = (Role) obj;
		if (emp_id != other.emp_id)
			return false;
		if (role_desc == null) {
			if (other.role_desc != null)
				return false;
		} else if (!role_desc.equals(other.role_desc))
			return false;
		if (role_id != other.role_id)
			return false;
		if (role_name == null) {
			if (other.role_name != null)
				return false;
		} else if (!role_name.equals(other.role_name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", emp_id=" + emp_id + ", role_name=" + role_name + ", role_desc="
				+ role_desc + "]";
	}
}