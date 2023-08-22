package com.in.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import com.in.studentinformation.StudentLogin;
import com.in.studentinformation.Student_attendance;
import com.in.studentinformation.Student_marks;
import com.in.studentinformation.Student_personaldetails;
import com.in.studentservice.Student_service;

import Student_Factory.StudentServiceFactory;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentLogin studentlogin = new StudentLogin();
	Student_personaldetails studentPersonaldetails;
	Student_marks student_marks;
	Student_attendance student_attendance;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		studentlogin.setROLLNO(request.getParameter("rollno")); // username
		studentlogin.setPASSWORD(request.getParameter("password")); // password
		response.setContentType("text/html");
		Student_service studentserviceimpl = StudentServiceFactory.getstudentservice();// service factory
		/*
		 * student login method
		 */
		boolean status = studentserviceimpl.Studentvalidation(studentlogin);
		/*
		 * student details method
		 */
		studentPersonaldetails = studentserviceimpl.Searchstudent(request.getParameter("rollno"));
		/*
		 * student marks method
		 */
		student_marks = studentserviceimpl.Searchmarks(request.getParameter("rollno"));
		/*
		 * student attendance method
		 */
		student_attendance = studentserviceimpl.Searchattendance(request.getParameter("rollno"));

		HttpSession http = request.getSession();
		if (status) {
			// student details

			http.setAttribute("studentPersonaldetails", studentPersonaldetails);

			http.setAttribute("student_marks", student_marks);

			http.setAttribute("student_attendance", student_attendance);
			String alert=request.getParameter("rollno")+" LOGIN SUCESSFULLY";
			http.setAttribute("alertmessage", alert);
			/*RequestDispatcher requeDispatcher = request.getRequestDispatcher("loginsucess.jsp");

			requeDispatcher.forward(request, response);*/

			 response.sendRedirect("loginsucess.jsp");

		}

		else {
		
			
			String alert="LOGIN FAILURE";
			http.setAttribute("alertmessage", alert);
			 response.sendRedirect("index.jsp");

		}
	}
}
