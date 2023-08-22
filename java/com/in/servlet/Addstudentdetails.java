package com.in.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import com.in.studentinformation.Student_personaldetails;
import com.in.studentservice.Student_service;

import Student_Factory.StudentServiceFactory;

@WebServlet("/Addstudentdetails")
public class Addstudentdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	String Fullname	=request.getParameter("fullname");
	String Class	=request.getParameter("class");
	String Rollno	=request.getParameter("rollno");
	String Password	=request.getParameter("password");
	String Date	=   request.getParameter("dob");
	String Gender	=request.getParameter("gender");
	String Email	=request.getParameter("email");
	String Mobile	=request.getParameter("mobile");
	String Address	=request.getParameter("address");
	Student_personaldetails studentpersonaldetails = new Student_personaldetails(Fullname, Class, Rollno, Password, Date, Gender, Email, Mobile, Address);
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		Student_service studentService = StudentServiceFactory.getstudentservice();
		String Status = studentService.AddStudent(studentpersonaldetails);
		HttpSession http=request.getSession();
		try {
			if (Status.equalsIgnoreCase("sucess")) {
				
				String alert="Registration sucess `@` THANK YOU!";
				http.setAttribute("alertmessage", alert);
				 response.sendRedirect("index.jsp");
				
			
			} else {
				String alert="REGISTRATION FAILURE or Already registered  `@` SORRY!";
				http.setAttribute("alertmessage", alert);
				 response.sendRedirect("index.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
