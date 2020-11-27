<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.connection.Userslogin"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="com.constants.QueryConstants"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.classes.users.UsersDataBase"%>
<%@page import="java.sql.Connection"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>TechBee | Update Reporting Manager</title>


<%
	int user_Id = Integer.parseInt(request.getParameter("id"));
	String edit = "";
	edit = request.getParameter("edit");
	String add = "";
	add = request.getParameter("add");
	String rm_id = request.getParameter("rm_id");
	String rm_name = request.getParameter("rm_name");
	String rm_dept = request.getParameter("rm_dept");
	if(session.getAttribute(com.constants.UIConstants.SESSION_NAME) == null){
		response.sendRedirect("Login.jsp");
	}

%>


<!-- Theme style -->
<link rel="stylesheet" href="css/adminlte.min.css">
<script src="https://kit.fontawesome.com/550c1e8106.js"></script>
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



			<% 
    session = request.getSession(false);
    if (session.getAttribute("name") == null) {
        // No session present, you can create yourself
        out.println("<a class='btn btn-primary' href='"+com.constants.URLConstants.LOGIN_PAGE_URL +"' style='float:right; margin-right:0; margin-left:auto;'> Login </a>");    
    } else {
        // Already created.
        out.println("<span style='float:right; margin-right:0; margin-left:auto;'><a class='btn btn-primary' href='logoutServlet'>Logout</a></span>");
    }
    %>
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



						<!--  <li class="nav-item">
            <a href="Registeration_Form.html" class="nav-link">
              <i class="nav-icon fa fa-user"></i>
              <p>
                Add Reporting Manager
              </p>
            </a>
          </li>-->
						<li class="nav-item"><a href="SearchReportingManager.jsp"
							class="nav-link"> <i class="nav-icon  fas fa-user-minus"></i>
								<p>Search Reporting Manager</p>
						</a>
						<li class="nav-item"><a href="UpdateReportingManager.jsp"
							class="nav-link"> <i class="nav-icon  fas fa-pen-alt"></i>
								<p>Add Reporting Manager</p>
						</a>
					</ul>
				</nav>
				<!-- /.sidebar-menu -->
			</div>
			<!-- /.sidebar -->
		</aside>



		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1>Add/Update Reporting Manager</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">

							</ol>
						</div>
					</div>
				</div>
				<!-- /.container-fluid -->
			</section>



			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-md-6">
						<div class="card card-primary">
							<div class="card-header">
								<h3 class="card-title">RM Details</h3>
								
						<% if(edit!=null && request.getParameter("fetch")==null){
							EntityManagerFactory emf=Persistence.createEntityManagerFactory("InsertUsers"); 
      						EntityManager em=emf.createEntityManager();
      						em.getTransaction().begin();   
      						System.out.println(2);
      						Query query = em.createQuery("SELECT u.rmId from Userslogin u WHERE u.user_Id = " + user_Id);
      						System.out.println(query);
							String Rm_Name= "";
							String Rm_Department = "";
							List<Userslogin> rmIdList= new ArrayList<>();
							List<Userslogin> userData = new ArrayList<>();
						    rmIdList = query.getResultList();
						    Userslogin userslogin = em.find(Userslogin.class, user_Id);
						    em.getTransaction().commit();
						    System.out.println(rmIdList);
						    int Rm_Id = 0;
							Rm_Id = userslogin.getRmId();
							em.getTransaction().begin();
							query = em.createQuery("SELECT u from Userslogin u WHERE u.user_Id = " + Rm_Id);
							userData = query.getResultList();
							em.getTransaction().commit();
							for(Userslogin u: userData){
								Rm_Name = u.getFirstName() + " " +  u.getLastName();
								Rm_Department = u.getDepartment();
							}
							if(request.getParameter("fetch") != null&&request.getParameter("error")==null){
								Rm_Name = rm_name;
								Rm_Department = rm_dept;
								Rm_Id = Integer.parseInt(rm_id);
								System.out.println(Rm_Name);
							}
							%>
							<form action = 'editRm' method='post'>
							<div class='card-tools'>
								<button type="button" class="btn btn-tool"
									data-card-widget="collapse" title="Collapse">
									<i class="fas fa-minus"></i>
								</button>
							</div>
						</div>
						<% out.println("<input type='text' style='visibility:hidden; height:0; width:0;' name='user_id' value='"+user_Id+"' id='user_id'></input>"); %>
						<div>
							<div class="input-group mb-3">
								<% out.println("<input type='text' class='form-control' name='Full_Name' id='rm_name' value='"+Rm_Name +"' required readonly>");%>						
								<div class="input-group-append">
									<div class="input-group-text">
										<span class="fas fa-user"></span>
									</div>
								</div>
							</div>
							<div class="input-group mb-3">
								<% out.println("<input type='text' class='form-control' id='rm_dept' name='Dept_Name' value='" + Rm_Department + "' required readonly>");%>
								<div class="input-group-append">
									<div class="input-group-text">
										<span class="fas fa-address-book"></span>
									</div>
								</div>
							</div>
							<div class="input-group mb-3">
								<% out.println("<input type='text' class='form-control' id='rm_id' name='Rm_Id' value='"+Rm_Id +"' required>");%>
							<button type='button' style='margin-right:5px' id='fetch_details'>Fetch Details  </button>
								<div class="input-group-append">
									<div class="input-group-text">
										<span class="fas fa-pen-nib"></span>
									</div>
								</div>
							</div>
							<% out.println("<input type='text' style='visibility:hidden; height:0; width:0;' name='user_id' value='"+user_Id+"'></input>"); %>
							<% out.println("<input type='text' style='visibility:hidden; height:0; width:0;' id='rm_id_box' value='"+Rm_Id+"'></input>"); %>
							<% 
								if(request.getParameter("error")!= null){
									out.println("<h6 style='color:red';><b>Sorry!! Rm With Such Id is not available</b></h6>");
								}
							%>
							<div class="row">
								<div class="col-12">
									<a href="SearchReportingManager.jsp" class="btn btn-secondary">Back</a> <input
										id='sbmt_btn' type="submit" value="Update Rm"
										class="btn btn-primary float-right">
								</div>
							</div>
						</div>
					</div>
				</div>
				</form>
				<%
				}
						else{ 
						%>
						<form action = 'UpdateRm' method='post'>
						<%
							String Rm_Name = "";
							String Rm_Department = "";
							int Rm_Id = 0;
							if(request.getParameter("fetch") != null&&request.getParameter("error")==null){
								Rm_Name = rm_name;
								Rm_Department = rm_dept;
								Rm_Id = Integer.parseInt(rm_id);
								System.out.println(Rm_Name);
							}
							%>
							<div class='card-tools'>
								<button type="button" class="btn btn-tool"
									data-card-widget="collapse" title="Collapse">
									<i class="fas fa-minus"></i>
								</button>
							</div>
						</div>
						<% out.println("<input type='text' style='visibility:hidden; height:0; width:0;' name='user_id' value='"+user_Id+"' id='user_id'></input>"); %>
						<div>
							<div class="input-group mb-3">
								<% out.println("<input type='text' class='form-control' name='Full_Name' id='rm_name' value='"+Rm_Name +"' required readonly>");%>						
								<div class="input-group-append">
									<div class="input-group-text">
										<span class="fas fa-user"></span>
									</div>
								</div>
							</div>
							<div class="input-group mb-3">
								<% out.println("<input type='text' class='form-control' id='rm_dept' name='Dept_Name' value='" + Rm_Department + "' required readonly>");%>
								<div class="input-group-append">
									<div class="input-group-text">
										<span class="fas fa-address-book"></span>
									</div>
								</div>
							</div>
							<div class="input-group mb-3">
								<% out.println("<input type='text' class='form-control' id='rm_id' name='Rm_Id' value='"+Rm_Id +"' required>");%>
							<button type='button' style='margin-right:5px' id='fetch_details'>Fetch Details  </button>
								<div class="input-group-append">
									<div class="input-group-text">
										<span class="fas fa-pen-nib"></span>
									</div>
								</div>
							</div>
							<% out.println("<input type='text' style='visibility:hidden; height:0; width:0;' name='user_id' value='"+user_Id+"'></input>"); %>
							<% out.println("<input type='text' style='visibility:hidden; height:0; width:0;' id='rm_id_box' value='"+Rm_Id+"'></input>"); %>
							<%
							
								if(request.getParameter("error")!= null){
									out.println("<h6 style='color:red';><b>Sorry!! Rm With Such Id is not available</b></h6>");
								}
							%>
							<div class="row">
								<div class="col-12">
									<a href="SearchReportingManager.jsp" class="btn btn-secondary">Back</a> <input
										id='sbmt_btn' type="submit" value="Update Rm"
										class="btn btn-primary float-right">
								</div>
							</div>
						</div>
					</div>
				</div>
				</form>
						<% } %>				
					<!-- /.card-body -->
				</div>
				<!-- /.card -->
		</div>
	

		</section>
		<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->



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
		var rm_name = document.getElementById("rm_name").value;
		var rm_dept = document.getElementById("rm_dept").value;
		var rm_id_box = document.getElementById("rm_id_box").value;
		var sbmt_btn = document.getElementById("sbmt_btn");
		var user_id = document.getElementById("user_id").value;
	 document.getElementById('rm_id').oninput = function(){
		var rm_id = document.getElementById("rm_id").value;
		document.getElementById('fetch_details').addEventListener('click', function(){
			console.log('done');
			window.location='fetchdetailsservlet?rm_id=' + rm_id + '&user_id=' + user_id;
		})
		console.log(rm_id);
		console.log(rm_id_box);
		sbmt_btn.disabled=true;
		if(rm_id===rm_id_box){
			sbmt_btn.disabled=false;
		}
		else if(rm_id!= rm_id_box && rm_name!=null){
			sbmt_btn.disbaled = true;
		}
		else if(rm_id=''){
			sbmt_btn.disabled=false;
		}
	 }
	</script>
</body>
</html>