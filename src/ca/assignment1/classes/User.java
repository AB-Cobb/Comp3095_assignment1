package ca.assignment1.classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class User {
	
	private User(String email, String firstname, String lastname, Date created, String passwordhash, String salt,
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
	}


	
	private String email;
	private String firstname;
	private String lastname;
	private String address;
	private Date created;
	private String passwordhash;
	private String salt;
	private String role;
	
	
	
	public static User authenticate(String email, String Password) {
		ResultSet user_data = DB.getUserByEmail(email);
		if (user_data !=null) {
			try {
				return new User(user_data.getString("email"), user_data.getString("firstname"), user_data.getString("lastname"),
						user_data.getDate("created"), user_data.getString("passwordhash"), user_data.getString("salt"), user_data.getString("role"));
			} catch (SQLException e) {
				return null;
			}
		}
		return null;
	}
	
	public void save() {
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

	public void setPasswordhash(String passwordhash) {
		this.passwordhash = passwordhash;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAddress() {
		return address;
	}
}
