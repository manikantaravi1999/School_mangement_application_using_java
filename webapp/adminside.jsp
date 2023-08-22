<%@page import="com.in.studentinformation.Student_attendance"%>
<%@page import="com.in.studentinformation.Student_marks"%>
<%@page import="com.in.studentinformation.Student_personaldetails"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>admin login sucess</title>
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
	margin-bottom:20px;
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
#table-div{
width: 100%;
margin-bottom: 20px;
}
table{
width: 100%;
text-align: center;}
th{
height:40px;

}
td{
height:34px;}
#head-table{
background-color: #68676791;}
#Add-btn {
	width: 150px;
	height: 30px;
	font-weight: bold;
	border-radius: 5px;
	background-color: #d5c8c8;
	border: none;
}

#Add-btn:hover {
	height:31px;
	width:153px;
	background-color: #e56262;

	color: white;
	cursor: pointer;}
	#edit-delete-btn{
	width: 70px;
	height:28px;
	font-weight: bold;
	border-radius: 5px;
	border: none;
	background-color: #d5c8c8;
		box-shadow: 3px solid black;

	
	}
	#edit-delete-btn:hover {
	height:29px;
	width:72px;
	background-color: #e56262;

	color: white;
	}
	a{
	text-decoration: none;
	color: black;
	}
	
</style>
</head>
<body>

	<div id="main-div">
	<div id="head-div" class="clearfix">



		<div id="welcome-div">
			<img src="LOGO.png" alt="logo" width="60px" height="60px"><span>
				<h2>
					WELCOME TO A KAMAKSHI HIGH SCHOOL
					


				</h2>
			</span>
		</div>
		<div id=logout-div>
			<form action="./logoutServlet">
				<input id="logout-btn" type="submit" value="LOGOUT">
			</form>
		</div>
	</div>
		<div id="table-div">
		
				<%
			String alertmessage=(String)request.getSession().getAttribute("alertmessage");
				%>
				
		
			<table border=2>
			<tr>
			<th id="head-table" colspan="9">STUDENT LIST</th>
						<th id="head-table" colspan="2"> <button id="Add-btn"
						onclick="window.location.
					href='adminaddstudent.jsp'">ADD STUDENT</button></th>
			
			</tr>
				<tr>
				
					<th>FULL NAME</th>
					<th>CLASS</th>
					<th>ROLL NO</th>
					<th>PASSWORD</th>
					<th>DOB</th>
					<th>GENDER</th>
					<th>EMAIL</th>
					<th>MOBILE</th>
					<th>ADDRESS</th>
					
					<th>EDIT</th>
					<th>DELETE</th>

				</tr>
				<%
				List<Student_personaldetails> studentdetail = (List<Student_personaldetails>) request.getSession()
						.getAttribute("studentdetails");
				for (Student_personaldetails stu : studentdetail) {
					
				%>
				<tr>
					<td><%=stu.getFuLLNAME()%></td>
					<td><%=stu.getCLASS()%></td>
					<td><%=stu.getROLLNO()%></td>
					<td><%=stu.getPASSWORD()%></td>
					<td><%=stu.getDOB()%></td>
					<td><%=stu.getGENDER()%></td>
					<td><%=stu.getEMAIL()%></td>
					<td><%=stu.getMOBILE()%></td>
					<td><%=stu.getADDRESS()%></td>
					<td><button id="edit-delete-btn">
							<a onclick=" return confirmEdit()"
								href="supportupdatestudentadminside?ROLLNO=<%=stu.getROLLNO()%>">edit</a>
						</button></td>
					<td>
						<button id="edit-delete-btn"><a onclick=" return confirmDelete()" href="deletestudent?ROLLNO=<%=stu.getROLLNO()%>">delete</a>
						</button>
					</td>

				</tr>
				<%
				}
				%>

			</table>
		</div>
		

		<div id="table-div">
			 

			<table border=2>
			<tr>
			<th id="head-table" colspan="8">MARKS LIST
			</th>
			<th id="head-table" colspan="2"> <button id="Add-btn"
						onclick="window.location.href='Addmarks.jsp'">ADD MARKS</button>
			</th>
			</tr>
				<tr>
					<th>ROLLNO</th>
					<th>TELUGU</th>
					<th>ENGLISH</th>
					<th>HINDI</th>
					<th>MATHS</th>
					<th>SCIENCE</th>
					<th>SOCIAL</th>
