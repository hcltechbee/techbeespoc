package com.classes.users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.constants.QueryConstants;
import com.constants.URLConstants;

public class UserDaoLayer {
		public static List<User> getAllSearchUser(String FirstName, String LastName) throws SQLException {
			 List<User> searchedList=new ArrayList<>();
		 PreparedStatement preparedStatement=URLConstants.DATABASECONNECTION.prepareStatement(QueryConstants.USERSEARCH);  
	        preparedStatement.setString(1,FirstName);
	        preparedStatement.setString(2,LastName);
	        ResultSet resultSet=preparedStatement.executeQuery();
	        
	     
	     while(resultSet.next()){  
	    	 
	            User currentUser=new User();  
	            currentUser.setUser_id(resultSet.getInt(1));
	            currentUser.setFirst_name(resultSet.getString(2));  
	            currentUser.setLast_Name(resultSet.getString(3));  
	            currentUser.setEmail_Id(resultSet.getString(5));  
	            currentUser.setMobile_No(resultSet.getString(6));
	            currentUser.setCountry(resultSet.getString(12)); 
	            currentUser.setPassword(resultSet.getString(13));
	          
	            searchedList.add(currentUser);
	           
	    
	     System.out.println(searchedList.size());
	     System.out.println();
	     }
			return searchedList;  
	}

		
		public static int getAllCount() throws SQLException {
			
			java.sql.Connection conn=UsersDataBase.getConnection();
			java.sql.Statement stmt = conn.createStatement();
			
			
			 PreparedStatement preparedStatement=URLConstants.DATABASECONNECTION.prepareStatement(QueryConstants.USERCOUNT);  
		      
		        ResultSet resultSet=preparedStatement.executeQuery();
		        
		        int result=0;
			     while(resultSet.next()){  
			    	 
	    	 
			    	 result=resultSet.getInt(1);
			          
			            
			        
			    
			     }
					return result;  
		
		
		}
		
public static int getAllCountRM() throws SQLException {
			
			java.sql.Connection conn=UsersDataBase.getConnection();
			java.sql.Statement stmt = conn.createStatement();
			
			
			 PreparedStatement preparedStatement=URLConstants.DATABASECONNECTION.prepareStatement(QueryConstants.USERCOUNTRM);  
		      
		        ResultSet resultSet=preparedStatement.executeQuery();
		        
		        int result=0;
			     while(resultSet.next()){  
			    	 
	    	 
			    	 result=resultSet.getInt(1);
			          
			            
			     }
					return result;  
		
		
		}
}
