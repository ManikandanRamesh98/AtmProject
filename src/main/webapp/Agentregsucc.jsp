<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agent registered sucessfully</title>
</head>
<body>
<%!String agent;
	String reguser;%>
	<%
	if (session.getAttribute("agent") != null) {
		agent = session.getAttribute("agent").toString();
	} else {
		response.sendRedirect("Login.html");
	}
	reguser = session.getAttribute("agentreg").toString();
	%>
	<h1>
		Agent
		<%=" " + reguser + " "%>
		Sucessfully Registered!!
	</h1>
</body>
</html>