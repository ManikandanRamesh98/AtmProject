<%@page import="com.atm.daoimpl.LoginDetailsImpl"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Details!!</title>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
  padding: 20px;
}
th{
color:yellow;
font-weight:bolder;
font-size:30px;
}
td{
font-size:20px;
}
table{
background-color: rgba(255,255,255,0.2);
}

</style>
</head>
<body bgcolor=" #363945">
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
	LoginDetailsImpl logindetailsdao = new LoginDetailsImpl();
		rs = logindetailsdao.fetchlogin();
	%>
	<table style="width: 80%; margin-left: 100px;">
		<tr>
			<th>Id</th>
			<th>UserName</th>
			<th>Logged at</th>
			<th>Role</th>
		</tr>
		<%
		while (rs.next()) {
		%>


		<tr>
			<td><%=rs.getString(1)%></td>
			<td><%=rs.getString(2)%></td>
			<td><%=rs.getString(3)%></td>
			<td><%=rs.getString(4)%></td>
			
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>