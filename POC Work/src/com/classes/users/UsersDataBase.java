package com.classes.users;

import java.util.*;
import java.util.Date;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.connection.Userdetail;
import com.connection.Userslogin;
import com.constants.QueryConstants;
import com.constants.URLConstants;
import com.servlet.users.Userfeed;

public class UsersDataBase {
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	public static Connection getConnection() {
		try {
			Class.forName(URLConstants.DATABASEDRIVER);
			URLConstants.DATABASECONNECTION = DriverManager.getConnection(URLConstants.DATABASEURL,
					URLConstants.DATABASEUSERNAME, URLConstants.DATABASEPASSWORD);
			LOGGER.log(Level.INFO, "CONNECTION ESTABLISHED");
		} catch (Exception exception) {
			LOGGER.log(Level.WARNING, "EXCEPTION OCCURED  " + exception);
		}
		return URLConstants.DATABASECONNECTION;
	}

	public static List<User> getAllEmployees() {
		List<User> list = new ArrayList<>();

		try {
			URLConstants.DATABASECONNECTION = UsersDataBase.getConnection();
			PreparedStatement preparedStatement = URLConstants.DATABASECONNECTION
					.prepareStatement(QueryConstants.DISPLAYALLUSERS);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				User currentUser = new User();
				currentUser.setUser_id(resultSet.getInt(1));
				currentUser.setFirst_name(resultSet.getString(2));
				currentUser.setLast_Name(resultSet.getString(3));
				currentUser.setEmail_Id(resultSet.getString(5));
				currentUser.setMobile_No(resultSet.getString(6));
				currentUser.setCountry(resultSet.getString(12));
				list.add(currentUser);
			}
			LOGGER.log(Level.INFO, "PRINTED ALL USERS");
			URLConstants.DATABASECONNECTION.close();
		} catch (Exception exception) {
			LOGGER.log(Level.WARNING, "EXCEPTION OCCURED  " + exception);
		}

