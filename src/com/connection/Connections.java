package ssd;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.journaldev.log.LoggingExample;

/**
 * @author root
 *
 */
public class Connections extends HttpServlet{
	  static Logger logger = Logger.getLogger(Connections.class.getName());
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
String query = com.constants.QueryConstants.INSERTQUERY + rand + "," + " TRIM ('" + first_name + "')," +

			" TRIM ('" + last_name + "')," + "1," + " TRIM ('" + email_id + "')," + mob_number + "," + gender + ","
			+ " TRIM ('" + address + "')," + " TRIM ('" + city + "')," + p_code + "," + " TRIM ('" + state + "'),"
			+ "'India'," + " TRIM ('" + pwd + "')," + "'" + DOB + "')" + ";";

try{
	
    Class.forName(com.constants.URLConstants.DATABASEDRIVER);  
    Connection connection=DriverManager.getConnection(com.constants.URLConstants.DATABASEURL,com.constants.URLConstants.DATABASEUSERNAME,com.constants.URLConstants.DATABASEPASSWORD);
    PreparedStatement stmt1=connection.prepareStatement(query2); 
    int j=stmt1.executeUpdate();  
	
    System.out.println(j+" records inserted in userlogin");    
    PreparedStatement stmt=connection.prepareStatement(query);   
    int i=stmt.executeUpdate();   
    LOGGER.log(Level.INFO, i+"records inserted in userdetails");
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





