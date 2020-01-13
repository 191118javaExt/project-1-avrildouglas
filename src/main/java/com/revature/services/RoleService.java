package com.revature.services;

import java.util.List;

import com.revature.models.Role;
import com.revature.repositories.RoleDAO;
import com.revature.repositories.RoleDAOImpl;


public class RoleService {
	
	RoleDAO repository = new RoleDAOImpl();

	public List<Role> findAll() {
		return repository.findAll();
	}
	
	public boolean insert(Role l) {
		return repository.insert(l);
	}
}