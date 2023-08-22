<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8" />
	<title>school management</title>
	<style>
		* {
			margin: 0%;
			padding: 0%;
			box-sizing: border-box;
		}

		#wrapper {
			width: 100%;
		}

		#logo-nav-div {
			width: 100%;
			background-image: url(nav1.jpeg);
			background-size: cover;
			margin-bottom: 3px;


		}

		#logo-div {
			width: 30%;
			min-height: 75px;

			padding-left: 50px;
			padding-top: 5px;
			float: left;

		}

		#nav-div {
			width: 70%;

			min-height: 75px;
			float: right;
			line-height: 75px;
			font-weight: bold;
			font-size: 20px;

		}

		.text1 {

			font-size: 20px;

		}

		#nav-div .unorderlist {
			display: flex;
			list-style-type: none;
		}

		li.nav {
			padding-left: 30px;

		}

		.clearfix::after {
			content: "";
			display: block;
			clear: both;
		}

		

		#bodyarea-div {
			width: 100%;
			min-height: 600px;
			background-image: url(ho.jpg);

			background-size: cover;
			float: right;
		}
#header{

    min-height: 150px;
    line-height:75px;
font-size: 35px;
color: red;
text-shadow: 3px 3px black;
margin-bottom: 150px;
}
#body{color: red;
text-shadow: 3px 3px white;
   
    height: 250px;
    width: 30%;
margin-left: 700px;
font-size: 30px;

}
#about-div{
			width: 100%;

			margin-bottom: 3px;


		}
        #heading-services{

text-align: center;
text-decoration: underline;
margin-top: 5px;
margin-bottom: 5px;

        }
#services{
			width:29.5%;
		

		margin-left:3%;
        margin-right:2%px;
			padding-top: 5px;
			float: left;

		}
    img.img {
        width: 100%;
        
        border: 2px solid black;

    }
		#footer-div {

			margin-top: 10px;
			width: 100%
		}

		#footer-leftside-div {
			width: 40%;
			background-color: #726565;

			float: left;
			min-height: 130px;
			padding-left: 30px;

		}

		#footer-rightside-div {
			padding-left: 40px;
			width: 60%;
			background-color: #726565;
			float: right;
			min-height: 120px;
			line-height: 120px;
		}

		ul.footer {
			list-style-type: none;
			margin: 0;
			padding: 0;
			overflow: hidden;
			display: flex;
		}

		form {
			width: 35%;
		}

		li.list {
			list-style-type: none;
		}


		li.nav {
			width: 200px;
			height: 30px;
		}

		li.cont {
			margin-top: 10px;
			align-items: center;
			padding-left: 10%;
		}

		a {
			color: blue;
		}

		a:hover {
			background-color: white;
			color: black;
		}

		.order {
			list-style-type: disc;
		}

		.text {
			color: white;
		}

		.location {
			color: white;
		}

		span {
			color: white;
		}




		.login-form {
			position: absolute;
			top: 50%;
			left: 50%;
			transform: translate(-50%, -50%)
		}


		table,
		th,
		td {

			width: 30%;
			height: 30px;
			text-align: center;
			margin-left: auto;
			margin-right: auto;
			margin-top: 50px;



			font-size: 25px;

			align-items: center;
		}



		th,
		td {
			height: 70px;
		}

		#bodyarea {
			text-align: center;

			height: 400px;
		}

		button.button {
			font-size: 20px;
			padding: 10px 10px;
			background-color: gray;
			color: white;
			font-weight: bold;
			border: 3px black;
			width: 80px;
			height: 40px;
		}

		button.button:hover {
			background-color: black;
			color: white;
		}



		.text {
			font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
			padding-left: 10px;
			color: black;
			font-size: 25px;
			height: 25px;
			width: 250px;
			background: transparent;
			border: none;
			border-bottom: 2px solid black;
			outline: none;
		}

		.select-container {

			justify-content: center;


		}

		form {
			background-color: aqua;
			border: 2px solid black;
			box-shadow: 2px 2px gray;
		}

		.select-box {
			border: none;

			width: 150px;
			height: 40px;
			background-color: transparent;
			font-size: 20px;
			font-weight: bold;
			color: blue;
			text-decoration: underline;
			align-items: center;
		}

		.select-box:hover {
			color: aqua;
			cursor: pointer;
			background-color: white;
			color: black;
		}

		option {
			border: none;
		}

		.login-form {

			display: none;
			position: absolute;
		}

		.close-button {
			position: absolute;
			top: 10px;
			right: 10px;
			font-size: 30px;
			cursor: pointer;
		}
	</style>
</head>

<body>
    <%

    String alert1=(String)request.getSession().getAttribute("alertmessage"); 
    String alert;
    if(alert1==null)
    {
        alert="WELCOME TO A KAMAKSHI HIGH SCHOOL";
        }
    else{
        alert=alert1;
    }
    
    %>
	<div id="wrapper">
		<div id="logo-nav-div" class="clearfix">
			<div id="logo-div">
				<img src="LOGO.png" alt="logo" width="60px" height="60px">
			</div>
			<div id="nav-div">
				<ul class="unorderlist">
					<li class="nav">
						<a href="#bodyarea-div">HOME</a>
					</li>
					<li class="nav">
						<a href="#">ABOUT</a>
					</li>
					<li class="nav">
						<a href="#about-div">SERVICES</a>
					</li>
					<li class="nav">
						<div class="select-container">
							<select id="login-type" class="select-box">
								<option value="default">LOGIN</option>
								<option value="form1">ADMIN LOGIN</option>
								<option value="form2">STUDENT LOGIN</option>
							</select>
						</div>


					</li>
					<li class="nav">
						<a href="register.jsp">REGISTRATION</a>
					</li>
					<li class="nav">
						<a href="#footer-div">CONTACTS</a>
					</li>

				</ul>

			</div>

		</div>
		

		<div id="bodyarea-div">
            <div id="header">
                <marquee> WELCOME TO A &nbsp; SWARNA KAMAKSHI HIGH SCHOOL</marquee>
            </div>
    
