<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel = "icon" type = "" href = "Assets/sbi-logo-33234.png">
<meta charset="ISO-8859-1">
<title>Atm out of Cash</title>
<style>
h1{
position : absolute;
font-size : 70px;
color:yellow;
top:140px;
left:600px;
}
h2{
position : absolute;
font-size : 80px;
color:yellow;
top:220px;
left:400px;
}
#timehead{
font-size: 38px;
}
</style>
</head>
<body bgcolor = "blue">
	<%!String user; %>

	<% 
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
if(session.getAttribute("user") == null){
	response.sendRedirect("Login.html");
}else{
 user = session.getAttribute("user").toString();
}
%>
<h1>Sorry!&#128531;</h1>	
<h2>ATM OUT OF CASH</h2>
<label id = "timehead">00:00</label>
</body>
<script>

let th = document.getElementById("timehead");
let time = 5;
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