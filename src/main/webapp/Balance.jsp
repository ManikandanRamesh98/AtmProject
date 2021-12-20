<%@page import="com.bank.login.Userprofilepojo"%>
<%@page import="com.bank.login.Userprofiledao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Balance</title>
<style>
#headbal{
position:absolute;
left:600px;
font-size:40px;
}
#headbal1{
font-size:60px;
position:absolute;
top:160px;
left:400px;
}
#hrbal{
position:relative;
top:80px;
}
#ballab{
color:yellow;
position:relative;
top:160px;
left:800px;
font-size:70px;
}
</style>
</head>
<body bgcolor = "blue">
<%!String user;
Userprofiledao userprofiledao = new Userprofiledao();
%>

<% 

if(session.getAttribute("user") == null){
	response.sendRedirect("Login.html");
}else{
 user = session.getAttribute("user").toString();
}
%>
<h1 id = "headbal">Welcome&ensp;<%= user %></h1>
<hr id = "hrbal">
<h1 id = "headbal1">Your Balance :</h1><br>
<%Userprofilepojo userprofilepojo = new Userprofilepojo(user); %>
<label id = "ballab"><%=userprofiledao.getbal(userprofilepojo)%></label>
</body>
</html>