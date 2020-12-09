package com.servlet.fetchdetailsservlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    if(session.getAttribute(com.constants.UIConstants.SESSION_NAME) == null){
        response.sendRedirect(com.constants.URLConstants.LOGIN_PAGE_URL);
    }
    int rm_id = Integer.parseInt(request.getParameter(com.constants.UIConstants.RM_ID));
    String original_user_id = request.getParameter(com.constants.UIConstants.USER_ID);
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
      EntityManagerFactory entitymanagerfactory=Persistence.createEntityManagerFactory(com.constants.UIConstants.ENTITY_NAME); 
      EntityManager entitymanager=entitymanagerfactory.createEntityManager();
      entitymanager.getTransaction().begin();   
      Query query = entitymanager.createQuery(com.constants.QueryConstants.USERSLOGINSELECTQUERY + rm_id + " AND u.isRm="+1);
      List<Userslogin> userLogin = new ArrayList<>();
      userLogin = query.getResultList();
      for(Userslogin s: userLogin){
      Rm_Name = s.getFirstName()+" " + s.getLastName();
      Rm_Dept = s.getDepartment();
      }
      entitymanager.getTransaction().commit();  
     // em.getTransaction().commit(); 
    /*
    while(rs.next()){
        Rm_Name = rs.getString(2) +" "+ rs.getString(3);
        Rm_Dept = rs.getString(10);
        
    }
    */
    if(Rm_Name!=null&&Rm_Name!="") {	
        response.sendRedirect(com.constants.URLConstants.UPDATE_USER_EDIT_URL+user_id+"&rm_id="+rm_id+"&rm_dept="+Rm_Dept+"&rm_name="+Rm_Name);    
    }else{
    response.sendRedirect(com.constants.URLConstants.UPDATE_USER_ERROR_URL+user_id);
    }
    }
    catch(Exception exception){
    	LOGGER.log(Level.WARNING, "EXCEPTION OCCURED  " + exception);
    }
   
}
}