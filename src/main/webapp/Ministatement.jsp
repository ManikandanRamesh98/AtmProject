<%@page import="com.atm.impl.UserProfileImpl"%>


<%@page import="java.sql.ResultSet"%>
<%@page import="com.atm.impl.MiniStatementImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.*"
	import="com.atm.models.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mini Statement</title>
<style>
td {
	color: yellow;
}

#transamount {
	position: relative;
	left: 100px;
}

#transtime {
	position: relative;
	left: 220px;
}

th {
	font-size: 30px;
}

td {
	font-size: 20px;
}
</style>
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
	<%!MiniStatementImpl ministatementdao = new MiniStatementImpl();

UserProfileImpl userprofiledao = new UserProfileImpl(); 
String transtype = null;%>
	<%
	UserProfileModel userprofilepojo = new UserProfileModel(user);
		Long accno = userprofiledao.getaccno(userprofilepojo);
		ResultSet rSet = ministatementdao.getministatement(accno);
	%>
	<table>
		<tr>
			<th>Transaction_type</th>
			<th id="transamount">Transaction</th>
			<th id="transtime">Transaction Time</th>
		</tr>
		<%
		while (rSet.next()) {
		%>
		<%
		if (Integer.parseInt(rSet.getString(1)) > 0) {
			transtype = "Deposit";
			if(rSet.getString(3) != null){
				transtype = "Money Transfer From " + rSet.getString(3);
			}
		} else {
			transtype = "Withdraw";
			if(rSet.getString(3) != null){
				transtype = "Money Transfer To " + rSet.getString(3);
			}
		}
		%>
		<tr>

			<td><%=transtype%>
			<td><br> <br> <br>
			<td><%=rSet.getString(1)%>
			<td><br> <br> <br>
			<td><%=rSet.getString(2)%>
			<td><br> <br> <br>
		</tr>
		<%
		}
		%>
	</table>
	
</body>
<script>
	

	
</script>
</html>