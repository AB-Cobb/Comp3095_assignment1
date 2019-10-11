package ca.assignment1.classes;

import java.sql.DriverManager;

import com.sun.corba.se.pept.transport.Connection;

public class DB {
	private static Connection connect = null;
	  
	 public static Connection connectDataBase() throws Exception {
	    try {
	      // This will load the MySQL driver, each DB has its own driver
	      Class.forName("com.mysql.jdbc.Driver");
	      // Setup the connection with the DB
	      connect = (Connection) DriverManager.getConnection(DB_conection);
	      return connect;
	    } catch (Exception e) {
	      throw e;
	    } 
	  }
}
