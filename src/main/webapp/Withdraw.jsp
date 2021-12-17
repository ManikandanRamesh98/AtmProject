<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Withdraw</title>
<style>
#headwith{
position:absolute;
left:600px;
font-size:40px;
}
#formwith{
position:relative;
float:right;
top:350px;
font-size:40px;
}
#labwith{
color:yellow;
font-size:70px;
position:absolute;
top:150px;
left:320px;
}
#withinp{
width:200px;
height:40px;
}
#withbt{

}

</style>
</head>
<body bgcolor = "blue">
<%!String user; %>

<% 

if(session.getAttribute("user") == null){
	response.sendRedirect("Login.html");
}else{
 user = session.getAttribute("user").toString();
}
%>
<h1 id = "headwith">Welcome&ensp;<%= user %></h1>
<label id ="labwith">Enter Amount To Withdraw</label>
<form action = "withdrawserv" id = "formwith">
<br>
<input type = "text" name = "inpwith" id = "withinp" required pattern = "[0-9]{3,7}" maxlength = "7" title = "Enter Valid Amount"><button type = "submit" id = "withbt" >Withdraw</button>
</form>
</body>
</html>