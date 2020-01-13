package com.revature.models;

import java.io.Serializable;
import java.util.Objects;

public class LoginTemplate implements Serializable {

	private static final long serialVersionUID = -3961527875565125642L;
	
	private String user_name;
	private String pass_word;

	public LoginTemplate() {
		super();
	}
	
	
	public LoginTemplate(String user_name, String pass_word) {
		super();
		
		this.user_name = user_name;
		this.pass_word = pass_word;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPass_word() {
		return pass_word;
	}

	public void setPass_word(String pass_word) {
		this.pass_word = pass_word;
	}


	@Override
	public int hashCode() {
		return Objects.hash(pass_word, user_name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof LoginTemplate)) {
			return false;
		}
		LoginTemplate other = (LoginTemplate) obj;
		return Objects.equals(pass_word, other.pass_word) && Objects.equals(user_name, other.user_name);
		}

	@Override
	public String toString() {
		return "LoginTemplate [user_name=" + user_name + ", pass_word=" + pass_word + "]";
	}
	

	
}