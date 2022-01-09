<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<div id="bgBlur"></div>
<title>Deposit</title>
<style>
*{
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial,Helvetica,sans-serif;	
}
#headwith {
	position: absolute;
	left: 530px;
	font-size: 45px;
	color: orange;
}

#labwith {
	color: white;
	font-size: 70px;
	position: absolute;
	top: 150px;
	left: 330px;
	font-weight: bolder;
}

#invallab {
	position: relative;
	color: red;
	font-size: 60px;
	top: 250px;
	left: 520px;
}

input {
	height: 90px;
	width: 300px;
	background-color: rgba(255,255,255,0.7);
	font-size: 60px;
}

form {
	position: absolute;
	top: 300px;
	left: 530px;
}

button {
	position: relative;
	width: 80px;
	height: 50px;
	background-color: red;
	right: -700px;
	border-radius: 10px;
	top: -280px;
}
body{

background-image: url("https://resize.indiatvnews.com/en/resize/newbucket/715_-/2020/03/sbi-atm-card-1584194515.jpg");
background-repeat: no-repeat;
background-size: cover;
}
#withpinid:hover{
	box-shadow: 0 0 20px white;
	transition-duration: 0.2s;
}
 #bgBlur{
	position: absolute;
	background-color: rgba(11, 11, 11, 0.6);
	height: 625px;
	width: 1366px;
}
</style>
</head>
<body bgcolor="blue">
	<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	if (session.getAttribute("invaliddeppin") != null) {
		boolean flag = (boolean) session.getAttribute("invaliddeppin");
		if (flag) {
	%>
	<label id="invallab">Invalid Pin!!</label>

	<%
	session.removeAttribute("invaliddeppin");
	}
	}
	%>
	<%!String user;%>

	<%
	if (session.getAttribute("user") == null) {
		response.sendRedirect("Login.html");
	} else {
		user = session.getAttribute("user").toString();
	}
	%>
	<h1 id="headwith">
		Welcome&ensp;
		<%=user%></h1>
	<label id="labwith">Enter Amount To Deposit</label>
	<form action="Enterpindep.jsp" id="formwith" autocomplete="off" >
		<br> <input type="text" name="inpdep" id="withinp" required
			pattern="[1-9][0-9]*[0][0]" minlength = "3" maxlength="7" title="Enter Valid Amount"
			onclick="invalabfn()" autofocus>
	</form>
	<form action="Welcomepage.jsp">
		<button type="submit">Home</button>
	</form>
<h1 id = "timehead">00:00</h1>
</body>

<script>
let th = document.getElementById("timehead");
let time = 20;
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
<script>
	function invalabfn() {
		let invallab = document.getElementById("invallab");
		invallab.style.visibility = "hidden";
	}
</script>
</html>