package com.revature.services;

import java.util.List;

import com.revature.models.Employee;
import com.revature.models.EmployeeDTO;
import com.revature.repositories.EmployeeDAO;
import com.revature.repositories.EmployeeDAOImpl;

public class EmployeeService {
	
	static EmployeeDAO empdaorepo = new EmployeeDAOImpl();
	
	public static List<Employee> findAll() {
		return empdaorepo.findAll();
	}
	
	public boolean insert(Employee e) {
		return empdaorepo.insert(e);
	}
	
	public boolean update(Employee e) {
		return empdaorepo.update(e);
	}
	
	public static Employee findByUsername(String user_name) {
		List<Employee> all = empdaorepo.findAll();
		
		for(Employee e : all) {
			if(e.getUser_name().equals(user_name)) {
				return e;
			}
		}
		
		return null;
	}
	
	public static Employee confirmLogin(String user_name, String pass_word) {
		Employee e = findByUsername(user_name);
		if(e == null) {
			return null;
		}
		if (e.getPass_word().equals(pass_word)) {
			return e;
		} else {
			return null;
		}
	}
	
	
	public static EmployeeDTO convertToDTO(Employee e) {

		return new EmployeeDTO(e.getEmp_id(),
	
				e.getFirst_name(),
				e.getLast_name(),
				e.getUser_name(),
				e.getPass_word(),
				e.getBirth_date(),
				e.getGender(),
				e.getHire_date().toString());
	}
}
	

