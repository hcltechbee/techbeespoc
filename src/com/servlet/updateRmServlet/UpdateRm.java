package com.servlet.updateRmServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.classes.users.UsersDataBase;

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
	String RM_Id = request.getParameter("Rm_Id");
	String User_Id = request.getParameter("user_id");
	try{
	Connection con = UsersDataBase.getConnection();
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(com.constants.QueryConstants.CHECKRMID+ RM_Id + "' AND IS_RM=1" );
	if (rs.next() == false)
	{
		response.sendRedirect("UpdateReportingManager.jsp?edit=yes&fetch=yes&error='yes'");
	}
	else{
	stmt.executeUpdate(com.constants.QueryConstants.UPDATERMQUERY + RM_Id + "' WHERE USER_ID = '" + User_Id+"'");
	response.sendRedirect("SearchReportingManager.jsp");
	}
	}
		catch(Exception e){
			e.printStackTrace();
		}
}
}
