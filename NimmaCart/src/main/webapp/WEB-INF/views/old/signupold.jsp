<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<script>
		function validateNum() {
			var x, text;
			console.log("Akshay");

			x.document.getElementById("num").value();

			if (isNaN(x)) {
				alert("PhoneNumber Invalid..!");
			}
			
		}
	</script>

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>

	

	<div class="container-fluid" style="background-color: #41B3A3">
		<font color=#283747 size="7" face="Comic Sans MS"> E-Kart </font>
	</div>
	<center>
		<br> <br> <br>
		<div
			style="background-color: #41B3A3; border-style: inset; width: 40%">
			<center>
				<font color="#283747" face="cambria" size="6">SignUp</font>
			</center>
		</div>
		<br>
		<div
			style="background-color: #41B3A3; border-style: ridge; width: 40%">
			<br><button onclick="validateNum()">asdfwaf</button>

			<form action="/signup" method="post">
				<font color="#283747" face="cambria"> <b>FirstName : <input
						type="text" name="fn" required><br> <br>
						LastName : <input type="text" name="ln" required><br>
					<br> Phone number : <input type="text" id="num" name="pn" onblur="validateNum()" required><br>
					<br> Email - Id : <input type="text" name="email" required><br>
					<br> Password : <input type="password" name="pw" required><br>
					<br> Re-Enter Password : <input type="password" name="rpw"
						required><br> <br> <input
						style="color: white; background-color: #B7950B;" type="submit"
						class="btn btn-default" value="SignUp"><br></font>
						
						
						
			</form>
			<br>
		</div>
	</center>




</body>
</html>