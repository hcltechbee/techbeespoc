package com.servlet.users;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.classes.users.UsersDataBase;

public class FeedServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession();
		session = request.getSession(false);
		
		
		String loginedUser="";
        String loginedUserId="";
        int CheckId=0;
        if(session.getAttribute(com.constants.UIConstants.SESSION_NAME)!= null)
        {
        	loginedUser =session.getAttribute(com.constants.UIConstants.SESSION_NAME).toString();
        	loginedUserId=session.getAttribute(com.constants.UIConstants.SESSION_USER_ID).toString();
        	CheckId=Integer.parseInt(loginedUserId);
        	String userLogined[]=loginedUser.split(" ");
        	//System.out.println(userLogined[0]);
        	loginedUser=userLogined[0];
        	//System.out.println(loginedUser);	
        } 
        System.out.println(CheckId);
        
		String messageOfUser ="";
	    messageOfUser=request.getParameter(com.constants.UIConstants.MESSAGEBYUSERS);
		String imageOfUser = "";
		imageOfUser=request.getParameter(com.constants.UIConstants.IMAGE);
		
		if(messageOfUser.isEmpty()) {
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('PLEASE ENTER SOME TEXT');");  
			out.println("</script>"); 
		}
		else if(imageOfUser.isEmpty()) {
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('NO PHOTO SECLETED');");  
			out.println("</script>");
		}
		
		else {
			UsersDataBase.InsertFeed(CheckId, messageOfUser, imageOfUser);
		response.sendRedirect(com.constants.URLConstants.HOME_PAGE_URL);
		}
	
		
	}	
}
