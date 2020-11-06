<html>

<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

	<script src="https://kit.fontawesome.com/550c1e8106.js" crossorigin="anonymous"></script>
	<title>Registration Form</title>


</head>


<body class="hold-transition register-page">
	<div class="register-box">
		<div class="card card-outline card-primary">
			<div class="card-header text-center">
				<a href="../../index2.html" class="h1"><b>POC</b>WORK</a>
			</div>
			<div class="card-body required">
				<p class="login-box-msg">Register a new membership</p>

				<form action="REGISTER">
					<div class="input-group mb-3">
						<input type="text" class="form-control " name="Full_Name" placeholder="Full name" required>
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-user"></span>
							</div>
						</div>
					</div>
					<div class="input-group mb-3">
						<input type="email" class="form-control" name="Email_Id" placeholder="Email" required>
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-envelope"></span>
							</div>
						</div>
					</div>
					<div class="input-group mb-3">
						<input type="text" class="form-control" name = "Mobile_Number" placeholder="Mobile Number" required>
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-mobile"></span>
							</div>
						</div>
					</div>
					<div class="input-group mb-3">
						<input type="date" class="form-control" name="DOB">
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-calendar-times"></span>
							</div>
						</div>
					</div>
					<div>
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<div class="input-group-text">
									<input type="radio" id="male" name="gender" value="1">
									<label for="male"><i class="fa fa-male" aria-hidden="true"></i> Male </label><br>
									<input type="radio" id="female" name="gender" value="2">
									<label for="female"><i class="fa fa-female" aria-hidden="true"></i> Female
									</label><br>

								</div>
							</div>
						</div>
						<div class="input-group mb-3">
							<input type="text" class="form-control" placeholder="Address" name="Address">
							<div class="input-group-append">
								<div class="input-group-text">
									<span class="fa fa-address-card"></span>
								</div>
							</div>
						</div>
						<div class="input-group mb-3">
							<input type="text" class="form-control" placeholder="City" name="City">
							<div class="input-group-append">
								<div class="input-group-text">
									<span class="fas fa-city"></span>
								</div>
							</div>
						</div>
						<div class="input-group mb-3">
							<input type="text" class="form-control" placeholder="Pin Code" name="Pin_Code" required>
							<div class="input-group-append">
								<div class="input-group-text">
									<span class="fa fa-university"></span>
								</div>
							</div>
						</div>
						<div class="input-group mb-3">
							<input type="text" class="form-control" placeholder="State" name="State" required>
							<div class="input-group-append">
								<div class="input-group-text">
									<span class="fa fa-university"></span>
								</div>
							</div>
						</div>
						<div class="input-group mb-3">
							<input type="text" name="Country" value="India" readonly="readonly" />
							<div class="input-group-append">
								<div class="input-group-text">
									<span class="fas fa-rupee-sign"></span>
								</div>
							</div>
						</div>
						<div class="input-group mb-3">
							<input type="password" class="form-control" placeholder="Password" name="pwd" required>
							<div class="input-group-append">
								<div class="input-group-text">
									<span class="fas fa-lock"></span>
								</div>
							</div>
						</div>
						<div class="input-group mb-3">
							<input type="password" class="form-control" placeholder="Retype password" name="conf_pwd" required>
							<div class="input-group-append">
								<div class="input-group-text">
									<span class="fas fa-lock"></span>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-8">
								<div class="icheck-primary">
									<input type="checkbox" id="agreeTerms" name="terms" value="agree">
									<label for="agreeTerms">
										I agree to the <a href="#">terms</a>
									</label>
								</div>
							</div>
							<!-- /.col -->
							<div class="col-4">
								<button type="submit" class="btn btn-primary btn-block">Register</button>
							</div>
							<!-- /.col -->
						</div>
				</form>



				<a href="Login.jsp" class="text-center">I already have a membership</a>
			</div>
			<!-- /.form-box -->
		</div><!-- /.card -->
	</div>
	<!-- /.register-box -->

</body>

</html>
