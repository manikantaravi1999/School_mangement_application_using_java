<%@page import="com.in.studentinformation.Student_attendance"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.in.studentinformation.*"%>






<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login sucess</title>
<style type="text/css">
* {
	margin: 0%;
	padding: 0%;
	box-sizing: border-box;
}

body {
	width: 100%;
}

#head-div {
	width: 100%;
	background-image: url(nav1.jpeg);
	background-size: cover;
	margin-bottom: 3px;
}

#welcome-div {
	width: 80%;
	min-height: 80px;
	line-height: 80px;
	text-align: center;
	align-items: center;
	float: left;
	display: flex;
	padding-left: 50px;
}

#logout-div {
	width: 20%;
	min-height: 80px;
	line-height: 80px;
	padding-left: 120px;
	float: right;
}

.clearfix::after {
	content: "";
	display: block;
	clear: both;
}

span {
	font-size: 30px;
	text-transform: uppercase;
	padding-left: 150px;
}

#logout-btn {
	width: 80px;
	height: 40px;
	border-radius: 5px;
	font-weight: bold;
	color: black;
	border: none;
}

#logout-btn:hover {
	width: 85px;
	height: 45px;
	cursor: pointer;
	background-color: #e56262;
	color: white;
	font-weight: bold;
}

#personal-div {
	width: 100;
	background-image: url("nav1.jpeg");
	background-size: cover;
	color: white;
	margin-bottom: 10px;
}

#personal-div table {
	width: 100%;
}

#personal-div th {
	font-size: 30px;
	height: 60px;
	padding-bottom: 10px;
	color: white;
	background-color: #68676791;
}

#personal-div td {
	height: 40px;
	padding-left: 50px;
	font-size: 20px;
	font-weight: bold;
}

button#edit-btn {
	width: 60px;
	height: 30px;
	font-weight: bold;
	border-radius: 5px;
	border: none;
}

#edit-btn:hover {
	height: 33px;
	width: 63px;
	background-color: #e56262;
	color: white;
	cursor: pointer;
}

#marksatt-div {
	width: 100%;
	margin-bottom: 10px;
}

#marksatt-div table {
	width: 100%;
	background-image: url(nav1.jpeg);
	background-size: cover;
}

#marksatt-div td {
	text-align: center;
}

.headmarksatt {
	height: 50px;
	font-size: 25px;
	padding-bottom: 10px;
	padding-top: 10px;
	background-color: #68676791;
}

#row-head-marksatt {
	height: 40px;
	font-size: 20px;
}

#side-marksatt {
	height: 30px;
	font-size: 18px;
	padding-left: 50px;
}

td {
	font-size: 20px;
}

