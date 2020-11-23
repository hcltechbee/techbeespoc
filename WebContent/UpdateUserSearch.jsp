<%@page import="com.classes.users.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>TechBee | UPDATE User</title>

  
  
  <!-- Theme style -->
    <link rel="stylesheet" href="css/adminlte.min.css">
  <script src="https://kit.fontawesome.com/550c1e8106.js" crossorigin="anonymous"></script>
  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="css/all.min.css">
  <!-- SweetAlert2 -->
  <link rel="stylesheet" href="css/bootstrap-4.min.css">
  <!-- Toastr -->
  <link rel="stylesheet" href="css/toastr.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="css/adminlte.min.css">
  
  

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
        <a href="mailto:abc@example.com" class="nav-link">Contact</a>
      </li>
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
      <a href="Home.jsp" class="h1"><b style="color:blue;">TECH</b>BEE</a>
    </div>
    
      
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user (optional) -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        
        <div class="info">
          <a href="#" class="d-block"><% if(session.getAttribute(com.constants.UIConstants.SESSION_NAME)!= null){out.println(session.getAttribute(com.constants.UIConstants.SESSION_NAME));} %></a>
        </div>
      </div>
	
      

      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
          
            
          
          <li class="nav-item">
            <a href="" class="nav-link">
              <i class="nav-icon fa fa-user"></i>
              <p>
                Add User
              </p>
            </a>
          </li>
          <li class="nav-item">
            <a href="UPDATEUsingSearch.jsp" class="nav-link">
              <i class="nav-icon  fas fa-user-minus"></i>
              <p>
                UPDATE User
              </p>
            </a>
            <li class="nav-item">
              <a href="" class="nav-link">
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


              <%
              String loginedUser="";
              String loginedUserId="";
              int CheckId=0;
              if(session.getAttribute(com.constants.UIConstants.SESSION_NAME)!= null)
              {
              	loginedUser =(String)session.getAttribute(com.constants.UIConstants.SESSION_NAME);
              	loginedUserId=(String)session.getAttribute(com.constants.UIConstants.SESSION_USER_ID);
              	CheckId=Integer.parseInt(loginedUserId);
              	String userLogined[]=loginedUser.split(" ");
              	//System.out.println(userLogined[0]);
              	loginedUser=userLogined[0];
              	//System.out.println(loginedUser);	
              } 
              //System.out.println(CheckId);
              String userSearched=request.getParameter("NameToSearch");
              String action;
             
              %>
        
          <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
   

    <div class="card card-info">
        <div class="card-header">
          <h4 class="card-title"><b>UPDATE USERS</b></h4>
        </div>
      
          
        <div class="card-body p-0">
          <table class="table">
             <%@page import="com.classes.users.UsersDataBase"%>
              <%@page import="com.classes.users.User"%>
              <%@page import="java.util.List"%>
            
         
                
              <%     String nameToFilter=request.getParameter("NameToSearch");
              List<User> list = UsersDataBase.UpdateAllEmployees(nameToFilter);
                      if (list.size()==0){
                    	  out.println("USER DOES NOT EXIST");
                      } else {
           
              %>
                   
            <thead>
              <tr>
<!--                 <th>UserID</th> -->
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email-ID</th>
                
                
                <th></th>
              </tr>
            </thead>
            <tbody>
              
              <%
              String email="";
              int id=0;
              for(User currentUser:list){  
            	  if(loginedUser.equals(userSearched) && (CheckId==currentUser.getUser_id())) {
                  	  action="#modal-UPDATE";
                    }
                    else{
                  	  action="#modal-info";
                    }
                out.println("<tr>");
//                 out.println("<td>"+currentUser.getUser_id()+"</td>");
                out.println("<td>"+currentUser.getFirst_name()+"</td>");
                out.println("<td>"+currentUser.getLast_Name()+"</td>");
                out.println("<td>"+currentUser.getEmail_Id()+"</td>");
                out.println("<td class=\"text-right py-0 align-middle\">");
                out.println("<div class=\"btn-group btn-group-sm\">");
                out.println("<a id='d"+currentUser.getUser_id()+"' data-toggle=\"modal\" href="+action+" ");  //   out.println(href='UPDATEServlet?id="+currentUser.getUser_id()+"'")               
                id=currentUser.getUser_id();
                email=currentUser.getEmail_Id();
              
                out.println("<a href=\"\" class=\"btn btn-info\"><i class=\"fas fa-user-edit\"></i></a>");
                //out.println("<a href='UPDATEServlet?id="+e.getId()+"' class="btn btn-danger"><i class="fas fa-trash"></i></a>");
              out.println("</td>");
              out.println("</tr>");
              
                      
             %>
                         
 
        <div class="modal fade" id="modal-info">
        <div class="modal-dialog">
          <div class="modal-content bg-info">
            <div class="modal-header">
              <h4 class="modal-title">UPDATING USER</h4>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
              <p>PLEASE CONFIRM TO UPDATE USER</p>
            </div>
            <div class="modal-footer justify-content-between">
              <button type="button" class="btn btn-outline-light" data-dismiss="modal">No</button>
              <% 
              //System.out.println(currentUser.getUser_id()+"  "+currentUser.getEmail_Id());
              System.out.println(id+" "+email);
            out.println("<a href=\"UpdateUserPage.jsp\" class=\"btn btn-outline-light confirmUPDATE\">YES</a>");
                      }  }
              %> 
              
            </div>
          </div>
          <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
      </div>
      <!-- /.modal -->
             
            </tbody>          
          </table>
        </div>
        <!-- /.card-body -->
      </div>
      <!-- /.card -->


    
   
    
