<%@page import="com.atm.impl.RemovedUsersimpl"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.atm.models.*"%>
<%@page import="com.atm.models.Removedusersmodel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
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
color:yellow;
font-size:30px;
}
</style>
</head>
<body bgcolor="blue">
	<%!ResultSet rs;%>
	<%
	RemovedUsersimpl removedusersdao = new RemovedUsersimpl();
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