package com.in.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.in.studentinformation.Student_personaldetails;
import com.in.studentservice.Student_service;

import Student_Factory.StudentServiceFactory;

/**
 * Servlet implementation class supportupdatestudentadminside
 */
@WebServlet("/supportupdatestudentadminside")
public class supportupdatestudentadminside extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String ROLLNO=request.getParameter("ROLLNO");
Student_personaldetails student_personaldetails;
		Student_service student_service=StudentServiceFactory.getstudentservice();
		student_personaldetails=student_service.Searchstudent(ROLLNO);
		if(student_personaldetails!=null)
		{
			request.setAttribute("student_personaldetails", student_personaldetails);
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("adminupdationform.jsp");
		requestDispatcher.forward(request, response);
		
	}

}}
