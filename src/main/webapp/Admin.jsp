<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
#adminlab{
font-size:50px;
position : absolute;
left:480px;
color : yellow;
}
#adminregus{
text-decoration : none;
font-size:70px;
position : absolute;
top : 130px;
border:3px solid white;
border-radius:10px;
color:yellow;
border-color:white;
left : 370px;
}
#adminuserdet{
text-decoration : none;
font-size:70px;
position : absolute;
top : 500px;
border:3px solid white;
border-radius:10px;
color:yellow;
border-color:white;
left : 370px;
}
#adminremuser{
text-decoration : none;
font-size:70px;
position : absolute;
top : 320px;
border:3px solid white;
border-radius:10px;
color:yellow;
border-color:white;
left : 370px;
}

</style>
</head>
<body bgcolor = "blue">
<%! String admin; %>
<%
if(session.getAttribute("admin") == null){
	response.sendRedirect("Login.html");
}else{
admin = session.getAttribute("admin").toString();
}
%>
<label id = "adminlab">welcome : <%=admin %></label>

<a href = "Register.jsp" id = "adminregus">Register New User</a><br><br>

<a href = "Removeacc.jsp" id = "adminremuser">Remove User</a><br><br>
<a href = "Userdetailadmin.jsp" id = "adminuserdet">User Details</a>
</body>

</html>