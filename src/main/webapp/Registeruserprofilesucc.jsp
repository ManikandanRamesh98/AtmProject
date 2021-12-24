<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registered Successfully!!</title>
<style>
#reghead{
color : yellow;
position : absolute;
top : 200px;
left : 130px;
font-size : 60px;
}

</style>
</head>
<body bgcolor = "blue">
	<%
	if (session.getAttribute("admin") != null) {
		String admin = session.getAttribute("admin").toString();
	} else {
		response.sendRedirect("Login.html");
	}
	%>
	<%!String reguser;%>
	<%
	reguser = session.getAttribute("reguser").toString();
	%>
	<h1 id = "reghead">
		User
		<%=" " + reguser + " "%>Registered Successfully!!
	</h1>
</body>
</html>