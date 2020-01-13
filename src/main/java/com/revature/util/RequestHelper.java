package com.revature.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.models.EmployeeDTO;
import com.revature.models.LoginTemplate;
import com.revature.models.Reimburse;
import com.revature.models.ReimburseDTO;
import com.revature.services.EmployeeService;
import com.revature.services.ReimburseService;

public class RequestHelper {
	
	private static Logger logger = LogManager.getLogger(RequestHelper.class);
	
	private static ObjectMapper om = new ObjectMapper();

	public static void processLogin(HttpServletRequest req, HttpServletResponse res) throws IOException {
		BufferedReader reader = req.getReader();
		
		StringBuilder s = new StringBuilder();
		String line = reader.readLine();
		while(line != null) {
			s.append(line);
			line = reader.readLine();
		}
		
		String body = s.toString();
		System.out.println(body);
		LoginTemplate loginAttempt = om.readValue(body, LoginTemplate.class);
		String user_name = loginAttempt.getUser_name();
		String pass_word = loginAttempt.getPass_word();
		
		logger.info("User attempted to login with username " + user_name);
		Employee e = EmployeeService.confirmLogin(user_name, pass_word);
		if(e != null) {
			HttpSession session = req.getSession();
			// Gets the current session, or creates one if it did not exist
			session.setAttribute("username", user_name);
			
			PrintWriter out = res.getWriter();
			res.setContentType("application/json");
			EmployeeDTO eDTO = EmployeeService.convertToDTO(e);
	
			out.println(om.writeValueAsString(eDTO));
			
			logger.info(user_name + " has successfully logged in");
		} else {
			res.setContentType("application/json");
			res.setStatus(204);
		}
	}

	public static void processLogout(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession(false);
		
		if(session != null) {
			String user_name = (String) session.getAttribute("user_name");
			logger.info(user_name + " has logged out");
			session.invalidate();
		}
		
		res.setStatus(200);
	}

	public static void processEmployees(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("application/json");
		List<Employee> all = EmployeeService.findAll();
		List<EmployeeDTO> allDTO = new ArrayList<>();
		
		for(Employee e : all) {
			allDTO.add(new EmployeeDTO(e.getEmp_id(),
					e.getFirst_name(),
					e.getLast_name(),
					e.getUser_name(),
					e.getPass_word(),
					e.getBirth_date(),
					e.getGender(),
					e.getHire_date().toString()));
		}
		
		String json = om.writeValueAsString(all);
		
		PrintWriter out = res.getWriter();
		out.println(json);
	}
	
	public static void processReimburse(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("application/json");
		List<Reimburse> all = ReimburseService.findAll();
		List<ReimburseDTO> allDTO = new ArrayList<>();
		
		for(Reimburse r : all) {
			allDTO.add(new ReimburseDTO(
					r.getReim_id(),
					r.getSubmit_by(),
					r.getReim_amt(),
					r.getReim_type(),
					r.getReim_descr(),
					r.getSubmit_dte(),
					r.getReim_recpt(),
					r.getProcess_by(),
					r.getProcess_dte(),
					r.getReim_stat(),
					r.getUser_name()));
		}
		String json = om.writeValueAsString(all);
		
		PrintWriter out = res.getWriter();
		out.println(json);
	}
	
}