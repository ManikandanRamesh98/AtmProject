<%@page import="com.atm.models.Userprofilemodel"%>
<%@page
	import="jakarta.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.atm.dao.Userprofiledao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
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
}
</style>
</head>
<body bgcolor="blue">
	<%!String user;
	Userprofiledao userprofiledao = new Userprofiledao();
	int id;
	String uname;
	Long accno;
	int bal;
	Long mobno;%>


	<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	if (session.getAttribute("user") == null) {
		response.sendRedirect("Login.html");
	} else {
		user = session.getAttribute("user").toString();
	}
	%>

	<%
	Userprofilemodel userprofilepojo = new Userprofilemodel(user);
	ResultSet rs = userprofiledao.getuserdetails(userprofilepojo);
	while (rs.next()) {
		id = rs.getInt(1);
		uname = rs.getString(2);
		accno = rs.getLong(3);
		bal = rs.getInt(4);
		mobno = rs.getLong(5);
	}
	%>
	<fieldset id="userdetailfield">
		<legend>User Details</legend>

		<label>UserName : <%=" " + uname%></label><br> <br> <label>User
			Account No : <%=" " + accno%></label><br> <br> <label>Balance
			: <%=" " + bal%></label><br> <br> <label>Mobile No : <%=" " + mobno%></label><br>
		<br>
	</fieldset>
</body>
</html>