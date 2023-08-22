package com.in.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.in.studentinformation.Student_attendance;
import com.in.studentservice.Student_service;

import Student_Factory.StudentServiceFactory;

/**
 * Servlet implementation class Supportupdateattendance
 */
@WebServlet("/Supportupdateattendance")
public class Supportupdateattendance extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		String ROLLNO=request.getParameter("ROLLNO");
		Student_service student_service=StudentServiceFactory.getstudentservice();
		Student_attendance student_attendance= student_service.Searchattendance(ROLLNO);
		if(student_attendance!=null)
		{
			request.setAttribute("studentattendance", student_attendance);
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("updateattendance.jsp");
		requestDispatcher.forward(request, response);}
	}

}
