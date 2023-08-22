package com.in.studentservice;

import java.util.List;

import com.in.studentinformation.SchoolAdminLogin;
import com.in.studentinformation.StudentLogin;
import com.in.studentinformation.Student_attendance;
import com.in.studentinformation.Student_marks;
import com.in.studentinformation.Student_personaldetails;

public interface Student_service {
	/* 
	 * school validation
	 */
	public boolean Schoolvalidation(SchoolAdminLogin studentadminlogin);

	/*
	 * loginStudent
	 */
	public boolean Studentvalidation(StudentLogin studentlogin);
	/*
	 * studentdetails
	 */
	public List<Student_personaldetails> viewallStudents();

	public String AddStudent(
			Student_personaldetails student_personal); /*
														 * insert student****acess both admin and student
														 */

	public String UpdateStudent(Student_personaldetails student_personaldetails); // update student****acess both admin and student

	public Student_personaldetails Searchstudent(String ROLLNO); // search student****acess both admin and student

	public String Deletestudent(String ROLLNO); // delete student**** access only admin

	/*
	 * studentmarks
	 */
	public List<Student_marks> viewallstudentmarks();// view all student marks ****acess only admin

	public Student_marks Searchmarks(String ROLLNO); // search studentmarks**** access student and admin

	public String Addmarks(Student_marks student_marks); // add studentmarks ****access only admin

	public String UpdateMarks(Student_marks Student_marks); // update student marks****acess only admin

	public String Deletemarks(String ROLLNO);// delete student marks****acess only admin
	
	/*
	 * student attendance
	 */
	public List<Student_attendance> viewallstudentattendance();// view all student marks ****acess only admin

	public String Addattendance(Student_attendance student_attendance);// add studentmarks ****access only admin

	public Student_attendance Searchattendance(String ROLLNO); // search student attendance**** access student and admin

	public String Updateattendance(Student_attendance student_attendance); // update student attendance****acess only admin

	public String Deleteattendance(String ROLLNO);// delete student attendance****acess only admin
}
