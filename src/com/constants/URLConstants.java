package com.constants;

import java.sql.Connection;

public class URLConstants {
	public final static String loginSucessUrl = "Login.jsp?success=";
	public final static String loginEmailUrl = "Login.jsp?Email=";
	public final static String loginPageUrl = "Login.jsp";
	public static final String homePgaeUrl = "Home.jsp";
	
	
	public static final String DATABASEURL="jdbc:mysql://localhost:3306/keshavdb";
	public static final String DATABASEUSERNAME="root";
	public static final String DATABASEPASSWORD="Keshav@2313";
	public static final String DATABASEDRIVER="com.mysql.jdbc.Driver";
	public static Connection DATABASECONNECTION=null; 
}
