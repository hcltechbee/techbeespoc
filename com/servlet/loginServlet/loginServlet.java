package com.servlet.loginServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.connector.dbConnector;
import com.mysql.cj.Session;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String email = request.getParameter("Email");
			String password = request.getParameter("Password");
			System.out.println(email);
			System.out.println(password);
			dbConnector dbcon = new dbConnector();
			Connection con = dbcon.con;
			Statement stmt = con.createStatement();
			String query = "SELECT Email_Id, Password, First_Name, isAdmin FROM users.userslogin where `Email_Id` = '" + email + "'"; 
			ResultSet rs = stmt.executeQuery(query);
			String userEmail, userPassword, userName;
			Boolean isAdmin;
			String success = "false";
			if(rs.next()){
				userEmail = rs.getString(1);
				userPassword = rs.getString(2);
				userName = rs.getString(3);
				isAdmin = rs.getBoolean(4);
				System.out.println(userEmail + "  and  " + userPassword);
			if(userPassword.equals(password)){
				success = "true";
				System.out.println("login success");
				response.sendRedirect("http://localhost:8080/User_Management_POC/Login.jsp?success=" + success);
				HttpSession session = request.getSession();	
				session.setAttribute("name", userName);
				session.setAttribute("isAdmin", isAdmin);
				session.setAttribute("LoggedIn", true);
			}
			else{
				success = "false";
				System.out.println("sorry");
				response.sendRedirect("http://localhost:8080/User_Management_POC/Login.jsp?success=" + success);
			}
			}
			else{
				success="username_incorrect";
				response.sendRedirect("http://localhost:8080/User_Management_POC/Login.jsp?success=" + success);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
