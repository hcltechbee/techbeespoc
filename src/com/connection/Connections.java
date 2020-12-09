package com.connection;
import java.io.IOException;
import java.math.BigInteger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 */

/**
 * @author root
 *
 */
 
public class Connections extends HttpServlet{
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{

	Userslogin user1=new Userslogin();
	Userdetail user_1 = new Userdetail();
	  EntityManagerFactory emf=Persistence.createEntityManagerFactory(com.constants.UIConstants.ENTITY_NAME); 
	  EntityManager em=emf.createEntityManager();
	  em.getTransaction().begin();   
	  System.out.println(user1.getUser_Id());
	  user1.setUser_Id(1000);
	  System.out.println(user1.getUser_Id());
	  user1.setFirstName(request.getParameter(com.constants.UIConstants.FIRSTNAME));
	  user1.setLastName(request.getParameter(com.constants.UIConstants.LASTNAME));
	  user1.setEmailId(request.getParameter(com.constants.UIConstants.EMAILID));
	  user1.setIsadmin((byte)1);
	  user1.setPassword(request.getParameter(com.constants.UIConstants.PWD));
	 
	  em.persist(user1);  
	  em.getTransaction().commit();
	  LOGGER.log(Level.INFO, "RECORDS INSERTED IN USERSLOGIN");
	 // em.getTransaction().commit(); 
	  

	 
	  
	 
	 EntityManager em1=emf.createEntityManager();
	 em1.getTransaction().begin();
	 System.out.println(user_1.getUserId());
	 user_1.setUserId(1000);;
	 System.out.println(user_1.getUserId());
	 
	  BigInteger mob;
	  mob = new BigInteger(request.getParameter(com.constants.UIConstants.MOBILENUMBER));
	  user_1.setFirstName(request.getParameter(com.constants.UIConstants.FIRSTNAME));
	  user_1.setLastName(request.getParameter(com.constants.UIConstants.LASTNAME));
	  user_1.setMobileNumber(mob);
	  System.out.println("hi 1 ");
user_1.setGender(request.getParameter(com.constants.UIConstants.GENDER));
user_1.setAddress(request.getParameter(com.constants.UIConstants.ADDRESS));
user_1.setCity(request.getParameter(com.constants.UIConstants.CITY));
user_1.setPincode(request.getParameter(com.constants.UIConstants.PINCODE));
user_1.setState(request.getParameter(com.constants.UIConstants.STATE));
user_1.setCountry("India");
System.out.println("hi 2 ");
Date date1;
try {
	date1 = new SimpleDateFormat("yyyy-mm-dd").parse(request.getParameter(com.constants.UIConstants.DATEOFBIRTH));
	//Date sqldate = new Date(date1.getTime());
	user_1.setDateOfBirth(date1);
} catch (ParseException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} 
System.out.println("hi 3");
em1.persist(user_1);  
System.out.println("hi 4 ");
em1.getTransaction().commit(); 
System.out.println(" records inserted in userdetails"); 
response.sendRedirect("Login.jsp"); 

      emf.close();
     

     
     
/*	  
response.setContentType("text/html");	

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
   */
}


	
	
	

	
	
	


}





