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
import java.util.ArrayList;
import java.util.List;

import com.in.studentinformation.Student_attendance;
import com.in.studentinformation.Student_marks;
import com.in.studentinformation.Student_personaldetails;
import com.in.studentservice.Student_service;

import Student_Factory.StudentServiceFactory;

@WebServlet("/Adminside_Addstudentdetails")
public class Adminside_Addstudentdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String Fullname = request.getParameter("fullname");
		String Class = request.getParameter("class");
		String Rollno = request.getParameter("rollno");
		String Password = request.getParameter("password");
		String Date = request.getParameter("dob");
		String Gender = request.getParameter("gender");
		String Email = request.getParameter("email");
		String Mobile = request.getParameter("mobile");
		String Address = request.getParameter("address");
		List<Student_personaldetails> student_personaldetails = new ArrayList<Student_personaldetails>();
		List<Student_marks> student_marks = new ArrayList<Student_marks>();
		List<Student_attendance> student_attendances = new ArrayList<Student_attendance>();
		HttpSession http = request.getSession();

		Student_personaldetails studentpersonaldetails = new Student_personaldetails(Fullname, Class, Rollno, Password,
				Date, Gender, Email, Mobile, Address);
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		Student_service studentService = StudentServiceFactory.getstudentservice();
		String Status = studentService.AddStudent(studentpersonaldetails);

		try {
			if (Status.equalsIgnoreCase("sucess")) {

				Student_service student_service1 = StudentServiceFactory.getstudentservice();
				student_personaldetails = student_service1.viewallStudents();
				student_marks = student_service1.viewallstudentmarks();
				student_attendances = student_service1.viewallstudentattendance();

				http.setAttribute("studentdetails", student_personaldetails);

				http.setAttribute("studentmarks", student_marks);

				http.setAttribute("studentattendance", student_attendances);
				String alertmessage=Rollno+" Student Added Sucessfully";
				http.setAttribute("alertmessage", alertmessage);

				response.sendRedirect("adminside.jsp");

			} else {
				
				Student_service student_service1 = StudentServiceFactory.getstudentservice();
				student_personaldetails = student_service1.viewallStudents();
				student_marks = student_service1.viewallstudentmarks();
				student_attendances = student_service1.viewallstudentattendance();

				http.setAttribute("studentdetails", student_personaldetails);

				http.setAttribute("studentmarks", student_marks);

				http.setAttribute("studentattendance", student_attendances);
				String alertmessage=Rollno+" Student Adding Failure";
				http.setAttribute("alertmessage", alertmessage);

				response.sendRedirect("adminside.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
