package com.servlet.editRmServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.classes.users.UsersDataBase;
import com.connection.Userslogin;

/**
 * Servlet implementation class editRm
 */
@WebServlet("/editRm")
public class editRm extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute(com.constants.UIConstants.SESSION_NAME) == null){
			response.sendRedirect(com.constants.URLConstants.LOGIN_PAGE_URL);
		}
		// TODO Auto-generated method stub
		int Rm_Id = Integer.parseInt(request.getParameter(com.constants.UIConstants.RM_ID));
		int User_Id = Integer.parseInt(request.getParameter(com.constants.UIConstants.USER_ID));
		EntityManagerFactory entitymanagerfactory=Persistence.createEntityManagerFactory(com.constants.UIConstants.ENTITY_NAME); 
		  EntityManager entitymanager=entitymanagerfactory.createEntityManager();
		  entitymanager.getTransaction().begin();
		  Userslogin userslogin = new Userslogin();
		  userslogin = entitymanager.find(Userslogin.class, User_Id);
		  userslogin.setRmId(Rm_Id);
			response.sendRedirect(com.constants.URLConstants.SEARCH_REPORTING_MANAGER_URL);
		
	}

}
