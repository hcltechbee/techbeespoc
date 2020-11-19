package com.servlet.fetchdetailsservlet;

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
 * Servlet implementation class fetchdetailsservlet
 */
@WebServlet("/fetchdetailsservlet")
public class fetchdetailsservlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session = request.getSession();
	if(session.getAttribute(com.constants.UIConstants.SESSIONNAME) == null){
		response.sendRedirect("Login.jsp");
	}
	String rm_id = request.getParameter("rm_id");
	String original_user_id = request.getParameter("user_id");
	String user_id = original_user_id;
	try{
	Connection con = UsersDataBase.getConnection();
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(com.constants.QueryConstants.CHECKRMID + rm_id +"' and IS_RM=1" );
	String Rm_Name = "";
	String Rm_Dept = "";
	while(rs.next()){
		Rm_Name = rs.getString(2) +" "+ rs.getString(3);
		Rm_Dept = rs.getString(10);
		response.sendRedirect("UpdateReportingManager.jsp?edit=yes&fetch=yes&id="+user_id+"&rm_id="+rm_id+"&rm_dept="+Rm_Dept+"&rm_name="+Rm_Name);
	}
	response.sendRedirect("UpdateReportingManager.jsp?edit=yes&error=yes&id="+user_id);
	}
	catch(Exception e){
		e.printStackTrace();
	}
}

}
