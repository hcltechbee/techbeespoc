<%-- 
    Document   : Loginl.jsp
    Created on : Oct 30, 2020, 12:58:19 PM
    Author     : DEVIL
--%>

<%@page import="java.io.PrintWriter"%>
<%
	PrintWriter write = response.getWriter();
	String success = "";
	success = request.getParameter("success");
	String error = "";
	if(success != null){
	if(success.equals("false")){
		error = "Sorry!! details you have entered is incorrect";
	}
	if(success.equals("true")){
		response.sendRedirect("https://localhost:8080/User_Management_POC/home.jsp");
		request.getSession();
		System.out.println(session.getAttribute("name"));
	}
	else if(success.equals("username_incorrect")){
		System.out.println(success);	}
	else{
		System.out.println(success);
	}
	}
	
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>AdminLTE 3 | Log in</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="./css/all.min.css">
  <!-- icheck bootstrap -->
  <link rel="stylesheet" href="./css/icheck-bootstrap.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="./css/adminlte.min.css">
</head>
<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
    <a href="../../index2.html"><b>Admin</b>LTE</a>
  </div>
  <!-- /.login-logo -->
  <div class="card">
    <div class="card-body login-card-body">
      <p class="login-box-msg">Sign in to start your session</p>

      <form action="loginServlet" method="post">
        <div class="input-group mb-3">
          <input type="email" name="Email" id="email" class="form-control" placeholder="Email" onChange = "checkInput()">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-envelope"></span>
            </div>
          </div>
        </div>
        <div class="input-group mb-3">
          <input type="password" id="pass" name="Password" class="form-control" placeholder="Password" onChange = "checkInput()">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-8">
            <div class="icheck-primary">
              <input type="checkbox" id="remember">
              <label for="remember">
                Remember Me
              </label>
            </div>
          </div>
          <!-- /.col -->
          <div class="col-4">
            <button type="submit" class="btn btn-primary btn-block" id="submitbtn">Sign In</button>
          </div>
          <!-- /.col -->
        </div>
      </form>

      <div class="social-auth-links text-center mb-3">
        <p>- OR -</p>
        <a href="#" class="btn btn-block btn-primary">
          <i class="fab fa-facebook mr-2"></i> Sign in using Facebook
        </a>
        <a href="#" class="btn btn-block btn-danger">
          <i class="fab fa-google-plus mr-2"></i> Sign in using Google+
        </a>
      </div>
      <!-- /.social-auth-links -->

      <p class="mb-1">
        <a href="forgot-password.html">I forgot my password</a>
      </p>
      <p class="mb-0">
        <a href="register.html" class="text-center">Register a new membership</a>
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
		console.log(emailInput)
		console.log(passInput)
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

<!-- <!DOCTYPE html> -->
<!-- <html lang="en"> -->
<!-- <head> -->
<!-- 	<title>Login V1</title> -->
<!-- 	<meta charset="UTF-8"> -->
<!-- 	<meta name="viewport" content="width=device-width, initial-scale=1"> -->

<!-- <!--===============================================================================================--> 
<!-- 	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous"> -->
<!-- <!--===============================================================================================-->	
<!-- 	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/> -->
<!-- <!--===============================================================================================--> 
<!-- 	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css"> -->
<!-- <!--===============================================================================================--> 
<!-- 	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css"> -->
<!-- <!--===============================================================================================--> 
<!-- 	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css"> -->
<!-- <!--===============================================================================================-->	
<!-- 	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css"> -->
<!-- <!--===============================================================================================--> 
<!-- 	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css"> -->
<!-- <!--===============================================================================================--> 
<!-- 	<link rel="stylesheet" type="text/css" href="css/util.css"> -->
<!-- 	<link rel="stylesheet" type="text/css" href="css/main.css"> -->
<!-- <!--===============================================================================================--> 
<!-- </head> -->
<!-- <body> -->
	
<!-- 	<div class="limiter"> -->
<!-- 		<div class="container-login100"> -->
<!-- 			<div class="wrap-login100"> -->
<!-- 				<div class="login100-pic js-tilt" data-tilt> -->
<!-- 					<img src="images/img-01.png" alt="IMG"> -->
<!-- 				</div> -->

<!-- 				<form class="login100-form validate-form" action="loginServlet" method="POST"> -->
<!-- 					<span class="login100-form-title"> -->
<!-- 						Member Login -->
<!-- 					</span> -->

<!-- 					<div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz"> -->
<!-- 						<input class="input100" type="email" name="Email" placeholder="Email"> -->
<!-- 						<span class="focus-input100"></span> -->
<!-- 						<span class="symbol-input100"> -->
<!-- 							<i class="fa fa-envelope" aria-hidden="true"></i> -->
<!-- 						</span> -->
<!-- 					</div> -->

