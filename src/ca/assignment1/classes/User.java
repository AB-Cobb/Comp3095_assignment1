package ca.assignment1.classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

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
		this.created = new java.sql.Date(System.currentTimeMillis());
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
		String [] credientials = DB.getLoginCredentials(username);
		if (credientials != null) {
			if (credientials[2] == "denied")
				return "denied";
			if ( Password.getHash(password, credientials[1]).equals(credientials[0])) {
					return credientials[2];
				} 
		}	
		return "denied";
	}
	public static User getUserByLogin(String email) throws Exception {
		return DB.getUserByEmail(email);
	}
	
	public boolean save() throws Exception {
		return DB.updateUser(this);
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
