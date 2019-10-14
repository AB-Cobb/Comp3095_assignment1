package ca.assignment1.classes;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.sun.corba.se.pept.transport.Connection;

public class DB {
	private static Connection connect = null;
	  
	 public static Connection connectDataBase() throws Exception {
	    try {
	      String DB_conection = "jdbc:mysql://localhost:3306/Comp3095?user=app&password=pw123";
	      // This will load the MySQL driver, each DB has its own driver
	      Class.forName("com.mysql.jdbc.Driver");
	      // Setup the connection with the DB
	      connect = (Connection) DriverManager.getConnection(DB_conection);
	      return connect;
	    } catch (Exception e) {
	      throw e;
	    } 
	  }
	 public static ResultSet getUserByEmail(String email) {
		 
		 try {
			PreparedStatement selectUser = ((java.sql.Connection) connect).prepareStatement("SELECT * FROM users WHERE email LIKE ?");
			selectUser.setString(0, email);
			selectUser.executeUpdate();
			ResultSet results = selectUser.executeQuery();
			return results;
			
		} catch (SQLException e) {
			return null;
		}
	 }
	 public static ResultSet getLoginCredentials(String email) {
		try {
			PreparedStatement selectUser;
			selectUser = ((java.sql.Connection) connect).prepareStatement("SELECT password, salt, role FROM users WHERE email LIKE ?");
			selectUser.setString(0, email);
			selectUser.executeUpdate();
			ResultSet results = selectUser.executeQuery();
			return results;
		} catch (SQLException e) {
			return null;
		}
	 }
	 public static boolean updateUser (User user) {
		 try {
			PreparedStatement updateUsers = ((java.sql.Connection) connect).prepareStatement(
					"INSERT users (firstname,lastname,email,address,role,created,passwordhash,salt) VALUES (?,?,?,?,?,?,?,?)");
			updateUsers.setString(0, user.getFirstname());
			updateUsers.setString(1, user.getLastname());
			updateUsers.setString(2, user.getEmail());
			updateUsers.setString(3, user.getAddress());
			updateUsers.setString(4, user.getRole());
			updateUsers.setDate(5, (java.sql.Date)user.getCreated());
			updateUsers.setString(6, user.getPasswordhash());
			updateUsers.setString(7, user.getSalt());
			return true;
		 } catch (SQLException e) {
			return false;
		}
		 
	 }
	 
}
