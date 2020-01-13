package com.revature.repositories;

import java.util.List;

import com.revature.models.Reimburse;
import com.revature.models.ReimburseTemplate;

public interface ReimburseDAO {
	
	public List<Reimburse> findAll();
	public Reimburse findById(int reim_id);
	public boolean insert(Reimburse r);
	public boolean update(Reimburse r);
}
