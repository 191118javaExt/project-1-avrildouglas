package com.revature.web;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
////
////import com.fasterxml.jackson.databind.ObjectMapper;
//import com.revature.models.Employee;
//import com.revature.models.EmployeeDTO;
//import com.revature.models.LoginTemplate;
//import com.revature.services.EmployeeService;
//import com.revature.util.HtmlTemplate;
//
//public class LoginServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private static Logger logger = LogManager.getLogger(LoginServlet.class);	
//	private static ObjectMapper om = new ObjectMapper();
//	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse res)
//		throws ServletException, IOException {
//		BufferedReader reader = req.getReader();
//		
//		StringBuilder s = new StringBuilder();
//		String line = reader.readLine();
//		while(line != null) {
//			s.append(line);
//			line = reader.readLine();
//		}
//		
//		String body = s.toString();
//		System.out.println(body);
//		LoginTemplate loginAttempt = om.readValue(body, LoginTemplate.class);
//		String user_name = loginAttempt.getUser_name();
//		String pass_word = loginAttempt.getPass_word();
//		
//		logger.info("User attempted to login with username " + user_name);
//		Employee e = EmployeeService.confirmLogin(user_name, pass_word);
//		if(e != null) {
//			HttpSession session = req.getSession();
//			// Gets the current session, or creates one if it did not exist
//			session.setAttribute("username", user_name);
//			
//			PrintWriter out = res.getWriter();
//			res.setContentType("application/json");
//			EmployeeDTO eDTO = EmployeeService.convertToDTO(e);
//			
//			out.println(om.writeValueAsString(eDTO));
//			
//			logger.info(user_name + " has successfully logged in");
//		} else {
//			res.setContentType("application/json");
//			res.setStatus(204);
//		}
//	}
//}

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Employee;
import com.revature.repositories.EmployeeDAOImpl;
import com.revature.services.EmployeeService;
import com.revature.util.HtmlTemplate;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private static Logger logger = Loggr.getLogger(LoginServlet.class);
	private static Logger logger = LogManager.getLogger(LoginServlet.class);

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		String user_name = req.getParameter("username");
		String pass_word = req.getParameter("password");
		
		logger.info("User attempted to login with username " + user_name);
		Employee e = EmployeeService.confirmLogin(user_name, pass_word);
		if(e != null) {
			HttpSession session = req.getSession();
			// Gets the current session, or creates one if it did not exist
			session.setAttribute("user_name", user_name);
			session.setAttribute("user_id", user_name);
			RequestDispatcher rd = req.getRequestDispatcher("./home/mainmenu.html");
			//RequestDispatcher rd = req.getRequestDispatcher("./index.html");
			rd.forward(req, res);
			logger.info(user_name + " has successfully logged in");
		} else {
			PrintWriter out = HtmlTemplate.getHtmlWriter(res);
			logger.info(user_name + " has failed to login.");
			out.println("<h3 style='color:red'>Denied.</h3>");
			out.println("<p>Username or password is incorrect.</p>");
		}		
		
	}
}