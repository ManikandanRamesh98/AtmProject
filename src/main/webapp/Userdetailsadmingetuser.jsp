<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<div id="bgBlur"></div>
<title>User Details - Admin</title>
<style>
*{
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial,Helvetica,sans-serif;	
}
legend {
	font-size: 20px;
	color: yellow;
}

fieldset {
	position: absolute;
	top: 200px;
	width: 300px;
	height: 150px;
	left: 500px;
	height:300px;
	padding: 20px;
}

form {
	position: relative;
	top: 30px;
}

label {
	font-size: 40px;
	color:white;
}
body{
background-image: url("https://scontent.fmaa12-2.fna.fbcdn.net/v/t31.18172-8/22051279_1623705757680216_2725610580980024577_o.jpg?_nc_cat=111&ccb=1-5&_nc_sid=9267fe&_nc_ohc=rQNE9RPtZRwAX-mhcc2&_nc_ht=scontent.fmaa12-2.fna&oh=00_AT8DZmZcWuSx5EuS6yKVIyni07maX40Fdj558GuUd-6Ayg&oe=61FBF9C7");
background-repeat: no-repeat;
background-size:cover;	
}
#subid{
position: absolute;
top:170px;
width:80px;
height: 40px;
right : 110px;
}
#usernameinp{
position: relative;
top:27px;
width: 280px;
height: 30px;
left : 10px;
}
#subid:hover {
	background-color: black;
	color:white;
}
#usernameinp:hover {
	color:white;
	background-color: black;
}
#bgBlur{
	position: absolute;
	background-color: rgba(11, 11, 11, 0.6);
	height: 625px;
	width: 1366px;
}
input:hover{
	box-shadow: 0 0 20px blue;
	transition-duration: 0.2s;
}
button:hover{
	box-shadow: 0 0 20px blue;
	transition-duration: 0.2s;
}
</style>
</head>
<body bgcolor="#363945">
	<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	if (session.getAttribute("admin") != null) {
		String admin = session.getAttribute("admin").toString();
	} else {
		response.sendRedirect("index.jsp");
	}
	%>
	<fieldset>
		<legend>User Details : </legend>
		<form action="Userdetailadmin.jsp">
			<label>Enter Username : </label><br> <input type="text"
				name="userdetadmin" pattern="[A-Z][a-zA-Z]{3,20}"
				title="Start with A-Z and use A-Z or a-z or 0-9 minimum 3 character maximum 20 character" id = "usernameinp">
			<input type="submit" id = "subid">
		</form>
	</fieldset>
</body>
</html>