.markatt {
	padding-left: 40px;
}
</style>
</head>
<body>
	<%
	Student_personaldetails student_personaldetails = (Student_personaldetails) request.getSession()
			.getAttribute("studentPersonaldetails");
	
	String alertmessage=(String)request.getSession().getAttribute("alertmessage");
	%>
	<div id="head-div" class="clearfix">



		<div id="welcome-div">
			<img src="LOGO.png" alt="logo" width="60px" height="60px"><span>
				<h2>
					WELCOME TO
					<%=student_personaldetails.getFuLLNAME()%>


				</h2>
			</span>
		</div>
		<div id=logout-div>
			<form action="./logoutServlet">
				<input id="logout-btn" type="submit" value="LOGOUT">
			</form>
		</div>
	</div>
	<div id="personal-div">


		<table id="person-table-div">
			<tr>
			<tr>
				<th colspan="4">PERSONAL DETAILS
			</tr>
			<td>ROLL NO :</td>
			<td><%=student_personaldetails.getROLLNO()%></td>
			<td>FULL NAME :</td>
			<td><%=student_personaldetails.getFuLLNAME()%></td>
			</tr>
			<tr>
				<td>CLASS :</td>
				<td><%=student_personaldetails.getCLASS()%><sup>th</sup> class</td>
				<td>PASSWORD :</td>
				<td><%=student_personaldetails.getPASSWORD()%></td>
			</tr>
			<tr>

				<td>DOB :</td>
				<td><%=student_personaldetails.getDOB()%></td>
				<td>GENDER :</td>
				<td><%=student_personaldetails.getGENDER()%></td>
			</tr>

			<tr>
				<td>EMAIL :</td>
				<td><%=student_personaldetails.getEMAIL()%></td>
				<td>MOBILE :</td>
				<td><%=student_personaldetails.getMOBILE()%></td>
			</tr>
			<tr>
				<td>ADDRESS :</td>
				<td><%=student_personaldetails.getADDRESS()%></td>
				<td>EDIT :~~</td>
				<td>

					<button id="edit-btn"
						onclick="window.location.
					
						href='updatepersonservlet?ROLLNO=<%=student_personaldetails.getROLLNO()%>'">
						EDIT</button>
				</td>
			</tr>

		</table>







	</div>



	<div id="marksatt-div">
		<%
		Student_marks student_marks = (Student_marks) request.getSession().getAttribute("student_marks");
		if (student_marks != null) {
			float sum1 = student_marks.getTELUGU() + student_marks.getENGLISH() + student_marks.getHINDI()
			+ student_marks.getMATHS() + student_marks.getSCIENCE() + student_marks.getSOCIAL();
		%>

		<table id="marksatt-table-div" border=2>
			<tr>
				<th class="headmarks" colspan="3">MARKS</th>
			</tr>
			<tr>
				<th class="markatt" id="row-head-marksatt">SUBJECT</th>
				<th id="row-head-marksatt">MARKS OBTAINED</th>
				<th id="row-head-marksatt">MAXIMUM MARKS</th>
			</tr>
			<tr>
				<th id="side-marksatt">TELUGU</th>
				<td><%=student_marks.getTELUGU()%></td>
				<td>100</td>
			</tr>
			<tr>
				<th id="side-marksatt">ENGLISH</th>
				<td><%=student_marks.getENGLISH()%></td>
				<td>100</td>
			</tr>
			<tr>
				<th id="side-marksatt">HINDI</th>
				<td><%=student_marks.getHINDI()%></td>
				<td>100</td>

			</tr>
			<tr>
				<th id="side-marksatt">MATHS</th>
				<td><%=student_marks.getMATHS()%></td>
				<td>100</td>

			</tr>
			<tr>
				<th id="side-marksatt">SCIENCE</th>
				<td><%=student_marks.getSCIENCE()%></td>
				<td>100</td>

			</tr>
			<tr>
				<th id="side-marksatt">SOCIAL</th>
				<td><%=student_marks.getSOCIAL()%></td>
				<td>100</td>

			</tr>
			<tr id="row-head-marksatt">
				<th id="side-marksatt">TOTAL</th>
				<th><%=sum1%></th>
				<th>600</th>

			</tr>


			<%
			} else {
			%>
			<table id="marksatt-table-div" border=2>
				<tr>
					<th class="headmarksatt" colspan="3">MARKS</th>
				</tr>
				<tr>
					<th class="markatt" id="row-head-marksatt">SUBJECT</th>
					<th id="row-head-marksatt">MARKS OBTAINED</th>
					<th id="row-head-marksatt">MAXIMUM MARKS</th>
				</tr>
				<tr>
					<th id="side-marksatt">TELUGU</th>
					<td>NOT EXISTED</td>
					<td>100</td>
				</tr>
				<tr>
					<th id="side-marksatt">ENGLISH</th>
					<td>NOT EXISTED</td>
					<td>100</td>
				</tr>
				<tr>
					<th id="side-marksatt">HINDI</th>
					<td>NOT EXISTED</td>
					<td>100</td>

				</tr>
				<tr>
					<th id="side-marksatt">MATHS</th>
					<td>NOT EXISTED</td>
					<td>100</td>

				</tr>
				<tr>
					<th id="side-marksatt">SCIENCE</th>
					<td>NOT EXISTED</td>
					<td>100</td>

				</tr>
				<tr>
					<th id="side-marksatt">SOCIAL</th>
					<td>NOT EXISTED</td>
					<td>100</td>

				</tr>
				<tr id="row-head-marksatt">
					<th id="side-marksatt">TOTAL</th>
					<th>00</th>
					<th>600</th>

				</tr>

				<%
				}
				%>
			</table>

			</div>

			<div id="marksatt-div"">
				<%
				Student_attendance studentattendance = (Student_attendance) request.getSession().getAttribute("student_attendance");
				if (studentattendance != null) {
					float sum = studentattendance.getJune() + studentattendance.getJuly() + studentattendance.getAug()
					+ studentattendance.getSep() + studentattendance.getOct() + studentattendance.getNov()
					+ studentattendance.getDec() + studentattendance.getJan() + studentattendance.getFeb()
					+ studentattendance.getMar() + studentattendance.getApr();
				%>
				<table id="marksatt-table-div" border=2>

					<tr>
						<th colspan="3" class="headmarksatt">ATTENDANCE</th>
					</tr>
					<tr>
						<th class="markatt" id="row-head-marksatt">MONTHS</th>
						<th id="row-head-marksatt">PRESENT DAYS</th>

						<th id="row-head-marksatt">WORKING DAYS</th>

					</tr>
					<tr>
						<th id="side-marksatt">JUNE</th>
						<td><%=studentattendance.getJune()%></td>
						<td>18</td>
					</tr>
					<tr>
						<th id="side-marksatt">JULY</th>

						<td><%=studentattendance.getJuly()%></td>
						<td>22</td>
					</tr>
					<tr>
						<th id="side-marksatt">AUGUST</th>

						<td><%=studentattendance.getAug()%></td>
						<td>24</td>
					</tr>
					<tr>
						<th id="side-marksatt">SEPTEMBER</th>

						<td><%=studentattendance.getSep()%></td>
						<td>21</td>
					</tr>
					<tr>
						<th id="side-marksatt">OCTOBER</th>

						<td><%=studentattendance.getOct()%></td>
						<td>20</td>
					</tr>
					<tr>
						<th id="side-marksatt">NOVEMBER</th>

						<td><%=studentattendance.getNov()%></td>
						<td>23</td>
					</tr>
					<tr>
						<th id="side-marksatt">DECEMBER</th>

						<td><%=studentattendance.getDec()%></td>
						<td>20</td>
					</tr>
					<tr>
						<th id="side-marksatt">JANUARY</th>

						<td><%=studentattendance.getJan()%></td>
						<td>19</td>
					</tr>
					<tr>
						<th id="side-marksatt">FEBRUARY</th>

						<td><%=studentattendance.getFeb()%></td>
						<td>24</td>
					</tr>
					<tr>
						<th id="side-marksatt">MARCH</th>

						<td><%=studentattendance.getMar()%></td>
						<td>22</td>
					</tr>
					<tr>
						<th id="side-marksatt">APRIL</th>
						<td><%=studentattendance.getApr()%></td>
						<td>18</td>
					</tr>
					<tr id="row-head-marksatt">
						<th id="side-marksatt">TOTAL</th>

						<td><%=sum%></td>
						<td>231</td>
					</tr>


				</table>

				<%
				} else {
				%>
				<table id="marksatt-table-div" border=2>

					<tr>
						<th colspan="3" class="headmarksatt">ATTENDANCE</th>
					</tr>
					<tr>
						<th class="markatt" id="row-head-marksatt">MONTHS</th>
						<th id="row-head-marksatt">PRESENT DAYS</th>

						<th id="row-head-marksatt">WORKING DAYS</th>

					</tr>
					<tr>
						<th id="side-attendance">JUNE</th>
						<td>NOT EXISTED</td>
						<td>18</td>
					</tr>
					<tr>
						<th id="side-attendance">JULY</th>

						<td>NOT EXISTED</td>
						<td>22</td>
					</tr>
					<tr>
						<th id="side-attendance">AUGUST</th>

						<td>NOT EXISTED</td>
						<td>24</td>
					</tr>
					<tr>
						<th id="side-attendance">SEPTEMBER</th>

						<td>NOT EXISTED</td>
						<td>21</td>
					</tr>
					<tr>
						<th id="side-attendance">OCTOBER</th>

						<td>NOT EXISTED</td>
						<td>20</td>
					</tr>
					<tr>
						<th id="side-attendance">NOVEMBER</th>

						<td>NOT EXISTED</td>
						<td>23</td>
					</tr>
					<tr>
						<th id="side-attendance">DECEMBER</th>

						<td>NOT EXISTED</td>
						<td>20</td>
					</tr>
					<tr>
						<th id="side-attendance">JANUARY</th>

						<td>NOT EXISTED</td>
						<td>19</td>
					</tr>
					<tr>
						<th id="side-attendance">FEBRUARY</th>

						<td>NOT EXISTED</td>
						<td>24</td>
					</tr>
					<tr>
						<th id="side-attendance">MARCH</th>

						<td>NOT EXISTED</td>
						<td>22</td>
					</tr>
					<tr>
						<th id="side-attendance">APRIL</th>
						<td>NOT EXISTED</td>
						<td>18</td>
					</tr>
					<tr id="row-head-marksatt">
						<th id="side-attendance">TOTAL</th>

						<td>00</td>
						<td>231</td>
					</tr>

					<%
					}
					%>

				</table>
			</div>
			<script>
			alert("<%=alertmessage%>")
			</script>
</body>
</html>