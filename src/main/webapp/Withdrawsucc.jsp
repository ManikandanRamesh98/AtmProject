<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Withdraw Success</title>
<style>
#withsucclab {
	font-size: 50px;
	position: absolute;
	top: 180px;
	left: 260px;
}

#succhead {
	font-size: 60px;
	color: yellow;
	position: absolute;
	top: 300px;
	left: 400px;
}
</style>
</head>
<body bgcolor="blue">
	<%!String user;%>

	<%
	if (session.getAttribute("user") == null) {
		response.sendRedirect("Login.html");
	} else {
		user = session.getAttribute("user").toString();
	}
	%>
	<%
	int succamount = (int) session.getAttribute("withamount");
	int succbal = (int) session.getAttribute("withbal");
	%>
	<label id="withsucclab">You have successfully withdrawed amount
		<%=succamount%></label>
	<h1 id="succhead">
		BALANCE:<%=succbal%></h1>
	
</body>
</html>