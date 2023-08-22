package com.in.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.in.studentinformation.Student_marks;
import com.in.studentservice.Student_service;

import Student_Factory.StudentServiceFactory;

/**
 * Servlet implementation class supportupdatemarks
 */
@WebServlet("/supportupdatemarks")
public class supportupdatemarks extends HttpServlet {
	private static final long serialVersionUID = 1L;
          
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ROLLNO=request.getParameter("ROLLNO");
		Student_service student_service=StudentServiceFactory.getstudentservice();
		Student_marks student_marks=student_service.Searchmarks(ROLLNO);
		if(student_marks!=null)
		{
			request.setAttribute("studentmarks", student_marks);
		}
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("updatemarks.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
