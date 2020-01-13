package com.revature.models;

import java.util.Date;

public class ReimburseTemplate {

	private int reim_id;
	private String submit_by;
	private Double reim_amt;
	private String reim_type;
	private String reim_descr;
	private Date submit_dte;
	private String reim_recpt;
	private String reim_stat;
	private Date process_dte;
	private String process_by;
	private String user_name;
	
	public ReimburseTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReimburseTemplate(int reim_id, String submit_by, Double reim_amt, String reim_type, String reim_descr,
			Date submit_dte, String reim_recpt, String reim_stat, Date process_dte, String process_by, String user_name) {
		super();
		this.reim_id = reim_id;
		this.submit_by = submit_by;
		this.reim_amt = reim_amt;
		this.reim_type = reim_type;
		this.reim_descr = reim_descr;
		this.submit_dte = submit_dte;
		this.reim_recpt = reim_recpt;
		this.reim_stat = reim_stat;
		this.process_dte = process_dte;
		this.process_by = process_by;
		this.user_name = user_name;
	}
	public int getReim_id() {
		return reim_id;
	}
	public void setReim_id(int reim_id) {
		this.reim_id = reim_id;
	}
	public String getSubmit_by() {
		return submit_by;
	}
	public void setSubmit_by(String submit_by) {
		this.submit_by = submit_by;
	}
	public Double getReim_amt() {
		return reim_amt;
	}
	public void setReim_amt(Double reim_amt) {
		this.reim_amt = reim_amt;
	}
	public String getReim_type() {
		return reim_type;
	}
	public void setReim_type(String reim_type) {
		this.reim_type = reim_type;
	}
	public String getReim_descr() {
		return reim_descr;
	}
	public void setReim_descr(String reim_descr) {
		this.reim_descr = reim_descr;
	}
	public Date getSubmit_dte() {
		return submit_dte;
	}
	public void setSubmit_dte(Date submit_dte) {
		this.submit_dte = submit_dte;
	}
	public String getReim_recpt() {
		return reim_recpt;
	}
	public void setReim_recpt(String reim_recpt) {
		this.reim_recpt = reim_recpt;
	}
	public String getReim_stat() {
		return reim_stat;
	}
	public void setReim_stat(String reim_stat) {
		this.reim_stat = reim_stat;
	}
	public Date getProcess_dte() {
		return process_dte;
	}
	public void setProcess_dte(Date process_dte) {
		this.process_dte = process_dte;
	}
	public String getProcess_by() {
		return process_by;
	}
	public void setProcess_by(String process_by) {
		this.process_by = process_by;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((process_by == null) ? 0 : process_by.hashCode());
		result = prime * result + ((process_dte == null) ? 0 : process_dte.hashCode());
		result = prime * result + ((reim_amt == null) ? 0 : reim_amt.hashCode());
		result = prime * result + ((reim_descr == null) ? 0 : reim_descr.hashCode());
		result = prime * result + reim_id;
		result = prime * result + ((reim_recpt == null) ? 0 : reim_recpt.hashCode());
		result = prime * result + ((reim_stat == null) ? 0 : reim_stat.hashCode());
		result = prime * result + ((reim_type == null) ? 0 : reim_type.hashCode());
		result = prime * result + ((submit_by == null) ? 0 : submit_by.hashCode());
		result = prime * result + ((submit_dte == null) ? 0 : submit_dte.hashCode());
		result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
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
		ReimburseTemplate other = (ReimburseTemplate) obj;
		if (process_by == null) {
			if (other.process_by != null)
				return false;
		} else if (!process_by.equals(other.process_by))
			return false;
		if (process_dte == null) {
			if (other.process_dte != null)
				return false;
		} else if (!process_dte.equals(other.process_dte))
			return false;
		if (reim_amt == null) {
			if (other.reim_amt != null)
				return false;
		} else if (!reim_amt.equals(other.reim_amt))
			return false;
		if (reim_descr == null) {
			if (other.reim_descr != null)
				return false;
		} else if (!reim_descr.equals(other.reim_descr))
			return false;
		if (reim_id != other.reim_id)
			return false;
		if (reim_recpt == null) {
			if (other.reim_recpt != null)
				return false;
		} else if (!reim_recpt.equals(other.reim_recpt))
			return false;
		if (reim_stat == null) {
			if (other.reim_stat != null)
				return false;
		} else if (!reim_stat.equals(other.reim_stat))
			return false;
		if (reim_type == null) {
			if (other.reim_type != null)
				return false;
		} else if (!reim_type.equals(other.reim_type))
			return false;
		if (submit_by == null) {
			if (other.submit_by != null)
				return false;
		} else if (!submit_by.equals(other.submit_by))
			return false;
		if (submit_dte == null) {
			if (other.submit_dte != null)
				return false;
		} else if (!submit_dte.equals(other.submit_dte))
			return false;
		if (user_name == null) {
			if (other.user_name != null)
				return false;
		} else if (!user_name.equals(other.user_name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ReimburseTemplate [reim_id=" + reim_id + ", submit_by=" + submit_by + ", reim_amt=" + reim_amt
				+ ", reim_type=" + reim_type + ", reim_descr=" + reim_descr + ", submit_dte=" + submit_dte
				+ ", reim_recpt=" + reim_recpt + ", reim_stat=" + reim_stat + ", process_dte=" + process_dte
				+ ", process_by=" + process_by + ", user_name=" + user_name + "]";
	}
	
}
