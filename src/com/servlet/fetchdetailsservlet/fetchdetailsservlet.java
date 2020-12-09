package com.servlet.fetchdetailsservlet;

 

 

 

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

 

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 

import com.connection.Userslogin;

 

 

 

/**
 * Servlet implementation class fetchdetailsservlet
 */
@WebServlet("/fetchdetailsservlet")
public class fetchdetailsservlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    if(session.getAttribute(com.constants.UIConstants.SESSION_NAME) == null){
        response.sendRedirect("Login.jsp");
    }
    int rm_id = Integer.parseInt(request.getParameter("rm_id"));
    String original_user_id = request.getParameter("user_id");
    String user_id = original_user_id;
    try{
        /*
    Connection con = UsersDataBase.getConnection();
    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery(com.constants.QueryConstants.CHECKRMID + rm_id +"' and IS_RM=1" );
    */
    String Rm_Name = "";
    String Rm_Dept = "";

 

 

 

    Userslogin user1=new Userslogin();
    //Userdetail user_1 = new Userdetail();
      EntityManagerFactory emf=Persistence.createEntityManagerFactory("InsertUsers"); 
      EntityManager em=emf.createEntityManager();
      em.getTransaction().begin();   
      Query query = em.createQuery("SELECT u from Userslogin u WHERE u.user_Id = " + rm_id + " AND u.isRm="+1);
      List<Userslogin> userLogin = new ArrayList<>();
      userLogin = query.getResultList();
      for(Userslogin s: userLogin){
      Rm_Name = s.getFirstName()+" " + s.getLastName();
      Rm_Dept = s.getDepartment();
      }
      em.getTransaction().commit();
      //System.out.println(" records inserted in userlogin");  
     // em.getTransaction().commit(); 
    /*
    while(rs.next()){
        Rm_Name = rs.getString(2) +" "+ rs.getString(3);
        Rm_Dept = rs.getString(10);
        
    }
    */
    if(Rm_Name!=null&&Rm_Name!="") {	
        response.sendRedirect("UpdateReportingManager.jsp?edit=yes&fetch=yes&id="+user_id+"&rm_id="+rm_id+"&rm_dept="+Rm_Dept+"&rm_name="+Rm_Name);    
    }else{
    response.sendRedirect("UpdateReportingManager.jsp?edit=yes&error=yes&id="+user_id);
    }
    }
    catch(Exception e){
        e.printStackTrace();

 


    }
   
}
}