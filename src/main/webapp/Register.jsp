<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "com.atm.controller.*"%>
<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel = "icon" type = "" href = "Assets/sbi-logo-33234.png">
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<div id="bgBlur"></div>
<title>Register User</title>
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
 width:500px;
}
.form-control
{
   width:340px;
}
#fieldreg {
	position: absolute;
	width: 400px;
	top: 50px;
	border-color: blue;
	left: 450px;
	padding: 20px;	
}

input {
	width: 250px;
	height: 30px;
	position: relative;
	margin-left: 110px;
}

legend {
	font-size: 30px;
	color: blue;
}

#reglab {
	font-size: 20px;
	position: relative;
	top: -280px;
	left: 400px;
	color: red;
	visibility: hidden;
}

label {
	font-size: 20px;
	color:white;
}
body{

background-image: url("https://scontent.fmaa12-2.fna.fbcdn.net/v/t31.18172-8/22051279_1623705757680216_2725610580980024577_o.jpg?_nc_cat=111&ccb=1-5&_nc_sid=9267fe&_nc_ohc=rQNE9RPtZRwAX-mhcc2&_nc_ht=scontent.fmaa12-2.fna&oh=00_AT8DZmZcWuSx5EuS6yKVIyni07maX40Fdj558GuUd-6Ayg&oe=61FBF9C7");
background-repeat: no-repeat;
background-size:cover;	
}
legend
{
  color:white;
}
#regbt{
position : absolute;
top: 460px;
left:180px;
width:140px;
height:40px;
border-radius: 5px;
}
#regbt:hover{
background-color:black;
color:white;
}

#resbt{
position : absolute;
top: 460px;
left:330px;
width:140px;
height:40px;
border-radius: 5px;
}
#resbt:hover{
background-color:black;
color:white;
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
<body bgcolor="grey">
	<c:if test="${admin == null}">
	<c:redirect url="index.jsp"></c:redirect>
	</c:if>
<div class="container mt-1">
	<fieldset id="fieldreg">
		<legend>Register User</legend>

		<form action="registersucc" method="post" id="regform"
			onsubmit="return cnfpass()" autocomplete="off" class = "was-validated">
			<label class="form-label">Enter User Name : </label><br> <input type="text"
				name="userreg" placeholder="Abcd9" class="form-control" pattern="[A-Z][a-zA-Z]{3,20}"
				title="Start with A-Z and use A-Z or a-z or 0-9 minimum 3 character maximum 20 character"
				id="userid" required>
				
				 <label class="form-label">Enter
				Password : </label><br> <input type="password" class="form-control" name="passreg"
				placeholder="abcd@89" pattern="[A-Za-z0-9!@#$%^&*_+=-~`/|\]{6,20}"
				minlength="6" onclick="invalabfn()"
				title="minimum 6 character and special characters allowed"
				id="passid" required>
				
				<label class="form-label">Confirm
				Password : </label><br> <input type="password"  class="form-control" name="cnfpassreg"
				placeholder="abcd@89" pattern="[A-Za-z0-9!@#$%^&*_+=-~`/|\]{6,20}"
				minlength="6" onclick="invalabfn()"
				title="minimum 6 character and special characters allowed"
				id="cnfpassid" required><label class="form-label">Role
				: </label><br> <input type="text" name="rolereg" class="form-control" id="roleregid"
				placeholder="user,admin,agent" pattern="[a-z]{4,5}"
				title="use a-z for role" required>
			<label class="form-label">Mob_no : </label><br> <input type="text" name="mobnoreg"
				id="mobnoregid" placeholder="mobile number" class="form-control" pattern="[6-9][0-9]{9}"
				title="Enter 10 digit mobile number" required><br> <br>
			<br> <label id="reglab">Password Must Be Same</label>
			<button id="regbt" type="submit" class="btn btn-primary">Register</button>
			&ensp;&ensp;&ensp;&ensp;
			<button id="resbt" type="reset" class="btn btn-primary">Reset</button>
		</form>
	</fieldset>
	</div>
</body>
<script>
	let pass1 = document.getElementById("passid");
	let pass2 = document.getElementById("cnfpassid");
	let reglab = document.getElementById("reglab");
	function cnfpass() {
		if (pass1.value != pass2.value) {
			pass1.style.borderBlockColor = "red";
			pass2.style.borderBlockColor = "red";
			reglab.style.visibility = "visible";
			return false;
		}
		return true;
	}
	
	//hide pssword must be same label:
		function invalabfn() {
		let invallab = document.getElementById("reglab");
		invallab.style.visibility = "hidden";
	}
</script>
</html>