<%@page import="com.atm.daoimpl.UserProfileImpl"%>
<%@page import="com.atm.models.UserProfileModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.atm.controller.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="" href="Assets/sbi-logo-33234.png">
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<div id="bgBlur">

	<title>Balance</title>
	<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial, Helvetica, sans-serif;
}

#headbal {
	position: absolute;
	left: 480px;
	font-size: 50px;
	color: orange;
}

#headbal1 {
	font-size: 80px;
	position: absolute;
	top: 280px;
	left: 280px;
	color: white;
}

#hrbal {
	position: relative;
	top: 180px;
}

#ballab {
	color: yellow;
	position: relative;
	top: 260px;
	left: 850px;
	font-size: 70px;
}

button {
	position: relative;
	background-color: red;
	height: 50px;
	width: 140px;
	float: right;
	top: -100px;
	border-radius: 10px;
}

#timehead {
	position: absolute;
	top: 0px;
}

body {
	background-image:
		url("https://resize.indiatvnews.com/en/resize/newbucket/715_-/2020/03/sbi-atm-card-1584194515.jpg");
	background-repeat: no-repeat;
	background-size: cover;
}

#bgBlur {
	position: absolute;
	background-color: rgba(11, 11, 11, 0.6);
	height: 625px;
	width: 1366px;
}
</style>
</head>
<body bgcolor="blue">

	<c:if test="${user == null}">
		<c:redirect url="index.jsp"></c:redirect>
	</c:if>

	<h1 id="headbal">Welcome&ensp; ${user}</h1>

	<h1 id="headbal1">Your Balance :</h1>
	<br>

	<label id="ballab">${balanceInt}</label>
	<form action="Welcomepage.jsp">
		<button type="submit" class="btn btn-danger">Home</button>
	</form>
	<h1 id="timehead">00:00</h1>
</body>

<script>

let th = document.getElementById("timehead");
let time = 10;
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