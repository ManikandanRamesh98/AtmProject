<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deposit</title>
<style>
#headwith{
position:absolute;
left:600px;
font-size:40px;
}
#formwith{
position:relative;
float:right;
top:350px;
font-size:40px;
}
#labwith{
color:yellow;
font-size:70px;
position:absolute;
top:150px;
left:320px;
}
#withinp{
width:200px;
height:40px;
}
#withbt{

}

</style>
</head>
<body bgcolor = "blue">
<%!String user; %>

<% 

if(session.getAttribute("user") == null){
	response.sendRedirect("Login.html");
}else{
 user = session.getAttribute("user").toString();
}
%>
<h1 id = "headwith">Welcome&ensp;<%= user %></h1>
<label id ="labwith">Enter Amount To Deposit</label>
<form action = "depserv" id = "formwith">
<br>
<input type = "text" name = "inpdep" id = "withinp" required><button type = "submit" id = "withbt">Deposit</button>
</form>
</body>
</html>