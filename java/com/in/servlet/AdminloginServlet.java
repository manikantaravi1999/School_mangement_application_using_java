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
import java.util.Iterator;
import java.util.List;

import org.apache.catalina.Session;

import com.in.studentinformation.SchoolAdminLogin;
import com.in.studentinformation.Student_attendance;
import com.in.studentinformation.Student_marks;
import com.in.studentinformation.Student_personaldetails;
import com.in.studentservice.Student_service;

import Student_Factory.StudentServiceFactory;

/**
 * Servlet implementation class AdminloginServlet
 */
@WebServlet("/AdminloginServlet")
public class AdminloginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;public AdminloginServlet() {
		// TODO Auto-generated constructor stub
	}
	
	
	SchoolAdminLogin schoolAdminLogin=new SchoolAdminLogin();
	List<Student_personaldetails> student_personaldetails=new ArrayList<Student_personaldetails>();
	List<Student_marks>student_marks=new ArrayList<Student_marks>();
	List<Student_attendance> student_attendances=new ArrayList<Student_attendance>();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
PrintWriter pw=response.getWriter();
schoolAdminLogin.setSchool_Id(request.getParameter("username")); // username
		schoolAdminLogin.setSchool_password(request.getParameter("password")); // password
		response.setContentType("text/html");
		Student_service studentserviceimpl = StudentServiceFactory.getstudentservice();
		boolean status = studentserviceimpl.Schoolvalidation(schoolAdminLogin);
		Student_service student_service=StudentServiceFactory.getstudentservice();
		student_personaldetails=student_service.viewallStudents();
		student_marks=student_service.viewallstudentmarks();
		student_attendances=student_service.viewallstudentattendance();
		HttpSession http=request.getSession();
		if (status) {
		
				http.setAttribute("studentdetails", student_personaldetails);
			
			
				http.setAttribute("studentmarks", student_marks);
			
			
				http.setAttribute("studentattendance", student_attendances);
				String alertmessage="LOGIN SUCESSFULLY !";
				http.setAttribute("alertmessage", alertmessage);
		response.sendRedirect("adminside.jsp");
			/*RequestDispatcher requestDispatcher=request.getRequestDispatcher("adminside.jsp");
			requestDispatcher.forward(request, response);
		 /*pw.println("sucess");	
		if(student_personaldetails!=null) {
 			while(itr.hasNext())
			{
				Student_personaldetails student_personaldetail =itr.next();
				pw.println(student_personaldetail.getADDRESS());
				pw.println("<br>"); 
			}
		/*Student_personaldetails student_personaldetail = null;
			for(Student_personaldetails student_personaldetail:student_personaldetails);
			{
			//Student_personaldetails student_personaldetail = null;
			pw.println(student_personaldetail.getADDRESS());
			
			}*/
	
		
		}
		else {
			String alert="LOGIN FAILURE";
			http.setAttribute("alertmessage", alert);
			 response.sendRedirect("index.jsp");	

		}
	}}


