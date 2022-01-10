<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.* "%>
<!DOCTYPE html>
<html>
<head>
<%!String admin;%>
	<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	if (session.getAttribute("admin") == null) {
		response.sendRedirect("Login.html");
	} else {
		admin = session.getAttribute("admin").toString();
	}
	%>
<meta charset="ISO-8859-1">
<div id="bgBlur"></div>s
<title>Welcome <%=admin %></title>
<style>
*{
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial,Helvetica,sans-serif;	
}
a{
color: black;
}
#adminlab {
	font-size: 50px;
	position: absolute;
	left: 500px;
	color : orange;
}

#adminregus {
	text-decoration: none;
	font-size: 50px;
	position: absolute;
	top: 110px;
	border: 3px solid white;
	border-radius: 10px;
	background-color: rgba(255,255,255,0.5);
	border-color: white;
	left: 0px;
}

#adminuserdet {
	text-decoration: none;
	font-size: 50px;
	position: absolute;
	top: 210px;
	border: 3px solid white;
	border-radius: 10px;
	background-color: rgba(255,255,255,0.5);
	left: 0px;
}

#adminremuser {
	text-decoration: none;
	font-size: 50px;
	position: absolute;
	top: 300px;
	border: 3px solid white;
	border-radius: 10px;
	background-color: rgba(255,255,255,0.5);
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
	top: 20px;
	border-radius: 10px;
}

#removedusers {
	text-decoration: none;
	font-size: 50px;
	position: absolute;
	top: 380px;
	border: 3px solid white;
	border-radius: 10px;
	background-color: rgba(255,255,255,0.5);
	border-color: white;
	left: 0px;
}

#logindetails {
	text-decoration: none;
	font-size: 50px;
	position: absolute;
	top: 480px;
	border: 3px solid white;
	border-radius: 10px;
	background-color: rgba(255,255,255,0.5);
	border-color: white;
	left: 0px;
}
#timehead{
position : relative;
color : #F5DF4D;
top : -100px;
}
body{

background-image: url("https://techcrunch.com/wp-content/uploads/2018/09/GettyImages-465790437.jpg?w=430&h=230&crop=1");
background-repeat: no-repeat;
background-size: cover;
}
a:hover{
	box-shadow: 0 0 20px white;
	transition-duration: 0.2s;
	background-color: orange;
}
 #bgBlur{
	position: absolute;
	background-color: rgba(11, 11, 11, 0.6);
	height: 625px;
	width: 1366px;
}
</style>
</head>
<body bgcolor="blue">
<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	if (session.getAttribute("admin") != null) {
		String admin = session.getAttribute("admin").toString();
	} else {
		response.sendRedirect("index.jsp");
	}
	%>
	
	<label id="adminlab">welcome : <%=admin%></label>

	<a href="Register.jsp" id="adminregus">Register New User</a>
	<br>
	<br>

	<a href="Removeacc.jsp" id="adminremuser">Remove User</a>
	<br>
	<br>
	<a href="Userdetailsadmingetuser.jsp" id="adminuserdet">User
		Details</a>
	<a href="Logoutadmin.jsp" id="logoutatag">LogOut</a>
	<br>
	<a href="Removedusers.jsp" id="removedusers">Removed Users List</a>
	<br>
	<a href="Logindetails.jsp" id="logindetails">Login Details</a>
	<h1 id = "timehead">00:00</h1>
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