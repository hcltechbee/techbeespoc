package com.servlet.editRmServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
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
			response.sendRedirect("Login.jsp");
		}
		// TODO Auto-generated method stub
		int Rm_Id = Integer.parseInt(request.getParameter("Rm_Id"));
		int User_Id = Integer.parseInt(request.getParameter("user_id"));
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("InsertUsers"); 
		  EntityManager em=emf.createEntityManager();
		  em.getTransaction().begin();
		  Userslogin userslogin = new Userslogin();
		  userslogin = em.find(Userslogin.class, User_Id);
		  userslogin.setRmId(Rm_Id);
			response.sendRedirect("SearchReportingManager.jsp");
		
	}

}
