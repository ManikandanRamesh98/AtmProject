<%@page import="com.atm.daoimpl.UserProfileImpl"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.atm.daoimpl.MiniStatementImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.*"
	import="com.atm.models.*" isELIgnored="false"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
<!DOCTYPE html>
<html>
<div id="bgBlur"></div>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Mini Statement</title>
<style>
*{
	margin: 0;
	padding: 0;
	font-family: Arial,Helvetica,sans-serif;	
}
td {
	color: yellow;
	font-weight: bolder;
	text-align:center;
}

table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
  padding: 20px;`
}
table
{
 align:center;
 margin-top:100px;
}

th{
color:white;
font-weight:bolder;
font-size:30px;
text-align:center;
}
tr:hover
{
  background-color:black;
  color:yellow;
}
td{
font-size:20px;
}
body{

background-color : #363945;
background-repeat: no-repeat;
background-size: cover;
}
#timehead
{
 color:red;
}
</style>
</head>
<body >
	<c:if test="${user == null}">
	<c:redirect url="index.jsp"></c:redirect>
	</c:if>
	
  <div class="container mt-1">	
	<div id = "minidiv">
	<table class="table table-bordered table-sm">
	<thead class="table-dark">
		<tr>
			<th>Transaction_type</th>
			<th id="transamount">Transaction</th>
			<th id="transtime">Transaction Time</th>
		</tr>
		</thead>
		<c:forEach items="${ministatementjspobj}" var = "m">
		<tr>
		<td>${m.transActionType}</td>
		<td>${m.transActionAmount}</td>
		<td>${m.transActionAt}</td>
			</tr>
		</c:forEach>
	</table>
	
<h1 id = "timehead">00:00</h1>
</div>
</div>
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