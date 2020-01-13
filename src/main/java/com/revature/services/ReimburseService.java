package com.revature.services;

import java.util.List;

import com.revature.models.Reimburse;
import com.revature.models.ReimburseDTO;
import com.revature.repositories.ReimburseDAO;
import com.revature.repositories.ReimburseDAOImpl;

public class ReimburseService {
	
	static ReimburseDAO repository = new ReimburseDAOImpl();
	

	public static List<Reimburse> findAll() {
		return repository.findAll();
	}
	
	public boolean insert(Reimburse r) {
		return repository.insert(r);
	}
	
	public static Reimburse findByUsername(String username) {
		List<Reimburse> all = new ReimburseDAOImpl().findAll();
		
		for(Reimburse r : all) {
			if(r.getUser_name().equals(username)) {
				return r;
			}
		}
		
		return null;
	}
	
	public static ReimburseDTO convertToDTO(Reimburse r) {

		return new ReimburseDTO(r.getReim_id(),
						r.getSubmit_by(),
						r.getReim_amt(),
						r.getReim_type(),
						r.getReim_descr(),
						r.getSubmit_dte(),
						r.getReim_recpt(),
						r.getProcess_by(),
						r.getProcess_dte(),
						r.getReim_stat(),
						r.getUser_name());
		
	}
}