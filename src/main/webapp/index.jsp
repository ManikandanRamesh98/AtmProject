<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel = "icon" type = "" href = "Assets/sbi-logo-33234.png">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<div id="bgBlur"></div>
<title>State Bank Of India</title>
<link rel="stylesheet" href="Bank.css">
<style>
*{
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial,Helvetica,sans-serif;	
}
legend{
position: relative;
left : 160px;
top:-50px;
}
label {
	font-size: 20px;
	position : absolute;
	top : 10px;
	padding : 20px;
}
#passlab{
position : absolute;
top : 120px;
}

#user
{
position: absolute;
top:70px;
right:100px;
}
#pass{
position: absolute;
top:180px;
right:100px;
}

fieldset {
	position: absolute;
	top: 110px;
	right:20px;
	width: 500px;
	height: 360px;
	border-color: black;
	border: none;
}
input{
width:350px;
height:40px;
border-radius: 5px;
background-color: black;
color: white;
font-size: 30px;

}

#sub{
position : absolute;
top: 260px;
left:80px;
width:140px;
height:40px;
border-radius: 5px;
}
#sub:hover{

color:white;
}

#res{
position : absolute;
top: 260px;
left:280px;
width:140px;
height:40px;
border-radius: 5px;
}
#res:hover{

color:white;
}
marquee {
	position :absolute;
	bottom: 0px;
	font-size: 20px;
	opacity: 0.9;
}
body{
	background-image:url("https://scontent.fmaa12-2.fna.fbcdn.net/v/t31.18172-8/22051279_1623705757680216_2725610580980024577_o.jpg?_nc_cat=111&ccb=1-5&_nc_sid=9267fe&_nc_ohc=rQNE9RPtZRwAX-mhcc2&_nc_ht=scontent.fmaa12-2.fna&oh=00_AT8DZmZcWuSx5EuS6yKVIyni07maX40Fdj558GuUd-6Ayg&oe=61FBF9C7");
	background-repeat: no-repeat;
	background-size: 100%;
	overflow-x:hidden; 
}
#logintxt{
width:700px;
font-size: 30px;
position: absolute;
top :170px;
text-align:justify;

}
.form-control
{
  width:330px;
}
body{
color:white;
}
#logger
{
font-size:30px;
  
}
h3{
font-size:25px;
position : absolute;
top: 40px;
color:white;
font-weight: bolder;
opacity: 0.7;
}
#bgBlur{
	position: absolute;
	background-color: rgba(11, 11, 11, 0.3);
	height: 625px;
	width: 1366px;
} 
button:hover{
	box-shadow: 0 0 20px blue;
	transition-duration: 0.2s;
}


</style>
</head>
<body >
<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate"); %>
<div class="fullbody">
<div class="one">
	<fieldset>
		<legend id="logger" class="form-label">LOGIN</legend>
		
		<form action="loginval" id="formlogin" autocomplete="off" method="post" class = "was-validated">

			<label id="userlab" class="form-label">User Name:</label><br> <input type="text"
				name="username" class="form-control" required id="user" pattern="[A-Z][a-zA-Z]{3,20}"
				title="Start with A-Z and use A-Z or a-z or 0-9 minimum 3 character maximum 20 character" autofocus><br>
			<label id="passlab" class="form-label">Password:</label><br> <input type="password"
				name="password" required id="pass" class="form-control"
				pattern="[A-Za-z0-9!@#$%^&*_+=-~`/|\]{6,20}" minlength="6"
				title="minimum 6 character and special characters allowed"><br>
			<button id="sub" type="submit" class="btn btn-success">Submit</button>
			&ensp;&ensp;
			<button type="reset" id="res" class="btn btn-danger">Reset</button>
		</form>
	</fieldset>
	</div>
	
<marquee scrollamount="10">For Security Reason kindly change your Password in a circle of 180 days,Contact 18000189786 for help,Stay home and stay safe,Avoid visiting Bank in Pandemic situation,Bank never ask otp/card details be aware of Fraud Calls!!,please dont click any Anonymus link in the name of STATE BANK.</marquee>
<div id = "logintxt">
<h3>Be aware of fraudulent emails offering free gifts and rewards. Scammers send these emails to extract money from your account via your personal details. Do not share your bank details with anyone. SBI never asks for your UPI PIN or Card Details.</h3>
</div>
</div>
</body>
<script type="text/javascript">


</script>


</html>