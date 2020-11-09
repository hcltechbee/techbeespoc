package com.constants;

public class QueryConstants {
	public static final String DISPLAYALLUSERS="select * from keshavdb.userslogin";
	public static final String DELETEUSERS="delete from keshavdb.userslogin where User_Id=?";
	public static final String SEARCHUSER="select * from keshavdb.userslogin where First_Name=?";
	public static final String CHECKEMAIL="SELECT Email_Id, Password, First_Name, isAdmin, Last_Name FROM keshavdb.userslogin where `Email_Id` = '";
	public static final String CHECKMOBILE="SELECT Email_Id FROM keshavdb.userslogin where `Mobile_Number` = '";
}
