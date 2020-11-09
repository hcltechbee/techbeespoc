<%@page import="com.constants.UIConstants"%>
<%@page import="com.constants.URLConstants"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>TechBee | Home</title>
  <!-- Theme style -->
  <link rel="stylesheet" href="css/adminlte.min.css">
  <script src="https://kit.fontawesome.com/550c1e8106.js" crossorigin="anonymous"></script>
  <style>
.footer {
  position: fixed;
  left: 0;
  bottom: 0;
  width: 100%;
  text-align:center;
}
</style>
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
        <a href="" class="nav-link">Home</a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="mailto: abc@example.com" class="nav-link">Contact</a>
      </li>
    </ul>

    <% 
	session = request.getSession(false);
    if (session.getAttribute("name") == null) {
        // No session present, you can create yourself
    	out.println("<a class='btn btn-primary' href='"+URLConstants.loginPageUrl +"' style='float:right; margin-right:0; margin-left:auto;'> Login </a>");    
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
      <a href="#" class="h1"><b style="color:blue">TECH</b>BEE</a>
    </div>
    </a>
    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user (optional) -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        
        <div class="info">
          <a href="#" class="d-block"><% if(session.getAttribute(UIConstants.sessionName)!= null){out.println(session.getAttribute(UIConstants.sessionName));} %></a>
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
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
<!--               <li class="breadcrumb-item active">Home </li> -->
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>
    
<!--         <div class="card card-info"> -->
<!--         <div class="card-header"> -->
<!--           <h3 class="card-title"><b>USERS</b></h3> -->
<!--         </div> -->
<!--             <a href="FilterUser.jsp" class="btn btn-info" style="background-color:grey;">FILTER USER : <i class="fas fa-filter"></i></a> -->
<!--         <div class="card-body p-0"> -->
<!--           <table class="table"> -->
<!--             <thead> -->
<!--               <tr> -->
<!--                 <th>UserID</th> -->
<!--                 <th>Name</th> -->
<!--                 <th>Email-ID</th> -->
<!--                 <th>Country</th> -->
                
<!--                 <th></th> -->
<!--               </tr> -->
<!--             </thead> -->
<!--             <tbody> -->
        
       
<%--               <%@page import="com.db.connector.dbConnector"%> --%>
<%--               <%@page import="java.util.List"%> --%>
              

<!-- //               		  dbConnector dbCon = new dbConnector(); -->
<!-- //                       Connection connection = dbCon.con; -->
<!-- //                       Statement stmt = connection.createStatement(); -->
<!-- //                       ResultSet rs = stmt.executeQuery("SELECT User_Id, First_name, Email_Id, Country FROM users.userslogin"); -->
                      
<%--               %> --%>
              
              
<%--               <% --%>
<!-- //               while(rs.next()){   -->
<!-- //                 out.println("<tr>"); -->
<!-- //                 out.println("<td>"+rs.getInt(1)+"</td>"); -->
<!-- //                 out.println("<td>"+rs.getString(2)+"</td>"); -->
<!-- //                 out.println("<td>"+rs.getString(3)+"</td>"); -->
<!-- //                 out.println("<td>"+rs.getString(4)+"</td>"); -->
<!-- //                 out.println("<td class=\"text-right py-0 align-middle\">"); -->
<!-- //                 out.println("<div class=\"btn-group btn-group-sm\">"); -->
<!-- //                 out.println("<button method='get' id='d"+rs.getInt(1) +"'"); -->
<!-- //                 out.println("class=\"delete btn btn-danger\">"); -->
<!-- //                 out.println("<i class=\"fas fa-trash\"></i></a>"); -->
<!-- //                 //out.println("<a href='DeleteServlet?id="+e.getId()+"' class="btn btn-danger"><i class="fas fa-trash"></i></a>"); -->
<!-- //                 out.println("</div>"); -->
<!-- //               out.println("</td>"); -->
<!-- //               } -->

              
<%-- /<--               <% --%> 	 
<!-- // 			String deleteId = ""; -->
<!-- // 		deleteId = request.getParameter("delete"); -->
<!-- // 		if(deleteId!=null){ -->
<!-- // 			System.out.println(deleteId); -->
<!-- // 			stmt.executeUpdate("DELETE FROM users.userslogin where `User_Id` = "+deleteId); -->
		
<!-- // 	} -->
<!--  --> 
              
<!--             </tbody> -->
<!--           </table> -->
<!--         </div> -->
<!--         /.card-body -->
<!--       </div> -->
<!--       /.card -->
   
<!--   <div class="row"> -->
<!--     <div class="col-12"> -->
<!--       <a href="#" class="btn btn-secondary">Cancel</a> -->
<!--       <input type="submit" value="Save Changes" class="btn btn-success float-right"> -->
<!--     </div> -->
<!--   </div> -->

	

  <footer class="main-footer footer">
	   <strong>Copyright &copy; 2020</strong> All rights reserved.
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
<script src=".js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="js/demo.js"></script>

</body>
</html>
