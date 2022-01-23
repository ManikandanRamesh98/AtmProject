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
<title>Pin change</title>
<style>
*{
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial,Helvetica,sans-serif;	
}
#pinchangehead {
	font-size: 50px;
	position: absolute;
	left: 500px;
	color: orange;
}

legend {
	font-size: 30px;
	color:#F5DF4D;
}

fieldset {
	position: absolute;
	top: 170px;
	width: 300px;
	left: 500px;
	height:350px;
	padding : 20px;
		
}
#subbt{
position:absolute;
left:120px;
top:210px;
width:90px;
height:40px;
}
input{
width:300px;
height:30px;
background-color: rgba(255,255,255,0.6);
}
#reglab{
position:absolute;
top:330px;
left:50px;
visibility: hidden;
}
#homebt{
position: absolute;
right : 0px;
top : 0px;
background-color: red;
width:90px;
height:50px;
border-radius: 10px;
}
body{
background-image: url("https://resize.indiatvnews.com/en/resize/newbucket/715_-/2020/03/sbi-atm-card-1584194515.jpg");
background-repeat: no-repeat;
background-size: cover;
}
input:hover{
	box-shadow: 0 0 20px white;
	transition-duration: 0.2s;
}
 #bgBlur{
	position: absolute;
	background-color: rgba(11, 11, 11, 0.6);
	height: 625px;
	width: 1366px;
}
#cnfpin{
position: relative;
top : 20px;
}
h1{
color:white;
}
button:hover{
	box-shadow: 0 0 20px white;
	transition-duration: 0.2s;
}
</style>
</head>
<body bgcolor="blue">
	<c:if test="${user == null}">
	<c:redirect url="index.jsp"></c:redirect>
	</c:if>
	
	<h1 id="pinchangehead">
		Welcome ${user}
</h1>
	<fieldset>
		<legend>Generate New Pin</legend>
		<h1 id="pinchangehead1">Enter The New Pin:</h1>
		<form action="pinchangeserv" method="post" autocomplete = "off" onsubmit="return cnfpass()">
			<input type="password" name="pininp" id="pininpid"
				pattern="[0-9]{4}" 
				title="enter new pin number 0-9 in length of four" autofocus required onclick = "invalabfn()">
			<br>
			<h1 id = "cnfpin">Confirm New Pin :</h1><br>
			<input type="password" name="pininp" id="pininpid1"
				pattern="[0-9]{4}" 
				title="enter new pin number 0-9 in length of four" autofocus required><br>
			<button type="submit" id = "subbt" >Generate</button><br>
		</form>
		<h1 id = "reglab">Pin Must Match!!</h1>
	</fieldset>
<h1 id = "timehead">00:00</h1>
<form action="Welcomepage.jsp">
		<button type="submit" id = "homebt">Home</button>
	</form>
</body>

<script>
let pass1 = document.getElementById("pininpid");
let pass2 = document.getElementById("pininpid1");
let reglab = document.getElementById("reglab");
function cnfpass() {
	if (pass1.value != pass2.value) {
		pass1.style.borderBlockColor = "red";
		pass2.style.borderBlockColor = "red";
		reglab.style.color = "red";
		reglab.style.visibility = "visible";
		return false;
	}
	return true;
}

//hiding lab function:
	function invalabfn() {
		let invallab = document.getElementById("reglab");
		pass1.style.borderBlockColor = "black";
		pass2.style.borderBlockColor = "black";
		invallab.style.visibility = "hidden";
	}
	
	//timeout function:
	let th = document.getElementById("timehead");
let time = 70;
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