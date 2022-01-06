<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pin change</title>
<style>
#pinchangehead {
	font-size: 50px;
	position: absolute;
	left: 500px;
}

legend {
	font-size: 30px;
	color:yellow;
}

fieldset {
	position: absolute;
	top: 170px;
	width: 300px;
	left: 500px;
	height:350px;
		
}
#subbt{
position:absolute;
left:120px;
top:280px;
width:90px;
height:40px;
}
input{
width:300px;
height:30px;
background-color: blue;
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
</style>
</head>
<body bgcolor="blue">
	<%!String user; %>

	<% 
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
if(session.getAttribute("user") == null){
	response.sendRedirect("Login.html");
}else{
 user = session.getAttribute("user").toString();
}
%>
	<h1 id="pinchangehead">
		Welcome
		<%=' ' + user %></h1>
	<fieldset>
		<legend>Generate New Pin</legend>
		<h1 id="pinchangehead1">Enter The New Pin</h1>
		<form action="pinchangeserv" method="post" autocomplete = "off" onsubmit="return cnfpass()">
			<input type="password" name="pininp" id="pininpid"
				pattern="[0-9]{4}" 
				title="enter new pin number 0-9 in length of four" autofocus required onclick = "invalabfn()">
			<br>
			<h1>Confirm New Pin</h1><br>
			<input type="password" name="pininp" id="pininpid1"
				pattern="[0-9]{4}" 
				title="enter new pin number 0-9 in length of four" autofocus required><br>
			<input type="submit" id = "subbt" ><br>
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
			window.location.assign("Logout.jsp");
		}
	},1000);
	
});

</script>
</html>