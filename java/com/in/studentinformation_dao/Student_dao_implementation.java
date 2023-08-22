package com.in.studentinformation_dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.in.studentinformation.SchoolAdminLogin;
import com.in.studentinformation.StudentLogin;
import com.in.studentinformation.Student_attendance;
import com.in.studentinformation.Student_marks;
import com.in.studentinformation.Student_personaldetails;

import Student_Factory.ConnectionFactory;
import Student_Factory.StudentDaoFactory;

public class Student_dao_implementation implements Student_dao {
	Connection connection = ConnectionFactory.getConnection();
	@Override
	public boolean Schoolvalidation(SchoolAdminLogin schooladminlogin) {
		boolean status = false;
		try {
			Statement statement = connection.createStatement();
			String Sql_query = "select * from admin where username='" + schooladminlogin.getSchool_Id()
					+ "' and password='" + schooladminlogin.getSchool_password() + "'";
			ResultSet resultSet = statement.executeQuery(Sql_query);
			if (resultSet.next()) {
				status = true;
			} else {
				status = false;
			}

		} catch (Exception e) {
			System.out.println(e);
			status=false;
		}

		return status;
	}

	@Override

	public boolean Studentvalidation(StudentLogin studentlogin) {

		boolean status = false;
		try {
			Statement statement = connection.createStatement();
			String Sql_query = "select * from Studentlogin where rollno='" + studentlogin.getROLLNO()
					+ "' and password='" + studentlogin.getPASSWORD() + "'";
			ResultSet resultSet = statement.executeQuery(Sql_query);
			if (resultSet.next()) {
				status = true;
			} else {
				status = false;
			}

		} catch (Exception e) {
			System.out.println(e);
			status=false;
		}

		return status;

	}

	@Override
	public String AddStudent(Student_personaldetails student_personal) {
		String status = null;
		try {
			
			Statement statement = connection.createStatement();
			String sql_query = "insert into studentlogin values('" + student_personal.getFuLLNAME() + "','"
					+ student_personal.getCLASS() + "','" + student_personal.getROLLNO() + "','"
					+ student_personal.getPASSWORD() + "','" + student_personal.getDOB() + "','"
					+ student_personal.getGENDER() + "','" + student_personal.getEMAIL() + "','"
					+ student_personal.getMOBILE() + "','" + student_personal.getADDRESS() + "')";
			int rowCount = statement.executeUpdate(sql_query);
			if (rowCount == 1) {
				status = "sucess";
			} else {
				status = "failure";
			}
		} catch (Exception e) {
			status=e.getMessage();
		}

		return status;
	}

	@Override
	public String UpdateStudent(Student_personaldetails student_personaldetails) {
		String status = null;
		try {
			Statement statement = connection.createStatement();
			String sql_query = "update studentlogin" + " set FULLNAME='" + student_personaldetails.getFuLLNAME()
					+ "',CLASS='" + student_personaldetails.getCLASS() + "',PASSWORD='"
					+ student_personaldetails.getPASSWORD() + "', DOB='" + student_personaldetails.getDOB() + "',"
					+ "GENDER='" + student_personaldetails.getGENDER() + "', EMAIL='"
					+ student_personaldetails.getEMAIL() + "',MOBILE='" + student_personaldetails.getMOBILE()
					+ "',ADDRESS='" + student_personaldetails.getADDRESS() + "'" + " where ROLLNO='"
					+ student_personaldetails.getROLLNO() + "'";

			int rowcount = statement.executeUpdate(sql_query);
			if (rowcount == 1) {
				status = "sucess";
			} 
		else {
			
			status="failure";
		}}
		
		catch (Exception e) {
			String al=e.getMessage();
System.out.println(al);
			status=e.getMessage();
		}

		return status;
	}

	@Override
	public Student_personaldetails Searchstudent(String ROLLNO) {
		Student_personaldetails student_personaldetails = null;
		try {
			Statement statement = connection.createStatement();
			String sql = "select * from Studentlogin where ROLLNO='" + ROLLNO + "'";
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
			/*	student_personaldetails = new Student_personaldetails();
				student_personaldetails.setFIRSTNAME(resultSet.getString(1));
				student_personaldetails.setLASTNAME(resultSet.getString(2));
				student_personaldetails.setROLLNO(resultSet.getString(3));
				student_personaldetails.setPASSWORD(resultSet.getString(4));
				student_personaldetails.setDOB(resultSet.getString(5));
				student_personaldetails.setGENDER(resultSet.getString(6));
				student_personaldetails.setEMAIL(resultSet.getString(7));
				student_personaldetails.setMOBILE(resultSet.getString(8));
				student_personaldetails.setADDRESS(resultSet.getString(9));*/
				String  FULLNAME=resultSet.getString(1);
				String CLASS	=resultSet.getString(2);
				String ROLLNO1	=resultSet.getString(3);
				String PASSWORD	=resultSet.getString(4);
				String DOB=resultSet.getString(5);
				String GENDER=resultSet.getString(6);
				String EMAIL=resultSet.getString(7);
				String MOBILE	=resultSet.getString(8);
				String ADDRESS=resultSet.getString(9);
				student_personaldetails=new Student_personaldetails(FULLNAME, CLASS, ROLLNO1, PASSWORD, DOB, GENDER, EMAIL, MOBILE, ADDRESS);
			

			} else {
				student_personaldetails = null;
			}
		} catch (Exception e) {
			System.out.println(e);
			student_personaldetails=null;
		}

