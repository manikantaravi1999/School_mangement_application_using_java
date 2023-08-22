<!DOCTYPE html>
<%@page import="com.in.studentinformation.Student_personaldetails"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>UPDATE FORM</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-size: cover;
        }

        table {
            background-image: url(app.jpeg);
            border: 2px solid black;
            border-radius: 5px;
            background-color: aqua;
            box-shadow: 5px 5px gray;
            width: 40%;
            margin: 0 auto;
            margin-bottom: 50px;
            padding-bottom: 50px;
        }

        .logo {
            width: 120px;
            height: 120px;
            margin: 0 auto;
        }

        #logo-div-one {
            margin-bottom: 10px;
        }

        #logo-div-two {
            text-align: center;
            font-size: 25px;
            font-weight: bold;
            text-decoration: underline;
            margin-bottom: 15px;
        }

        .text {
            font-size: 15px;
            background: transparent;
            border: 1px solid black;
            border-radius: 5px;
            width: 240px;
            height: 30px;
            margin-right: 20px;
            padding-left: 10px;
            font-weight: lighter;
        }

        #tag {
            padding-left: 70px;
            font-size: 18px;
        }

        label.gender {
            font-size: 17px;
            padding-left: 5px;
            padding-right: 5px;
        }

        td {
            padding-top: 30px;
        }

        #submit {
            text-align: center;
            font-size: 20px;
        }

        .button1 {
            font-size: 12px;
            font-weight: bold;
            padding: 10px 10px;
            background-color: transparent;
            color: black;
            font-weight: bold;
            border: 3px solid black;
            border-radius: 5px;
            cursor: pointer;
            margin-left: 20px;
        }

        .button1:hover {
            background-color: grey;
            color: white;
            border: 3px solid white;
            border-radius: 5px;
        }

        span {
            color: red;
            font-size: 10px;
        }
    </style>
</head>
<body>

    <div id="container">
        <div id="div-form">
           <form action="./studentupdatedetails" method="post">
