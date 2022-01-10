<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deposit Agent</title>
<style>
h1{
position : absolute;
font-size :40px;
left:550px;
}
fieldset{
position : absolute;
top:250px;
left:400px;
width:550px;
height:150px;
}
legend{
font-size:30px;
color:yellow;
}
label{
font-size:25px;
}
input{
position : absolute;
left:280px;
width:250px;
height:30px;
}
button{
position : absolute;
left:480px;
top:80px;
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
	<fieldset>
	<legend>REFILL</legend>
	<form action = "depagentserv" method = "post">
	<label>Enter Amount To Refill : </label><br>
	<input type = "text" name= "depagentamount" pattern="[1-9][0-9]+[0][0]" maxlength="7"><br>
	<button type = "submit">Deposit</button>
	</form>
	</fieldset>
<h2 id = "timehead">00:00</h2>
</body>

<script>
let th = document.getElementById("timehead");
let time = 5;
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