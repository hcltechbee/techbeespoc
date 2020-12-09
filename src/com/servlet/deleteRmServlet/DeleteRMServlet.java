package com.servlet.deleteRmServlet;

 

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

 

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 

import com.classes.users.UsersDataBase;
import com.connection.Userslogin;

 

/**
 * Servlet implementation class DeleteRMServlet
 */
@WebServlet("/DeleteRMServlet")
public class DeleteRMServlet extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int user_id = Integer.parseInt(request.getParameter(com.constants.UIConstants.SESSION_USER_ID));
        EntityManagerFactory entitymanagerfactory=Persistence.createEntityManagerFactory(com.constants.UIConstants.ENTITY_NAME); 
          EntityManager entitymanager=entitymanagerfactory.createEntityManager();
          entitymanager.getTransaction().begin();
            Userslogin userslogin = entitymanager.find(Userslogin.class, user_id);
            userslogin.setRmId(0);
            entitymanager.getTransaction().commit();
            entitymanager.close();
            
//        Connection con = UsersDataBase.getConnection();
//        Statement stmt = con.createStatement();
//        stmt.executeUpdate(com.constants.QueryConstants.DELETERMMAPQUERY + user_id);
        response.sendRedirect(com.constants.URLConstants.SEARCH_REPORTING_MANAGER_URL);
    }
}
 