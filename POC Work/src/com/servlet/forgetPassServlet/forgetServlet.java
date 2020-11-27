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

import com.classes.users.UsersDataBase;
import com.constants.QueryConstants;


/**
 * Servlet implementation class forgetPassServlet
 */
@WebServlet("/forgetServlet")
public class forgetServlet extends HttpServlet {	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forget_mobile_number = request.getParameter(com.constants.UIConstants.FORGET_NUMBER);
		try{
		Connection con = UsersDataBase.getConnection();
		Statement statement = con.createStatement();
		ResultSet check_mobile_number = statement.executeQuery(QueryConstants.CHECKMOBILE + forget_mobile_number + "'");
		String Email;
		if(check_mobile_number.next()){
			Email = check_mobile_number.getString(1);
			response.sendRedirect(com.constants.URLConstants.LOGIN_EMAIL_URL+ Email);
		}
		else{
			response.sendRedirect("forgot.jsp?error=mobile_number_invalid");
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
