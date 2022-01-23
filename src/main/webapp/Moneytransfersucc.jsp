<%@page import="com.atm.daoimpl.UserProfileImpl"%>
<%@page import="com.atm.models.UserProfileModel"%>
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
<title>Money Transfer Success!!</title>
<style>
*{
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial,Helvetica,sans-serif;	
}
h1{
position : absolute;
font-size:60px;
top:50px;

}
label{
position : absolute;
color:yellow;
font-size:80px;
top:280px;
left:400px;
}
button{
width:80px;
height:50px;
background-color:red;
float:right;
border-radius:10px;
}
#timehead{
position : absolute;
top : 0px;
left : 0px;
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
#succhead{
color:white;
}
</style>
</head>
<body bgcolor = "blue">
<c:if test="${user == null}">
	<c:redirect url="index.jsp"></c:redirect>
	</c:if>

<h1 id = "succhead">You Have Successfully Transfered ${moneytransfamount} to ${moneytransfname}</h1>
<label>Your Balance is ${userbalint}</label>
<form action = "Welcomepage.jsp">
<button type = "submit">Home</button>
</form>
<h1 id = "timehead">00:00</h1>
</body>

<script>
let th = document.getElementById("timehead");
let time = 10;
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