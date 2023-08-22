 package com.in.studentservice;

import java.util.List;

import com.in.studentinformation.SchoolAdminLogin;
import com.in.studentinformation.StudentLogin;
import com.in.studentinformation.Student_attendance;
import com.in.studentinformation.Student_marks;
import com.in.studentinformation.Student_personaldetails;
import com.in.studentinformation_dao.Student_dao;
import Student_Factory.StudentDaoFactory;

public class Student_service_implementation implements Student_service {
	Student_dao student_dao=StudentDaoFactory.getstudentdaoimpl();


	@Override
	public boolean Studentvalidation(StudentLogin studentlogin) {
	
		boolean status=student_dao.Studentvalidation(studentlogin);
		return status;
				
	}

	@Override
	public String AddStudent(Student_personaldetails student_personal) {
	String status=student_dao.AddStudent(student_personal);
	
		return status;
	}

	@Override
	public String UpdateStudent(Student_personaldetails student_personaldetails) {
		String status=student_dao.UpdateStudent(student_personaldetails);
		return status;
	}

	@Override
	public Student_personaldetails Searchstudent(String ROLLNO) {
		Student_personaldetails student_personaldetails=student_dao.Searchstudent(ROLLNO); 
		return student_personaldetails;
	}

	@Override
	public String Deletestudent(String ROLLNO) {
		String status=student_dao.Deletestudent(ROLLNO);
		return status;
	}

	@Override
	public Student_marks Searchmarks(String ROLLNO) {
		Student_marks student_marks=student_dao.Searchmarks(ROLLNO);
		return student_marks;
	}

	@Override
	public String Addmarks(Student_marks student_marks) {
		String status=student_dao.Addmarks(student_marks);
		return status;
	}

	@Override
	public String UpdateMarks (Student_marks student_marks) {
String status=student_dao.UpdateMarks(student_marks);
return status;
	}

	@Override
	public String Deletemarks(String ROLLNO) {
String status=student_dao.Deletemarks(ROLLNO);
return status;
	}

	@Override
	public String Addattendance(Student_attendance student_attendance) {
		String status=student_dao.Addattendance(student_attendance);
		return status;
	}

	@Override
	public Student_attendance Searchattendance(String ROLLNO) {
		Student_attendance student_attendance=student_dao.Searchattendance( ROLLNO);
		return student_attendance;
	}

	@Override
	public String Updateattendance(Student_attendance student_attendance) {
String status=student_dao.Updateattendance(student_attendance);
		return status;
	}

	@Override
	public String Deleteattendance(String ROLLNO) {
String status=student_dao.Deleteattendance(ROLLNO);
		return status;
	}

	@Override
	public boolean Schoolvalidation(SchoolAdminLogin schooladminlogin) {
boolean status = student_dao.Schoolvalidation(schooladminlogin);
		return status;
	}

	@Override
	public List<Student_personaldetails> viewallStudents() {
		List <Student_personaldetails> student_personaldetails=student_dao.viewallStudents();
		return student_personaldetails;
	}

	@Override
	public List<Student_marks> viewallstudentmarks() {
		List<Student_marks> student_marks=student_dao.viewallstudentmarks();
		return student_marks;
	}

	@Override
	public List<Student_attendance> viewallstudentattendance() {
		List<Student_attendance> student_attendances=student_dao.viewallstudentattendance();
		
		return student_attendances;
	}

}
