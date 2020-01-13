package com.revature.services;

import java.util.List;

import com.revature.models.ReimType;
import com.revature.repositories.ReimTypeDAO;
import com.revature.repositories.ReimTypeDAOImpl;

public class ReimTypeService {
	
	ReimTypeDAO repository = new ReimTypeDAOImpl();

	public List<ReimType> findAll() {
		return repository.findAll();
	}
	
	public boolean insert(ReimType t) {
		return repository.insert(t);
	}
}