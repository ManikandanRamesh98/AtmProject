<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agent registered sucessfully</title>
</head>
<body>
<%!String agent;
	String reguser;%>
	<%
	if (session.getAttribute("agent") != null) {
		agent = session.getAttribute("agent").toString();
	} else {
		response.sendRedirect("index.jsp");
	}
	reguser = session.getAttribute("agentreg").toString();
	%>
	<h1>
		Agent
		<%=" " + reguser + " "%>
		Sucessfully Registered!!
	</h1>
<h2 id = "timehead">00:00</h2>
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
			clearInterval(i);
			window.location.assign("index.jsp");
		}
	},1000);
	
});



</script>
</html>