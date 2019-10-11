package ca.assignment1.classes;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.corba.se.pept.transport.Connection;

public class DB {
	private static Connection connect = null;
	  
	 public static Connection connectDataBase() throws Exception {
	    try {
	      String  DB_conection = "jdbc:mysql://localhost:3306/Comp3095?user=app&password=pw123";
	      // This will load the MySQL driver, each DB has its own driver
	      Class.forName("com.mysql.jdbc.Driver");
	      // Setup the connection with the DB
	      connect = (Connection) DriverManager.getConnection(DB_conection);
	      return connect;
	    } catch (Exception e) {
	      throw e;
	    } 
	  }
	 public static String[] getUserByName(String username) {
		 String [] user = new String [3];
		 try {
			Statement selectUser = ((java.sql.Connection) connect).createStatement();
			ResultSet results = selectUser.executeQuery("SELECT * FROM users WHERE name LIKE $username");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	 }
	 
}