		return list;
	}

	
	public static int deleteUser(int id) {
		int status = 0;
		try {
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("InsertUsers");   

		    EntityManager em=emf.createEntityManager();   

		em.getTransaction().begin();   

		Userslogin deleteuser1=em.find(Userslogin.class,id);
			    
		em.remove(deleteuser1);   

		em.getTransaction().commit();   

		emf.close();   
			/*
			URLConstants.DATABASECONNECTION = UsersDataBase.getConnection();
			PreparedStatement preparedStatement = URLConstants.DATABASECONNECTION
					.prepareStatement(QueryConstants.DELETEUSERS);
			preparedStatement.setInt(1, id);
			status = preparedStatement.executeUpdate();
			*/
			LOGGER.log(Level.INFO, "USER DELETED");
			URLConstants.DATABASECONNECTION.close();
		} catch (Exception exception) {
			LOGGER.log(Level.WARNING, "EXCEPTION OCCURED  " + exception);
		}

		return status;
	}

	public static List<User> getAllEmployees(String userName) {
		List<User> filterList = new ArrayList<>();
		// userName="%"+userName+"%";
		try {
			/*
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("InsertUsers");   

		    EntityManager em=emf.createEntityManager();   
		    Query query = em.createQuery("SELECT p FROM POC_work.userslogin p where p.FIRST_NAME="+userName,Userslogin.class);
		    @SuppressWarnings("unchecked")  
		    List<Userslogin> list=(List<Userslogin>)query.getResultList( ); 
		    for( Userslogin s:list ) {
		    	
		    	User currentUser = new User();
				currentUser.setUser_id(s.getUser_Id());
				currentUser.setFirst_name(s.getFirstName());
				currentUser.setLast_Name(s.getLastName());
				currentUser.setEmail_Id(s.getEmailId());
				currentUser.setMobile_No(s.getUserdetail().getMobileNumber().toString());
				currentUser.setCountry(s.getUserdetail().getCountry());
				filterList.add(currentUser);
		    }
		    
			*/
			
			URLConstants.DATABASECONNECTION = UsersDataBase.getConnection();
			PreparedStatement preparedStatement = URLConstants.DATABASECONNECTION
					.prepareStatement(QueryConstants.SEARCHUSER);
			preparedStatement.setString(1, userName);
			ResultSet resultSet = preparedStatement.executeQuery();
			Userdetail ud = new Userdetail();
			while (resultSet.next()) {
				User currentUser = new User();
				currentUser.setUser_id(resultSet.getInt(1));
				currentUser.setFirst_name(resultSet.getString(2));
				currentUser.setLast_Name(resultSet.getString(3));
				currentUser.setEmail_Id(resultSet.getString(4));
				//currentUser.setMobile_No();
				//currentUser.setCountry(ud.getCountry());
				filterList.add(currentUser);
				
			}
			
			LOGGER.log(Level.INFO, "SEARCHED USER DISPLAYED");
			URLConstants.DATABASECONNECTION.close();
		} catch (Exception exception) {
			LOGGER.log(Level.WARNING, "EXCEPTION OCCURED  " + exception);
		}

		return filterList;
	}
	 public static List<User> UpdateAllEmployees(String userName){  
	 	    List<User> filterList=new ArrayList<>();  
	 	   // userName="%"+userName+"%";
	 	try{  
	 	URLConstants.DATABASECONNECTION=UsersDataBase.getConnection();  
	 	PreparedStatement preparedStatement=URLConstants.DATABASECONNECTION.prepareStatement(QueryConstants.SEARCHUSER);  
	 	preparedStatement.setString(1,userName); 
	 	ResultSet resultSet=preparedStatement.executeQuery();  
	 	while(resultSet.next()){  
	 	    User currentUser=new User();  
	 	    currentUser.setUser_id(resultSet.getInt(1));  
	 	    currentUser.setFirst_name(resultSet.getString(2));  
	 	    currentUser.setLast_Name(resultSet.getString(3));  
	 	    currentUser.setEmail_Id(resultSet.getString(4)); 
	 	    filterList.add(currentUser);  
	 	}  
	 	LOGGER.log(Level.INFO,"SEARCHED USER DISPLAYED");
	 	URLConstants.DATABASECONNECTION.close();  
	 	}catch(Exception exception){LOGGER.log(Level.WARNING,"EXCEPTION OCCURED  "+exception);}  

	 	return filterList;  
	 	} 
			 public static List<Userfeed> getAllFeeds(String date){  
		        List<Userfeed> filterFeed=new ArrayList<>();  
		       // userName="%"+userName+"%";
		        
		try{
			 Userfeed feed1 = new Userfeed(); 
			
			 EntityManagerFactory emf=Persistence.createEntityManagerFactory("InsertUsers"); 
			  EntityManager em=emf.createEntityManager();
			  em.getTransaction().begin( );   
			  Query query = em.createQuery("SELECT u "+"from Userfeed u "+"where u.dateCreated >"+date);   
			 // List<StudentEntity> list=(List<StudentEntity>)query.getResultList( );   
			 
			  filterFeed = query.getResultList();
			   for( Userfeed s:filterFeed ){  
			  feed1.getFeedText();
			  feed1.getPhoto();
			  feed1.getFeedId();
			  filterFeed.add(feed1);
			   }
			   em.getTransaction().commit();   

		          emf.close();   
			  
			/*
			URLConstants.DATABASECONNECTION=UsersDataBase.getConnection();  
	        PreparedStatement preparedStatement=URLConstants.DATABASECONNECTION.prepareStatement(QueryConstants.SEARCHFEED);  
	        preparedStatement.setString(1,date); 
	        ResultSet resultSet=preparedStatement.executeQuery();  
	        while(resultSet.next()){  
	            Feed currentUser=new Feed();  
	           currentUser.setFeed_Text(resultSet.getString(2));
	           currentUser.setPhoto((Blob) resultSet.getBlob(3));
	           currentUser.setFeed_Id(resultSet.getInt(6));
	            filterFeed.add(currentUser);  
	        }  */
	        LOGGER.log(Level.INFO,"SEARCHED USER DISPLAYED");
	        URLConstants.DATABASECONNECTION.close();  
	    }catch(Exception exception){LOGGER.log(Level.WARNING,"EXCEPTION OCCURED  "+exception);}  
	      
	    return filterFeed;  
	 } 
		 
		 
		 public static List<Userfeed> getFeedImage(int id){  
		        List<Userfeed> filterFeed=new ArrayList<>();  
		     
		        
		try{ 
			Userfeed feed1 = new Userfeed(); 
		
		 EntityManagerFactory emf=Persistence.createEntityManagerFactory("InsertUsers"); 
		  EntityManager em=emf.createEntityManager();
		  em.getTransaction().begin( );   
		  Query query = em.createQuery("select u from Userfeed u where u.feedId="+id);   
		 // List<StudentEntity> list=(List<StudentEntity>)query.getResultList( );   
		 
		  filterFeed = query.getResultList();
		   for( Userfeed s:filterFeed ){  
		  feed1.getFeedText();
		  feed1.getPhoto();
		  feed1.getFeedId();
		  filterFeed.add(feed1);
		   }
		   em.getTransaction().commit();   

	          emf.close();   
		  
			/*
			URLConstants.DATABASECONNECTION=UsersDataBase.getConnection();  
	        PreparedStatement preparedStatement=URLConstants.DATABASECONNECTION.prepareStatement(QueryConstants.SEARCHFEEDIMAGE);  
	        preparedStatement.setInt(1,id); 
	        ResultSet resultSet=preparedStatement.executeQuery();  
	        while(resultSet.next()){  
	            Feed currentUser=new Feed();  
	           currentUser.setFeed_Text(resultSet.getString(2));
	           currentUser.setPhoto((Blob) resultSet.getBlob(3));
	           currentUser.setFeed_Id(resultSet.getInt(6));
	            filterFeed.add(currentUser);  
	        } */
			
	        LOGGER.log(Level.INFO,"IMAGE DISPLAYED");
	        URLConstants.DATABASECONNECTION.close();  
	    }catch(Exception exception){LOGGER.log(Level.WARNING,"EXCEPTION OCCURED  "+exception);}  
	      
	    return filterFeed;  
	 }
		  public static int InsertFeed(int id, String note, String myFile) throws IOException{  
	            int status=0; 
	            
	            System.out.println(id);
	            System.out.println(note);
	           // File userImage = new File(image);
	           // System.out.println(userImage);
	            File myImage=new File(myFile);
	            
	            FileInputStream userImage = new FileInputStream(myImage.getAbsoluteFile());
	            ByteArrayOutputStream os = new ByteArrayOutputStream();
	            int len;
	            byte[] buffer = new byte[1024];
	            while ((len = userImage.read(buffer)) != -1) {
	                // write bytes from the buffer into output stream
	                os.write(buffer, 0, len);
	            }
	            //FileInputStream userImage = new FileInputStream("C:\\Users\\hppc\\Pictures\\Screenshots\\testImage.png");
	               
	            System.out.println(userImage);
	            try{
	            	
	            Userfeed feed1 = new Userfeed(); 
	            Date date= new Date();
	            //getTime() returns current time in milliseconds
	   	 long time = date.getTime();
	            //Passed the milliseconds to constructor of Timestamp class 
	   	 Timestamp ts = new Timestamp(time);
	   			  EntityManagerFactory emf=Persistence.createEntityManagerFactory("InsertUsers"); 
	   			  EntityManager em=emf.createEntityManager();
	   			  em.getTransaction().begin( );   
	   			  feed1.setUserId(id);
	   			  feed1.setFeedText(note);
	   			  feed1.setPhoto(os.toByteArray());
	   			  feed1.setDateCreated(ts);
	   			  feed1.setLastUpdated(ts);
	   			  em.persist(feed1);
	   			  em.getTransaction().commit(); 
	   			  
	   		      emf.close();   
	   			  
	            	/*
	                URLConstants.DATABASECONNECTION=UsersDataBase.getConnection();  
	                PreparedStatement preparedStatement=URLConstants.DATABASECONNECTION.prepareStatement(QueryConstants.INSERTFEED);  
	               
	                preparedStatement.setInt(1, id);
	                preparedStatement.setString(2,note);
	                preparedStatement.setBinaryStream(3, userImage);

	 

	                status=preparedStatement.executeUpdate(); 
	                */
	                LOGGER.log(Level.INFO,"VALUES INSERTED");
	                URLConstants.DATABASECONNECTION.close();  
	            }catch(Exception exception){LOGGER.log(Level.WARNING,"EXCEPTION OCCURED  "+exception);}  
	              
	            return status;  
	        } 
		  public static List<Userdetail> getAllEmployee(String FirstName, String LastName){  
              List<Userdetail> filterFeed=new ArrayList<>();  
             // userName="%"+userName+"%";
              
      try{
          
           EntityManagerFactory emf=Persistence.createEntityManagerFactory("InsertUsers"); 
            EntityManager em=emf.createEntityManager();
            em.getTransaction().begin( );
            Query query;
          
            query = em.createQuery("select u from Userdetail u where u.firstName="+"\""+FirstName+"\"" +" OR u.lastName= "+ "\""+LastName+"\"");  
            filterFeed = query.getResultList();



            
           
            for(Userdetail searchedUser:filterFeed ){  
           
                Userdetail currentUser = new Userdetail(); 
            
            currentUser.setFirstName(searchedUser.getFirstName());
            currentUser.setLastName(searchedUser.getLastName());
            currentUser.setMobileNumber(searchedUser.getMobileNumber());
            currentUser.setCountry(searchedUser.getCountry());
            currentUser.setGender(searchedUser.getGender());
           
             }
           
             em.getTransaction().commit();   
             emf.close();   
  
          LOGGER.log(Level.INFO,"SEARCHED USER DISPLAYED");
         // URLConstants.DATABASECONNECTION.close();  
      }catch(Exception exception){LOGGER.log(Level.WARNING,"EXCEPTION OCCURED  "+exception);}  
        
      return filterFeed;  
   } 
      
	      
}
