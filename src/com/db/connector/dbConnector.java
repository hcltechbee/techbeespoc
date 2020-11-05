
package com.db.connector;

import java.sql.*;


public class dbConnector {
    public static Connection con; 

	public dbConnector() throws Exception
    {
    Class.forName("com.mysql.jdbc.Driver");
    con = DriverManager.getConnection(com.constants.dbConstants.connectionUrl, com.constants.dbConstants.connectionUsername, com.constants.dbConstants.connectionPassword);
    System.out.println("connection made");
    }
    }


