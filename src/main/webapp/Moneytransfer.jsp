<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<div id="bgBlur"></div>
<title>Money Transfer</title>
<style>
*{
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial,Helvetica,sans-serif;	
}
fieldset {
	width: 500px;
	border-color: black;
	position: absolute;
	top: 90px;
	left: 400px;
	height: 400px;
	padding:20px;
}

legend {
	color: #F5DF4D;
	font-size: 40px;
}

label {
	font-size: 30px;
	color:white;
}

input {
	position: absolute;
	left: 240px;
	background-color: rgba(255,255,255,0.7);
	height: 40px;
	font-size: 217x;
	font-weight: bolder;
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
	background-color: #0072B5;
	top: 30px;
	width: 100px;
	height: 40px;
	left: 170px;
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
#moneytransfname{
position: relative;

}
#moneytransfaccno{
position: relative;
}
#moneytransfamount{
position: relative;
}
button:hover{
	box-shadow: 0 0 20px white;
	transition-duration: 0.2s;
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
			<label>Enter UserName : </label><br> <input type="text" id = "moneytransfname"
				name="moneytransfname" autofocus><br> <label>Enter
				UserAccountNo : </label><br> <input type="text" id = "moneytransfaccno" name="moneytransfaccno" pattern = "[0-9]{11}" title = "Enter valid Account no"><br>
			<label>Enter Amount : </label><br> <input type="text" id = "moneytransfamount"
				name="moneytransfamount" required
			pattern="[1-9][0-9]*[0][0]" minlength = "3" maxlength="7" title="Enter Valid Amount"><br>
			<button type="submit" id="formbt">TRANSFER</button>
		</form>
	</fieldset>
	<form action="Welcomepage.jsp">
		<button type="submit" id="homebt">Home</button>
	</form>
<h1 id = "timehead">00:00</h1>
</body>

<script>
let th = document.getElementById("timehead");
let time = 80;
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