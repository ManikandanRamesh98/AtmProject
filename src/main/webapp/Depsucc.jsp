<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<div id="bgBlur">
<title>Deposit Success</title>
<style>
*{
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial,Helvetica,sans-serif;	
}
#withsucclab {
	font-size: 45px;
	position: absolute;
	top: 180px;
	left: 190px;
	color : white;
	font-weight:bolder;
}

#succhead {
	font-size: 60px;
	color: yellow;
	position: absolute;
	top: 300px;
	left: 480px;
}
body{
background-image: url("https://resize.indiatvnews.com/en/resize/newbucket/715_-/2020/03/sbi-atm-card-1584194515.jpg");
background-repeat: no-repeat;
background-size: cover;
}

 #bgBlur{
	position: absolute;
	background-color: rgba(11, 11, 11, 0.7);
	height: 625px;
	width: 1366px;
} 
</style>
</head>
<body bgcolor="blue">
	<%!String user;%>

	<%
	if (session.getAttribute("user") == null) {
		response.sendRedirect("index.jsp");
	} else {
		user = session.getAttribute("user").toString();
	}
	%>
	<%
	int succamount = (int) session.getAttribute("depsuccamount");
	int succbal = (int) session.getAttribute("depsuccbal");
	%>
	<label id="withsucclab">You have successfully Deposited amount
		<%=succamount%></label>
	<h1 id="succhead">
		BALANCE:<%=succbal%></h1>


<h1 id = "timehead">00:00</h1>
</body>

<script>

let th = document.getElementById("timehead");
let time = 4;
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