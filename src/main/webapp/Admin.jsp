<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.* "%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
#adminlab {
	font-size: 50px;
	position: absolute;
	left: 500px;
}

#adminregus {
	text-decoration: none;
	font-size: 50px;
	position: absolute;
	top: 110px;
	border: 3px solid white;
	border-radius: 10px;
	background-color: yellow;
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
	background-color: yellow;
	left: 0px;
}

#adminremuser {
	text-decoration: none;
	font-size: 50px;
	position: absolute;
	top: 300px;
	border: 3px solid white;
	border-radius: 10px;
	background-color: yellow;
	border-color: white;
	left: 0px;
}

#logoutatag {
	text-decoration: none;
	font-size: 50px;
	position: absolute;
	background-color: red;
	border-color: white;
	right: 0px;
	top: 0px;
	border-radius: 10px;
}

#removedusers {
	text-decoration: none;
	font-size: 50px;
	position: absolute;
	top: 380px;
	border: 3px solid white;
	border-radius: 10px;
	background-color: yellow;
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
	background-color: yellow;
	border-color: white;
	left: 0px;
}
#timehead{
position : relative;
color : black;
top : -100px;
}
</style>
</head>
<body bgcolor="blue">
	<%!String admin;%>
	<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	if (session.getAttribute("admin") == null) {
		response.sendRedirect("Login.html");
	} else {
		admin = session.getAttribute("admin").toString();
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
let time = 30;
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
			window.location.assign("Login.html");
		}
	},1000);
	
});



</script>

</html>