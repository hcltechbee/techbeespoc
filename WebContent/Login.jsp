<%-- 
    Document   : Loginl.jsp
    Created on : Oct 30, 2020, 12:58:19 PM
    Author     : DEVIL
--%>

<%@page import="com.constants.UIConstants"%>
<%@page import="com.constants.URLConstants"%>
<%@page import="java.io.PrintWriter"%>
<%
	PrintWriter write = response.getWriter();
	String Email = "";
	Email = request.getParameter(com.constants.UIConstants.LOGIN_EMAIL);
	String success = "";
	success = request.getParameter(com.constants.UIConstants.LOGIN_SUCCESS);
	String error = "";
	if(success != null){
	if(success.equals("true")){
		response.sendRedirect(URLConstants.HOME_PAGE_URL);
	}
	}
	
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Techbees | Home</title>

<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<!-- Font Awesome -->
<link rel="stylesheet" href="./css/all.min.css">
<!-- icheck bootstrap -->
<link rel="stylesheet" href="./css/icheck-bootstrap.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="./css/adminlte.min.css">
<script src="https://kit.fontawesome.com/550c1e8106.js"
	crossorigin="anonymous"></script>
</head>
<body class="hold-transition login-page">
	<div class="login-box">
		<div class="login-logo">
			<a href="../../index2.html"><b>Techbees</b></a>
		</div>
		<!-- /.login-logo -->
		<div class="card">
			<div class="card-body login-card-body">
				<p class="login-box-msg">Sign in</p>

				<form action="loginServlet" method="post">
					<div class="input-group mb-3">
						<input type="email" name="Email" id="email" class="form-control"
							placeholder="Email" onChange="checkInput()">
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-envelope"></span>
							</div>
						</div>
					</div>
					<div class="input-group mb-3">
						<input type="password" id="pass" name="Password"
							class="form-control" placeholder="Password"
							onChange="checkInput()" minlength="8">
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-lock"></span>
							</div>
						</div>
					</div>
					<!-- /.col -->
					<div class="col-12" style="text-align: center;">
						<button type="submit" class="btn btn-primary btn-block"
							id="submitbtn">Sign In</button>
					</div>
					<!-- /.col -->
			</div>
			</form>

			<% 
      out.println("<div style='text-align:center'>");
      	if(Email != null){
      		out.println("<h6>Your Email is : " + Email + "</h6>");
      	}
      	else if(success != null){
    	  if(success.equals("false")){
    		out.println("<h6 style='color:red;'>Sorry!! You have entered an Incorrect password.</h6>");
    	  }
    	  else if(success.equals(com.constants.UIConstants.LOGIN_USERNAME_INCORRECT)){
    		  out.println("<h6 style='color:red;'>Sorry!! User with this email doesn't exist.</h6>");  
    	  }
    	}
      out.println("</div>");
      %>

			<!-- /.social-auth-links -->

			<p class="mb-1" style="margin: 0 auto;">
				<a href="forgot.jsp">Forgot Username</a>
			</p>
			<p class="mb-0" style="margin: 0 auto; margin-bottom: 10px;">
				<a href="Registeration_Form.html" class="text-center">Create New
					Account</a>
			</p>
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
	<script src="js/adminlte.min.js"></script>

	<script>
	let loginBtn = document.getElementById("submitbtn");
	let emailInput = document.getElementById("email");
	let passInput = document.getElementById("pass");
	loginBtn.disabled = true;
	function checkInput(){
		passInput = document.getElementById("pass").value;
		emailInput = document.getElementById("email").value;
		if(!emailInput || !passInput){
			loginBtn.disabled = true;
			
			console.log("locked");
		}
		else{
			loginBtn.disabled = false;
			console.log("open");
		}
	}
</script>

</body>
</html>

