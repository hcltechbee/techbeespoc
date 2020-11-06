
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>TechBee | Update User</title>

  
  
  <!-- Theme style -->
  <link rel="stylesheet" href="adminlte.min.css">
  <script src="https://kit.fontawesome.com/550c1e8106.js" crossorigin="anonymous"></script>
</head>
<body class="hold-transition sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">
  <!-- Navbar -->
  <nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <!-- Left navbar links -->
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="Home.jsp" class="nav-link">Home</a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="#" class="nav-link">Contact</a>
      </li>
    </ul>
   

    <!-- SEARCH FORM -->
    <form action="Search.jsp"class="form-inline ml-3">
      <div class="input-group input-group-sm">
        <input class="form-control form-control-navbar" type="search" name="NameToSearch" placeholder="Search" aria-label="Search">
        <div class="input-group-append">
          <button class="btn btn-navbar" type="submit">
            <i class="fas fa-search"></i>
          </button>
        </div>
      </div>
    </form>
    </nav>
  <!-- /.navbar -->

  <!-- Main Sidebar Container -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <div class="card-header text-center">
      <a href="../../index2.html" class="h1"><b>TECH</b>BEE</a>
    </div>
    
      
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user (optional) -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        
        <div class="info">
          <a href="#" class="d-block">User Name</a>
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
            <a href="UserInterface.jsp" class="nav-link">
              <i class="nav-icon  fas fa-user-minus"></i>
              <p>
                Delete User
              </p>
            </a>
            <li class="nav-item">
              <a href="UpdateUser.html" class="nav-link">
                <i class="nav-icon  fas fa-pen-alt"></i>
                <p>
                  Update User
                </p>
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
            <h1>DELETE USER</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Update User</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <div class="card card-info">
        <div class="card-header">
          <h3 class="card-title"><b>USERS</b></h3>
        </div>
        <div class="card-body p-0">
          <table class="table">
            <thead>
              <tr>
                <th>UserID</th>
                <th>Name</th>
                <th>Password</th>
                <th>Email-ID</th>
                <th>Country</th>
                
                <th></th>
              </tr>
            </thead>
            <tbody>
        
       
              <%@page import="com.classes.users.UsersDataBase"%>
              <%@page import="com.classes.users.Users"%>
              <%@page import="java.util.List"%>
           
              
                
              <%     
                      List<Users> list=UsersDataBase.getAllEmployees();
              %>
              
              
              <%
              for(Users e:list){  
               
                out.println("<tr>");
                out.println("<td>"+e.getId()+"</td>");
                out.println("<td>"+e.getName()+"</td>");
                out.println("<td>"+e.getPassword()+"</td>");
                out.println("<td>"+e.getEmail()+"</td>");
                out.println("<td>"+e.getCountry()+"</td>");
                out.println("<td class=\"text-right py-0 align-middle\">");
                out.println("<div class=\"btn-group btn-group-sm\">");
                out.println("<a href='DeleteServlet?id="+e.getId()+"'");
                out.println("class=\"btn btn-danger\" onClick=\"myFunction()\">");
                out.println("<i class=\"fas fa-trash\"></i></a>");
                //out.println("<a href='DeleteServlet?id="+e.getId()+"' class="btn btn-danger"><i class="fas fa-trash"></i></a>");
                out.println("</div>");
              out.println("</td>");
              }
              %> 
              
            </tbody>
          </table>
        </div>
        <!-- /.card-body -->
      </div>
      <!-- /.card -->
   
  <div class="row">
    <div class="col-12">
      <a href="UserInterface.jsp" class="btn btn-secondary">Cancel</a>
      <input type="submit" value="Save Changes" class="btn btn-success float-right">
    </div>
  </div>


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
    <strong>Copyright &copy; 2014-2020 <a href="#"> All rights reserved.
  </footer>

<!-- jQuery -->
<script src="../../plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="../../plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="../../dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../../dist/js/demo.js"></script>
<script>
function myFunction() {
  alert("USER HAS BEEN SUCCESSFULLY DELETED");
}
</script>
</body>
</html>
