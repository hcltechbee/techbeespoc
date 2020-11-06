package com.servlet.forgetPassServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.connector.dbConnector;

/**
 * Servlet implementation class forgetPassServlet
 */
@WebServlet("/forgetServlet")
public class forgetServlet extends HttpServlet {	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mobile_number = request.getParameter(com.constants.UIConstants.forgetNumber);
		try{
		dbConnector dbcon = new dbConnector();
		Connection con = dbConnector.con;
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery("SELECT Email_Id FROM users.userslogin where `Mobile_Number` = '" + mobile_number + "'");
		String Email;
		if(rs.next()){
			Email = rs.getString(1);
			response.sendRedirect("http://localhost:8080/User_Management_POC/Login.jsp?Email=" + Email);
		}
		else{
			System.out.println(mobile_number);
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
