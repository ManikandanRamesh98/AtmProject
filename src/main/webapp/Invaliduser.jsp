<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
h1{
color:yellow;
position : absolute;
top : 200px;
left : 430px;
font-size:40px;
}
button{
position: absolute;
top:300px;
width:70px;
height:50px;
left:630px;
}
#timehead{
position : absolute;
color:black;
left:0px;
top:0px;

}

</style>
</head>
<body bgcolor = "blue">
	<h1>Invalid Username or password</h1>
	<form action="Login.html">
		<button type="submit">Login</button>
	</form>
	<h1 id = "timehead">00:00</h1>
</body>

<script>
let th = document.getElementById("timehead");
let time = 5;
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