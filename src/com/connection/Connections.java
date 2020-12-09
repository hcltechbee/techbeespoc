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

	Userslogin usersLogin=new Userslogin();
	Userdetail userDetails = new Userdetail();
	  EntityManagerFactory entitymanagerfactory=Persistence.createEntityManagerFactory(com.constants.UIConstants.ENTITY_NAME); 
	  EntityManager entitymanager=entitymanagerfactory.createEntityManager();
	  entitymanager.getTransaction().begin();   
	  usersLogin.setUser_Id(1000);
	  usersLogin.setFirstName(request.getParameter(com.constants.UIConstants.FIRSTNAME));
	  usersLogin.setLastName(request.getParameter(com.constants.UIConstants.LASTNAME));
	  usersLogin.setEmailId(request.getParameter(com.constants.UIConstants.EMAILID));
	  usersLogin.setIsadmin((byte)1);
	  usersLogin.setPassword(request.getParameter(com.constants.UIConstants.PWD));
	 
	  entitymanager.persist(usersLogin);  
	  entitymanager.getTransaction().commit();
	  LOGGER.log(Level.INFO, "RECORDS INSERTED IN USERSLOGIN");
	 // em.getTransaction().commit(); 
	  

	 
	  
	 
	 EntityManager em1=entitymanagerfactory.createEntityManager();
	 em1.getTransaction().begin();
	 System.out.println(userDetails.getUserId());
	 userDetails.setUserId(1000);;
	 System.out.println(userDetails.getUserId());
	 
	  BigInteger mob;
	  mob = new BigInteger(request.getParameter(com.constants.UIConstants.MOBILENUMBER));
	  userDetails.setFirstName(request.getParameter(com.constants.UIConstants.FIRSTNAME));
	  userDetails.setLastName(request.getParameter(com.constants.UIConstants.LASTNAME));
	  userDetails.setMobileNumber(mob);
userDetails.setGender(request.getParameter(com.constants.UIConstants.GENDER));
userDetails.setAddress(request.getParameter(com.constants.UIConstants.ADDRESS));
userDetails.setCity(request.getParameter(com.constants.UIConstants.CITY));
userDetails.setPincode(request.getParameter(com.constants.UIConstants.PINCODE));
userDetails.setState(request.getParameter(com.constants.UIConstants.STATE));
userDetails.setCountry(com.constants.UIConstants.INDIA);
Date date1;
try {
	date1 = new SimpleDateFormat("yyyy-mm-dd").parse(request.getParameter(com.constants.UIConstants.DATEOFBIRTH));
	//Date sqldate = new Date(date1.getTime());
	userDetails.setDateOfBirth(date1);
} catch (ParseException e) {
	e.printStackTrace();
} 
em1.persist(userDetails);  
em1.getTransaction().commit(); 
response.sendRedirect(com.constants.URLConstants.LOGIN_PAGE_URL); 

      entitymanagerfactory.close();
     

     
     
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





