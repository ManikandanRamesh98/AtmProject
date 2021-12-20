<%@page import="com.bank.login.Userprofilepojo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.ResultSet"%>
<%@page import="com.bank.login.Userprofiledao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details</title>
<style>
#userdetailfield{
width:500px;
}
label{
color:yellow;
font-size:50px;
}
legend{
font-size:30px;
}
#headinval{
position : absolute;
font-size : 80px;
left:400px;
top : 200px;
}
</style>
</head>
<body bgcolor = "blue">
<%!String user;
Userprofiledao userprofiledao = new Userprofiledao();
int id;
String uname;
Long accno;
int bal;
Long mobno;
%>
<% String username = request.getParameter("userdetadmin");
%>

<% 

if(session.getAttribute("admin") == null){
	response.sendRedirect("Login.html");
}else{
 user = session.getAttribute("admin").toString();
}
%>

<%
Userprofilepojo userprofilepojo = new Userprofilepojo(username);
ResultSet rs = userprofiledao.getuserdetails(userprofilepojo);
while(rs.next()){
	 id = rs.getInt(1);
	 uname = rs.getString(2);
	 accno = rs.getLong(3);
	 bal = rs.getInt(4);
	 mobno = rs.getLong(5);
}
%>

<fieldset id = "userdetailfield">
<legend>User Details</legend>
 <label>User Id : <%=" " +id %></label><br><br>
<label>UserName : <%=" " +uname %></label><br><br>
<label>User Account No : <%=" " +accno %></label><br><br>
<label>Balance : <%=" " +bal %></label><br><br>
<label>Mobile No : <%=" " +mobno %></label><br><br>
</fieldset>


</body>
</html>