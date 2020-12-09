package com.servlet.loginServlet;


import java.io.IOException;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;
import com.classes.users.UsersDataBase;
import com.connection.Userdetail;
import com.connection.Userslogin;
import com.constants.QueryConstants;
import com.servlet.users.Userfeed;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String email = request.getParameter(com.constants.UIConstants.LOGIN_EMAIL);
			String password = request.getParameter(com.constants.UIConstants.LOGIN_PASSWORD);
			List<Userslogin> login = new ArrayList<>();
			String userEmail = "", userPassword = "", userName = "", lastName = "", firstName = "";
			Userslogin user1 = new Userslogin();
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("InsertUsers");
			EntityManager em = emf.createEntityManager();
			Query query = em.createQuery("SELECT u FROM Userslogin u where u.emailId  = " + "\"" + email + "\"");
			login = query.getResultList();
			em.getTransaction().begin();
			int isAdmin = 0;
			int userId = 1;
			System.out.println("hi");
			for (Userslogin s : login) {
				userEmail = s.getEmailId();
				System.out.println(userEmail);
				userPassword = s.getPassword();

				firstName = s.getFirstName();
				isAdmin = s.getIsadmin();
				lastName = s.getLastName();
				userId = s.getUser_Id();
			}
			System.out.println("hi 1");
			em.getTransaction().commit();
			emf.close();
			String success = "false";
			if (userEmail != null) {
				boolean matched = BCrypt.checkpw(password, userPassword);
				System.out.println("Hash Password matched : " + matched);
				if (matched == true) {
					success = "true";
					response.sendRedirect(com.constants.URLConstants.LOGIN_SUCCESS_URL + success);
					HttpSession session = request.getSession();
					session.setAttribute(com.constants.UIConstants.SESSION_NAME, firstName + " " + lastName);
					session.setAttribute(com.constants.UIConstants.SESSION_USER_ID, userId);
					// System.out.println(""+userId);
					session.setAttribute(com.constants.UIConstants.SESSION_ISADMIN, isAdmin);
					session.setAttribute(com.constants.UIConstants.SESSION_LOGGEDIN, true);
				} else {
					success = "false";
					System.out.println("sorry");
					response.sendRedirect(com.constants.URLConstants.LOGIN_SUCCESS_URL + success);
				}
			} else {
				success = "username_incorrect";
				response.sendRedirect(com.constants.URLConstants.LOGIN_SUCCESS_URL + success);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
