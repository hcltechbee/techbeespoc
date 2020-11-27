package com.constants;

import java.sql.Connection;

public class URLConstants {
	public final static String LOGIN_SUCCESS_URL = "Login.jsp?success=";
	public final static String LOGIN_EMAIL_URL = "Login.jsp?Email=";
	public final static String LOGIN_PAGE_URL = "Login.jsp";
	public static final String HOME_PAGE_URL = "Home.jsp";
	public static final String REGISTERATION = "Registeration_Form.html";
	public static final String UPDATE_USER = "UpdateUser.jsp";
	
	
	public static final String DATABASEURL="jdbc:mysql://localhost:3306/POC_work";
	public static final String DATABASEUSERNAME="root";
	public static final String DATABASEPASSWORD="2710";
	public static final String DATABASEDRIVER="com.mysql.jdbc.Driver";
	public static Connection DATABASECONNECTION=null; 
}
