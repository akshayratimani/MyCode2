<!DOCTYPE html>
<html lang="en">

<head>


<style>
/* Style all input fields */
input {
	width: 100%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	margin-top: 6px;
	margin-bottom: 16px;
}

/* Style the submit button */
input[type=submit] {
	background-color: #4CAF50;
	color: white;
}

/* Style the container for inputs */
.container {
	background-color: #f1f1f1;
	padding: 20px;
}

/* The message box is shown when the user clicks on the password field */
#message {
	color: #000;
	position: relative;
	padding: 5px;
	margin-top: 3px;
}

#message p {
	padding: 3px 35px;
	font-size: 12px;
}

/* Add a green text color and a checkmark when the requirements are right */
.valid {
	color: green;
}

.valid:before {
	position: relative;
	left: -35px;
	content: "";
}

/* Add a red text color and an "x" when the requirements are wrong */
.invalid {
	color: red;
}

.invalid:before {
	position: relative;
	left: -35px;
	content: "";
}
</style>


<!-- Required meta tags-->
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Colorlib Templates">
<meta name="author" content="Colorlib">
<meta name="keywords" content="Colorlib Templates">

<!-- Title Page-->
<title>SigunUp</title>

<!-- Icons font CSS-->
<link
	href="resources/vendor/mdi-font/css/material-design-iconic-font.min.css"
	rel="stylesheet" media="all">
<link href="resources/vendor/font-awesome-4.7/css/font-awesome.min.css"
	rel="stylesheet" media="all">
<!-- Font special for pages-->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i"
	rel="stylesheet">

<!-- Vendor CSS-->
<link href="resources/vendor/select2/select2.min.css" rel="stylesheet"
	media="all">
<link href="resources/vendor/datepicker/daterangepicker.css"
	rel="stylesheet" media="all">

<!-- Main CSS-->
<link href="resources/css/main.css" rel="stylesheet" media="all">
</head>

