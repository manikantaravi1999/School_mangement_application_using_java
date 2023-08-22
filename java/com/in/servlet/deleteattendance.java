package com.in.servlet;

import jakarta.servlet.RequestDispatcher;
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
 * Servlet implementation class deleteattendance
 */
@WebServlet("/deleteattendance")
public class deleteattendance extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student_personaldetails> student_personaldetails=new ArrayList<Student_personaldetails>();
		List<Student_marks>student_marks=new ArrayList<Student_marks>();
		List<Student_attendance> student_attendances=new ArrayList<Student_attendance>();

		String ROLLNO=request.getParameter("ROLLNO");
		Student_service student_service=StudentServiceFactory.getstudentservice();
		String status=student_service.Deleteattendance(ROLLNO);
		if (status.equalsIgnoreCase("sucess")) {
			student_personaldetails=student_service.viewallStudents();
			student_marks=student_service.viewallstudentmarks();
			student_attendances=student_service.viewallstudentattendance();
			HttpSession http=request.getSession();
			http.setAttribute("studentdetails", student_personaldetails);
			
			
			http.setAttribute("studentmarks", student_marks);
		
		
			http.setAttribute("studentattendance", student_attendances);
			String alertmessage= ROLLNO+"  Attendance Delete sucessfully";
			http.setAttribute("alertmessage", alertmessage);
	response.sendRedirect("adminside.jsp");
				/*RequestDispatcher requestDispatcher=request.getRequestDispatcher("adminside.jsp");
				requestDispatcher.forward(request, response);*/
		}
		else {
			
			
			student_personaldetails=student_service.viewallStudents();
			student_marks=student_service.viewallstudentmarks();
			student_attendances=student_service.viewallstudentattendance();
			HttpSession http=request.getSession();
			http.setAttribute("studentdetails", student_personaldetails);
			
			
			http.setAttribute("studentmarks", student_marks);
		
		
			http.setAttribute("studentattendance", student_attendances);
			String alertmessage= ROLLNO+"  Attendance Deletion failure";
			http.setAttribute("alertmessage", alertmessage);
	response.sendRedirect("adminside.jsp");
		}
			
		}
		
	}


