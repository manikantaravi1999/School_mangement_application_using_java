
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Marks</title>
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
#main-div{
    margin-top: 50px;
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
        table {

            background-image: url(app.jpeg);
            border: 2px solid black;
            border-radius: 5px;
            background-color: aqua;
            box-shadow: 5px 5px gray;
            width: 40%;
            margin: 0 auto;
            margin-bottom: 30px;
            padding-bottom: 50px;
            text-align: center;
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
th{

    height:50px;
    font-size: 25px;
    text-decoration: underline;
}
td{
    height: 30px;
}
td {
            padding-top: 30px;
        }

        #submit {
            text-align: center;
            font-size: 20px;
        }

        .button1 {
            width: 100px;
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
    <div id="main-div">
	<form action="./Addmarks" method="post" id="myform">
		<table >
		    
                    <tr>
                        <th class="head" colspan="2">
                            <div id="logo-div">
                                <div id="logo-div-one">
                                    <img class="logo" src="LOGO.png" alt="logo">
                                </div>
                                <div id="logo-div-two">	ADD MARKS</div>
                            </div>
                        </th>
                    </tr>
                </tr>
		
			<tr>
				<td>
					<h4>ROLL NO: </h4>
				</td>
				<td>
					<input id="rollno" class="text" type="number" name="rollno" placeholder="Rollno" ><br>
					<span id="error-rollno"></span>
				</td>
			</tr>
			<tr>
				<td>
					<h4>TELUGU: </h4>
				</td>
				<td>
					<input id="telugu" class="text" type="number" name="telugu" placeholder="00"><br>
				<span id="error-telugu"></span>
				</td>
			</tr>
			<tr>
				<td>
					<h4>ENGLISH: </h4>
				</td>
				<td>
					<input id="english"  class="text" type="number" name="english" placeholder="00"><br>
				<span id="error-english"></span>
				</td>
			</tr>
			<tr>
			
			<td>
				<h4>HINDI: </h4>
			</td>
			<td><input id="hindi" class="text" type="number" name="hindi" placeholder="00"><br>
			<span id="error-hindi"></span>
			</td>
			</tr>
			<tr>
				<td>
					<h4>MATHS: </h4>
				</td>

				<td>
					 <input id="maths" class="text" type="number"  name="maths" placeholder="00" ><br>
<span id="error-maths"></span>
				</td>
			</tr>
			<tr>
				<td>
					<h4>SCIENCE:</h4>
				</td>
				<td>
					<input id="science" class="text" type="number" name="science" placeholder="00" ><br>
				<span id="error-science"></span>
				</td>
			</tr>
			<tr>
				<td>
					<h4>SOCIAL:</h4>
				</td>
				<td>
					<input id="social" class="text" type="number" name="social" placeholder="00"><br>
				<span id="error-social"></span>
				</td>
			</tr>
			<tr>
				<td colspan="2" id="submit">
					<input class="button1" type="submit" value="ADD">
				
				
					<input class="button1" type="reset" value="RESET">
				</td>
			</tr>
		</table>

		</from>
    </div>
		   <script>
        const form = document.getElementById("myform");
        const Inputrollno = document.getElementById("rollno");
        const Inputtelugu = document.getElementById('telugu');
        const Inputenglish = document.getElementById('english');
        const Inputhindi = document.getElementById('hindi');
        const Inputmaths = document.getElementById('maths');
        const Inputscience= document.getElementById('science');
        const Inputsocial = document.getElementById('social');
       

        form.addEventListener("submit", function (event) {
            if (!validateRollno() || !validatetelugu() || !validateenglish() || 
                !validatemaths() || !validatescience() || !validatehindi() || 
                !validatesocial() ){
                event.preventDefault();
                alert('please fill required details');
            }
        });

        Inputrollno.addEventListener("input", validateRollno);
        Inputtelugu.addEventListener('input', validatetelugu);
        Inputenglish.addEventListener('input', validateenglish);
        Inputhindi.addEventListener('input', validatehindi);
        Inputmaths.addEventListener('input', validatemaths);
        Inputscience.addEventListener('input', validatescience);
        Inputsocial.addEventListener('input', validatesocial);
        
        function validateRollno() {
            const errorrollno = document.getElementById("error-rollno");
            if (Inputrollno.value.trim().length !== 10) {
                errorrollno.textContent = '** ROLLNO MUST BE 10 DIGITS';
                return false;
            } else {
                errorrollno.textContent = '';
                return true;
            }
        }

        function validatetelugu() {
            const errortelugu = document.getElementById("error-telugu");
            if (Inputtelugu.value.trim().length<1 || Inputtelugu.value.trim().length>2) {
                errortelugu.textContent =  '** INVALID MARKS';
                return false;
            }   errortelugu.textContent = '';
                return true;
            }
        

        function validateenglish() {
            const errorenglish = document.getElementById("error-english");
            if (Inputenglish.value.trim().length<1 || Inputenglish.value.trim().length>2) {
                errorenglish.textContent =  '** INVALID MARKS';
                return false;
            } else {
                errorenglish.textContent = '';
                return true;
            }
        }

       
        function validatehindi() {
            const errorhindi = document.getElementById("error-hindi");
            if (Inputhindi.value.trim().length<1 || Inputhindi.value.trim().length>2) {
                errorhindi.textContent = '** INVALID MARKS';
                return false;
            } else {
                errorhindi.textContent = '';
                return true;
            }
        }

        function validatemaths() {
            const errormaths = document.getElementById("error-maths");
            if (Inputmaths.value.trim().length<1 || Inputmaths.value.trim().length>2){
                errormaths.textContent = '** INVALID MARKS';
                return false;
            } else {
                errormaths.textContent = '';
                return true;
            }
        }
        function validatescience() {
            const errorscience = document.getElementById("error-science");
            if (Inputscience.value.trim().length<1 || Inputscience.value.trim().length>2 ){
                errorscience.textContent = '** INVALID MARKS';
                return false;
            } else {
                errorscience.textContent = '';
                return true;
            }
        }
      

        function validatesocial() {
            const errorsocial = document.getElementById("error-social");
           
            if( Inputsocial.value.trim().length<1 || Inputsocial.value.trim().length>2) {
                errorsocial.textContent = '** INVALID MARKA';
                return false;
            } else {
                errorsocial.textContent = '';
                return true;
            }
        }

        
    </script>
</body>
</html>