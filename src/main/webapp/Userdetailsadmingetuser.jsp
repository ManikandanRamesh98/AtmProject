<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel = "icon" type = "" href = "Assets/sbi-logo-33234.png">
<meta charset="ISO-8859-1">
<div id="bgBlur"></div>
<title>User Details - Admin</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<style>
*{
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial,Helvetica,sans-serif;	
}
form
{
   border:3px solid #f1f1f1;
   padding:10px;
   width:350px;
   margin-left:auto;
   margin-right:auto;
   height:200px;
}
h1
{
 color:#f1f1f1;
 position:absolute;
 top:150px;
 left:400px;
}
h4
{
  color:#f1f1f1;
}

form {
	position:absolute;
	top: 200px;
	left:400px;
}
body{
background-image: url("https://scontent.fmaa12-2.fna.fbcdn.net/v/t31.18172-8/22051279_1623705757680216_2725610580980024577_o.jpg?_nc_cat=111&ccb=1-5&_nc_sid=9267fe&_nc_ohc=rQNE9RPtZRwAX-mhcc2&_nc_ht=scontent.fmaa12-2.fna&oh=00_AT8DZmZcWuSx5EuS6yKVIyni07maX40Fdj558GuUd-6Ayg&oe=61FBF9C7");
background-repeat: no-repeat;
background-size:cover;	
}
#subid{
position: absolute;
top:170px;
width:80px;
height: 40px;
right : 110px;
}
.form-control
{
  width:300px;
}
#subid:hover {
	background-color: black;
	color:white;
}
#usernameinp:hover {
	color:white;
	background-color: black;
}
#bgBlur{
	position: absolute;
	background-color: rgba(11, 11, 11, 0.6);
	height: 625px;
	width: 1366px;
}
input:hover{
	box-shadow: 0 0 20px blue;
	transition-duration: 0.2s;
}
button:hover{
	box-shadow: 0 0 20px blue;
	transition-duration: 0.2s;
}
</style>
</head>
<body bgcolor="#363945">
	<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	if (session.getAttribute("admin") != null) {
		String admin = session.getAttribute("admin").toString();
	} else {
		response.sendRedirect("index.jsp");
	}
	%>
		<h1>User Details : </h1>
		<form action="Userdetailadmin.jsp">
			<h4>Enter Username : </h4><br> <input type="text"
				name="userdetadmin" class="form-control"  pattern="[A-Z][a-zA-Z]{3,20}"
				title="Start with A-Z and use A-Z or a-z or 0-9 minimum 3 character maximum 20 character" id = "usernameinp" autofocus>
		<div class="container mt-4">		
			<button type="submit" class="btn btn-primary">Submit</button>
			</div>
		</form>
</body>
</html>