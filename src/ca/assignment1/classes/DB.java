package ca.assignment1.classes;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
//import com.sun.corba.se.pept.transport.Connection;
import java.sql.Connection;

public class DB {
	//private static Connection connect = null;
	  
	 public static Connection connectDataBase() throws Exception {
	    try {
	      Connection connect = null;
	      String DB_conection = "jdbc:mysql://localhost:3306/Comp3095?user=root&password=pw123";
	      // This will load the MySQL driver, each DB has its own driver
	      Class.forName("com.mysql.jdbc.Driver");
	      // Setup the connection with the DB
	      connect = DriverManager.getConnection(DB_conection);
	      return connect;
	    } catch (Exception e) {
	      throw e;
	    } 
	  }
	 public static ResultSet getUserByEmail(String email) throws Exception {
		 
		 try {
			Connection connect = connectDataBase();
			
			PreparedStatement selectUser = connect.prepareStatement("SELECT * FROM users WHERE email LIKE ?");
			selectUser.setString(1, email);
			ResultSet results = selectUser.executeQuery();
			selectUser.close();
			connect.close();
			return results;
			
		} catch (Exception e) {
			throw e;
		}
	 }
	 
	 public static ResultSet getLoginCredentials(String email)throws Exception {
		try {
			Connection connect = connectDataBase();
			PreparedStatement selectUser;
			selectUser = connect.prepareStatement("SELECT password, salt, role FROM users WHERE email LIKE ?");
			selectUser.setString(1, email);
			ResultSet results = selectUser.executeQuery();
			selectUser.close();
			connect.close();
			return results;
			}
			catch (Exception e) {
				throw e;
		}
	 }
	 
	 public static void updateUser (User user) throws Exception{
		 try {
			Connection connect = connectDataBase();
			PreparedStatement updateUsers =  connect.prepareStatement(
					"INSERT users (firstname,lastname,email,address,role,created,passwordhash,salt) VALUES (?,?,?,?,?,?,?,?)");
			updateUsers.setString(1, user.getFirstname());
			updateUsers.setString(2, user.getLastname());
			updateUsers.setString(3, user.getEmail());
			updateUsers.setString(4, user.getAddress());
			updateUsers.setString(5, user.getRole());
			updateUsers.setDate(6, (java.sql.Date)user.getCreated());
			updateUsers.setString(7, user.getPasswordhash());
			updateUsers.setString(8, user.getSalt());
			updateUsers.executeUpdate();
			updateUsers.close();	
			connect.close();

		 } catch (Exception e) {
			 throw e;
		}
		 
	 }
	 
}
