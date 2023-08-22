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
 * Servlet implementation class updatemarks
 */
@WebServlet("/updatemarks")
public class updatemarks extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter pw=response.getWriter();
	String ROLLNO=request.getParameter("rollno");
	float TELUGU=Float.parseFloat(request.getParameter("telugu"));
	float ENGLISH=Float.parseFloat(request.getParameter("english"));
	float HINDI=Float.parseFloat(request.getParameter("hindi"));
	float MATHS=Float.parseFloat(request.getParameter("maths"));
	float SCIENCE=Float.parseFloat(request.getParameter("science"));
	float SOCIAL=Float.parseFloat(request.getParameter("social"));
	Student_marks student_marks=new Student_marks(ROLLNO, TELUGU, ENGLISH, HINDI, MATHS, SCIENCE, SOCIAL);
			
	Student_service student_service=StudentServiceFactory.getstudentservice();
	String status=student_service.UpdateMarks(student_marks);
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
		String alertmessage=ROLLNO+" Marks Update sucessfully";
		http.setAttribute("alertmessage", alertmessage);
response.sendRedirect("adminside.jsp");
	}
else {
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
	String alertmessage=ROLLNO+" Marks Updation failure";
	http.setAttribute("alertmessage", alertmessage);
response.sendRedirect("adminside.jsp");

	
}
	}

}
