<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details - Admin</title>
<style>
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
}

form {
	position: relative;
	top: 30px;
}

label {
	font-size: 20px;
}
</style>
</head>
<body bgcolor="blue">
	<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
%>
	<fieldset>
		<legend>User Details : </legend>
		<form action="Userdetailadmin.jsp">
			<label>Enter Username : </label><br> <input type="text"
				name="userdetadmin" pattern="[A-Z][a-zA-Z]{3,20}"
				title="Start with A-Z and use A-Z or a-z or 0-9 minimum 3 character maximum 20 character">
			<input type="submit">
		</form>
	</fieldset>
</body>
</html>