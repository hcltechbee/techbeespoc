package com.servlet.updateRmServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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

import com.classes.users.UsersDataBase;
import com.connection.Userslogin;

/**
 * Servlet implementation class UpdateRm
 */
@WebServlet("/UpdateRm")
public class UpdateRm extends HttpServlet {
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			if(session.getAttribute(com.constants.UIConstants.SESSION_NAME) == null){
				response.sendRedirect("Login.jsp");
			}
		// TODO Auto-generated method stub
	int RM_Id = Integer.parseInt(request.getParameter("Rm_Id"));
	int User_Id = Integer.parseInt(request.getParameter("user_id"));
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("InsertUsers"); 
	  EntityManager em=emf.createEntityManager();
	  em.getTransaction().begin();
	  Query query = em.createQuery("SELECT u "+"from Userslogin u "+"where u.user_Id = " +RM_Id+" AND u.isRm = "+1);
		Userslogin userslogin = em.find(Userslogin.class, User_Id); 
		List<Userslogin> userData = new ArrayList<>();
		userData = query.getResultList();
		em.getTransaction().commit();
		for(Userslogin s: userData){
			em.getTransaction().begin();
			userslogin.setRmId(RM_Id);
			em.getTransaction().commit();
			
		}
		if(userslogin.getRmId() == RM_Id){
		response.sendRedirect("SearchReportingManager.jsp");
		}
		else{
		response.sendRedirect("UpdateReportingManager.jsp?edit=yes&fetch=yes&error='yes'");}
		}
		

}
