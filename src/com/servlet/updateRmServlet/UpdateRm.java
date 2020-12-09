package com.servlet.updateRmServlet;

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
 * Servlet implementation class UpdateRm
 */
@WebServlet("/UpdateRm")
public class UpdateRm extends HttpServlet {
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			if(session.getAttribute(com.constants.UIConstants.SESSION_NAME) == null){
				response.sendRedirect(com.constants.URLConstants.LOGIN_PAGE_URL);
			}
		// TODO Auto-generated method stub
	int RM_Id = Integer.parseInt(request.getParameter(com.constants.UIConstants.RM_ID));
	int User_Id = Integer.parseInt(request.getParameter(com.constants.UIConstants.USER_ID));
	EntityManagerFactory entitymanagerfactory=Persistence.createEntityManagerFactory(com.constants.UIConstants.ENTITY_NAME); 
	  EntityManager entitymanager=entitymanagerfactory.createEntityManager();
	  entitymanager.getTransaction().begin();
	  Query query = entitymanager.createQuery(com.constants.QueryConstants.USERSLOGINSELECTQUERY +RM_Id+" AND u.isRm = "+1);
		Userslogin userslogin = entitymanager.find(Userslogin.class, User_Id); 
		List<Userslogin> userData = new ArrayList<>();
		userData = query.getResultList();
		entitymanager.getTransaction().commit();
		for(Userslogin s: userData){
			entitymanager.getTransaction().begin();
			userslogin.setRmId(RM_Id);
			entitymanager.getTransaction().commit();
			
		}
		if(userslogin.getRmId() == RM_Id){
		response.sendRedirect(com.constants.URLConstants.SEARCH_REPORTING_MANAGER_URL);
		}
		else{
		response.sendRedirect(com.constants.URLConstants.UPDATE_USER_FETCH_ERROR_URL);}
		}
		

}
