<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
button {
	color: blue;
}
body {
	margin: 0px;
}
header, section, footer {
	margin: 0;
}
</style>

<meta charset="ISO-8859-1">
<title>Search User</title>
<!-- Theme style-->
<link rel="stylesheet" href="css/adminlte.min.css">
<script src="https://kit.fontawesome.com/550c1e8106.js"
	crossorigin="anonymous"></script>
</head>

<body class="hold-transition sidebar-mini">
	<!-- Site wrapper -->
	<div class="wrapper">
		<!-- Navbar -->
		<nav
			class="main-header navbar navbar-expand navbar-white navbar-light">
			<!-- Left navbar links -->
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" data-widget="pushmenu"
					href="#" role="button"><i class="fas fa-bars"></i></a></li>
				<li class="nav-item d-none d-sm-inline-block"><a
					href="Home.jsp" class="nav-link">Home</a></li>
				<li class="nav-item d-none d-sm-inline-block"><a
					href="mailto: abc@example.com" class="nav-link">Contact</a></li>
			</ul>
			<%
				session = request.getSession(false);
			if (session.getAttribute("name") == null) {
				// No session present, you can create yourself
				out.println("<a class='btn btn-primary' href='" + com.constants.URLConstants.LOGIN_PAGE_URL
				+ "' style='float:right; margin-right:0; margin-left:auto;'> Login </a>");
			} else {
				// Already created.
				out.println(
				"<span style='float:right; margin-right:0; margin-left:auto;'><a class='btn btn-primary' href='logoutServlet'>Logout</a></span>");
			}
			%>







		</nav>
		<!-- /.navbar -->

		<!-- Main Sidebar Container -->
		<aside class="main-sidebar sidebar-dark-primary elevation-4">
			<div class="card-header text-center">
				<a href="Home.jsp" class="h1"><b style="color: blue;">TECH</b>BEE</a>
			</div>


			</a>

			<!-- Sidebar -->
			<div class="sidebar">
				<!-- Sidebar user (optional) -->
				<div class="user-panel mt-3 pb-3 mb-3 d-flex">

					<div class="info">
						<a href="#" class="d-block"> <%
 	if (session.getAttribute(com.constants.UIConstants.SESSION_NAME) != null) {
 	out.println(session.getAttribute(com.constants.UIConstants.SESSION_NAME));
 }
 %>
						</a>
					</div>
				</div>



				<!-- Sidebar Menu -->
				<nav class="mt-2">
					 <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
          <li class="nav-item">
            <a href="Registeration_Form.html" class="nav-link">
              <i class="nav-icon fa fa-user"></i>
              <p>
                Add User
              </p>
            </a>
          </li>
          <li class="nav-item">
            <a href="DeleteUsingSearch.jsp" class="nav-link">
              <i class="nav-icon  fas fa-user-minus"></i>
              <p>
                Delete User
              </p>
            </a>
            <li class="nav-item">
              <a href="UpdateUser.jsp" class="nav-link">
                <i class="nav-icon  fas fa-pen-alt"></i>
                <p>
                  Update User
                </p>
              </a>
               <li class="nav-item">
              <a href="Search.jsp" class="nav-link">
                <i class="nav-icon  fas fa-search"></i>
                <p>
                  Search User
                </p>
              </a>
        </ul>
				</nav>
				<!-- /.sidebar-menu -->
			</div>
			<!-- /.sidebar -->
		</aside>

		<!-- Content Wrapper. Contains page content -->

		<!-- Content Header (Page header) -->

		<div class="content-wrapper" width="70">
			<!-- Content Header (Page header) -->




			<div class="card card-info">
				<div class="card-header">
					<h3 class="card-title">
						<b>SEARCH USERS</b>
					</h3>
				</div>
			</div>
			<!-- Horizontal Form -->





			<form name="searching" action="Search.jsp"
				onsubmit="return validateForm()" method="POST">


				<div class="register-box text-center"
					style="width: 25rem; margin: 0 auto; float: none; margin-bottom: 40px; margin-top: 30px;">
					<div class="card card-outline card-primary">
						<div class="card-header text-center">
							<a href="Search.jsp" class="h1"><b>Advance Search</b></a>
						</div>
						<div class="card-body required">


							<div class="input-group mb-3">
								<input type="text" class="form-control " name="firstName"
									placeholder="First name" pattern="[a-zA-Z ]{2,30}"
									title="Only alphabets and space allowed.">
								<div class="input-group-append">
									<div class="input-group-text">
										<span class="fas fa-user"></span>
									</div>
								</div>
							</div>

							<div class="input-group mb-3">
								<input type="text" class="form-control " name="secondName"
									placeholder="last name" pattern="[a-zA-Z ]{2,30}"
									title="Only alphabets and space allowed.">
								<div class="input-group-append">
									<div class="input-group-text">
										<span class="fas fa-user"></span>
									</div>
								</div>
							</div>




							<!-- /.card-body -->

							<div class="card-footer navbar-expand navbar-white ">
								<hr>

								<button type="submit" class="btn btn-primary">Search</button>
								<!--   <button type="submit" class="btn btn-default float-right">Cancel</button>-->

							</div>
							<!-- /.card-footer -->
			</form>
		</div>
	</div>
	</div>

	<!-- /.card -->
	<!-- Control Sidebar -->
	<aside class="control-sidebar control-sidebar-dark">
		<!-- Control sidebar content goes here -->
	</aside>
	<!-- /.control-sidebar -->
	</div>
	<!-- ./wrapper -->

	<footer class="main-footer">
		<div class="float-right d-none d-sm-block">
			<b>Version</b> 3.1.0-pre
		</div>
		<strong>Copyright &copy; 2014-2020 <a href="#"> All
				rights reserved. 
	</footer>

	<!-- jQuery -->
	<script src="../../plugins/jquery/jquery.min.js"></script>
	<!-- Bootstrap 4 -->
	<script src="../../plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- AdminLTE App -->
	<script src="../../dist/js/adminlte.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="../../dist/js/demo.js"></script>
	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- Bootstrap 4 -->
	<script src=".js/bootstrap.bundle.min.js"></script>
	<!-- AdminLTE App -->
	<script src="js/adminlte.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="js/demo.js"></script>
	<script>
    
function validateForm() {
	
var x = document.forms["searching"]["firstName"].value;
var y = document.forms["searching"]["secondName"].value;
if (x.equals("")){
alert("Name must be filled out");
returnfalse;
}
}     
</script>

</body>
</html>
