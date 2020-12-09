package com.connection;
import java.io.IOException;
//import java.sql.Connection;
///import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.math.BigInteger;

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
    EntityManagerFactory entitymanagerfactory=Persistence.createEntityManagerFactory(com.constants.UIConstants.ENTITY_NAME); 
      EntityManager entitymanager=entitymanagerfactory.createEntityManager();
      entitymanager.getTransaction().begin();   
      int id = Integer.parseInt(request.getParameter(com.constants.UIConstants.SESSION_USER_ID));
      Userslogin usersLogin=entitymanager.find(Userslogin.class, id);
      Userdetail usersDetails = entitymanager.find(Userdetail.class, id);
      String gender = request.getParameter(com.constants.UIConstants.GENDER);
      BigInteger mob = new BigInteger(request.getParameter(com.constants.UIConstants.MOBILENUMBER));
      usersLogin.setFirstName(request.getParameter(com.constants.UIConstants.FIRSTNAME));
      usersLogin.setLastName(request.getParameter(com.constants.UIConstants.LASTNAME));
      usersLogin.setEmailId(request.getParameter(com.constants.UIConstants.EMAILID));
      usersDetails.setFirstName(request.getParameter(com.constants.UIConstants.FIRSTNAME));
      usersDetails.setLastName(request.getParameter(com.constants.UIConstants.LASTNAME));
      usersDetails.setMobileNumber(mob);
      usersDetails.setGender(gender);
      usersDetails.setGender(request.getParameter(com.constants.UIConstants.GENDER));
      usersDetails.setAddress(request.getParameter(com.constants.UIConstants.ADDRESS));
      usersDetails.setCity(request.getParameter(com.constants.UIConstants.CITY));
      usersDetails.setPincode(request.getParameter(com.constants.UIConstants.PINCODE));
      usersDetails.setState(request.getParameter(com.constants.UIConstants.STATE));
      usersLogin.setIsadmin((byte)1);
      
      
      entitymanager.persist(usersLogin);     
      entitymanager.persist(usersDetails);
      entitymanager.getTransaction().commit();

 

      response.sendRedirect(com.constants.URLConstants.LOGIN_PAGE_URL);  
    

 

    entitymanagerfactory.close();   
/*
    
    response.setContentType("text/html");	


String mob_number =request.getParameter(com.constants.UIConstants.MOBILENUMBER);
String DOB =request.getParameter(com.constants.UIConstants.DATEOFBIRTH);
String gender =request.getParameter(com.constants.UIConstants.GENDER);
String address =request.getParameter(com.constants.UIConstants.ADDRESS);
String city =request.getParameter(com.constants.UIConstants.CITY);
String p_code =request.getParameter(com.constants.UIConstants.PINCODE);
String state =request.getParameter(com.constants.UIConstants.STATE);
String pwd =request.getParameter(com.constants.UIConstants.PWD);
String c_pwd =request.getParameter("conf_pwd");

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





