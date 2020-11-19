package com.connection;
import java.io.IOException;
//import java.sql.Connection;
///import java.sql.DriverManager;
//import java.sql.PreparedStatement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.swing.JOptionPane;


/**
 * 
 */

/**
 * @author root
 *
 */
public class UpdateUserConnections extends HttpServlet{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{

	EntityManagerFactory emf=Persistence.createEntityManagerFactory("InsertUsers"); 
	  EntityManager em=emf.createEntityManager();
	  em.getTransaction().begin();   
	  Userslogin user1=new Userslogin();
	  
	  user1.setFirstName(request.getParameter(com.constants.UIConstants.FIRSTNAME));
	  user1.setLastName(request.getParameter(com.constants.UIConstants.LASTNAME));
	  user1.setEmailId(request.getParameter(com.constants.UIConstants.EMAILID));
	  user1.setIsadmin((byte)1);
	 
	  em.persist(user1);  
	  em.getTransaction().commit();   

	  response.sendRedirect("Login.jsp");  
    

    emf.close();   

   
	/*
	
response.setContentType("text/html");	

String 	first_name =request.getParameter(com.constants.UIConstants.FIRSTNAME);
String 	last_name =request.getParameter(com.constants.UIConstants.LASTNAME);
String email_id =request.getParameter(com.constants.UIConstants.EMAILID);
String mob_number =request.getParameter(com.constants.UIConstants.MOBILENUMBER);
String DOB =request.getParameter(com.constants.UIConstants.DATEOFBIRTH);
String gender =request.getParameter(com.constants.UIConstants.GENDER);
String address =request.getParameter(com.constants.UIConstants.ADDRESS);
String city =request.getParameter(com.constants.UIConstants.CITY);
String p_code =request.getParameter(com.constants.UIConstants.PINCODE);
String state =request.getParameter(com.constants.UIConstants.STATE);
String pwd =request.getParameter(com.constants.UIConstants.PWD);
//String c_pwd =request.getParameter("conf_pwd");

String query="UPDATE `POC_work`.`userslogin`\n"
		+ "SET\n"
		+ "`User_Id` = <{User_Id: }>,\n"
		+ "`First_Name` = <{First_Name: }>,\n"
		+ "`Last_Name` = <{Last_Name: }>,\n"
		+ "`isAdmin` = <{isAdmin: 1}>,\n"
		+ "`Email_Id` = <{Email_Id: }>,\n"
		+ "`Mobile_Number` = <{Mobile_Number: }>,\n"
		+ "`Gender` = <{Gender: }>,\n"
		+ "`Address` = <{Address: }>,\n"
		+ "`City` = <{City: }>,\n"
		+ "`Pin_Code` = <{Pin_Code: }>,\n"
		+ "`State` = <{State: }>,\n"
		+ "`Country` = <{Country: }>,\n"
		+ "`Password` = <{Password: }>,\n"
		+ "`DateOfBirth` = <{DateOfBirth: }>,\n"
		+ "`Time_Stamp` = <{Time_Stamp: CURRENT_TIMESTAMP}>\n"
		+ "WHERE `User_Id` = <{expr}>;\n"
		+ "";
try{
	
    Class.forName(com.constants.URLConstants.DATABASEDRIVER);  
    Connection connection=DriverManager.getConnection(com.constants.URLConstants.DATABASEURL,com.constants.URLConstants.DATABASEUSERNAME,com.constants.URLConstants.DATABASEPASSWORD);
    PreparedStatement stmt=connection.prepareStatement(query);   

    int i=stmt.executeUpdate();  
    System.out.println(i+" records inserted");  
      
    connection.close();  
    response.sendRedirect("Login.jsp");  

	}
	 
catch (Exception e) {
  System.out.println(e);
	   String excep = e.toString();
	   JOptionPane.showMessageDialog(null, excep);
	   if(excep == "com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException") {
		   
		   JOptionPane.showMessageDialog(null, excep);
	   }
	   
   }
   */
}


	
	
	

	
	
	


}





