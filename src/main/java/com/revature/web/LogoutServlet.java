package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogoutServlet extends HttpServlet {
	
	private static Logger logger = LogManager.getLogger(LogoutServlet.class);
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		
		if(session != null) {
			String user_name = (String) session.getAttribute("user_name");
			logger.info(user_name + " has logged out");
			session.invalidate();
		}
		
		res.setStatus(200);
	}
}

