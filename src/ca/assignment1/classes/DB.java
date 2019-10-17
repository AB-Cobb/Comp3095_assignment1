/*
*********************************************************************************
* Project:	Comp3095_assignment1
* Assignment: Assignment One
* Author(s):
*      Andrew Cobb:		101142044
*      Giuseppe Ragusa; 101109502
*      Arsalan Farooqui:101144384
*       
*      Date: 17/10/2019
*      Description:           Connects to Database to store and get  user data
 ******************************************************************************** */



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
	 public static User getUserByEmail(String email) throws Exception {
		 ResultSet rs = null;
		 Connection connect = null;
		 try {
			connect = connectDataBase();	
			PreparedStatement selectUser = connect.prepareStatement("SELECT * FROM users WHERE email LIKE ?");
			selectUser.setString(1, email);
			rs = selectUser.executeQuery();
			User user = null;
			if ((rs.first())) {
				user =  new User(rs.getString("email"), rs.getString("firstname"), rs.getString("lastname"),
					rs.getDate("created"), rs.getString("passwordhash"), rs.getString("salt"), rs.getString("role"));
			} 
			return user;
			
		} catch (Exception e) {
			throw e;
		} finally {
			rs.close();
			connect.close();
		}
	 }
	 
	 public static String[] getLoginCredentials(String email)throws Exception {
		 ResultSet rs = null;
		 Connection connect = null;
		 try {
			String results[] = new String[3];
			connect = connectDataBase();
			PreparedStatement selectUser;
			selectUser = connect.prepareStatement("SELECT passwordhash, salt, role FROM users WHERE email LIKE ?");
			selectUser.setString(1, email);
			rs = selectUser.executeQuery();
			if ((rs.first())) {
				results[0] = rs.getString("passwordhash");
				results[1] = rs.getString("salt");
				results[2] = rs.getString("role");
			} else {
				results[0] = "denied";
				results[1] = "denied";
				results[2] = "denied";
			}
			//selectUser.close();
			connect.close();
			return results;
			}
			catch (Exception e) {
				throw e;
			}finally {
			rs.close();
			connect.close();
		}
	 }
	 
	 public static boolean updateUser (User user) throws Exception{
		 Connection connect = null;
		 if (getLoginCredentials(user.getEmail())[0] != "denied")
			 return false; //email already exist 
		 try {
			connect = connectDataBase();
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
			//updateUsers.close();	
			connect.close();
			return true;
		 } catch (Exception e) {
			 throw e;
		} finally {
			connect.close();
		}
		 
	 }
	 
}
