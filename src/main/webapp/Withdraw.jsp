<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel = "icon" type = "" href = "Assets/sbi-logo-33234.png">
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  
<div id="bgBlur"></div>
<title>Withdraw</title>
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
	color:orange;
}

#labwith {
	color: white;
	font-size: 70px;
	position: absolute;
	top: 150px;
	left: 320px;
	font-weight: bolder;
}

#invallab {
	position: relative;
	color: #FF6347;
	font-size: 60px;
	top: 250px;
	left: 540px;
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
#withinp:hover{
	box-shadow: 0 0 20px white;
	transition-duration: 0.2s;
}
 #bgBlur{
	position: absolute;
	background-color: rgba(11, 11, 11, 0.6);
	height: 625px;
	width: 1366px;
} 
#amountexceed{
position: absolute;
color: #FF6347;
top : 450px;
left : 420px;
}
#remainingWithdraw{
position: absolute;
color: #FF6347;
top : 450px;
left : 350px;
}
</style>
</head>
<body>
	<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	if (session.getAttribute("invalidpin") != null) {
		boolean flag = (boolean) session.getAttribute("invalidpin");
		if (flag) {
	%>
	<label id="invallab">Invalid Pin</label>

	<%
	session.removeAttribute("invalidpin");
	}
	}
	%>
	<!-- amount exceed than 10000 -->
	<%
	if(session.getAttribute("amountexceed") != null){%>
		<h1 id = "amountexceed">Enter Amount Less Than 10000</h1>
	<% session.removeAttribute("amountexceed");}
	%>
	
	<!-- remaining amount limit-->
	<%
	if(session.getAttribute("remainingWithdraw") != null){
		int remainingAmount = (int)session.getAttribute("remainingWithdraw");
		
	%>
	
		<h1 id = "remainingWithdraw">Your Remaining Withdraw Limit is <%=remainingAmount %></h1>
	<% session.removeAttribute("remainingWithdraw");}
	%>
	<%!String user;%>

	<%
	if (session.getAttribute("user") == null) {
		response.sendRedirect("index.jsp");
	} else {
		user = session.getAttribute("user").toString();
	}
	%>
	<h1 id="headwith">
		Welcome&ensp;
		<%=user%></h1>
	<label id="labwith">Enter Amount To Withdraw</label>
	<form action="Enterpin.jsp" id="formwith" autocomplete="off">
		<br> <input type="text" name="inpwith" id="withinp" required
			pattern="[1-9][0-9]*[0][0]" minlength = "3" maxlength="7" title="Enter multiples of 100"
			onclick="invalabfn()" onmouseover="amountexceed()" onmouseenter="remainingamount()" autofocus>
	</form>
	<form action="Welcomepage.jsp">
		<button type="submit" class="btn btn-danger">Home</button>
	</form>
	<h1 id = "timehead">00:00</h1>
</body>
<script>
	function invalabfn() {
		let invallab = document.getElementById("invallab");
		invallab.style.visibility = "hidden";
		
	}
	function amountexceed() {
		let invallab1 = document.getElementById("amountexceed");
		invallab1.style.visibility = "hidden";
	}
	function remainingamount() {
		let invallab1 = document.getElementById("remainingWithdraw");
		invallab1.style.visibility = "hidden";
	}
	
</script>
<script>

let th = document.getElementById("timehead");
let time = 20;
let i;
window.addEventListener('load', () =>{
	
	 i= setInterval(() => {
		if(time > 0){
			if(time >= 10){
				
				th.style.color = "#98FB98";
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