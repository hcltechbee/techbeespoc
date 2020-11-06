package com.servlet.users;

import java.io.IOException;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import com.classes.users.UsersDataBase;  
  
@SuppressWarnings("serial")
public class DeleteServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
             throws ServletException, IOException {  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        UsersDataBase.deleteUser(id);  
        response.sendRedirect("UserInterface.jsp");  
    }  
}  