<th>TOTAL</th>
					<th>EDIT</th>
					<th>DELETE</th>

				</tr>
				<%
				List<Student_marks> student_marks = (List<Student_marks>) request.getSession().getAttribute("studentmarks");
				for (Student_marks mar : student_marks) {
					float sum1 = mar.getTELUGU() + mar.getENGLISH() + mar.getHINDI()
					+ mar.getMATHS() + mar.getSCIENCE() + mar.getSOCIAL();
				%>
				<tr>
					<td><%=mar.getROLLNO()%></td>
					<td><%=mar.getTELUGU()%></td>
					<td><%=mar.getENGLISH()%></td>
					<td><%=mar.getHINDI()%></td>
					<td><%=mar.getMATHS()%></td>
					<td><%=mar.getSCIENCE()%></td>
					<td><%=mar.getSOCIAL()%></td>
					<td><%=sum1 %> </td>
					<td><button id="edit-delete-btn">
							<a onclick=" return confirmEdit()"
								href="supportupdatemarks?ROLLNO=<%=mar.getROLLNO()%>">Edit</a>
						</button></td>
					<td><button id="edit-delete-btn">
							<a onclick=" return confirmDelete()"
								href="deletemarks?ROLLNO=<%=mar.getROLLNO()%>">Delete</a>
						</button></td>

					<%
					}
					%>
				</tr>
			</table>
		</div>
		
		

		<div id="table-div">
			 

			<table border=2>
			<tr> 
			<th id="head-table" colspan="13"> ATTENDANCE LIST</th>
			<th id="head-table" colspan="2"> <button id="Add-btn"
						onclick="window.location.href='Addattendance.jsp'">ADD ATTENDANCE</button></th>
			</tr>
				<tr>
				
					<th>ROLLNO</th>
					<th>JUN</th>
					<th>JUL</th>
					<th>AUG</th>
					<th>SEP</th>
					<th>OCT</th>
					<th>NOV</th>
					<th>DEC</th>
					<th>JAN</th>
					<th>FEB</th>
					<th>MAR</th>
					<th>APR</th>
					<th>TOTAL</th>
					
					<th>EDIT</th>
					<th>DELETE</th>



				</tr>
				<%
				List<Student_attendance> student_attendances = (List<Student_attendance>) request.getSession().getAttribute("studentattendance");
				for (Student_attendance att : student_attendances) {
					float sum = att.getJune() + att.getJuly() + att.getAug()
					+ att.getSep() + att.getOct() + att.getNov()
					+ att.getDec() + att.getJan() + att.getFeb()
					+ att.getMar() + att.getApr();
				%>
				<tr>
					<td><%=att.getROLLNO()%></td>
					<td><%=att.getJune()%></td>
					<td><%=att.getJuly()%></td>
					<td><%=att.getAug()%></td>
					<td><%=att.getSep()%></td>
					<td><%=att.getOct()%></td>
					<td><%=att.getNov()%></td>
					<td><%=att.getDec()%></td>
					<td><%=att.getJan()%></td>
					<td><%=att.getFeb()%></td>
					<td><%=att.getMar()%></td>
					<td><%=att.getApr()%></td>
					<td><%= sum%></td>
					
					<td><button id="edit-delete-btn"><a onclick=" return confirmEdit()" href="Supportupdateattendance?ROLLNO=<%=att.getROLLNO()%>">Edit</a>
						</button></td>

					<td><button id="edit-delete-btn"><a onclick=" return confirmDelete()" href="deleteattendance?ROLLNO=<%=att.getROLLNO()%>">Delete</a>
						</button></td>
			

					<%
					}
					%>
				</tr>
			</table>
		</div>
		
	</div>
	<script type="text/javascript">
		function confirmDelete() {
			return window.confirm("Are you sure you want to delete this item?");
		}
		function confirmEdit() {
			return window.confirm("Are you sure you want to edit");
		}
		
		alert("<%=alertmessage%>");
		</script>
		</script>
	</body>
	</html>