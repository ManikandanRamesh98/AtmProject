<%@page import="com.atm.impl.UserProfileimpl"%>
<%@page import="com.atm.models.Userprofilemodel"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Balance</title>
<style>
#headbal {
	position: absolute;
	left: 600px;
	font-size: 40px;
}

#headbal1 {
	font-size: 60px;
	position: absolute;
	top: 160px;
	left: 400px;
}

#hrbal {
	position: relative;
	top: 80px;
}

#ballab {
	color: yellow;
	position: relative;
	top: 160px;
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
</style>
</head>
<body bgcolor="blue">
	<%!String user;
	
	UserProfileimpl userProfiledao = new UserProfileimpl();
	%>

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
	<hr id="hrbal">
	<h1 id="headbal1">Your Balance :</h1>
	<br>
	<%
	Userprofilemodel userprofilepojo = new Userprofilemodel(user);
	%>
	<label id="ballab"><%=userProfiledao.getbal(userprofilepojo)%></label>
	<form action="Welcomepage.jsp">
		<button type="submit">Home</button>
	</form>
</body>
</html>