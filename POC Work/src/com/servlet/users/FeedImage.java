/**
 * 
 */
package com.servlet.users;




import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.rowset.serial.SerialBlob;
 

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 

import com.classes.users.Feed;
import com.classes.users.UsersDataBase;
import com.mysql.jdbc.Blob;

 


public class FeedImage extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException  {
        
        int FeedId = Integer.parseInt(request.getParameter("id"));
        
        ServletOutputStream imageOut = response.getOutputStream();  
        List<Userfeed> feedList = UsersDataBase.getFeedImage(FeedId);
        
        for(Userfeed currentUser:feedList)
        {
        	byte[] my_byte_array= currentUser.getPhoto();
        	  //Blob blob = null;
        	  //blob = new SerialBlob(my_byte_array);
        	
        
          response.setContentType("image");
          
          //int length = my_byte_array.length;
       
          
         
          
      
          imageOut.write(my_byte_array);;
          System.out.println("IMAGE DISPLAYED");
        
             
        }
}
}