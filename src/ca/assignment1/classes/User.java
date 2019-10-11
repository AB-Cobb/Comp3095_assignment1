package ca.assignment1.classes;

public class User {
	public User(String name, String password) {
		this.name = name;
		this.salt = Password.newRandomSalt();
		this.passwordhash = Password.getHash(password, name);
		this.role = "client";
	}



	private String name;
	private String passwordhash;
	private String salt;
	private String role;
	
	
	
	public static User authenticate(String name, String Password) {
		String [] user_data = DB.getUserByName(name);
		if (user_data !=null) {
			String user_name = user_data[0];
			
		}
		return null;
	}
	
	public void save() {
		DB.updateUser(this);
	}


	public String getName() {
		return name;
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
}
