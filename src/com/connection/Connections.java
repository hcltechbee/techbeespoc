package com.connection;
import java.io.IOException;
import java.math.BigInteger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;
public class Connections extends HttpServlet{
	private static final long serialVersionUID = 1L;	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Userslogin user1 = new Userslogin();
		Userdetail user_1 = new Userdetail();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("InsertUsers");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		System.out.println(user1.getUser_Id());
		user1.setUser_Id(2263);
		System.out.println(user1.getUser_Id());
		user1.setFirstName(request.getParameter(com.constants.UIConstants.FIRSTNAME));
		user1.setLastName(request.getParameter(com.constants.UIConstants.LASTNAME));
		user1.setEmailId(request.getParameter(com.constants.UIConstants.EMAILID));
		user1.setIsadmin((byte) 1);
		String password = request.getParameter(com.constants.UIConstants.PWD);
		String generatedSecuredPasswordHash = BCrypt.hashpw(password, BCrypt.gensalt(12));
		user1.setPassword(generatedSecuredPasswordHash);
		em.persist(user1);
		em.getTransaction().commit();
		System.out.println(" records inserted in userlogin");
		EntityManager em1 = emf.createEntityManager();
		em1.getTransaction().begin();
		System.out.println(user_1.getUserId());
		user_1.setUserId(2263);
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
			date1 = new SimpleDateFormat("yyyy-mm-dd")
					.parse(request.getParameter(com.constants.UIConstants.DATEOFBIRTH));
			user_1.setDateOfBirth(date1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("hi 3");
		em1.persist(user_1);
		System.out.println("hi 4 ");
		em1.getTransaction().commit();
		System.out.println(" records inserted in userdetails");
		response.sendRedirect("Login.jsp");
		emf.close();

}
}





