package com.revature.services;

import java.util.List;

import com.revature.models.ReimStatus;
import com.revature.repositories.ReimStatusDAO;
import com.revature.repositories.ReimStatusDAOImpl;

public class ReimStatusService {
	
	ReimStatusDAO repository = new ReimStatusDAOImpl();

	public List<ReimStatus> findAll() {
		return repository.findAll();
	}
	
	public boolean insert(ReimStatus s) {
		return repository.insert(s);
	}
	
}