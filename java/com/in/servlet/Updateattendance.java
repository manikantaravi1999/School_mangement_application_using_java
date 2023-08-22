package com.in.servlet;

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

import Student_Factory.StudentServiceFactory;

/**
 * Servlet implementation class Updateattendance
 */
@WebServlet("/Updateattendance")
public class Updateattendance extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ROLLNO = request.getParameter("rollno");
		float JUNE = Float.parseFloat(request.getParameter("jun"));
		float JULY = Float.parseFloat(request.getParameter("jul"));
		float AUGUST = Float.parseFloat(request.getParameter("aug"));
		float SEPTEMBER = Float.parseFloat(request.getParameter("sep"));
		float OCTOBER = Float.parseFloat(request.getParameter("oct"));
		float NOVEMBER = Float.parseFloat(request.getParameter("nov"));
		float DECEMBER = Float.parseFloat(request.getParameter("dec"));
		float JANUARY = Float.parseFloat(request.getParameter("jan"));
		float FEBRUARY = Float.parseFloat(request.getParameter("feb"));
		float MARCH = Float.parseFloat(request.getParameter("mar"));
		float APRIL = Float.parseFloat(request.getParameter("apr"));
		Student_attendance student_attendance=new Student_attendance(ROLLNO, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER, JANUARY, FEBRUARY, MARCH, APRIL);
		PrintWriter pw=response.getWriter();

	Student_service student_service=StudentServiceFactory.getstudentservice();
	String status=student_service.Updateattendance(student_attendance);
	if (status.equalsIgnoreCase("sucess")) {
		
		List<Student_personaldetails> student_personaldetails=new ArrayList<Student_personaldetails>();
		List<Student_marks>student_marks1=new ArrayList<Student_marks>();
		List<Student_attendance> student_attendances=new ArrayList<Student_attendance>();

		Student_service student_service1=StudentServiceFactory.getstudentservice();
		student_personaldetails=student_service1.viewallStudents();
		student_marks1=student_service.viewallstudentmarks();
		student_attendances=student_service.viewallstudentattendance();
		HttpSession http=request.getSession();
		http.setAttribute("studentdetails", student_personaldetails);
		
		
		http.setAttribute("studentmarks", student_marks1);
	
	
		http.setAttribute("studentattendance", student_attendances);
		String alertmessage=ROLLNO+" Attendance update sucessfully";
		http.setAttribute("alertmessage", alertmessage);
response.sendRedirect("adminside.jsp");	
	}
else {List<Student_personaldetails> student_personaldetails=new ArrayList<Student_personaldetails>();
List<Student_marks>student_marks1=new ArrayList<Student_marks>();
List<Student_attendance> student_attendances=new ArrayList<Student_attendance>();

Student_service student_service1=StudentServiceFactory.getstudentservice();
student_personaldetails=student_service1.viewallStudents();
student_marks1=student_service.viewallstudentmarks();
student_attendances=student_service.viewallstudentattendance();
HttpSession http=request.getSession();
http.setAttribute("studentdetails", student_personaldetails);


http.setAttribute("studentmarks", student_marks1);


http.setAttribute("studentattendance", student_attendances);
String alertmessage=ROLLNO+" Attendance updation failure";
http.setAttribute("alertmessage", alertmessage);
response.sendRedirect("adminside.jsp");	


	
}
				
				

	}

}
