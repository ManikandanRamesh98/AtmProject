<%@page import="com.atm.daoimpl.UserProfileImpl"%>
<%@page import="com.atm.models.UserProfileModel"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Balance</title>
<style>
#headbal {
	position: absolute;
	left: 480px;
	font-size: 50px;
}

#headbal1 {
	font-size: 80px;
	position: absolute;
	top: 280px;
	left: 280px;
}

#hrbal {
	position: relative;
	top: 180px;
}

#ballab {
	color: yellow;
	position: relative;
	top: 320px;
	left: 850px;
	font-size: 70px;
}

button {
	position: relative;
	background-color: red;
	height: 50px;
	width: 140px;
	float: right;
	top: -100px;
	border-radius: 10px;
}
#timehead{
position : absolute;
top:0px;
}
</style>
</head>
<body bgcolor="blue">
	<%!String user;
	
	UserProfileImpl userProfiledao = new UserProfileImpl();%>

	<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		if (session.getAttribute("user") == null) {
			response.sendRedirect("Login.html");
		} else {
			user = session.getAttribute("user").toString();
		}
	%>
	<h1 id="headbal">
		Welcome&ensp;
		<%=user%></h1>
	
	<h1 id="headbal1">Your Balance :</h1>
	<br>
	<%
	UserProfileModel userprofilepojo = new UserProfileModel(user);
	%>
	<label id="ballab"><%=userProfiledao.getbal(userprofilepojo)%></label>
	<form action="Welcomepage.jsp">
		<button type="submit">Home</button>
	</form>
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
			window.location.assign("Logout.jsp");
		}
	},1000);
	
});


</script>
</html>