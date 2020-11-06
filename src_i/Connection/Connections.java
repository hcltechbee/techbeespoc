package Connection;
import java.sql.Connection;

import java.sql.DriverManager;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.IOException;

import java.sql.*;


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
private String jdbcConnection = "jdbc:mysql://127.0.0.1:3306/POC_work";
private String jdbcUser = "root";
private String jdbcpwd = "2710";

public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{


response.setContentType("text/html");	
String 	first_name =request.getParameter("Full_Name");
String email_id =request.getParameter("Email_Id");
String mob_number =request.getParameter("Mobile_Number");
String DOB =request.getParameter("DOB");
String gender =request.getParameter("gender");
String address =request.getParameter("Address");
String city =request.getParameter("City");
String p_code =request.getParameter("Pin_Code");
String state =request.getParameter("State");
String pwd =request.getParameter("pwd");
//String c_pwd =request.getParameter("conf_pwd");

String query = "INSERT INTO `POC_work`.`userslogin` (`User_Id`,`First_Name`,`Last_Name`,`isAdmin`,"+
"`Email_Id`,`Mobile_Number`,`Gender`,`Address`,`City`,`Pin_Code`,`State`,`Country`,`Password`,"+
"`DateOfBirth`) VALUES ( 2,"+
" ' "+ first_name +"',"+

" ' "+ first_name +"',"+
"1,"+
" ' "+ email_id +"',"+
mob_number +","+
gender+","+
" ' "+ address +"',"+
" ' "+ city +"',"+
p_code +","+
" ' "+ state +"',"+
"'India',"+
" ' "+ pwd +"',"+
"'"+ DOB+ "')"+
";"
		;
try{
	
    Class.forName("com.mysql.jdbc.Driver");  
    Connection connection=DriverManager.getConnection(jdbcConnection,jdbcUser,jdbcpwd);
    PreparedStatement stmt=connection.prepareStatement(query);   

    int i=stmt.executeUpdate();  
    System.out.println(i+" records inserted");  
      
    connection.close();  
       

	}
	 
catch (Exception e) {
    System.out.println(e);
}


	
	
	

	
	
	


}




}
