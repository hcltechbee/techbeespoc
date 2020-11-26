package com.constants;

public class QueryConstants {
	public static final String DISPLAYALLUSERS="select * from keshavdb.userslogin";
	public static final String DELETEUSERS="delete from keshavdb.userslogin where User_Id=?";
	public static final String SEARCHUSER="select * from keshavdb.userslogin where First_Name=?";
	public static final String CHECKEMAIL="SELECT Email_Id, Password, First_Name, isAdmin, Last_Name, User_id FROM keshavdb.userslogin where `Email_Id` = '";
	public static final String CHECKMOBILE="SELECT Email_Id FROM keshavdb.userslogin where `Mobile_Number` = '";
	public static final String INSERTQUERY = "INSERT INTO `POC_work`.`userslogin` (`User_Id`,`First_Name`,`Last_Name`,`isAdmin`,"+
			"`Email_Id`,`Mobile_Number`,`Gender`,`Address`,`City`,`Pin_Code`,`State`,`Country`,`Password`,"+
			"`DateOfBirth`) VALUES ( ";
        public static final String INSERTFEED = "insert into keshavdb.userfeeds(USER_ID,FEED_TEXT,PHOTO) values(?,?,?)";
	public static final String SEARCHFEED = "select * from keshavdb.userfeeds where DATE_CREATED > ? ";
	public static final String SEARCHFEEDIMAGE = "select * from keshavdb.userfeeds where Feed_Id=?";

	public static final String DELETERMMAPQUERY = "UPDATE userslogin SET `RM_ID` = null WHERE `USER_ID` = ";
	public static final String UPDATERMQUERY = "UPDATE userslogin SET `RM_ID` = '";

	public static final String CHECKRMID = "SELECT * FROM userslogin WHERE USER_ID = ";
	public static final String GETRMID = "SELECT RM_ID FROM userslogin WHERE USER_ID = '";
	public static final String USERCOUNT="select  COUNT(User_Id) AS NumberOfUserId FROM create_table.userslogin";
	public static final String USERCOUNTRM="select  COUNT(id) AS NumberOfUserId FROM create_table.new_table";
}
