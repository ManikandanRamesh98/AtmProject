<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Withdraw</title>
<style>
#headwith {
	position: absolute;
	left: 530px;
	font-size: 45px;
}

#labwith {
	color: yellow;
	font-size: 70px;
	position: absolute;
	top: 150px;
	left: 320px;
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
	background-color: blue;
	font-size: 60px;
	border-color: blue;
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
</style>
</head>
<body bgcolor="blue">
	<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	if (session.getAttribute("invalidpin") != null) {
		boolean flag = (boolean) session.getAttribute("invalidpin");
		if (flag) {
	%>
	<label id="invallab">Invalid Pin!!</label>

	<%
	session.removeAttribute("invalidpin");
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
	<label id="labwith">Enter Amount To Withdraw</label>
	<form action="Enterpin.jsp" id="formwith">
		<br> <input type="text" name="inpwith" id="withinp" required
			pattern="[1-9][0-9]+[0]" minlength = "3" maxlength="7" title="Enter Valid Amount"
			onclick="invalabfn()" autofocus>
	</form>
	<form action="Welcomepage.jsp">
		<button type="submit">Home</button>
	</form>
	<h1 id = "timehead">00:00</h1>
</body>
<script>
	function invalabfn() {
		let invallab = document.getElementById("invallab");
		invallab.style.visibility = "hidden";
	}
</script>
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
			window.location.assign("Logout.jsp");
		}
	},1000);
	
});

</script>


</html>