		return student_personaldetails;
	}

	@Override
	public String Deletestudent(String ROLLNO) {
		String status = null;
		try {
			Statement statement = connection.createStatement();
			String sql = "delete from studentlogin where ROLLNO='" + ROLLNO + "'";
			int rowCount = statement.executeUpdate(sql);

			if (rowCount == 1) {
				status = "sucess";
			} else {
				status = "failure";
			}
		} catch (Exception e) {
			System.out.println(e);
			status=e.getMessage();
		}

		return status;
	}

	/*
	 * marks
	 */
	@Override
	public Student_marks Searchmarks(String ROLLNO) {

		Student_marks student_marks = null;
		try {
			Statement statement = connection.createStatement();
			String sql = "select * from studentmarks where ROLLNO='" + ROLLNO + "'";
			ResultSet resultSet = statement.executeQuery(sql);

			if (resultSet.next()) {
				/*
				 * student_marks = new Student_marks();
				 * student_marks.setROLLNO(resultSet.getString(1));
				 * student_marks.setTELUGU(resultSet.getFloat(2));
				 * student_marks.setENGLISH(resultSet.getFloat(3));
				 * student_marks.setHINDI(resultSet.getFloat(4));
				 * student_marks.setMATHS(resultSet.getFloat(5));
				 * student_marks.setSCIENCE(resultSet.getFloat(6));
				 * student_marks.setSOCIAL(resultSet.getFloat(7));
				 */
				String ROLLNO1 = resultSet.getString(1);
				float TELUGU = resultSet.getFloat(2);
				float ENGLISH = resultSet.getFloat(3);

				float HINDI = resultSet.getFloat(4);
				float MATHS = resultSet.getFloat(5);
				float SCIENCE = resultSet.getFloat(6);

				float SOCIAL = resultSet.getFloat(7);
				student_marks = new Student_marks(ROLLNO1, TELUGU, ENGLISH, HINDI, MATHS, SCIENCE, SOCIAL);
			} else {
				student_marks = null;
			}
		} catch (SQLException e) {

			System.out.println(e);
			student_marks=null;
		}

		return student_marks;
	}

	@Override
	public String Addmarks(Student_marks student_marks) {
		String status = null;
		try {
			Statement statement = connection.createStatement();
			String sql_query = "insert into studentmarks values('" + student_marks.getROLLNO() + "',"
					+ student_marks.getTELUGU() + "," + student_marks.getENGLISH() + "," + student_marks.getHINDI()
					+ "," + student_marks.getMATHS() + "," + student_marks.getSCIENCE() + ","
					+ student_marks.getSOCIAL() + ")";
			int rowCount = statement.executeUpdate(sql_query);
			if (rowCount == 1) {
				status = "sucess";
			} else {
				status = "failure";
			}
		} catch (Exception e) {
			status=e.getMessage();
		}
		return status;
	}

	@Override
	public String UpdateMarks(Student_marks student_marks) {
		String status = null;
		try {
			Statement statement = connection.createStatement();

			String sql_query = "update studentmarks set TELUGU=" + student_marks.getTELUGU() + ",ENGLISH="
					+ student_marks.getENGLISH() + ", HINDI=" + student_marks.getHINDI() + ", MATHS="
					+ student_marks.getMATHS() + ", SCIENCE=" + student_marks.getSCIENCE() + ", SOCIAL="
					+ student_marks.getSOCIAL() + " where ROLLNO='" + student_marks.getROLLNO() + "'";
			int rowcount = statement.executeUpdate(sql_query);
			if (rowcount == 1) {
				status = "sucess";
			} else {
				status = "failure";
			}

		} catch (Exception e) {
status=e.getMessage();		}
		return status;
	}

	@Override
	public String Deletemarks(String ROLLNO) {
		String status = null;
		try {
			Statement statement = connection.createStatement();
			String sql = "delete from studentmarks where ROLLNO='" + ROLLNO + "'";
			int rowCount = statement.executeUpdate(sql);

			if (rowCount == 1) {
				status = "sucess";
			} else {
				status = "failure";
			}
		} catch (Exception e) {
			System.out.println(e);
			status=e.getMessage();
		}

		return status;
	}

	/*
	 * attendance
	 * 
	 */
	@Override
	public String Addattendance(Student_attendance student_attendance) {
		String status = null;
		try {
			Statement statement = connection.createStatement();
			String sql_query = "insert into studentattendance values('" + student_attendance.getROLLNO() + "',"
					+ student_attendance.getJune() + "," + student_attendance.getJuly() + ","
					+ student_attendance.getAug() + "," + student_attendance.getSep() + ","
					+ student_attendance.getOct() + "," + student_attendance.getNov() + ","
					+ student_attendance.getDec() + "," + student_attendance.getJan() + ","
					+ student_attendance.getFeb() + "," + student_attendance.getMar() + ","
					+ student_attendance.getApr() + ")";
			int rowCount = statement.executeUpdate(sql_query);
			if (rowCount == 1) {
				status = "sucess";
			} else {
				status = "failure";
			}

		} catch (Exception e) {
status=e.getMessage();		}
		return status;
	}

	@Override
	public Student_attendance Searchattendance(String ROLLNO) {
		Student_attendance student_attendance = null;
		try {
			// step:2 create a statement using a connection object
			Statement statement = connection.createStatement();
			// step:3 write sql query
			String sql = "select * from studentattendance where ROLLNO='" + ROLLNO + "'";
			// step:4 execute the query
			ResultSet resultSet = statement.executeQuery(sql);
			// step:5 process the resultset object
			if (resultSet.next()) {
				String ROLLNO1 = resultSet.getString(1);
				float JUNE = Float.parseFloat(resultSet.getString(2));
				float JULY = Float.parseFloat(resultSet.getString(3));
				float AUGUST = Float.parseFloat(resultSet.getString(4));
				float SEPTEMBER = Float.parseFloat(resultSet.getString(5));
				float OCTOBER = Float.parseFloat(resultSet.getString(6));
				float NOVEMBER = Float.parseFloat(resultSet.getString(7));
				float DECEMBER = Float.parseFloat(resultSet.getString(8));
				float JANUARY = Float.parseFloat(resultSet.getString(9));
				float FEBRUARY = Float.parseFloat(resultSet.getString(10));
				float MARCH = Float.parseFloat(resultSet.getString(11));
				float APRIL = Float.parseFloat(resultSet.getString(12));
				student_attendance = new Student_attendance(ROLLNO1, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER,
						DECEMBER, JANUARY, FEBRUARY, MARCH, APRIL);
				/*
				 * student_attendance = new Student_attendance();
				 * student_attendance.setROLLNO(resultSet.getString(1));
				 * student_attendance.setJune(resultSet.getFloat(2));
				 * student_attendance.setJuly(resultSet.getFloat(3));
				 * student_attendance.setAug(resultSet.getFloat(4));
				 * student_attendance.setSep(resultSet.getFloat(5));
				 * student_attendance.setOct(resultSet.getFloat(6));
				 * student_attendance.setNov(resultSet.getFloat(7));
				 * student_attendance.setDec(resultSet.getFloat(8));
				 * student_attendance.setJan(resultSet.getFloat(9));
				 * student_attendance.setFeb(resultSet.getFloat(10));
				 * student_attendance.setMar(resultSet.getFloat(11));
				 * student_attendance.setApr(resultSet.getFloat(12));
				 */

			} else {
				
				student_attendance = null;
			}
		} catch (Exception e) {
			System.out.println(e);
			student_attendance=null;
		}

		return student_attendance;
	}

	@Override
	public String Updateattendance(Student_attendance student_attendance) {
		String status = null;
		try {
			Statement statement = connection.createStatement();

			String sql_query = "update studentattendance set JUN=" + student_attendance.getJune() + ",JUL="
					+ student_attendance.getJuly() + ", AUG=" + student_attendance.getAug() + ", SEP="
					+ student_attendance.getSep() + ", OCT=" + student_attendance.getOct() + ", NOV="
					+ student_attendance.getNov() + ", DEC=" + student_attendance.getDec() + ", JAN="
					+ student_attendance.getJan() + ", FEB=" + student_attendance.getFeb() + ", MAR="
					+ student_attendance.getMar() + ", APR=" + student_attendance.getApr() + " where ROLLNO='"
					+ student_attendance.getROLLNO() + "'";
			int rowcount = statement.executeUpdate(sql_query);
			if (rowcount == 1) {
				status = "sucess";
			} else {
				status = "failure";
			}
		} catch (Exception e) {
status=e.getMessage();		}

		return status;
	}

	@Override
	public String Deleteattendance(String ROLLNO) {
		String status = null;
		try {
			Statement statement = connection.createStatement();
			String sql = "delete from studentattendance where ROLLNO='" + ROLLNO + "'";
			int rowCount = statement.executeUpdate(sql);

			if (rowCount == 1) {
				status = "sucess";
			} else {
				status = "failure";
			}
		} catch (Exception e) {
			System.out.println(e);
			status=e.getMessage();
		}

		return status;
	}

	@Override
	public List<Student_personaldetails> viewallStudents() {
		List<Student_personaldetails> student_personaldetails = new ArrayList<Student_personaldetails>();
		try {
			// step:2 create a statement using a connection object
			Statement statement = connection.createStatement();
			// step:3 write sql query
			String sql = "select * from studentlogin";
			// step:4 execute the query
			ResultSet resultSet = statement.executeQuery(sql);
			// step:5 process the resultset object
			while (resultSet.next()) {
				String FIRSTNAME = resultSet.getString(1);
				String LASTNAME = resultSet.getString(2);
				String ROLLNO = resultSet.getString(3);
				String PASSWORD = resultSet.getString(4);
				String DOB = resultSet.getString(5);
				String GENDER = resultSet.getString(6);
				String EMAIL = resultSet.getString(7);
				String MOBILE = resultSet.getString(8);
				String ADDRESS = resultSet.getString(9);

				student_personaldetails.add(new Student_personaldetails(FIRSTNAME, LASTNAME, ROLLNO, PASSWORD, DOB, GENDER, EMAIL, MOBILE, ADDRESS));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return student_personaldetails;
	}

	@Override
	public List<Student_marks> viewallstudentmarks() {
		List<Student_marks> student_marks = new ArrayList<Student_marks>();
		try {
			// step:2 create a statement using a connection object
			Statement statement = connection.createStatement();
			// step:3 write sql query
			String sql = "select * from studentmarks";
			// step:4 execute the query
			ResultSet resultSet = statement.executeQuery(sql);
			// step:5 process the resultset object
			while (resultSet.next()) {

				String ROLLNO = resultSet.getString(1);
				float TELUGU = resultSet.getFloat(2);
				float ENGLISH = resultSet.getFloat(3);
				float HINDI = resultSet.getFloat(4);
				float MATHS = resultSet.getFloat(5);
				float SCIENCE = resultSet.getFloat(6);
				float SOCIAL = resultSet.getFloat(7);
				student_marks.add(new Student_marks(ROLLNO, TELUGU, ENGLISH, HINDI, MATHS, SCIENCE, SOCIAL));

			}

		}

		catch (Exception e) {
			System.out.println(e);
			student_marks=null;
		}
		return student_marks;
	}

	@Override
	public List<Student_attendance> viewallstudentattendance() {
		List<Student_attendance> student_attendances = new ArrayList<Student_attendance>();
		try {
			// step:2 create a statement using a connection object
			Statement statement = connection.createStatement();
			// step:3 write sql query
			String sql = "select * from studentattendance";
			// step:4 execute the query
			ResultSet resultSet = statement.executeQuery(sql);
			// step:5 process the resultset object
			while (resultSet.next()) {
				String ROLLNO1 = resultSet.getString(1);
				float JUNE = Float.parseFloat(resultSet.getString(2));
				float JULY = Float.parseFloat(resultSet.getString(3));
				float AUGUST = Float.parseFloat(resultSet.getString(4));
				float SEPTEMBER = Float.parseFloat(resultSet.getString(5));
				float OCTOBER = Float.parseFloat(resultSet.getString(6));
				float NOVEMBER = Float.parseFloat(resultSet.getString(7));
				float DECEMBER = Float.parseFloat(resultSet.getString(8));
				float JANUARY = Float.parseFloat(resultSet.getString(9));
				float FEBRUARY = Float.parseFloat(resultSet.getString(10));
				float MARCH = Float.parseFloat(resultSet.getString(11));
				float APRIL = Float.parseFloat(resultSet.getString(12));
				student_attendances.add(new Student_attendance(ROLLNO1, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER,
						NOVEMBER, DECEMBER, JANUARY, FEBRUARY, MARCH, APRIL));
			}
		} catch (Exception e) {
			System.out.println(e);
			student_attendances=null;
		}
		return student_attendances;
	}
}
