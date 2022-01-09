<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
</head>
<body>
	<%!String admin;%>

	<%
	if (session.getAttribute("admin") == null) {
		response.sendRedirect("Login.html");
	} else {
		admin = session.getAttribute("admin").toString();
	}
	%>
	<%
	session.invalidate();
	response.sendRedirect("Login.html");
	%>
</body>
</html>