<div id="body"> Making lives better
<br>
    School is Cool
    <br>
    Aim for A Victory!
    <br>
    Charge Up for a Victory!
    <br>
    Knowledge – Learn to Love it</div>


		</div>
		<div id="about-div" class="clearfix">
            <div id="heading-services">
              <h1>SERVICES</h1>  
            </div>
		<div id="services">

            <img class="img" src="service1.jpg" alt="service1" height="400px" >
            <h3> HEALTHY CLASSROOMS</h3>
        </div>
        <div id="services" >
            <img class="img" src="service2.webp" alt="services" height="400px">
            <h3>PLAYGROUND</h3>
        </div>
        <div id="services">
            <img class="img" src="service3.jpg" alt="services" height="400px" >
            <h3>SCHOOL LIBRARY</h3>
        </div>
		</div>

		<div id="footer-div">
			<div id="footer-leftside-div">

				<divli class="contact"><u class="text1"> ADDRESS :&nbsp;</u>
					<br>
					<span>ALLINAGARAM,<br>
						PINCODE:521325,<br>
						VIJAYAWADA CITY,<br>
						ANDHRA PRADESH.

						<br>
					</span>
					<h4>
						<a class="location" href="https://maps.app.goo.gl/PWNcwzBbArmWQQ756">
							<img class="src" src="loc.png" alt="location" width="20" height="20">https:location//.??
						</a>
					</h4>
			</div>

			<div id="footer-rightside-div">
				<ul class="footer">

					<li class="cont"> <a class="image" href="https://www.facebook.com/manikantaravi.anagani.9">
							<img class="image" src="facebook.png" alt="facebook" width="30" height="30">
						</a></li>
					<li class="cont"> <a class="image" href="mailto:manikantaravi199@gmail.com">
							<img class="image" src="gmail.png" alt="facebook" width="30" height="30">
						</a></li>
					<li class="cont"> <a class="image" href="https://www.instagram.com/Mech_ravi2/">
							<img class="image" src="insta.png" alt="facebook" width="30" height="30">
						</a></li>
					<li class="cont"> <a class="image" href=" https://wa.me/7036896411/?">
							<img class="image" src="whatsapp.png" alt="facebook" width="30" height="30">
						</a></li>
					<li class="cont">
						<a class="image" href="tel:7036896411">
							<img class="image" src="call.png" alt="facebook" width="30" height="30">
						</a>
					</li>
				</ul>
			</div>
		</div>

	</div>


	<form action="./AdminloginServlet" method="post" id="form1" class="login-form">
		<span class="close-button" onclick="closeForm('form1')">&times;</span>
		<table>

			<tr>
				<th colspan="2">
					<h3><u> ADMIN LOGIN</u></h3>
				</th>
			</tr>
			<tr>
				<td>
					<h4>USERNAME:</h4>
				</td>
				<td> <input class="text" type="text" name="username"></td>
			</tr>

			<tr>
				<td>
					<h4>PASSWORD: </h4>
				</td>
				<td> <input class="text" type="password" name="password"></td>
			</tr>
			<tr>
				<td> <button class="button" type="submit" value="LOGIN">submit
					</button>

				</td>

				<td> <button class="button" type="reset" value="reset">reset
					</button>

				</td>
			</tr>


		</table>
	</form>




	<form action="./LoginServlet" method="post" id="form2" class="login-form">
		<span class="close-button" onclick="closeForm('form2')">&times;</span>
		<table>

			<tr>
				<th colspan="2">
					<h2><u> STUDENT LOGIN</u></h2>
				</th>
			</tr>
			<tr>
				<td>
					<h4>USERNAME:</h4>
				</td>
				<td> <input class="text" type="text" name="rollno"></td>
			</tr>

			<tr>
				<td>
					<h4>PASSWORD: </h4>
				</td>
				<td> <input class="text" type="password" name="password"></td>
			</tr>
			<tr>
				<td> <button class="button" type="submit">SUBMIT</button></td>

				<td> <button class="button" type="reset" value="RESET">RESET</button></td>
			</tr>


		</table>
	</form>
	<script>
		
		
		const loginTypeSelect = document.getElementById('login-type');
		const loginForms = document.querySelectorAll('.login-form');

		function closeForm(formId) {
			const form = document.getElementById(formId);
			if (form) {
				form.style.display = 'none';
			}
		}

		loginTypeSelect.addEventListener('change', (event) => {
			const selectedFormId = event.target.value;

			loginForms.forEach(form => {
				form.style.display = 'none';
			});

			if (selectedFormId !== 'default') {
				const selectedForm = document.getElementById(selectedFormId);
				if (selectedForm) {
					selectedForm.style.display = 'block';
				}
			}
		});
		alert("<%=alert%>")
	</script>
</body>

</html>