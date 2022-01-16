<%@page import="com.atm.daoimpl.RemovedUsersImpl"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.atm.models.*"%>
<%@page import="com.atm.models.RemovedUsersModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel = "icon" type = "" href = "Assets/sbi-logo-33234.png">
<meta charset="ISO-8859-1">
<title>Removed Users!!</title>
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

</style>
</head>
<body bgcolor="#2F4F4F">
<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	if (session.getAttribute("admin") != null) {
		String admin = session.getAttribute("admin").toString();
	} else {
		response.sendRedirect("index.jsp");
	}
	%>
	<%!ResultSet rs;%>
	<%
	RemovedUsersImpl removedusersdao = new RemovedUsersImpl();
			rs = removedusersdao.fetchremoveusers();
	%>
	<table style="width: 80%; margin-left: 100px;">
		<tr>
			<th>Id</th>
			<th>UserAccount Number</th>
			<th>UserName</th>
			<th>LastBalance</th>
			<th>Mobile no</th>
			<th>UserPin</th>

			<th>Account removed At</th>
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
			<td><%=rs.getString(6)%></td>
			<td><%=rs.getString(7)%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>