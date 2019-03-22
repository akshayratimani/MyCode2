<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style type="text/css">
.checked {
	color: orange;
}
</style>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="https://use.typekit.net/ifg4gvk.css">
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
<title>E-kart</title>
</head>
<body>

	<div class="container-fluid"
		style="height: 75px; background-color: #283747">
		<font color=White size="6" face="MERRIWEATHER"> <label
			style="position: absolute; bottom: 725px; left: 25px;">E-Kart</label></font>
		<span
			style="display: inline-block; height: 20px; width: 20px; background-color: #CA3C3C; border-width: 0px; border-style: groove; position: absolute; bottom: 760px; left: 1300px;"><font
			color="White" size="2px"><b><center>0</center></b></font></span><a href="/login"
			class="btn btn-default"
			style="background-color: #B7950B; position: absolute; bottom: 735px; left: 1350px;">Login</a>
		<div style="position: absolute; bottom: 735px; left: 250px;">
			<form class="form-inline md-form mr-auto mb-4">
				<input class="form-control mr-sm-2" type="text" placeholder="Search"
					aria-label="Search" style="width: 275px">
				<button class="btn aqua-gradient btn-rounded btn-sm my-0"
					type="submit">Search</button>
			</form>
		</div>
	</div>

	<img style="position: absolute; bottom: 725px; left: 1260px;"
		height="55px" width="55px" alt="Not found"
		src="resources/images/carticon.png">