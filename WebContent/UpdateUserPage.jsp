<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.constants.QueryConstants"%>
<%@page import="java.sql.Statement"%>

<%@page import="com.classes.users.UsersDataBase"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.connection.Userslogin"%>
<%@page import="com.connection.Userdetail"%>
<%
	String id = request.getParameter("id");
%>

<!DOCTYPE html>
<html lang="en">


<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>TechBee | Update User</title>



<!-- Theme style -->
<link rel="stylesheet" href="css/adminlte.min.css">
<script src="https://kit.fontawesome.com/550c1e8106.js"></script>
<style>

/* The message box is shown when the user clicks on the password field */
#message {
	display: none;
	background: #f1f1f1;
	color: #000;
	position: relative;
	padding: 20px;
	margin-top: 10px;
}

#message p {
	font-size: 12px;
}

/* Add a green text color and a checkmark when the requirements are right */
.valid {
	color: green;
}

.valid:before {
	position: relative;
	left: -35px;
	content: "✔";
}

/* Add a red text color and an "x" icon when the requirements are wrong */
.invalid {
	color: red;
}

.invalid:before {
	position: relative;
	left: -35px;
	content: "✖";
}
</style>
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
					href="mailTo:'abc@gmail.com'" class="nav-link">Contact</a></li>
			</ul>

			<!----- <% 
	session = request.getSession(false);
    if (session.getAttribute("name") == null) {
        // No session present, you can create yourself
    	out.println("<a class='btn btn-primary' href='"+com.constants.URLConstants.LOGIN_PAGE_URL +"' style='float:right; margin-right:0; margin-left:auto;'> Login </a>");    
    } else {
        // Already created.
        out.println("<span style='float:right; margin-right:0; margin-left:auto;'><a class='btn btn-primary' href='logoutServlet'>Logout</a></span>");
    }
    %>-->
		</nav>
		<!-- /.navbar -->

		<!-- Main Sidebar Container -->
		<aside class="main-sidebar sidebar-dark-primary elevation-4">
			<div class="card-header text-center">
				<a href="Home.jsp" class="h1"><b style="color: blue">TECH</b>BEE</a>
			</div>




			<!-- Sidebar -->
			<div class="sidebar">
				<!-- Sidebar user (optional) -->
				<div class="user-panel mt-3 pb-3 mb-3 d-flex">

					<div class="info">
						<a href="#" class="d-block">
							<% if(session.getAttribute(com.constants.UIConstants.SESSION_NAME)!= null){out.println(session.getAttribute(com.constants.UIConstants.SESSION_NAME));} %>
						</a>
					</div>
				</div>



				<!-- Sidebar Menu -->
				<nav class="mt-2">
					<ul class="nav nav-pills nav-sidebar flex-column"
						data-widget="treeview" role="menu" data-accordion="false">
						<!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->



						<li class="nav-item"><a href="Registeration_Form.html"
							class="nav-link"> <i class="nav-icon fa fa-user"></i>
								<p>Add User</p>
						</a></li>
						<li class="nav-item"><a href="DeleteUsingSearch.jsp"
							class="nav-link"> <i class="nav-icon  fas fa-user-minus"></i>
								<p>Delete User</p>
						</a>
						<li class="nav-item"><a href="UpdateUser.jsp"
							class="nav-link"> <i class="nav-icon  fas fa-pen-alt"></i>
								<p>Update User</p>
						</a></li>




					</ul>
				</nav>
				<!-- /.sidebar-menu -->
			</div>
			<!-- /.sidebar -->
		</aside>





		<!-- /.content -->

		<!-- /.content-wrapper -->
		<br>
		<% 
    Userslogin user1=new Userslogin();
	Userdetail user_1 = new Userdetail();
	  EntityManagerFactory emf=Persistence.createEntityManagerFactory("InsertUsers"); 
	  EntityManager em=emf.createEntityManager();
	  Query query = em.createQuery("SELECT u "+"from Userslogin u "+"where u.user_Id="+id);
	  List<Userslogin> userData=new ArrayList<>();  
	  userData = query.getResultList();
	  Query query2 = em.createQuery("SELECT u "+"from Userdetail u "+"where u.userId="+id);
	  List<Userdetail> userDetails=new ArrayList<>();
	  userDetails = query2.getResultList();
	  em.getTransaction().begin();  
	  System.out.println(user1.getUser_Id());

    	int userId = 0;
    	String firstName = "";
    	String lastName = "";
    	String email = "";
    	String password = "";
    	String country = "";
    	String mobileNumber = "";
    	String address = "";
    	String city = "";
    	String pinCode = "";
    	String state = "";
    	 
		 // List<StudentEntity> list=(List<StudentEntity>)query.getResultList( );   
		  
		   for( Userslogin s:userData){  
		  userId = s.getUser_Id();
		  firstName = s.getFirstName();
		  lastName = s.getLastName();
		  email = s.getEmailId();
		  password = s.getPassword();
		   }
		  for(Userdetail s: userDetails){
			  country = s.getCountry();
			  mobileNumber = s.getMobileNumber().toString();
			  address = s.getAddress();
			  city = s.getCity();
			  pinCode = s.getPincode();
			  state = s.getState();
		  }
   	out.println("<form action='UPDATE' method='post'>");
    out.println("<div class='content-wrapper'>");
      out.println("<div class='col-md-6'>");
        out.println("<div class='card card-primary'>");
          out.println("<div class='card-header'>");
            out.println("<h3 class='card-title'>General</h3>");

            out.println("<div class='card-tools'>");
              out.println("<button type='button' class='btn btn-tool' data-card-widget='collapse' title='Collapse'>");
                out.println("<i class='fas fa-minus'></i>");
              out.println("</button>");
            out.println("</div>");
          out.println("</div>");
          out.println("<div class='card-body'>");
            out.println("<input type='text' class='form-control' name='First_Name' placeholder='First name' value ='"+firstName+"'");
              out.println("pattern='[a-zA-Z ]{2,30}' title='Only alphabets and space allowed.' required>");

          out.println("</div>");
          out.println("<div class='card-body'>");
            out.println("<input type='text' class='form-control' name='Last_Name' placeholder='Last name' pattern='[a-zA-Z ]{2,30}' title='Only alphabets and space allowed.' required value ='"+lastName+"'>");

          out.println("</div>");
          out.println("<div class='card-body'>");
            out.println("<input type='email' class='form-control' name='Email_Id' placeholder='Email' required value ='"+email+"'>");

          out.println("</div>");
          out.println("<div class='card-body'>");
            out.println("<input type='tel' class='form-control' name='Mobile_Number' placeholder='Mobile Number' pattern='[789][0-9]{9}' data-toggle='popover' title='Phone number with 7-9 and remaining 9 digit with 0-9' required value ='"+mobileNumber+"'>");

          out.println("</div>");


          out.println("<div class='card-body'>");
            out.println("<input type='text' class='form-control' placeholder='Address' name='Address' value ='"+address+"'>");
            
          out.println("</div>");
          out.println("<div class='input-group mb-3 center'>");
          out.println("<div class='custom-control custom-radio custom-control-inline'>");
              out.println("<input type='radio' class='custom-control-input' id='male' name='gender' value='1' required>");
              out.println("<label class='custom-control-label' for='male'><i class='fa fa-male' aria-hidden='true'></i> Male</label>");
          out.println("</div>");
          out.println("<div class='custom-control custom-radio custom-control-inline'>");
              out.println("<input type='radio' class='custom-control-input' type='radio' id='female' name='gender' value='2'>");
              out.println("<label class='custom-control-label' for='female'><i class='fa fa-female' aria-hidden='true'></i> Female</label>");
          out.println("</div>");
      out.println("</div>");
          out.println("<div class='card-body'>");
                  out.println("<input type='text' class='form-control' placeholder='City' name='City' value ='"+city+"'>");
                 
                out.println("</div>");
                out.println("<div class='card-body'>");
                 out.println("<input type='text' class='form-control' placeholder='Pin Code' name='Pin_Code' required value ='"+pinCode+"'>");
                 
               out.println("</div>");
                out.println("<div class='card-body'>");
                  out.println("<input type='text' class='form-control' placeholder='State' name='State' required value ='"+state+"'>");                 
                out.println("</div>");
                out.println("<div class='card-body'>");
                  out.println("<input type='text' class='form-control' placeholder='India' name='Country' readonly value ='"+country+"'>");
                  
                out.println("</div>");
	  out.println("<input type='text' value='"+id+"' style='visibility:hidden' name='id'");
