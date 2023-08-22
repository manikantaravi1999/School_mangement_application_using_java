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
import java.util.ArrayList;
import java.util.List;

import com.in.studentinformation.Student_attendance;
import com.in.studentinformation.Student_marks;
import com.in.studentinformation.Student_personaldetails;
import com.in.studentservice.Student_service;

import Student_Factory.StudentDaoFactory;
import Student_Factory.StudentServiceFactory;

/**
 * Servlet implementation class deletemarks
 */
@WebServlet("/deletemarks")
public class deletemarks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		List<Student_personaldetails> student_personaldetails=new ArrayList<Student_personaldetails>();
		List<Student_marks>student_marks=new ArrayList<Student_marks>();
		List<Student_attendance> student_attendances=new ArrayList<Student_attendance>();

		String ROLLNO=request.getParameter("ROLLNO");
		Student_service student_service=StudentServiceFactory.getstudentservice();
		String status=student_service.Deletemarks(ROLLNO);
		if (status.equalsIgnoreCase("sucess")) {
			
			Student_service student_service1=StudentServiceFactory.getstudentservice();
			student_personaldetails=student_service1.viewallStudents();
			student_marks=student_service.viewallstudentmarks();
			student_attendances=student_service.viewallstudentattendance();
			HttpSession http=request.getSession();
			http.setAttribute("studentdetails", student_personaldetails);
			
			
			http.setAttribute("studentmarks", student_marks);
		
		
			http.setAttribute("studentattendance", student_attendances);
			String alertmessage=ROLLNO+" Marks delete sucessfully";
			http.setAttribute("alertmessage", alertmessage);
	response.sendRedirect("adminside.jsp");
				/*RequestDispatcher requestDispatcher=request.getRequestDispatcher("adminside.jsp");
				requestDispatcher.forward(request, response);*/
		}
	else {
	
		Student_service student_service1=StudentServiceFactory.getstudentservice();
		student_personaldetails=student_service1.viewallStudents();
		student_marks=student_service.viewallstudentmarks();
		student_attendances=student_service.viewallstudentattendance();
		HttpSession http=request.getSession();
		http.setAttribute("studentdetails", student_personaldetails);
		
		
		http.setAttribute("studentmarks", student_marks);
	
	
		http.setAttribute("studentattendance", student_attendances);
		String alertmessage=ROLLNO+" Marks deletion failure";
		http.setAttribute("alertmessage", alertmessage);
response.sendRedirect("adminside.jsp");
		
	}
	}

}
