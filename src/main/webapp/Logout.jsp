<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LogOut</title>
</head>
<body>
	<%!String user;%>

	<%
	if (session.getAttribute("user") == null) {
		response.sendRedirect("index.jsp");
	} else {
		user = session.getAttribute("user").toString();
	}
	%>
	<%
	session.invalidate();
	response.sendRedirect("index.jsp");
	%>
</body>
</html>