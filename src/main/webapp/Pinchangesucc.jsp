<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pin change Success</title>
<style>
h1{
color:yellow;
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

</style>
</head>
<body bgcolor = "blue">
	<h1>Pin Changed Successfully!!</h1>
<h1 id = "timehead">00:00</h1>
</body>

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
			window.location.assign("Login.html");
		}
	},1000);
	
});
</script>
</html>