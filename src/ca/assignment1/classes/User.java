package ca.assignment1.classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class User {
	
	public User(String email, String firstname, String lastname, Date created, String passwordhash, String salt,
			String role) {
		super();
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.created = created;
		this.passwordhash = passwordhash;
		this.salt = salt;
		this.role = role;
	}

	public User(String email, String firstname, String lastname, String password, String address) {
		this.email = email;
		this.firstname = firstname;
		this.lastname= lastname;
		this.address = address;
		this.salt = Password.newRandomSalt();
		this.passwordhash = Password.getHash(password, salt);
		this.role = "client";
		this.created = new java.util.Date(System.currentTimeMillis());
	}


	
	private String email;
	private String firstname;
	private String lastname;
	private String address;
	private Date created;
	private String passwordhash;
	private String salt;
	private String role;
	
	
	public static String authenticate(String username, String password) throws Exception {
		String role ="denied";
		ResultSet credientials = DB.getLoginCredentials(username);
		if (credientials != null) {
			try {
			if ( Password.getHash(password, credientials.getString("salt")).equals(credientials.getString("passwordhash" ))) {
					return credientials.getString("Role");
				} 
			} catch (SQLException e) {
				throw e;
			}
		}
		
		return role;
	}
	public static User getUserByLogin(String email) throws Exception {
		ResultSet user_data = DB.getUserByEmail(email);
		if (user_data !=null) {
				return new User(user_data.getString("email"), user_data.getString("firstname"), user_data.getString("lastname"),
						user_data.getDate("created"), user_data.getString("passwordhash"), user_data.getString("salt"), user_data.getString("role"));
		}
		return null;
	}
	
	public void save() throws Exception {
		DB.updateUser(this);
	}


	public String getPasswordhash() {
		return passwordhash;
	}



	public String getSalt() {
		return salt;
	}


	public String getRole() {
		return role;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public Date getCreated() {
		return created;
	}

	public String getAddress() {
		return address;
	}
}