//                 out.println("<div class='card-body'>");
//       						out.println("<input type='password' class='form-control' placeholder='Enter Current Password' id='pwd' name='pwd' pattern='(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}' title='Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters' required value ='"+password+"'>");
      						
//       					out.println("</div>");
//                 out.println("<div class='card-body'>");
//       						out.println("<input type='password' class='form-control' placeholder='Change Password' id='change_pwd' name='change_pwd' pattern='(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}' title='Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters' required>");
      						
//       					out.println("</div>");
//       					out.println("<div id='message' class='card-body'>");
//       						out.println("<h6>Password must contain the following:</h6>");
//       							out.println("<p id='letter' class='invalid'>A <b>lowercase</b> letter</p>");
//       							out.println("<p id='capital' class='invalid'>A <b>capital (uppercase)</b> letter</p>");
//       							out.println("<p id='number' class='invalid'>A <b>number</b></p>");
//       							out.println("<p id='length' class='invalid'>Minimum <b>8 characters</b></p>");
//       					out.println("</div>");
//       					out.println("<div class='card-body'>");
//       						out.println("<input type='password' class='form-control' onblur='matchPassword()' placeholder='Retype password' name='conf_pwd' id='conf_pwd' required>");
      						
//       					out.println("</div>");
               out.println("<div class='row'>");
                 out.println("<div class='col-12'>");
                  out.println("<a href='#' class='btn btn-secondary'>Cancel</a>");
                   out.println("<input type='submit' value='Save Changes' class='btn btn-success float-right'>");
                 out.println("</div>");
               out.println("</div>");
             out.println("</div>");
           out.println("</div>");
         out.println("</div>");
         out.println("</form>");
      out.println("</div>");

      
    	%>

		<footer class="main-footer">
			<div class="float-right d-none d-sm-block">
				<b>Version</b> 3.1.0-pre
			</div>
			<strong>Copyright &copy; 2014-2020 <a
				href="https://adminlte.io">TechBee.io</a>.
			</strong> All rights reserved.
		</footer>

		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Control sidebar content goes here -->
		</aside>
		<!-- /.control-sidebar -->
	</div>
	<!-- ./wrapper -->

	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- Bootstrap 4 -->
	<script src="js/bootstrap.bundle.min.js"></script>
	<!-- AdminLTE App -->
	<script src="js/adminlte.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="js/demo.js"></script>
	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- Bootstrap 4 -->
	<script src=".js/bootstrap.bundle.min.js"></script>
	<!-- AdminLTE App -->
	<script src="js/adminlte.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="js/demo.js"></script>
</body>
<script>
	var myInput = document.getElementById("pwd");
	var letter = document.getElementById("letter");
	var capital = document.getElementById("capital");
	var number = document.getElementById("number");
	var length = document.getElementById("length");

	// When the user clicks on the password field, show the message box
	myInput.onfocus = function () {
		document.getElementById("message").style.display = "block";
	}

	// When the user clicks outside of the password field, hide the message box
	myInput.onblur = function () {
		document.getElementById("message").style.display = "none";
	}

	// When the user starts to type something inside the password field
	myInput.onkeyup = function () {
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
	function matchPassword() {
		var pw1 = document.getElementById("pwd").value;
		var pw2 = document.getElementById("conf_pwd").value;
		var result = pw1.localeCompare(pw2);
		if (result !== 0) {
			alert("Passwords did not match");
		} else {
			alert("Password created successfully");
		}
	}  
</script>
</html>