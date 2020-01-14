package com.revature.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimburse;
import com.revature.models.ReimburseDTO;
import com.revature.models.ReimburseTemplate;
import com.revature.services.ReimburseService;

public class ReimburseServlet extends HttpServlet {
	
	private static ObjectMapper om = new ObjectMapper();

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
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
		ReimburseTemplate reimburse = om.readValue("{ .. }", ReimburseTemplate.class);
		
		
		String submitby = req.getParameter("submit_by");
		String reimamt = req.getParameter("reim_amt");
		String reimtype = reimburse.getReim_type();
	
		
		PrintWriter out = res.getWriter();
		out.println(json);
	}
}
		
