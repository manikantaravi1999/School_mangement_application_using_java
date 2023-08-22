package com.in.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import org.apache.tomcat.dbcp.dbcp2.ConnectionFactory;

/**
 * Servlet implementation class logoutServlet
 */
@WebServlet("/logoutServlet")
public class logoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession(false).invalidate();
		HttpSession http=request.getSession();
		String alert="LOGOUT SUCESSFULLY"+" "+"please visit again! Thank you! `@`";
		http.setAttribute("alertmessage", alert);
		
		
	     response.sendRedirect("index.jsp");
		
		
	}

}
