<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
h1 {
	position: absolute;
	color: yellow;
	font-size: 90px;
	left: 480px;
}

form {
	position: absolute;
	top: 300px;
	left: 500px;
}

input {
	height: 90px;
	width: 300px;
	background-color: blue;
	font-size: 60px;
	border-color: blue;
}
</style>
</head>
<body bgcolor="blue">
	<%
	int amount = Integer.parseInt(request.getParameter("inpwith"));
	session.setAttribute("withamount", amount);
	%>
	<h1>Enter Pin</h1>
	<form action="Enterpinservlet">
		<input type="password" name="withpin" id="withpinid">

	</form>
</body>
</html>