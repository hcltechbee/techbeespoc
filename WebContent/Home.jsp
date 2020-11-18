<%@page import="java.time.LocalDate"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Arrays"%>
<%@page import="com.mysql.jdbc.Blob"%>
<%@page import="com.classes.users.UsersDataBase"%>
<%@page import="com.classes.users.Feed"%>
<%@page import="java.util.List"%>
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
  <!-- jQuery -->
<script src="js/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src=".js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="js/demo.js"></script>
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

img {
    max-width: 300px;
    vertical-align: middle;
    border-style: none;
    height: 300px;
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
 
      
    <div class="card card-primary">
        <div class="card-header">
          <h3 class="card-title"><b>FEED</b></h3>
        </div>
      </div>
 
    


	  <!-- Content Wrapper. Contains page content -->
  <div class="container" >
    <!-- Content Header (Page header) -->


    <!-- Main content -->
    <section class="container-fluid" style="text-align:center">
      <div class="container-fluid">
        <div class="row">
        <form action="InsertFeed">
          <div class="col-12">
            <!-- Default box -->
            <div class="card card-primary" style='margin-bottom:80px'>
              <div class="card-header">
                <h3 class="card-title"></h3>
                <div class="card-tools">
                  <button type="button" class="btn btn-tool" data-card-widget="collapse" title="Collapse">
                    <i class="fas fa-minus"></i>
                  </button>
                </div>
              </div>
              <div class="card-body">
<!--                 <input type="text" name="messageByUser" placeholder="Type Your Text Here"> -->
                <textarea rows="3" cols="140" name="messageByUser" placeholder="Type Your Text Here" required></textarea>
              </div>
              <!-- /.card-body -->
              <div class="card-footer justify-content-between">
              <input type="file" id="img" class="btn btn-primary" name="image" value="PHOTO" required accept="image/*" onchange="return fileValidation()" style="overflow:hidden">
              <br>
              <br>
              <input type="submit" class="btn btn-primary" value="POST">
              </div>
              
              <!-- /.card-footer-->
            </div>
            <!-- /.card -->
            
            <%@page import="com.classes.users.UsersDataBase"%>
            <%@page import="com.classes.users.Feed"%>
            <%@page import="java.util.List"%>
            <%@page import="com.constants.UIConstants"%>
            <%@page import="com.constants.URLConstants"%>
            <%@page import="java.sql.ResultSet"%>
            <%@page import="java.sql.Statement"%>
            <%@page import="java.sql.Connection"%>
            
            <% 
            String loginedUser="";
            String loginedUserId="";
            int CheckId=0;
            if(session.getAttribute(com.constants.UIConstants.sessionName)!= null)
            {
            	loginedUser =(String)session.getAttribute(com.constants.UIConstants.sessionName);
            	loginedUserId=(String)session.getAttribute(com.constants.UIConstants.sessionUser_id);
            	CheckId=Integer.parseInt(loginedUserId);
            	String userLogined[]=loginedUser.split(" ");
            	//System.out.println(userLogined[0]);
            	loginedUser=userLogined[0];
            	//System.out.println(loginedUser);	
            } 
            LocalDate date = LocalDate.now();  
            LocalDate timeToFilter = date.minusDays(5);
            String dateToSearch = ""+timeToFilter; 
            System.out.println(dateToSearch);
            
            List<Feed> feedList = UsersDataBase.getAllFeeds(dateToSearch);
                   
                   for(Feed currentUser:feedList)
                   {
                	   
            %>
            
             <div class="card card-primary" style='margin-bottom:60px'>
              <div class="card-header">
                <h3 class="card-title"></h3>
                <div class="card-tools">
                  <button type="button" class="btn btn-tool" data-card-widget="collapse" title="Collapse">
                    <i class="fas fa-minus"></i>
                  </button>
                </div>
              </div>
              <div class="card-body">
              
              <div style="text-align:left;">
              <%
               
              out.println(currentUser.getFeed_Text());
              Blob blob = currentUser.getPhoto();
              //Thread.sleep(1000);
              
              %>
              </div>
<div class="col-12">
    <div class="thumbnail">
        <img src="FeedImage?id=<%=currentUser.getFeed_Id()%>">
    </div>
 </div>
  
<%-- <img src="FeedImage?id=<%=currentUser.getFeed_Id()%>" /> --%>
              </div>
              <!-- /.card-body -->
              <div class="card-footer">
              
              </div>
              
              <!-- /.card-footer-->
            </div>
            
          </div>
   <%
                   }
   %>
   
        </div>
      </div>
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
 

  <footer class="main-footer footer" style='z-index:10'>
	   <strong>Copyright &copy; 2020</strong> All rights reserved.
  </footer>

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->


  <script language="javascript"> 
  function fileValidation() { 
      var fileInput =  
          document.getElementById('img'); 
        
      var filePath = fileInput.value; 
    
      // Allowing file type 
      var allowedExtensions =  
              /(\.jpg|\.png)$/i; 
        
      if (!allowedExtensions.exec(filePath)) { 
          alert('Invalid file type only .png and .jpg allowed'); 
          fileInput.value = ''; 
          return false; 
      }  
      
      const fi = document.getElementById('img'); 
      // Check if any file is selected. 
      if (fi.files.length > 0) { 
          for (const i = 0; i <= fi.files.length - 1; i++) { 

              const fsize = fi.files.item(i).size; 
              const file = Math.round((fsize / 1024)); 
              // The size of the file. 
              if (file >= 2048) { 
            	 
//             	  $(document).ready(function(){
//             		  $('#modalFileSize').modal('show');
//             		});

            	  document.getElementById('img').style.borderColor = "red";
              alert( 
                    "File too Big, please select a file less than 2mb");     
                  fileInput.value = ''; 
                  return false;
              }
          } 
      } 
        
      
  }

  
    </script> 
    
<!--  <script>   -->
//   $(document).ready(function(){
//     $("#img").click(function(){
//       $("#modalFileSize").modal();
//     });
//   });
<!-- </script> -->


<div class="modal fade" id="modalFileSize">
        <div class="modal-dialog">
          <div class="modal-content bg-info">
            <div class="modal-header">
              <h4 class="modal-title">FILE SIZE</h4>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
              <p>File too Big, please select a file less than 2mb</p>
            </div>
             <div class="modal-footer">
              <button type="button" class="btn btn-outline-light" data-dismiss="modal">OK</button>
            </div>
          </div>
          <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
      </div>
      <!-- /.modal -->



</body>
</html>
