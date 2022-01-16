<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel = "icon" type = "" href = "Assets/sbi-logo-33234.png">
<meta charset="ISO-8859-1">
<div id="bgBlur"></div>
<title>Pin change Success</title>
<style>
*{
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial,Helvetica,sans-serif;	
}
h1{
color:#F5DF4D;
font-size:60px;
position: absolute;
top:200px;
left:330px;
}
#timehead{
color:black;
position:absolute;
left:0px;
top:0px;

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
</style>
</head>
<body bgcolor = "blue">
	<h1>Pin Changed Successfully!!</h1>
<h1 id = "timehead">00:00</h1>
</body>
	<%!String user; %>

	<% 
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
if(session.getAttribute("user") == null){
	response.sendRedirect("index.jsp");
}else{
 user = session.getAttribute("user").toString();
}
%>
<script>
let th = document.getElementById("timehead");
let time = 3;
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