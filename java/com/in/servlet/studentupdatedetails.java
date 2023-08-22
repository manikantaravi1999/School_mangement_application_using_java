package com.in.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.in.studentinformation.Student_attendance;
import com.in.studentinformation.Student_marks;
import com.in.studentinformation.Student_personaldetails;
import com.in.studentservice.Student_service;

import Student_Factory.StudentServiceFactory;

/**
 * Servlet implementation class studentupdatedetails
 */
@WebServlet("/studentupdatedetails")
public class studentupdatedetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Student_personaldetails studentPersonaldetails;
		Student_marks student_marks;
		Student_attendance student_attendance;
		Student_service studentserviceimpl = StudentServiceFactory.getstudentservice();// service factory

	String	fullname=request.getParameter("fullname");
	String Class=request.getParameter("class");
	String rollno=request.getParameter("rollno");
	String password	=request.getParameter("password");

	String dob=request.getParameter("dob");
	String gender	=request.getParameter("gender");
	String email	=request.getParameter("email");
	String mobile	=request.getParameter("mobile");
	String address	=request.getParameter("address");
	Student_personaldetails student_personaldetails = new Student_personaldetails(fullname, Class, rollno, password, dob, gender, email, mobile, address);
		Student_service student_service = StudentServiceFactory.getstudentservice();
		String status = student_service.UpdateStudent(student_personaldetails);
		if (status.equalsIgnoreCase("sucess")) {

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

			http.setAttribute("studentPersonaldetails", studentPersonaldetails);

			http.setAttribute("student_marks", student_marks);

			http.setAttribute("student_attendance", student_attendance);
			
			String alert=rollno+" updation sucess";
http.setAttribute("alertmessage", alert);
			/*RequestDispatcher requeDispatcher = request.getRequestDispatcher("loginsucess.jsp");

			requeDispatcher.forward(request, response);*/

			 response.sendRedirect("loginsucess.jsp");

		} else {

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

		http.setAttribute("studentPersonaldetails", studentPersonaldetails);

		http.setAttribute("student_marks", student_marks);

		http.setAttribute("student_attendance", student_attendance);
		String errormessage1=status;
		String alert=rollno+" FAILURE ";
		http.setAttribute("alertmessage", alert);
response.sendRedirect("loginsucess.jsp");

		/*PrintWriter pw=response.getWriter();
		pw.println(status);*/
		}
	}

}
