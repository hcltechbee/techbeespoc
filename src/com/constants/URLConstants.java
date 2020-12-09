package com.constants;

import java.sql.Connection;

public class URLConstants {
	public final static String LOGIN_SUCCESS_URL = "Login.jsp?success=";
	public final static String LOGIN_EMAIL_URL = "Login.jsp?Email=";
	public final static String LOGIN_PAGE_URL = "Login.jsp";
	public static final String HOME_PAGE_URL = "Home.jsp";
	public static final String REGISTERATION = "Registeration_Form.html";
	public static final String UPDATE_USER = "UpdateUser.jsp";
	public static final String UPDATE_USER_EDIT_URL = "UpdateReportingManager.jsp?edit=yes&fetch=yes&id=";
	public static final String UPDATE_USER_FETCH_ERROR_URL = "UpdateReportingManager.jsp?edit=yes&fetch=yes&error=yes";
	public static final String UPDATE_USER_ERROR_URL = "UpdateReportingManager.jsp?edit=yes&error=yes&id=";
	public static final String SEARCH_REPORTING_MANAGER_URL = "SearchReportingManager.jsp";
	public static final String FORGOT_PAGE_ERROR_URL = "forgot.jsp?error=mobile_number_invalid";
	
	
	public static final String DATABASEURL="jdbc:mysql://localhost:3309/users";
	public static final String DATABASEUSERNAME="root";
	public static final String DATABASEPASSWORD="123456";
	public static final String DATABASEDRIVER="com.mysql.jdbc.Driver";
	public static Connection DATABASECONNECTION=null; 
}
