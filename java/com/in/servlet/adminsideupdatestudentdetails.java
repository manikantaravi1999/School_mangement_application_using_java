package com.in.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.in.studentinformation.Student_attendance;
import com.in.studentinformation.Student_marks;
import com.in.studentinformation.Student_personaldetails;
import com.in.studentservice.Student_service;

import Student_Factory.StudentServiceFactory;

/**
 * Servlet implementation class adminsideupdate
 */
@WebServlet("/adminsideupdatestudentdetails")
public class adminsideupdatestudentdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String	fullname=request.getParameter("fullname");
		String Class=request.getParameter("class");
		String rollno=request.getParameter("rollno");
		String password	=request.getParameter("password");

		String dob=request.getParameter("dob");
		String gender	=request.getParameter("gender");
		String email	=request.getParameter("email");
		String mobile	=request.getParameter("mobile");
		String address	=request.getParameter("address");
		Student_personaldetails student_personaldetails1 = new Student_personaldetails(fullname, Class, rollno, password, dob, gender, email, mobile, address);
			Student_service student_service = StudentServiceFactory.getstudentservice();
			String status = student_service.UpdateStudent(student_personaldetails1);
			
			HttpSession http=request.getSession();
			if (status.equalsIgnoreCase("sucess")) {
				List<Student_personaldetails> student_personaldetails=new ArrayList<Student_personaldetails>();
				List<Student_marks>student_marks1=new ArrayList<Student_marks>();
				List<Student_attendance> student_attendances=new ArrayList<Student_attendance>();

				Student_service student_service1=StudentServiceFactory.getstudentservice();
				student_personaldetails=student_service1.viewallStudents();
				student_marks1=student_service.viewallstudentmarks();
				student_attendances=student_service.viewallstudentattendance();
				
				http.setAttribute("studentdetails", student_personaldetails);
				
				
				http.setAttribute("studentmarks", student_marks1);
			
			
				http.setAttribute("studentattendance", student_attendances);
				String alertmessage=rollno+"Student update sucessfully";
				http.setAttribute("alertmessage", alertmessage);
		response.sendRedirect("adminside.jsp");	}
			else {
				String alertmessage=rollno+" Student update failure";
				http.setAttribute("alertmessage", alertmessage);
				response.sendRedirect("adminside.jsp");
				
				
			}
	}

}
