<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
String error = ""; 
error = request.getParameter("error");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>AdminLTE 3 | Forgot Username</title>
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Font Awesome -->
<link rel="stylesheet" href="/css/all.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- icheck bootstrap -->
<link rel="stylesheet" href="css/icheck-bootstrap.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="css/adminlte.min.css">
<script src="https://kit.fontawesome.com/550c1e8106.js"
	crossorigin="anonymous"></script>
<!-- Google Font: Source Sans Pro -->
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700"
	rel="stylesheet">
<script
	src="chrome-extension://mooikfkahbdckldjjndioackbalphokd/assets/prompt.js"></script>
</head>
<body class="login-page" style="min-height: 348.8px;">
	<div class="login-box">
		<div class="login-logo">
			<a href="#"><b>Tech</b>BEE</a>
		</div>
		<!-- /.login-logo -->
		<div class="card">
			<div class="card-body login-card-body">
				<p class="login-box-msg">You forgot your Email? Just Enter Your
					Phone Number.</p>

				<form action="forgetServlet" method="post">
					<div class="input-group mb-3">
						<input type="tel" class="form-control" placeholder="Phone Number"
							name="mobile_number" maxlength="10" minlength="10">
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-envelope"></span>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-12">
							<button type="submit" class="btn btn-primary btn-block">Know
								Your Email</button>
						</div>
						<!-- /.col -->
					</div>
				</form>
				<% 
      if(error!=null){
	  if(error.equals("mobile_number_invalid")){
    		out.println("<p style='color:red; margin-top:10px; text-align:center; font-size:15px'>Sorry!! This mobile number is not in our records.</p>");
    	  }
    }
      %>
				<div style="text-align: center">
					<p class="mt-3 mb-1">
						<a href="Login.jsp">Login</a>
					</p>
					<p class="mb-0">
						<a href="Registeration_Form.html" class="text-center">Register
							a new Account</a>
					</p>
				</div>
			</div>
			<!-- /.login-card-body -->
		</div>
	</div>
	<!-- /.login-box -->

	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- Bootstrap 4 -->
	<script src="js/bootstrap.bundle.min.js"></script>
	<!-- AdminLTE App -->
	<script src="/js/adminlte.min.js"></script>



</body>
</html>
</html>