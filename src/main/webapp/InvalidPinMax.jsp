<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel = "icon" type = "" href = "Assets/sbi-logo-33234.png">
<meta charset="ISO-8859-1">
<div id="bgBlur"></div>
<title>Insert title here</title>
<style type="text/css">
*{
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial,Helvetica,sans-serif;	
}
h1,h2{
color:#F5DF4D;
position: absolute;
top:270px;
left:280px;
font-size:50px;
}
h2{
position: absolute;
top: 340px;
left : 550px;
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
#timehead{
position : absolute;
left:0dpx;
top:0px;
color:black;
font-size : 20px;
}

</style>
</head>
<body>


	
<h1>Account Is Locked Try After 2 Minutes!!</h1>
<h2>Contact Branch</h2>
<h1 id = "timehead">00:00</h1>
</body>

<script>
let th = document.getElementById("timehead");
let time = 4;
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
			if(localStorage.getItem("invalmax") == null){
			localStorage.removeItem("invalmax");
			localStorage.setItem("invalmax",1);
			clearInterval(i);
			window.location.assign("Logout.jsp");
			}else{
				clearInterval(i);
				window.location.assign("index.jsp");
			}
		}
	},1000);
	
});

</script>
</html>