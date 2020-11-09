package com.constants;

import java.sql.Connection;

public class URLConstants {
	public final static String loginSucessUrl = "Login.jsp?success=";
	public final static String loginEmailUrl = "Login.jsp?Email=";
	public final static String loginPageUrl = "Login.jsp";
	public static final String homePgaeUrl = "Home.jsp";
	public static final String registeration = "Registeration_Form.html";
	public static final String updateUser = "UpdateUser.jsp";
	
	
	public static final String DATABASEURL="jdbc:mysql://localhost:3306/POC_work";
	public static final String DATABASEUSERNAME="root";
	public static final String DATABASEPASSWORD="2710";
	public static final String DATABASEDRIVER="com.mysql.jdbc.Driver";
	public static Connection DATABASECONNECTION=null; 
}
