<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.atm.controller.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Remove Account</title>
<style>
legend {
	font-size: 20px;
	color: yellow;
}

fieldset {
	position: absolute;
	top: 200px;
	width: 300px;
	height: 250px;
	left: 500px;
}

label {
	font-size: 20px;
	color: white;
	padding: 10px;
}

input {
	position: absolute;
	left: 90px;
	width:200px;
	height:30px;
}

button {
	position: absolute;
	left: 200px;
	top: 100px;
}

body {
	background-image:
		url("https://scontent.fmaa12-2.fna.fbcdn.net/v/t31.18172-8/22051279_1623705757680216_2725610580980024577_o.jpg?_nc_cat=111&ccb=1-5&_nc_sid=9267fe&_nc_ohc=rQNE9RPtZRwAX-mhcc2&_nc_ht=scontent.fmaa12-2.fna&oh=00_AT8DZmZcWuSx5EuS6yKVIyni07maX40Fdj558GuUd-6Ayg&oe=61FBF9C7");
	background-repeat: no-repeat;
	background-size: cover;
}

button {
	position: relative;
	left: 105px;
	width: 90px;
	height: 40px;
	top: 50px;
}

button:hover {
	background-color: black;
	color: white;
}
input:hover {
	background-color: black;
	color:white;
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
<body bgcolor="blue">
	<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	if (session.getAttribute("admin") != null) {
		String admin = session.getAttribute("admin").toString();
	} else {
		response.sendRedirect("index.jsp");
	}
	%>
	<fieldset>
		<legend>Remove User : </legend>
		<form action="removeaccserv" method="post">
			<label>Enter User : </label><br> <input type="text"
				name="remusername" pattern="[A-Z][a-zA-Z]{3,20}"
				title="Start with A-Z and use A-Z or a-z or 0-9 minimum 3 character maximum 20 character"><br>
			<br>
			<br>
			<br> <label>Enter user id :</label><br> <input type="text"
				name="remuserid" pattern="[0-9]{1,5}" title="Enter Valid User Id"><br>
			<button type="submit">Remove</button>

		</form>
	</fieldset>
</body>
</html>