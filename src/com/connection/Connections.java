package com.connection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


/**
 * 
 */

/**
 * @author root
 *
 */
public class Connections extends HttpServlet{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{

	long max = 1000000000; 
    long min = 1000000; 
    long range = max - min + 1; 
    long rand = 1;
    // generate random numbers within 1 to 10 
    for (int i = 0; i < 10; i++) { 
        rand = (long)(Math.random() * range) + min; 


        
    } 
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

String query =com.constants.QueryConstants.UDINSQUERY+ rand + ","+
"'"+ first_name +"',"+
"'"+ last_name +"',"+
mob_number +","+
gender+","+
"'"+ address +"',"+
"'"+ city +"',"+
"'"+ p_code+"',"+
"'"+ state +"',"+
"'India',"+
"'"+DOB+ "')"+
";";
String query2 = com.constants.QueryConstants.ULINSQUERY+ rand + ","+
"'"+ first_name +"',"+
"'"+ last_name +"',"+
"'"+ email_id +"',"+
"'"+ pwd +"',"+
"1)"+
";";
try{
	
    Class.forName(com.constants.URLConstants.DATABASEDRIVER);  
    Connection connection=DriverManager.getConnection(com.constants.URLConstants.DATABASEURL,com.constants.URLConstants.DATABASEUSERNAME,com.constants.URLConstants.DATABASEPASSWORD);
    PreparedStatement stmt1=connection.prepareStatement(query2);   

    int j=stmt1.executeUpdate();  
    System.out.println(j+" records inserted in userlogin");
    
    PreparedStatement stmt=connection.prepareStatement(query);   

    int i=stmt.executeUpdate();  
    System.out.println(i+" records inserted in userdetails");  
    
  
      
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
}


	
	
	

	
	
	


}





