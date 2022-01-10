<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Register</title>
</head>
<body>
	<%!String user;
	String reguser;%>
	<%
	if (session.getAttribute("admin") != null) {
		user = session.getAttribute("admin").toString();
	} else {
		response.sendRedirect("index.jsp");
	}
	reguser = session.getAttribute("adminreg").toString();
	%>
	<h1>
		Admin
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