<%
Student_personaldetails student_personaldetails=(Student_personaldetails)request.getAttribute("student_personaldetails");
%>
                <table>
                    <tr>
                        <th class="head" colspan="2">
                            <div id="logo-div">
                                <div id="logo-div-one">
                                    <img class="logo" src="LOGO.png" alt="logo">
                                </div>
                                <div id="logo-div-two">	UPDATE FORM</div>
                            </div>
                        </th>
                    </tr>
                    <tr>
                        <td id="tag">FULL Name:*</td>
                        <td>
                            <input id="fullname" class="text" type="text" name="fullname" placeholder="Full name" value="<%=student_personaldetails.getFuLLNAME()%>">
                            <br>
                            <span id="error-message-firstname"></span>
                        </td>
                    </tr>
                    <tr>
                        <td id="tag">CLASS:*</td>
                        <td>
                            <input id="class" class="text" type="number" name="class" placeholder="1 -10" value="<%= student_personaldetails.getCLASS()%>">
                            <br>
                            <span id="error-message-lastname"></span>
                        </td>
                    </tr>
                    <tr>
                        <td id="tag">Roll NO:*</td>
                        <td>
                            <input id="rollno" class="text" type="number" name="rollno" placeholder="Username or roll number" value="<%=student_personaldetails.getROLLNO()%>" readonly>
                            <br>
                            <span id="error-message-rollno"></span>
                        </td>
                    </tr>
                    <tr>
                        <td id="tag"> Password:*</td>
                        <td>
                            <input id="password" class="text" type="password" name="password" placeholder="Create password" value="<%=student_personaldetails.getPASSWORD()%>">
                            <br>
                            <span id="error-message-password"></span>
                        </td>
                    </tr>
                    
                    <tr>
                        <td id="tag">Date Of Birth:*</td>
                        <td>
                            <input id="dateofbirth" class="text" type="date" name="dob" placeholder="DD/MM/YYYY" value="<%=student_personaldetails.getDOB()%>">
                            <br>
                            <span id="error-message-dateofbirth"></span>
                        </td>
                    </tr>
                    <tr>
                        <td id="tag">Gender:</td>
                        <td>
                            <input type="radio"  name="gender" value="MALE"<%=student_personaldetails.getGENDER().equals("MALE")? "checked":""%>>
                            <label class="gender">Male</label>
                            <input type="radio" name="gender" value="FEMALE"<%=student_personaldetails.getGENDER().equals("FEMALE")? "checked":""%>>
                            <label class="gender">Female</label>
                        </td>
                    </tr>
                    <tr>
                        <td id="tag">Email:*</td>
                        <td>
                            <input id="email" class="text" type="text" name="email" placeholder="Email" value="<%=student_personaldetails.getEMAIL()%>">
                            <br>
                            <span id="error-message-email"></span>
                        </td>
                    </tr>
                    <tr>
                        <td id="tag">Mobile Number:*</td>
                        <td>
                            <input id="number" class="text" type="number" name="mobile" placeholder="Mobile number" value="<%=student_personaldetails.getMOBILE()%>">
                            <br>
                            <span id="error-message-number"></span>
                        </td>
                    </tr>
                    <tr>
                        <td id="tag">Address (optional):</td>
                        <td>
                            <input id="address" class="text" type="text" name="address" placeholder="Address" value="<%=student_personaldetails.getADDRESS()%>">
                        </td>
                    </tr>
                    <tr>
                        <td id="submit" colspan="2">
                            <input id="button" class="button1" type="submit" value="UPDATE">
                            <input id="button1" class="button1" type="reset" value="RESET">
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>

    <script>
        const form = document.getElementById("myform");
        const Inputfullname = document.getElementById("fullname");
        const Inputclass = document.getElementById('class');
        const Inputrollno = document.getElementById('rollno');
        const Inputpassword = document.getElementById('password');
        const InputconfirmPassword = document.getElementById('confirmpassword');
        const Inputdateofbirth = document.getElementById('dateofbirth');
        const Inputemail = document.getElementById('email');
        const Inputnumber = document.getElementById('number');

        form.addEventListener("submit", function (event) {
            if (!validateFullname() || !validateClass() || !validateRollno() || 
                !validatePassword() || !validateConfirmpassword() || !validateDateOfBirth() || 
                !validateEmail() || !validateNumber()) {
                event.preventDefault();
                alert('please fill required details');
            }
        });

        Inputfullname.addEventListener("input", validateFullname);
        Inputclass.addEventListener('input', validateClass);
        Inputrollno.addEventListener('input', validateRollno);
        Inputpassword.addEventListener('input', validatePassword);
        InputconfirmPassword.addEventListener('input', validateConfirmpassword);
        Inputdateofbirth.addEventListener('input', validateDateOfBirth);
        Inputemail.addEventListener('input', validateEmail);
        Inputnumber.addEventListener('input', validateNumber);

        function validateFullname() {
            const errorfirstname = document.getElementById("error-message-firstname");
            if (Inputfullname.value.trim().length < 2) {
                errorfirstname.textContent = '** PLEASE ENTER FIRSTNAME';
                return false;
            } else {
                errorfirstname.textContent = '';
                return true;
            }
        }

        function validateClass() {
            const errorLastname = document.getElementById("error-message-lastname");
            if (Inputclass.value.trim().length<1 || Inputclass.value.trim().length>2) {
                errorLastname.textContent = '**please enter valid class';
                return false;
            } else {
                errorLastname.textContent = '';
                return true;
            }
        }

        function validateRollno() {
            const errorrollno = document.getElementById("error-message-rollno");
            if (Inputrollno.value.trim().length !== 10) {
                errorrollno.textContent = '** ROLLNO MUST BE 10 DIGITS';
                return false;
            } else {
                errorrollno.textContent = '';
                return true;
            }
        }

        function validatePassword() {
            const errorpassword = document.getElementById("error-message-password");
            if (Inputpassword.value.trim().length!==8) {
                errorpassword.textContent = '** PASSWORD MUST BE 8 CHARACTERS';
                return false;
            } else {
                errorpassword.textContent = '';
                return true;
            }
        }

        function validateConfirmpassword() {
            const errorconfirmpassword = document.getElementById("error-message-confirmpassword");
            if (Inputpassword.value !== InputconfirmPassword.value) {
                errorconfirmpassword.textContent = '** PASSWORDS DO NOT MATCH';
                return false;
            } else {
                errorconfirmpassword.textContent = '';
                return true;
            }
        }

        function validateDateOfBirth() {
            const dateofbirtherror = document.getElementById('error-message-dateofbirth');
            const selectDate = new Date(Inputdateofbirth.value);
            const currentDate = new Date();

            if (isNaN(selectDate.getDate())||((selectDate > currentDate)) ){
                dateofbirtherror.textContent = 'Invalid Date of Birth';
                return false;
            } else {
                dateofbirtherror.textContent = '';
                return true;
            }
        }

        function validateEmail() {
            const emailError = document.getElementById("error-message-email");
            const emailPattern = /^[A-Za-z\._\-0-9]*[@][A-Za-z]*[\.][a-z]{2,4}$/;
            if (!emailPattern.test(Inputemail.value)) {
                emailError.textContent = '** INVALID EMAIL';
                return false;
            } else {
                emailError.textContent = '';
                return true;
            }
        }

        function validateNumber() {
            const errornumber = document.getElementById("error-message-number");
            if (Inputnumber.value.trim().length !== 10) {
                errornumber.textContent = '** INVALID MOBILE NUMBER';
                return false;
            } else {
                errornumber.textContent = '';
                return true;
            }
        }
    </script>
</body>
</html>