<!-- 					<div class="wrap-input100 validate-input" data-validate = "Password is required"> -->
<!-- 						<input class="input100" type="password" name="Password" placeholder="Password"> -->
<!-- 						<span class="focus-input100"></span> -->
<!-- 						<span class="symbol-input100"> -->
<!-- 							<i class="fa fa-lock" aria-hidden="true"></i> -->
<!-- 						</span> -->
<!-- 					</div> -->
<%-- 					<% if(success != null) --%>
<!-- { -->
<!-- // 						if(success.equals("username_incorrect")) -->
<!-- // 						{ -->
<!-- // 							out.println("<p class='alert alert-danger'> <strong>sorry!!</strong> The username you have entered is incorrect </p>"); -->
<!-- // 						} -->
<!-- // 					if(success.equals("false")) -->
<!-- // 					{ -->
<!-- // 						out.println("<p class='alert alert-danger'> <strong>sorry!!</strong> The password you have entered is incorrect</p>"); -->
<!-- // 					} -->
<!-- // 					} -->
<%-- 					%> --%>
					
<!-- 					<div class="container-login100-form-btn"> -->
<!-- 						<button class="login100-form-btn"> -->
<!-- 							Login -->
<!-- 						</button> -->
<!-- 					</div> -->

<!-- 					<div class="text-center p-t-12"> -->
<!-- 						<span class="txt1"> -->
<!-- 							Forgot -->
<!-- 						</span> -->
<!-- 						<button class="link"  type="button" data-toggle="modal" data-target="#forgotPassModal"> -->
<!-- 							email/ -->
<!-- 						</button> -->
<!-- 						<button class="link"  type="button" data-toggle="modal" data-target="#forgotPassModal"> -->
<!-- 							Password? -->
<!-- 						</button> -->
<!-- 					</div> -->

<!-- 					<div class="text-center p-t-136"> -->
<!-- 						<a class="txt2" href="#"> -->
<!-- 							Create your Account -->
<!-- 							<i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i> -->
<!-- 						</a> -->
<!-- 					</div> -->
<!-- 				</form> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
	
	

	
<!-- <!--===============================================================================================-->	 
<%-- 	<script src="${pageContext.request.contextPath}/vendor/jquery/jquery-3.2.1.min.js"></script> --%>
<!-- <!--===============================================================================================--> 
<%-- 	<script src="${pageContext.request.contextPath}/vendor/bootstrap/js/popper.js"></script> --%>
<%-- 	<script src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.min.js"></script> --%>
<!-- <!--===============================================================================================--> 
<%-- 	<script src="${pageContext.request.contextPath}/vendor/select2/select2.min.js"></script> --%>
<!-- <!--===============================================================================================--> 
<%-- 	<script src="${pageContext.request.contextPath}/vendor/tilt/tilt.jquery.min.js"></script> --%>
<!-- 	<script > -->
<!-- // 		$('.js-tilt').tilt({ -->
<!-- // 			scale: 1.1 -->
<!-- // 		}) -->
<!-- 	</script> -->
<!-- <!--===============================================================================================--> 
<!-- 	<script src="js/main.js"></script> -->



<!-- <!-- Modal --> 
<!-- <div class="modal fade" id="forgotPassModal" tabindex="-1" aria-labelledby="forgotPassModa" aria-hidden="true"> -->
<!--   <div class="modal-dialog"> -->
<!--     <div class="modal-content"> -->
<!--       <div class="modal-header"> -->
<!--         <h5 class="modal-title" id="exampleModalLabel">Forgot Password</h5> -->
<!--         <button type="button" class="close" data-dismiss="modal" aria-label="Close"> -->
<!--           <span aria-hidden="true">&times;</span> -->
<!--         </button> -->
<!--       </div> -->
<!--       <div class="modal-body"> -->
<!--       <form action = "forgotPassServlet" method="post"> -->
<!--         <div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz"> -->
<!-- 						<input class="input100" type="email" name="Email" placeholder="Email"> -->
<!-- 						<span class="focus-input100"></span> -->
<!-- 						<span class="symbol-input100"> -->
<!-- 							<i class="fa fa-envelope" aria-hidden="true"></i> -->
<!-- 						</span> -->
<!-- 		</div> -->
<!-- 		<div class="container-login100-form-btn"> -->
<!-- 						<button class="login100-form-btn"> -->
<!-- 							Find Password -->
<!-- 						</button> -->
<!-- 		</div>  -->
<!-- 		</form> -->
<!--       </div> -->
<!--       <div class="modal-footer"> -->
<!--         <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button> -->
<!--       </div> -->
<!--     </div> -->
<!--   </div> -->
<!-- </div> -->
<!-- </body> -->

<!-- <!-- Button trigger modal --> 
<!-- </html> -->