<div class="container">
  <div class="row">
    <div class="col-12 text-center" >
      <a href="UpdateUser.jsp" class="btn btn-primary">Back</a>
    </div>
    </div>
  </div>





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
<script src="js/bootstrap.bundle.min.js"></script>
<!-- SweetAlert2 -->
<script src="js/sweetalert2.min.js"></script>
<!-- Toastr -->
<script src="js/toastr.min.js"></script>
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
<!-- Page specific script -->
<script>
  $(function() {
    var Toast = Swal.mixin({
      toast: true,
      position: 'top-end',
      showConfirmButton: false,
      timer: 3000
    });

    $('.swalDefaultSuccess').click(function() {
      Toast.fire({
        icon: 'success',
        title: 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr.'
      })
    });
    $('.swalDefaultInfo').click(function() {
      Toast.fire({
        icon: 'info',
        title: 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr.'
      })
    });
    $('.swalDefaultError').click(function() {
      Toast.fire({
        icon: 'error',
        title: 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr.'
      })
    });
    $('.swalDefaultWarning').click(function() {
      Toast.fire({
        icon: 'warning',
        title: 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr.'
      })
    });
    $('.swalDefaultQuestion').click(function() {
      Toast.fire({
        icon: 'question',
        title: 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr.'
      })
    });

    $('.toastrDefaultSuccess').click(function() {
      toastr.success('Lorem ipsum dolor sit amet, consetetur sadipscing elitr.')
    });
    $('.toastrDefaultInfo').click(function() {
      toastr.info('Lorem ipsum dolor sit amet, consetetur sadipscing elitr.')
    });
    $('.toastrDefaultError').click(function() {
      toastr.error('Lorem ipsum dolor sit amet, consetetur sadipscing elitr.')
    });
    $('.toastrDefaultWarning').click(function() {
      toastr.warning('Lorem ipsum dolor sit amet, consetetur sadipscing elitr.')
    });

    $('.toastsDefaultDefault').click(function() {
      $(document).Toasts('create', {
        title: 'Toast Title',
        body: 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr.'
      })
    });
    $('.toastsDefaultTopLeft').click(function() {
      $(document).Toasts('create', {
        title: 'Toast Title',
        position: 'topLeft',
        body: 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr.'
      })
    });
    $('.toastsDefaultBottomRight').click(function() {
      $(document).Toasts('create', {
        title: 'Toast Title',
        position: 'bottomRight',
        body: 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr.'
      })
    });
    $('.toastsDefaultBottomLeft').click(function() {
      $(document).Toasts('create', {
        title: 'Toast Title',
        position: 'bottomLeft',
        body: 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr.'
      })
    });
    $('.toastsDefaultAutohide').click(function() {
      $(document).Toasts('create', {
        title: 'Toast Title',
        autohide: true,
        delay: 750,
        body: 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr.'
      })
    });
    $('.toastsDefaultNotFixed').click(function() {
      $(document).Toasts('create', {
        title: 'Toast Title',
        fixed: false,
        body: 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr.'
      })
    });
    $('.toastsDefaultFull').click(function() {
      $(document).Toasts('create', {
        body: 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr.',
        title: 'Toast Title',
        subtitle: 'Subtitle',
        icon: 'fas fa-envelope fa-lg',
      })
    });
    $('.toastsDefaultFullImage').click(function() {
      $(document).Toasts('create', {
        body: 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr.',
        title: 'Toast Title',
        subtitle: 'Subtitle',
        image: '../../dist/img/user3-128x128.jpg',
        imageAlt: 'User Picture',
      })
    });
    $('.toastsDefaultSuccess').click(function() {
      $(document).Toasts('create', {
        class: 'bg-success',
        title: 'Toast Title',
        subtitle: 'Subtitle',
        body: 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr.'
      })
    });
    $('.toastsDefaultInfo').click(function() {
      $(document).Toasts('create', {
        class: 'bg-info',
        title: 'Toast Title',
        subtitle: 'Subtitle',
        body: 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr.'
      })
    });
    $('.toastsDefaultWarning').click(function() {
      $(document).Toasts('create', {
        class: 'bg-warning',
        title: 'Toast Title',
        subtitle: 'Subtitle',
        body: 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr.'
      })
    });
    $('.toastsDefaultDanger').click(function() {
      $(document).Toasts('create', {
        class: 'bg-danger',
        title: 'Toast Title',
        subtitle: 'Subtitle',
        body: 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr.'
      })
    });
    $('.toastsDefaultMaroon').click(function() {
      $(document).Toasts('create', {
        class: 'bg-maroon',
        title: 'Toast Title',
        subtitle: 'Subtitle',
        body: 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr.'
      })
    });
  });
</script>

       <div class="modal fade" id="modal-UPDATE">
        <div class="modal-dialog">
          <div class="modal-content bg-info">
            <div class="modal-header">
              <h4 class="modal-title">USER LOGGED IN</h4>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
              <p>LOGGED IN USER CAN NOT BE UPDATED</p>
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
</script>
</body>
</html>