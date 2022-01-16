<%@page import="com.atm.daoimpl.AtmMoneyManagementImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "java.sql.*" import = "com.atm.controller.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel = "icon" type = "" href = "Assets/sbi-logo-33234.png">
<meta charset="ISO-8859-1">
<title>Agent History</title>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 20px;
}
td{
font-size:30px;
}
th{
color:#F5DF4D;
font-size:30px;
}
body{
background-color: #0072B5;
}
</style>
</head>
<body>
<%!String agent;%>
	<%
	if (session.getAttribute("agent") == null) {
			response.sendRedirect("Login.html");
		} else {
			agent = session.getAttribute("agent").toString();
		}
	%>
	<body bgcolor="blue">
	<%!ResultSet rs;%>
	<%
	AtmMoneyManagementImpl atmMoneyManagementimpl = new AtmMoneyManagementImpl();
			rs = atmMoneyManagementimpl.history();
	%>
	<table style="width: 80%; margin-left: 100px;">
		<tr>
			<th>Id</th>
			<th>Money Filled</th>
			<th>Current Balance</th>
			<th>Filled At</th>
			<th>Agent Name</th>
		
		</tr>
		<%
		while (rs.next()) {
		%>


		<tr>
			<td><%=rs.getString(1)%></td>
			<td><%=rs.getString(2)%></td>
			<td><%=rs.getString(3)%></td>
			<td><%=rs.getString(4)%></td>
			<td><%=rs.getString(5)%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</body>
</html>