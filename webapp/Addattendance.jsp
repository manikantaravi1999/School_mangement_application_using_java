
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD Attendance</title>
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
        <form action="./Addattendance" method="post" id="myform">
            <table>
                <tr>
                    <tr>
                        <th class="head" colspan="2">
                            <div id="logo-div">
                                <div id="logo-div-one">
                                    <img class="logo" src="LOGO.png" alt="logo">
                                </div>
                                <div id="logo-div-two">	ADD ATTENDANCE</div>
                            </div>
                        </th>
                    </tr>
                </tr>
                
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
                        <h4>JUNE: </h4>
                    </td>
                    <td>
                        <input id="june" class="text" type="number" name="jun" placeholder="00"><br>
                        <span id="error-june"></span>
                    </td>
                </tr>
                <tr>
                    <td>
                        <h4>JULY: </h4>
                    </td>
                    <td>
                        <input id="july" class="text" type="number" name="jul" placeholder="00"><br>
                          <span id="error-july"></span>
                    </td>
                </tr>
                <tr>
                
                <td>
                    <h4>AUGUST: </h4>
                </td>
                <td><input id="august" class="text" type="number" name="aug" placeholder="00"><br>
                    <span id="error-august"></span>
                </td>
                </tr>
                <tr>
                    <td>
                        <h4>SEPTEMBER: </h4>
                    </td>
    
                    <td>
                         <input id="september" class="text" type="number"  name="sep" placeholder="00" ><br>
                         <span id="error-september"></span>
    
                    </td>
                </tr>
                <tr>
                    <td>
                        <h4>OCTOBER:</h4>
                    </td>
                    <td>
                        <input id="october" class="text" type="number" name="oct" placeholder="00" ><br>
                        <span id="error-october"></span>
                    </td>
                </tr>
                <tr>
                    <td>
                        <h4>NOVEMBER:</h4>
                    </td>
                    <td>
                        <input id="november" class="text" type="number" name="nov" placeholder="00"><br>
                        <span id="error-november"></span>
                    </td>
                </tr>
                <tr>
                    <td>
                        <h4>DECEMBER:</h4>
                    </td>
                    <td>
                        <input id="december" class="text" type="number" name="dec" placeholder="00"><br>
                        <span id="error-december"></span>
                    </td>
                </tr>
                <tr>
                    <td>
                        <h4>JANUARY:</h4>
                    </td>
                    <td>
                        <input id="january" class="text" type="number" name="jan" placeholder="00"><br>
                        <span id="error-january"></span>
                    </td>
                </tr>
                <tr>
                    <td>
                        <h4>FEBRUARY:</h4>
                    </td>
                    <td>
                        <input id="february" class="text" type="number" name="feb" placeholder="00"><br>
                        <span id="error-february"></span>
                    </td>
                </tr>
                <tr>
                    <td>
                        <h4>MARCH:</h4>
                    </td>
                    <td>
                        <input id="march" class="text" type="number" name="mar" placeholder="00"><br>
                        <span id="error-march"></span>
                    </td>
                </tr>
                <tr>
                    <td>
                        <h4>APRIL:</h4>
                    </td>
                    <td>
                        <input id="april" class="text" type="number" name="apr" placeholder="00"><br>
                        <span id="error-april"></span>
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
        const Inputjune = document.getElementById('june');
        const Inputjuly = document.getElementById('july');
        const Inputaugust = document.getElementById('august');
        const Inputseptember = document.getElementById('september');
        const Inputoctober= document.getElementById('october');
        const Inputnovember = document.getElementById('november');
        const Inputdecember = document.getElementById('december');
        const Inputjanuary = document.getElementById('january');
        const Inputfebruary= document.getElementById('february');
        const Inputmarch = document.getElementById('march');
        const Inputapril= document.getElementById('april');

        form.addEventListener("submit", function (event) {
            if (!validateRollno() || !validatejune() || !validatejuly() || 
                !validateaugust() || !validateseptember() || !validateoctober() || 
                !validatenovember() || !validatedecember() || !validatejanuary() || !validatefebruary() || !validatemarch() || !validateapril() ){
                event.preventDefault();
                alert('please fill required details');
            }
        });

        Inputrollno.addEventListener("input", validateRollno);
        Inputjune.addEventListener('input', validatejune);
        Inputjuly.addEventListener('input', validatejuly);
        Inputaugust.addEventListener('input', validateaugust);
        Inputseptember.addEventListener('input', validateseptember);
        Inputoctober.addEventListener('input', validateoctober);
        Inputnovember.addEventListener('input', validatenovember);
        Inputdecember.addEventListener('input', validatedecember);
        Inputjanuary.addEventListener('input', validatejanuary);
        Inputfebruary.addEventListener('input', validatefebruary);
        Inputmarch.addEventListener('input', validatemarch);
        Inputapril.addEventListener('input', validateapril);
        
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
        function validatejune() {
            const errorjune = document.getElementById("error-june");
            if (Inputjune.value.trim().length<1 || Inputjune.value.trim().length>2) {
                errorjune.textContent =  '** INVALID RECORD';
                return false;
            }   errorjune.textContent = '';
                return true;
            }
        function validatejuly() {
            const errorjuly = document.getElementById("error-july");
            if (Inputjuly.value.trim().length<1 || Inputjuly.value.trim().length>2) {
                errorjuly.textContent =  '** INVALID RECORD';
                return false;
            }   errorjuly.textContent = '';
                return true;
            }
        

        function validateaugust() {
            const erroraugust = document.getElementById("error-august");
            if (Inputaugust.value.trim().length<1 || Inputaugust.value.trim().length>2) {
                erroraugust.textContent =  '** INVALID RECORD';
                return false;
            } else {
                erroraugust.textContent = '';
                return true;
            }
        }

       
        function validateseptember() {
            const errorseptember = document.getElementById("error-september");
            if (Inputseptember.value.trim().length<1 || Inputseptember.value.trim().length>2) {
                errorseptember.textContent = '** INVALID RECORD';
                return false;
            } else {
                errorseptember.textContent = '';
                return true;
            }
        }
        function validateoctober() {
            const erroroctober = document.getElementById("error-october");
            if (Inputoctober.value.trim().length<1 || Inputoctober.value.trim().length>2) {
                erroroctober.textContent =  '** INVALID RECORD';
                return false;
            }   erroroctober.textContent = '';
                return true;
            }
            function validatenovember() {
            const errornovember = document.getElementById("error-november");
            if (Inputnovember.value.trim().length<1 || Inputnovember.value.trim().length>2){
                errornovember.textContent = '** INVALID RECORD';
                return false;
            } else {
                errornovember.textContent = '';
                return true;
            }
        }

        function validatedecember() {
            const errordecember= document.getElementById("error-december");
            if (Inputdecember.value.trim().length<1 || Inputdecember.value.trim().length>2){
                errordecember.textContent = '** INVALID RECORD';
                return false;
            } else {
                errordecember.textContent = '';
                return true;
            }
        }
        function validatejanuary() {
            const errorjanuary = document.getElementById("error-january");
            if (Inputjanuary.value.trim().length<1 || Inputjanuary.value.trim().length>2 ){
                errorjanuary.textContent = '** INVALID RECORD';
                return false;
            } else {
                errorjanuary.textContent = '';
                return true;
            }
        }
      
        function validatefebruary() {
            const errorfebruary = document.getElementById("error-february");
            if (Inputfebruary.value.trim().length<1 || Inputfebruary.value.trim().length>2) {
                errorfebruary.textContent =  '** INVALID RECORD';
                return false;
            }   errorfebruary.textContent = '';
                return true;
            }
        function validatemarch() {
            const errormarch = document.getElementById("error-march");
           
            if( Inputmarch.value.trim().length<1 || Inputmarch.value.trim().length>2) {
                errormarch.textContent = '** INVALID RECORD';
                return false;
            } else {
                errormarch.textContent = '';
                return true;
            }
        }
        function validateapril() {
            const errorapril = document.getElementById("error-april");
            if (Inputapril.value.trim().length<1 || Inputapril.value.trim().length>2) {
                errorapril.textContent =  '** INVALID RECORD';
                return false;
            }   errorapril.textContent = '';
                return true;
            }

        
    </script>
</body>
</html>