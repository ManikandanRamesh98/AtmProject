<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
    <%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel = "icon" type = "" href = "Assets/sbi-logo-33234.png">
<meta charset="ISO-8859-1">
<div id="bgBlur"></div>
<title>Deposit Agent</title>
<style>
*{
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial,Helvetica,sans-serif;	
}
h1{
position : absolute;
font-size :40px;
left:550px;
color:#F5DF4D;
}
fieldset{
position : absolute;
top:250px;
left:400px;
width:550px;
height:150px;
padding: 10px;
}
legend{
font-size:30px;
color:#FF6347;
}
label{
font-size:25px;
color: white;
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
body{

background-image: url("https://resize.indiatvnews.com/en/resize/newbucket/715_-/2020/03/sbi-atm-card-1584194515.jpg");
background-repeat: no-repeat;
background-size: cover;
}

 #bgBlur{
	position: absolute;
	background-color: rgba(11, 11, 11, 0.6);
	height: 625px;
	width: 1366px;
}
#timehead{
color:white;
}
</style>
</head>
<body bgcolor = "blue">
<c:if test="${agent == null}">
	<c:redirect url="index.jsp"></c:redirect>
	</c:if>
	
	<h1>welcome : ${agent}</h1>
	<fieldset>
	<legend>REFILL</legend>
	<form action = "depagentserv" method = "post">
	<label>Enter Amount To Refill : </label><br>
	<input type = "text" name= "depagentamount" pattern="[1-9][0-9]+[0][0]" maxlength="7" title = "Enter Amount Greater Than 2000 And Less Than 50000" autofocus><br>
	<button type = "submit">Deposit</button>
	</form>
	</fieldset>
<h2 id = "timehead">00:00</h2>
</body>

<script>
let th = document.getElementById("timehead");
let time = 100;
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