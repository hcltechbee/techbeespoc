package com.servlet.forgetPassServlet;

import java.io.IOException;
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

import com.connection.Userdetail;
import com.connection.Userslogin;


/**
 * Servlet implementation class forgetPassServlet
 */
@WebServlet("/forgetServlet")
public class forgetServlet extends HttpServlet {	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forget_mobile_number = request.getParameter(com.constants.UIConstants.FORGET_NUMBER);
			EntityManagerFactory emf=Persistence.createEntityManagerFactory(com.constants.UIConstants.ENTITY_NAME); 
		      EntityManager em=emf.createEntityManager();
		      em.getTransaction().begin();
		      Query query = em.createQuery(com.constants.QueryConstants.MOBILENUMBERCHECK + forget_mobile_number);
		      List<Userdetail> dataList = query.getResultList();		      
		      System.out.println(query);
		      em.getTransaction().commit();
		      int user_id = 0;
		      for(Userdetail d: dataList){
		    	  System.out.println(user_id);
		    	  user_id = d.getUserId();
		      }
		      if(user_id != 0){
		      em.getTransaction().begin();
		      Userslogin usersLogin = em.find(Userslogin.class, user_id);
		      em.getTransaction().commit();
		      String Email = "";
		    	  Email = usersLogin.getEmailId();
		    	  if(Email!="")
		    	  {
		    	  response.sendRedirect(com.constants.URLConstants.LOGIN_EMAIL_URL+ Email);
		    	  }		 
		    	  else{
		    		  response.sendRedirect(com.constants.URLConstants.FORGOT_PAGE_ERROR_URL);
		    	  }
		      }
		      else{
		    	  response.sendRedirect(com.constants.URLConstants.FORGOT_PAGE_ERROR_URL);
		      }
		
	}
}
