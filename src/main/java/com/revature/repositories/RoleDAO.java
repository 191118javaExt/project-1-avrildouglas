package com.revature.repositories;

import java.util.List;

import com.revature.models.Role;

public interface RoleDAO {

	public List<Role> findAll();
	public Role findById(int role_id);
	public boolean insert(Role l);
	public boolean update(Role l);
				
	}
