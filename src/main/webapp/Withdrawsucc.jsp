<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Withdraw Success</title>
<style>
#withsucclab {
	font-size: 60px;
	position: absolute;
	top: 180px;
	left: 130px;
}

#succhead {
	font-size: 60px;
	color: yellow;
	position: absolute;
	top: 300px;
	left: 480px;
}
</style>
</head>
<body bgcolor="blue">
	<%!String user;%>

	<%
	if (session.getAttribute("user") == null) {
		response.sendRedirect("Login.html");
	} else {
		user = session.getAttribute("user").toString();
	}
	%>
	<%
	int succamount = (int) session.getAttribute("withamount");
	int succbal = (int) session.getAttribute("withbal");
	%>
	<label id="withsucclab">You have successfully withdrawed amount
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
			window.location.assign("Login.html");
		}
	},1000);
	
});


</script>
</html>