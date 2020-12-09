package com.servlet.loginServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.Userslogin;



/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet { 
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String email = request.getParameter(com.constants.UIConstants.LOGIN_EMAIL);
			String password = request.getParameter(com.constants.UIConstants.LOGIN_PASSWORD);
			/*
			Connection con = UsersDataBase.getConnection();
			Statement stmt = con.createStatement();
			String query =  QueryConstants.CHECKEMAIL+ email + "'"; 
			ResultSet rs = stmt.executeQuery(query);
			*/
			List<Userslogin> login=new ArrayList<>(); 
			String userEmail="", userPassword="", userName="", lastName="", firstName="";
			Userslogin user1=new Userslogin();
			//Userdetail user_1 = new Userdetail();
			  EntityManagerFactory entitymanagerfactory=Persistence.createEntityManagerFactory("InsertUsers"); 
			  EntityManager entitymanager=entitymanagerfactory.createEntityManager();
			  Query query = entitymanager.createQuery(com.constants.QueryConstants.EMAILIDCHECK+"'"+email+"'");
			  
			  login=query.getResultList();
			  entitymanager.getTransaction().begin();
			  int isAdmin=0;
			  int userId=1;
			  
				 
					 for( Userslogin s:login ){
						  userEmail = s.getEmailId();
						  userPassword = s.getPassword();
						
							
							  
								firstName = s.getFirstName();
								 isAdmin = s.getIsadmin();
								lastName =s.getLastName();
								 userId=s.getUser_Id();
					 }
					 entitymanager.getTransaction().commit();   

			          entitymanagerfactory.close();   
				  
			         
			/*
			  
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
	  System.out.println(" records inserted in userlogin");  
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
     
			 */
			
			String success = "false";
			if(userEmail!=null){
				/*
				userEmail = rs.getString(1);
				userPassword = rs.getString(2);
				firstName = rs.getString(3);
				isAdmin = rs.getBoolean(4);
				lastName = rs.getString(5);
				userId=rs.getString(6);
				*/
				 
			if(userPassword.equals(password)){
				
				success = "true";
				response.sendRedirect(com.constants.URLConstants.LOGIN_SUCCESS_URL + success);
				HttpSession session = request.getSession();	
				session.setAttribute(com.constants.UIConstants.SESSION_NAME, firstName+" "+lastName);	
				session.setAttribute(com.constants.UIConstants.SESSION_USER_ID, userId);
				//System.out.println(""+userId);
				session.setAttribute(com.constants.UIConstants.SESSION_ISADMIN, isAdmin);
				session.setAttribute(com.constants.UIConstants.SESSION_LOGGEDIN, true);
				
			}
			else{
				success = "false";
				response.sendRedirect(com.constants.URLConstants.LOGIN_SUCCESS_URL + success);
			}
			}
			else{
				success="username_incorrect";
				response.sendRedirect(com.constants.URLConstants.LOGIN_SUCCESS_URL + success);
			}
		} catch (Exception exception) {
			LOGGER.log(Level.WARNING, "EXCEPTION OCCURED  " + exception);
		}
		
	}

}
