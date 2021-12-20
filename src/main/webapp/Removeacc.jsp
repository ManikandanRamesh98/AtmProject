<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Remove Account</title>
<style>
legend{
font-size : 20px;
color : yellow;
}
fieldset{
position : absolute;
top:200px;
width : 300px;
height : 150px;
left: 500px;
}
label{
font-size : 20px;
}
</style>
</head>
<body bgcolor = "blue">
<%if(session.getAttribute("admin") != null){
	String admin = session.getAttribute("admin").toString();
}else{
	response.sendRedirect("Login.html");
}
	%>
<fieldset>
<legend>Remove User : </legend>
<form action = "removeaccserv" method = "post">
<label>Enter User : </label><br>
<input type = "text" name = "remusername" pattern = "[A-Z][a-zA-Z]{3,20}" title = "Start with A-Z and use A-Z or a-z or 0-9 minimum 3 character maximum 20 character">
<input type = "submit">

</form>
</fieldset>
</body>
</html>