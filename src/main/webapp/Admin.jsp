<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.atm.controller.* "%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="" href="Assets/sbi-logo-33234.png">
<%!String admin;%>
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
if (session.getAttribute("admin") == null) {
	response.sendRedirect("index.jsp");
} else {
	admin = session.getAttribute("admin").toString();
}
%>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<div id="bgBlur"></div>
s
<title>Welcome <%=admin%></title>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial, Helvetica, sans-serif;
}

a {
	color: black;
}

body {
	overflow-x: hidden;
}

#adminlab {
	font-size: 50px;
	position: absolute;
	left: 500px;
	color: #FF8C00;
}

#adminregus {
	text-decoration: none;
	font-size: 50px;
	position: absolute;
	top: 110px;
	border-radius: 5px;
	background-color: rgba(255, 255, 255, 0.5);
	border-color: white;
	left: 0px;
}

#adminuserdet {
	text-decoration: none;
	font-size: 50px;
	position: absolute;
	top: 280px;
	border-radius: 5px;
	background-color: rgba(255, 255, 255, 0.5);
	left: 0px;
}

#adminremuser {
	text-decoration: none;
	font-size: 50px;
	position: absolute;
	top: 480px;
	border-radius: 5px;
	background-color: rgba(255, 255, 255, 0.5);
	border-color: white;
	left: 0px;
}

#logoutatag {
	text-decoration: none;
	font-size: 50px;
	position: absolute;
	background-color: #CD212A;
	border-color: black;
	right: 0px;
	top: 40px;
	border-radius: 10px;
}

#removedusers {
	text-decoration: none;
	font-size: 50px;
	position: absolute;
	top: 280px;
	border-radius: 5px;
	background-color: rgba(255, 255, 255, 0.5);
	border-color: white;
	right: 0px;
}

#logindetails {
	text-decoration: none;
	font-size: 50px;
	position: absolute;
	top: 480px;
	border-radius: 5px;
	background-color: rgba(255, 255, 255, 0.5);
	border-color: white;
	right: 0px;
}

#timehead {
	position: relative;
	color: #F5DF4D;
	top: -100px;
}

body {
	background-image:
		url("https://techcrunch.com/wp-content/uploads/2018/09/GettyImages-465790437.jpg?w=430&h=230&crop=1");
	background-repeat: no-repeat;
	background-size: cover;
}

#bgBlur {
	position: absolute;
	background-color: rgba(11, 11, 11, 0.6);
	height: 625px;
	width: 1366px;
}

a {
	display: inline-block;
	box-sizing: border-box;
	cursor: pointer;
	transition: transform 0.7s;
}

a:hover {
	transform: translateX(10px);
	box-shadow: 0 0 20px white;
	transition-duration: 0.2s;
	background-color: orange;
}

.left:hover {
	transform: translateX(-10px);
	box-shadow: 0 0 20px white;
	transition-duration: 0.2s;
	background-color: orange;
}
</style>
</head>
<body bgcolor="blue">


	<label id="adminlab">welcome : <%=admin%></label>

	<a href="Register.jsp" id="adminregus">Register New User</a>
	<br>
	<br>

	<a href="Removeacc.jsp" id="adminremuser">Remove User</a>
	<br>
	<br>
	<a href="Userdetailsadmingetuser.jsp" id="adminuserdet">User
		Details</a>
	<a href="Logoutadmin.jsp" id="logoutatag" class="btn btn-danger"
		class="left">LogOut</a>
	<br>
	<a href="Removedusers.jsp" id="removedusers" class="left">Removed
		Users List</a>
	<br>
	<a href="Logindetails.jsp" id="logindetails" class="left">Login
		Details</a>
	<h1 id="timehead">00:00</h1>
</body>

<script>
let th = document.getElementById("timehead");
let time = 100;
let i;
window.addEventListener('load', () =>{
	
	 i= setInterval(() => {
		if(time > 0){
			if(time >= 10){
				
		th.innerHTML = "00 : " + time--;
		
			}else{
				th.style.color = "red";
				th.innerHTML = "00 : 0" + time--;
			}
		}else{
			clearInterval(i);
			window.location.assign("index.jsp");
		}
	},1000);
	
});



</script>

</html>