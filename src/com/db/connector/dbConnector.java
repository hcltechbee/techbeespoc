
package com.db.connector;

import java.sql.*;


public class dbConnector {
    public static Connection con; 

	public dbConnector() throws Exception
    {
    Class.forName("com.mysql.jdbc.Driver");
    con = DriverManager.getConnection("jdbc:mysql://localhost:3309/users", "root", "123456");
    System.out.println("connection made");
    }
    }


