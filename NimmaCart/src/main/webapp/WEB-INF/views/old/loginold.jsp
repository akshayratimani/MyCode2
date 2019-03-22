<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>

	<div class="container-fluid" style="background-color: #41B3A3  ">
		<font color=#283747 size="7" face="Comic Sans MS"> 
			E-Kart
		</font> <a href="/signup" class="btn btn-default"
			style="font-color:white; background-color: #B7950B ; position: absolute; bottom: 740px; left: 1350px;"><font color="white">Register</font></a>
	</div>
	<center>
		<br>
		<br>
		<br>
		<div
			style="background-color: #41B3A3; border-style: inset; width: 40%">
			<center>
				<font color="#283747" face="cambria" size="6">SignIn</font>
			</center>
		</div>
		<br>
		<div
			style="background-color: #41B3A3; border-style: ridge; width: 40%">
			<br>

			<form action="/login" method="post">
				<font color="#283747" face="cambria"> <b>Username : <input
						type="text" name="un" required><br> <br>
						Password : <input type="password" name="pw" required><br>
						<br> <input style="color:white; background-color: #B7950B ;" type="submit" class="btn btn-default"
						value="login"><br></font>
			</form>
			<br>
		</div>
	</center>



</body>
</html>