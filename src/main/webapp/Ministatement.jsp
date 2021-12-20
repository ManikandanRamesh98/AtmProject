<%@page import="org.apache.catalina.connector.Response"%>
<%@page import="com.atm.dao.Userprofiledao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.atm.dao.Ministatementdao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.atm.login.*" import = "com.atm.models.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mini Statement</title>
<style>
td{
color:yellow;
}

table{
border : 1px solid;
}
#transamount{
position : relative;
left:70px;
}
#transtime{
position : relative;
left:150px;
}        
      
</style>
</head>
<body bgcolor = "blue">
<%!String user; %>

<% 
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
if(session.getAttribute("user") == null){
	response.sendRedirect("Login.html");
}else{
 user = session.getAttribute("user").toString();
}
%>
<%!
Ministatementdao ministatementdao = new Ministatementdao();
Userprofiledao userprofiledao = new Userprofiledao();
String transtype = null;
%>
<%
Userprofilepojo userprofilepojo = new Userprofilepojo(user);
Long accno = userprofiledao.getaccno(userprofilepojo);
ResultSet rSet = ministatementdao.getministatement(accno);
/* while(rSet.next()){
	response.getWriter().println(rSet.getString(1) + " " + rSet.getString(2));
	response.getWriter().println();
}*/
%>
<table>
<tr>
<th>Transaction_type</th>
<th id = "transamount">Transaction</th>
<th id = "transtime">Transaction Time</th>
</tr>
<%while(rSet.next()){%>
<%if(Integer.parseInt(rSet.getString(1)) > 0){
		transtype = "Deposit";
	}else{
		transtype = "Withdraw";
	}
		%>
	<tr>
	
	<td><%= transtype %><td>
	<td><%=rSet.getString(1) %><td>
	<td><%=rSet.getString(2) %><td>
	</tr>
<% }%>
</table>
</body>
<script>
let i = <%=user %>
</script>
</html>