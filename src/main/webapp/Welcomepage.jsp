<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>State Bank Of India</title>
<link rel="stylesheet" href="welcomeuser.css">
</head>
<body bgcolor="blue">
	<%!String user;%>

	<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	if (session.getAttribute("user") == null) {
		response.sendRedirect("Login.html");
	} else {
		user = session.getAttribute("user").toString();
	}
	%>



	<marquee id="welmar" scrollamount="20">STATE BANK OF INDIA</marquee>
	<hr>
	<a href="Withdraw.jsp" id="withdraw" class="atag">Withdraw</a>
	<a href="Deposit.jsp" id="deposit" class="atag">Deposit</a>
	<a href="Balance.jsp" id="balance" class="atag">Balance</a>
	<a href="Userdetails.jsp" id="userdetails" class="atag">User
		Details</a>
	<a href="Moneytransfer.jsp" id="moneytransfer" class="atag">Money
		Transfer</a>
	<a href="Ministatement.jsp" id="ministatement" class="atag">Mini
		Statement</a>
	<a href="Pinchange.jsp" id="pinchange" class="atag">Pin Change</a>
	<a href="Logout.jsp" id="logout" class="atag">Logout</a>
</body>
</html>
