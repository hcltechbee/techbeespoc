/**
 * 
 */
package com.servlet.users;




import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

 

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
        List<Feed> feedList = UsersDataBase.getFeedImage(FeedId);
        
        for(Feed currentUser:feedList)
        {
           

 

          Blob blob = currentUser.getPhoto();
          response.setContentType("image");
          InputStream in = null;
          int length;
        try {
            in = blob.getBinaryStream();
             length = (int) blob.length();
        }
        catch (Exception e) {
            System.out.println("EXCEPTION");
        }
        
          int bufferSize = 1024;
          byte[] buffer = new byte[bufferSize];
          while ((length = in.read(buffer)) != -1) {
          
      
          imageOut.write(buffer, 0, length);
          System.out.println("IMAGE DISPLAYED");
        
             }
        }
}
}