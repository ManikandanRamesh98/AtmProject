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
		response.sendRedirect("Login.html");
	} else {
		agent = session.getAttribute("agent").toString();
	}
	%>
	welcome :
	<%=agent%>

</body>
</html>