package com.revature.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.util.RequestHelper;

public class FrontController extends HttpServlet {

	private static final long serialVersionUID = 8339100247721381693L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		final String URI = req.getRequestURI().replace("/project-1", "");
		//final String URI = req.getRequestURI().replace("/project-1/", "");
		
		switch(URI) {
		case "login.main":
			//res.setContentType("text/html;charset=UTF-8");
			//PrintWriter out = res.getWriter();
			RequestHelper.processLogin(req, res);
			break;
		case "logout.main":
			RequestHelper.processLogout(req, res);
			break;
		case "employees.main":
			RequestHelper.processEmployees(req, res);
			break;
		case "reimburse.main":
			RequestHelper.processReimburse(req, res);
			break;
		}
	}
		
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}
}
//import java.io.*;
//import javax.servlet.*;
//import javax.servlet.http.*;
//
//public class FrontController extends HttpServlet {
//
//  protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//       response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        try {
//           
//            String username = request.getParameter("username");
//            String password = request.getParameter("password");
//            out.println("<h2> Welcome "+username+"</h2>");
//        } finally {            
//            out.close();
//        }
//    }
//}