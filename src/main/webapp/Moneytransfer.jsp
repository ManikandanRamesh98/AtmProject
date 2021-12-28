<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Money Transfer</title>
<style>
fieldset {
	width: 500px;
	border-color: black;
	position: absolute;
	top: 190px;
	left: 400px;
	height: 260px;
}

legend {
	color: yellow;
	font-size: 40px;
}

label {
	font-size: 30px;
}

input {
	position: absolute;
	left: 240px;
}

#homebt {
	position: relative;
	float: right;
	background-color: red;
	width: 130px;
	height: 50px;
	border-radius: 10px;
}

#formbt {
	position: relative;
	float: right;
	top: 10px;
	width: 100px;
	height: 40px;
	left: -20px;
}
</style>
</head>
<body bgcolor="blue">
	<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	%>
	<fieldset>
		<legend>Money Transfer</legend>
		<form action="moneytransferserv" method="post">
			<label>Enter UserName : </label><br> <input type="text"
				name="moneytransfname" autofocus><br> <label>Enter
				UserAccountNo : </label><br> <input type="text" name="moneytransfaccno" pattern = "[0-9]{11}" title = "Enter valid Account no"><br>
			<label>Enter Amount : </label><br> <input type="text"
				name="moneytransfamount" required
			pattern="[1-9][0-9]+[0]" minlength = "3" maxlength="7" title="Enter Valid Amount"><br>
			<button type="submit" id="formbt">Submit</button>
		</form>
	</fieldset>
	<form action="Welcomepage.jsp">
		<button type="submit" id="homebt">Home</button>
	</form>
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
			window.location.assign("Login.html");
		}
	},1000);
	
});



</script>
</html>