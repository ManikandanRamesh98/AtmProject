<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Register</title>
</head>
<body>
	<%!String user;
	String reguser;%>
	<%
	if (session.getAttribute("admin") != null) {
		user = session.getAttribute("admin").toString();
	} else {
		response.sendRedirect("Login.html");
	}
	reguser = session.getAttribute("adminreg").toString();
	%>
	<h1>
		Admin
		<%=" " + reguser + " "%>
		Sucessfully Registered!!
	</h1>
</body>
</html>