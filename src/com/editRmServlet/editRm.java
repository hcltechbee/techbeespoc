package com.servlet.editRmServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.classes.users.UsersDataBase;

/**
 * Servlet implementation class editRm
 */
@WebServlet("/editRm")
public class editRm extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute(com.constants.UIConstants.SESSIONNAME) == null){
			response.sendRedirect("Login.jsp");
		}
		// TODO Auto-generated method stub
		String Rm_Id = request.getParameter("Rm_Id");
		String User_Id = request.getParameter("user_id");
		Connection con = UsersDataBase.getConnection();
		try {
		Statement stmt;
			stmt = con.createStatement();
			String query = com.constants.QueryConstants.UPDATERMQUERY + Rm_Id + "' WHERE USER_ID = '"+ User_Id + "'";
			System.out.println(query);
			stmt.executeUpdate(query);
			response.sendRedirect("SearchReportingManager.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
