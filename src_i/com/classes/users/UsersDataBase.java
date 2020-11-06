package com.classes.users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.constants.QueryConstants;
import com.constants.URLConstants;

public class UsersDataBase {
	
	/*-----------------------------------------------------------------THIS PART IS FOR CREATING CONNECTION WITH EMPLOYEES---------*/
	
	public static Connection getConnection(){  
		URLConstants DBConnectivity= new URLConstants();  // Creating instance of Constant class for DB Connectivity
        try{  
            Class.forName(DBConnectivity.dataBaseDriver);
            DBConnectivity.dataBaseConnection=DriverManager.getConnection(URLConstants.dataBaseURL, URLConstants.dataBaseUserName, URLConstants.dataBasePassword);  
        }catch(Exception e){System.out.println(e);}  
        return DBConnectivity.dataBaseConnection;  
    }  
	
	/*-----------------------------------------------------------------THIS PART IS FOR GEETING ALL EMPLOYEES--------------*/
	
	 public static List<Users> getAllEmployees(){  
	        List<Users> list=new ArrayList<>();  
	        URLConstants DBConnectivity= new URLConstants();  // Creating instance of Constant class for DB Connectivity
	        QueryConstants queries = new QueryConstants();
	        
	try{  
        DBConnectivity.dataBaseConnection=UsersDataBase.getConnection();  
        PreparedStatement preparedStatement=DBConnectivity.dataBaseConnection.prepareStatement(queries.displayAllUsers);  
        ResultSet resultSet=preparedStatement.executeQuery();  
        while(resultSet.next()){  
            Users e=new Users();  
            e.setId(resultSet.getInt(1));  
            e.setName(resultSet.getString(2));  
            e.setPassword(resultSet.getString(3));  
            e.setEmail(resultSet.getString(4));  
            e.setCountry(resultSet.getString(5));  
            list.add(e);  
        }  
        DBConnectivity.dataBaseConnection.close();  
    }catch(Exception e){e.printStackTrace();}  
      
    return list;  
	 }  

	 /*-----------------------------------------------------------------THIS PART IS FOR DELETING USERS FROM DB--------------*/
	 
	  public static int deleteUser(int id){  
	        int status=0;  
	        URLConstants DBConnectivity= new URLConstants();  // Creating instance of Constant class for DB Connectivity
	        QueryConstants queries = new QueryConstants();
	        try{  
	            DBConnectivity.dataBaseConnection=UsersDataBase.getConnection();  
	            PreparedStatement preparedStatement=DBConnectivity.dataBaseConnection.prepareStatement(queries.deleteUsers);  
	            preparedStatement.setInt(1,id);  
	            status=preparedStatement.executeUpdate();  
	              
	            DBConnectivity.dataBaseConnection.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return status;  
	    }  
	
	  
	  
	  /*-----------------------------------------------------------------THIS PART IS FOR SEARCHING EMPLOYEES--------------*/
	  
	  
		 public static List<Users> getAllEmployees(String userName){  
		        List<Users> filterList=new ArrayList<>();  
		       // userName="%"+userName+"%";
		        URLConstants DBConnectivity= new URLConstants();  // Creating instance of Constant class for DB Connectivity
		        QueryConstants queries = new QueryConstants();
		try{  
	        DBConnectivity.dataBaseConnection=UsersDataBase.getConnection();  
	        PreparedStatement preparedStatement=DBConnectivity.dataBaseConnection.prepareStatement(queries.searchUser);  
	        preparedStatement.setString(1,userName); 
	        ResultSet resultSet=preparedStatement.executeQuery();  
	        while(resultSet.next()){  
	            Users e=new Users();  
	            e.setId(resultSet.getInt(1));  
	            e.setName(resultSet.getString(2));  
	            e.setPassword(resultSet.getString(3));  
	            e.setEmail(resultSet.getString(4));  
	            e.setCountry(resultSet.getString(5));  
	            filterList.add(e);  
	        }  
	        DBConnectivity.dataBaseConnection.close();  
	    }catch(Exception e){e.printStackTrace();}  
	      
	    return filterList;  
	 } 
}
