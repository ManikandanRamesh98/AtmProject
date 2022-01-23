<%@page import="com.atm.exception.NotLoggedInException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.atm.controller.*"%>
<!DOCTYPE html>
<html lang="eng">
<head>
<link rel = "icon" type = "" href = "Assets/sbi-logo-33234.png">
<meta charset="ISO-8859-1">
<%!String user;%>

<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
try {
	if (session.getAttribute("user") == null) {
		throw new NotLoggedInException();
	} else {
		user = session.getAttribute("user").toString();
	}
} catch (NotLoggedInException e) {
	response.sendRedirect(e.getMessage());
}
%>
<div id="bgBlur"></div>

<title>Welcome <%=user%></title>
<link rel="stylesheet" href="welcomeuser.css">
<style>
#invalpin {
	color: #F5DF4D;
	position: absolute;
	font-size: 80px;
	top: 300px;
	left: 500px;
	font-weight: bolder;
}

a {
	display: inline-block;
	box-sizing: border-box;
	cursor: pointer;
	transition: transform 0.7s;
}

a:hover {
	transform: translateY(-10px);
}
</style>
</head>
<body>
	<%
	if (session.getAttribute("invalidhomepin") != null) {
	%>
	<h1 id="invalpin">Invalid Pin</h1>
	<%
	session.removeAttribute("invalidhomepin");
	%>
	<%
	}
	%>
	<marquee id="welmar" scrollamount="20">STATE BANK OF INDIA</marquee>
	<hr>
	<a href="Withdraw.jsp" id="withdraw" class="atag">Withdraw</a>
	<a href="Deposit.jsp" id="deposit" class="atag">Deposit</a>
	<a href="EnterPinBal.jsp" id="balance" class="atag">Balance</a>
	<a href="EnterPinuserDetail.jsp" id="userdetails" class="atag">User
		Details</a>
	<a href="EnterPinMoneyTransf.jsp" id="moneytransfer" class="atag">Money
		Transfer</a>
	<a href="EnterPinMiniState.jsp" id="ministatement" class="atag">Mini
		Statement</a>
	<a href="Pinchange.jsp" id="pinchange" class="atag">Pin Change</a>
	<a href="Logout.jsp" id="logout" class="atag">Logout</a>
	<h1 id="timehead">00:00</h1>
</body>

<script>
localStorage.removeItem("invalmax");
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
