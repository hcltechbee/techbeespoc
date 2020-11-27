package com.constants;

public class QueryConstants {
	public static final String DISPLAYALLUSERS="select * from POC_work.userslogin";
	public static final String DELETEUSERS="delete from POC_work.userslogin where User_Id=?";
	public static final String SEARCHUSER="select * from POC_work.userslogin where FIRST_NAME=?";
	public static final String CHECKEMAIL="SELECT Email_Id, Password, First_Name, isAdmin, Last_Name, User_id FROM POC_work.userslogin where `Email_Id` = '";
	public static final String CHECKMOBILE="SELECT Email_Id FROM POC_work.userslogin where `Mobile_Number` = '";
	public static final String INSERTQUERY = "INSERT INTO `POC_work`.`userslogin` (`User_Id`,`First_Name`,`Last_Name`,`isAdmin`,"+
			"`Email_Id`,`Mobile_Number`,`Gender`,`Address`,`City`,`Pin_Code`,`State`,`Country`,`Password`,"+
			"`DateOfBirth`) VALUES ( ";
        public static final String INSERTFEED = "insert into POC_work.userfeeds(USER_ID,FEED_TEXT,PHOTO) values(?,?,?)";
	public static final String SEARCHFEED = "select * from POC_work.userfeeds where DATE_CREATED > ? ";
	public static final String SEARCHFEEDIMAGE = "select * from POC_work.userfeeds where Feed_Id=?";

	public static final String DELETERMMAPQUERY = "UPDATE userslogin SET `RM_ID` = null WHERE `USER_ID` = ";
	public static final String UPDATERMQUERY = "UPDATE userslogin SET `RM_ID` = '";

	public static final String CHECKRMID = "SELECT * FROM userslogin WHERE USER_ID = ";
	public static final String GETRMID = "SELECT RM_ID FROM userslogin WHERE USER_ID = '";
}