<body>
	<div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
		<div class="wrapper wrapper--w790">
			<div class="card card-5">
				<div class="card-heading">
					<h2 class="title">Registration Form</h2>
				</div>
				<div class="card-body">
					<form method="POST">
						<div class="form-row m-b-55">
							<div class="name">Name</div>
							<div class="value">
								<div class="row row-space">
									<div class="col-2">
										<div class="input-group-desc">
											<input class="input--style-5" type="text" name="first_name"
												required> <label class="label--desc">first
												name</label>
										</div>
									</div>
									<div class="col-2">
										<div class="input-group-desc">
											<input class="input--style-5" type="text" name="last_name"
												required> <label class="label--desc">last
												name</label>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="form-row">
							<div class="name">Email</div>
							<div class="value">
								<div class="input-group">
									<input class="input--style-5" type="text" name="email"
										id="email" placeholder="xyz@domain.com"
										onblur="validateEmail()" required>
								</div>
							</div>
						</div>

						<div class="form-row m-b-55">
							<div class="name">Phone number</div>
							<div class="value">
								<div class="input-group">
									<input class="input--style-5" type="text" id="phno"
										name="phone" required>
								</div>
							</div>
						</div>
						<div class="form-row m-b-55">
							<div class="name">Password</div>
							<div class="value">
								<div class="input-group">
									<input class="input--style-5" type="password" name="password"
										id="psw" required> <label class="label--desc">
										<div id="message">
											<p id="letter" class="invalid">
												-> A <b>lowercase</b> letter
											</p>
											<p id="capital" class="invalid">
												-> A <b>capital (uppercase)</b> letter
											</p>
											<p id="number" class="invalid">
												-> A <b>number</b>
											</p>
											<p id="length" class="invalid">
												-> Minimum <b>8 characters</b>
											</p>
										</div>
									</label>
								</div>
							</div>
						</div>
						<br> <br> <br>

						<div class="form-row m-b-55">
							<div class="name">Re-enter Password</div>
							<div class="value">
								<div class="input-group">
									<input class="input--style-5" type="password" name="rpw"
										id="rpsw" required> <label class="label--desc">
										<div id="message">
											<p id="letter2" class="invalid">Password not matching</p>
										</div>

									</label>
								</div>
							</div>
						</div>

						<div>
							<button class="btn btn--radius-2 btn--red" onclick="fun()"
								type="submit">Register</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>


	<script>
		var myInput = document.getElementById("psw");
		var email = document.getElementById("email");
		var myInput2 = document.getElementById("rpsw")
		var letter = document.getElementById("letter");
		var capital = document.getElementById("capital");
		var number = document.getElementById("number");
		var length = document.getElementById("length");
		var letter2 = document.getElementById("letter2");
		var ph = document.getElementById("phno");

		function fun() {
			
			if(!validateEmail()){
				return;
			}if(!validatePhoneNumber()){
				return;
			}if(!matchPassword()){
				return;
			}

		}
		
		function matchPassword(){
			if (myInput.value == myInput2.value) {
				return(true);
			}
			
			alert("Password did not match");
			return (false);
		}
		
		
	/*	function validatePassword(){
			//var p = (?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}
			//^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).{6,12}$
			var p = (/^[a-zA-Z]/{8,}$);
			if(myInput.value.match(p)){
				console.log("hoi");
				return (true);
			}
				alert("Invalid Password.");
				return(false);	
			
		}*/

		function validateEmail() {
			if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/
					.test(email.value)) {
				return (true);
			}
			alert("Invalid or Empty email address!");
			return(false);

		}

		function validatePhoneNumber() {
			var phoneno = /^\d{10}$/;

			if (ph.value.match(phoneno)) {
				return (true);

			} else {
				alert("Invalid or Empty PhoneNumber");
				return (false);
			}
		}	

		
		
		myInput2.onkeyup = function() {
			if (myInput.value == myInput2.value) {
				letter2.innerHTML = "Password matching";
				letter2.className = "valid";

			} else {
				letter2.innerHTML = "Password not matching";
				letter2.className = "invalid";
			}
		}
		// When the user clicks on the password field, show the message box
		myInput.onfocus = function() {
			document.getElementById("message").style.display = "block";
		}

		// When the user clicks outside of the password field, hide the message box

		// When the user starts to type something inside the password field
		myInput.onkeyup = function() {
			// Validate lowercase letters
			var lowerCaseLetters = /[a-z]/g;
			if (myInput.value.match(lowerCaseLetters)) {
				letter.classList.remove("invalid");
				letter.classList.add("valid");
			} else {
				letter.classList.remove("valid");
				letter.classList.add("invalid");
			}

			// Validate capital letters
			var upperCaseLetters = /[A-Z]/g;
			if (myInput.value.match(upperCaseLetters)) {
				capital.classList.remove("invalid");
				capital.classList.add("valid");
			} else {
				capital.classList.remove("valid");
				capital.classList.add("invalid");
			}

			// Validate numbers
			var numbers = /[0-9]/g;
			if (myInput.value.match(numbers)) {
				number.classList.remove("invalid");
				number.classList.add("valid");
			} else {
				number.classList.remove("valid");
				number.classList.add("invalid");
			}

			// Validate length
			if (myInput.value.length >= 8) {
				length.classList.remove("invalid");
				length.classList.add("valid");
			} else {
				length.classList.remove("valid");
				length.classList.add("invalid");
			}
		}
	</script>


	<!-- Jquery JS-->
	<script src="resources/vendor/jquery/jquery.min.js"></script>
	<!-- Vendor JS-->
	<script src="resources/vendor/select2/select2.min.js"></script>
	<script src="resources/vendor/datepicker/moment.min.js"></script>
	<script src="resources/vendor/datepicker/daterangepicker.js"></script>

	<!-- Main JS-->
	<script src="resources/js/global.js"></script>

</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
<!-- end document-->