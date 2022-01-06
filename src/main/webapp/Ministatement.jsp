<%@page import="com.atm.daoimpl.UserProfileImpl"%>


<%@page import="java.sql.ResultSet"%>
<%@page import="com.atm.daoimpl.MiniStatementImpl"%>
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



table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
  padding: 20px;
}
th{

font-weight:bolder;
font-size:30px;
}
td{
font-size:20px;
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
	
	
	<table style="width: 80%; margin-left: 100px;">
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
			</td>
			<td><%=rSet.getString(1)%>
			</td>
			<td><%=rSet.getString(2)%>
			</td>
		</tr>
		<%
		}
		%>
	</table>
	
<h1 id = "timehead">00:00</h1>
</body>

<script>
let th = document.getElementById("timehead");
let time = 30;
let i;
window.addEventListener('load', () =>{
	
	 i= setInterval(() => {
		if(time > 0){
			if(time >= 10){
				
		th.innerHTML = "00 : " + time--;
		
			}else{
				th.style.color = "red";
				th.innerHTML = "00 : 0" + time--;
			}
		}else{
			clearInterval(i);
			window.location.assign("Logout.jsp");
		}
	},1000);
	
});



</script>
</html>