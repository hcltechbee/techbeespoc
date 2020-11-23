package com.servlet.deleteRmServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.classes.users.UsersDataBase;

/**
 * Servlet implementation class DeleteRMServlet
 */
@WebServlet("/DeleteRMServlet")
public class DeleteRMServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_id = request.getParameter("id");
		try{
		Connection con = UsersDataBase.getConnection();
		Statement stmt = con.createStatement();
		stmt.executeUpdate(com.constants.QueryConstants.DELETERMMAPQUERY + user_id);
		System.out.println("deleted rm mapping");
		response.sendRedirect("SearchReportingManager.jsp");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
