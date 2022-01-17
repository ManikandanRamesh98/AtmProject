<%@page import="oracle.security.o3logon.a"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!String agent;%>

	<%
	if (session.getAttribute("agent") == null) {
		response.sendRedirect("index.jsp");
	} else {
		agent = session.getAttribute("agent").toString();
	}
	%>
	<%
	session.invalidate();
	response.sendRedirect("index.jsp");
	%>
</body>
</html>