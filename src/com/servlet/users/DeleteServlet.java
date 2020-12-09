package com.servlet.users;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.classes.users.UsersDataBase;
import com.constants.UIConstants;


@SuppressWarnings("serial")
public class DeleteServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
             throws ServletException, IOException {  
        String userId =request.getParameter(com.constants.UIConstants.SESSION_USER_ID);  
        int identificationOfUser=Integer.parseInt(userId);  
        UsersDataBase.deleteUser(identificationOfUser);  
        response.sendRedirect(UIConstants.DELETE_USING_SEARCH);  
    }  
}  
