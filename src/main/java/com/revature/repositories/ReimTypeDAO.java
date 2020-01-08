package com.revature.repositories;

import java.util.List;

import com.revature.models.ReimType;

public interface ReimTypeDAO {

	public List<ReimType> findAll();
	public ReimType findById(int type_id);
	public boolean insert(ReimType t);
	public boolean update(ReimType t);
			
	}

