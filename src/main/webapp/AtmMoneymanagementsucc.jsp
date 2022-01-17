<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel = "icon" type = "" href = "Assets/sbi-logo-33234.png">
<meta charset="ISO-8859-1">
<title>Money Deposited!!</title>
<style>
h1{
font-size:50px;
color:yellow;
position : absolute;
top:200px;
left:220px;
}
#timehead{
position : absolute;
top:0px;
left:0px;
color:black;
}
</style>
</head>
<body bgcolor = "blue">
<%!String agent;%>
	<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	if (session.getAttribute("agent") == null) {
		response.sendRedirect("index.jsp");
	} else {
		agent = session.getAttribute("agent").toString();
	}
	%>
	<%
	long eamount = (long)session.getAttribute("agentdepamount");
	%>
	<h1>You Have Successfully Deposited <%= " " +eamount+ " " + agent%></h1>
<h1 id = "timehead">00:00</h1>
</body>

<script>
let th = document.getElementById("timehead");
let time = 9;
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
			window.location.assign("LogOutAgent.jsp");
		}
	},1000);
	
});

</script>
</html>