<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
	<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel = "icon" type = "" href = "Assets/sbi-logo-33234.png">
<div id="bgBlur"></div>
<title>Agent</title>
<style>
*{
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial,Helvetica,sans-serif;	
}
h1{
position: absolute;
font-size:70px;
left:420px;
}
a{
background-color: rgba(255,255,255,0.5);
text-decoration : none;
position: absolute;
font-size:60px;
color:black;
border-radius:5px;
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
body{

background-image: url("https://resize.indiatvnews.com/en/resize/newbucket/715_-/2020/03/sbi-atm-card-1584194515.jpg");
background-repeat: no-repeat;
background-size: cover;
}
a:hover{
	box-shadow: 0 0 20px white;
	transition-duration: 0.2s;
}
 #bgBlur{
	position: absolute;
	background-color: rgba(11, 11, 11, 0.6);
	height: 625px;
	width: 1366px;
}
a {
	display: inline-block;
	box-sizing: border-box;
	cursor: pointer;
	transition: transform 0.7s;
}

a:hover {
	transform: translateY(10px);
	background-color: orange;
}
#agenthead{
color: #FF6347;
}

#logout{
position: relative;
top:0px;
}
#logout:hover {
	background-color: red;
	transform: translateX(10px);
}
</style>
</head>
<body bgcolor = "blue">
	<c:if test="${agent == null}">
	<c:redirect url="index.jsp"></c:redirect>
	</c:if>
	
	<h1 id = "agenthead">welcome :
	${agent}</h1>
<a href = "Depositagent.jsp" id = "depagent">Deposit Money To ATM</a><br>
<a href = "agenthistoryservlet" id = "historyagent">View History</a>
<a href="LogOutAgent.jsp" id="logout" class="atag">Logout</a>
<h1 id = "timehead">00:00</h1>
</body>
<script>
let th = document.getElementById("timehead");
let time = 50;
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