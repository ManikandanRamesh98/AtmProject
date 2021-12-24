<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agent</title>
<style>
h1{
position: absolute;
font-size:70px;
left:500px;
}
a{
background-color:yellow;
text-decoration : none;
position: absolute;
font-size:60px;
border:1px solid black;
border-radius:10px;
top:280px;

}
#depagent{
position: absolute;
top:200px;
left:0px;
}
#historyagent{
position: absolute;
top:200px;
right:0px;
}
</style>
</head>
<body bgcolor = "blue">
	<%!String agent;%>
	<%
	if (session.getAttribute("agent") == null) {
		response.sendRedirect("Login.html");
	} else {
		agent = session.getAttribute("agent").toString();
	}
	%>
	<h1>welcome :
	<%=agent%></h1>
<a href = "Depositagent.jsp" id = "depagent">Deposit Money To ATM</a><br>
<a href = "Historyagent.jsp" id = "historyagent">View History</a>
</body>
</html>