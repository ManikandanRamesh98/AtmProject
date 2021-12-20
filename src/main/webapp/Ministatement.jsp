<%@page import="org.apache.catalina.connector.Response"%>
<%@page import="com.bank.login.Userprofiledao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.bank.login.Ministatementdao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.bank.login.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mini Statement</title>
<style>
td{
color:yellow;
}
th {
           
            text-align:center;
        }
table{
border : 1px solid;
}
        
      
</style>
</head>
<body bgcolor = "blue">
<%!String user; %>

<% 

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
<th>Transaction<th>
<th>Transaction Time<th>
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