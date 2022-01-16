<%@page import="com.atm.exception.InvalidUsernameAdminException"%>
<%@page import="com.atm.daoimpl.UserProfileImpl"%>
<%@page import="com.atm.models.UserProfileModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<%@page import="java.sql.ResultSet"%>

<!DOCTYPE html>
<html>
<head>
<link rel = "icon" type = "" href = "Assets/sbi-logo-33234.png">
<meta charset="ISO-8859-1">
<title>User Details</title>
<style>
#userdetailfield {
	width: 500px;
}

label {
	color: yellow;
	font-size: 50px;
}

legend {
	font-size: 30px;
	color: white;
}

#headinval {
	position: absolute;
	font-size: 80px;
	left: 400px;
	top: 200px;
}
</style>
</head>
<body bgcolor="#2F4F4F">
	<%!String user;
	
	UserProfileImpl userprofiledao = new UserProfileImpl();
	int id;
	String uname;
	Long accno;
	int bal;
	Long mobno;%>
	<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		String username = request.getParameter("userdetadmin");
	%>

	<%
	if (session.getAttribute("admin") == null) {
			response.sendRedirect("index.jsp");
		} else {
			user = session.getAttribute("admin").toString();
		}
	%>

	<%
	UserProfileModel userprofilepojo = new UserProfileModel(username);
		ResultSet rs = userprofiledao.getuserdetails(userprofilepojo);
		while (rs.next()) {
			id = rs.getInt(1);
			uname = rs.getString(2);
			accno = rs.getLong(3);
			bal = rs.getInt(4);
			mobno = rs.getLong(5);
		}
	%>
<%
ResultSet rs1 = userprofiledao.getuserdetails(userprofilepojo);
try{
if(rs1.next()){ %>
	<fieldset id="userdetailfield">
		<legend>User Details</legend>
		<label>User Id : <%=" " + id%></label><br>
		<br> <label>UserName : <%=" " + uname%></label><br>
		<br> <label>User Account No : <%=" " + accno%></label><br>
		<br> <label>Balance : <%=" " + bal%></label><br>
		<br> <label>Mobile No : <%=" " + mobno%></label><br>
		<br>
	</fieldset>
	<%}else{
		throw new InvalidUsernameAdminException();
	}}catch(InvalidUsernameAdminException e){
	response.sendRedirect(e.getMessage());
	}%>


</body>
</html>