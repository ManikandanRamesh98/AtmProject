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
body{
background-image: url("https://scontent.fmaa12-2.fna.fbcdn.net/v/t31.18172-8/22051279_1623705757680216_2725610580980024577_o.jpg?_nc_cat=111&ccb=1-5&_nc_sid=9267fe&_nc_ohc=rQNE9RPtZRwAX-mhcc2&_nc_ht=scontent.fmaa12-2.fna&oh=00_AT8DZmZcWuSx5EuS6yKVIyni07maX40Fdj558GuUd-6Ayg&oe=61FBF9C7");
background-repeat: no-repeat;
background-size: cover;

}
</style>
</head>
<body bgcolor="blue">
<%
if (session.getAttribute("admin") == null) {
		response.sendRedirect("Login.html");
	}
	
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
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