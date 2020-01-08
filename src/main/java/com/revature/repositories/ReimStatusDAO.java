package com.revature.repositories;

import java.util.List;

import com.revature.models.ReimStatus;

public interface ReimStatusDAO {

	public List<ReimStatus> findAll();
	public ReimStatus findById(int status_id);
	public boolean insert(ReimStatus s);
	public boolean update(ReimStatus s);
		
	}

