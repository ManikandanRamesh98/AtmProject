<%@page import="com.atm.daoimpl.LoginDetailsImpl"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel = "icon" type = "" href = "Assets/sbi-logo-33234.png">
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
width: 80%;
margin-left: 100px;
}

</style>
</head>
<body bgcolor=" #363945">
<c:if test="${admin == null}">
	<c:redirect url="index.jsp"></c:redirect>
	</c:if>
	
	<table>
		<tr>
			<th>Id</th>
			<th>UserName</th>
			<th>Logged at</th>
			<th>Role</th>
		</tr>
		
		<c:forEach items="${logindetailsobj}" var="l">
		<tr>
			<td>${l.id}</td>
			<td>${l.username}</td>
			<td>${l.loggedat}</td>
			<td>${l.role}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>