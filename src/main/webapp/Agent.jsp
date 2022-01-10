<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agent</title>
<style>
h1{
position: absolute;
font-size:70px;
left:420px;
}
a{
background-color:yellow;
text-decoration : none;
position: absolute;
font-size:60px;
border:1px solid black;
border-radius:10px;
top:280px;

}
#depagent{
position: absolute;
top:200px;
left:0px;
}
#historyagent{
position: absolute;
top:200px;
right:0px;
}
#timehead{
position : relative;
font-size:30px;
left:0px;
}
</style>
</head>
<body bgcolor = "blue">
	<%!String agent;%>
	<%
	if (session.getAttribute("agent") == null) {
		response.sendRedirect("index.jsp");
	} else {
		agent = session.getAttribute("agent").toString();
	}
	%>
	<h1>welcome :
	<%=agent%></h1>
<a href = "Depositagent.jsp" id = "depagent">Deposit Money To ATM</a><br>
<a href = "Historyagent.jsp" id = "historyagent">View History</a>
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
			window.location.assign("index.jsp");
		}
	},1000);
	
});



</script>
</html>