<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Money Transfer</title>
<style>
fieldset {
	width: 500px;
	border-color: black;
	position: absolute;
	top: 190px;
	left: 400px;
	height: 260px;
}

legend {
	color: yellow;
	font-size: 40px;
}

label {
	font-size: 30px;
}

input {
	position: absolute;
	left: 240px;
}

#homebt {
	position: relative;
	float: right;
	background-color: red;
	width: 130px;
	height: 50px;
	border-radius: 10px;
}

#formbt {
	position: relative;
	float: right;
	top: 10px;
	width: 100px;
	height: 40px;
	left: -20px;
}
</style>
</head>
<body bgcolor="blue">
	<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	%>
	<fieldset>
		<legend>Money Transfer</legend>
		<form action="moneytransferserv" method="post">
			<label>Enter UserName : </label><br> <input type="text"
				name="moneytransfname" autofocus><br> <label>Enter
				UserAccountNo : </label><br> <input type="text" name="moneytransfaccno"><br>
			<label>Enter Amount : </label><br> <input type="text"
				name="moneytransfamount"><br>
			<button type="submit" id="formbt">Submit</button>
		</form>
	</fieldset>
	<form action="Welcomepage.jsp">
		<button type="submit" id="homebt">Home</button>
	</form>
</body>
</html>