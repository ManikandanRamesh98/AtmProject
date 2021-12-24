<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Money Deposited!!</title>
<style>
h1{
font-size:50px;
color:yellow;
position : absolute;
top:200px;
left:220px;
}
</style>
</head>
<body bgcolor = "blue">
<%!String agent;%>
	<%
	if (session.getAttribute("agent") == null) {
		response.sendRedirect("Login.html");
	} else {
		agent = session.getAttribute("agent").toString();
	}
	%>
	<%
	long eamount = (long)session.getAttribute("agentdepamount");
	%>
	<h1>You Have Successfully Deposited <%= " " +eamount+ " " + agent%></h1>
</body>
</html>