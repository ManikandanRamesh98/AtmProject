<%@page import="com.atm.impl.UserProfileImpl"%>

<%@page import="com.atm.models.UserProfileModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Money Transfer Success!!</title>
<style>
h1{
position : absolute;
font-size:60px;
top:50px;

}
label{
position : absolute;
color:yellow;
font-size:80px;
top:280px;
left:400px;
}
button{
width:80px;
height:50px;
background-color:red;
float:right;
border-radius:10px;
}

</style>
</head>
<body bgcolor = "blue">
<%!String username;
int eamount;
String user;
int userbal;%>
<%
username = session.getAttribute("moneytransfname").toString();
eamount = (int)session.getAttribute("moneytransfamount");
user = session.getAttribute("user").toString();
UserProfileModel userprofilepojo = new UserProfileModel(user);

UserProfileImpl userprofiledao = new UserProfileImpl();
userbal = userprofiledao.getbal(userprofilepojo);
%>
<h1>You Have Sucessfully Transfered <%=" " + eamount + " " %> to <%=" " + username %></h1>
<label>Your Balance is <%=" " + userbal %></label>
<form action = "Welcomepage.jsp">
<button type = "submit">Home</button>
</form>
</body>
</html>