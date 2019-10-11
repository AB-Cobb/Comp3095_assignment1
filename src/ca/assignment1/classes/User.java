package ca.assignment1.classes;

public class User {
	public User(String name, String password) {
		this.name = name;
		this.salt = Password.newRandomSalt();
		this.passwordhash = Password.getHash(password, name);
		this.type = "client";
	}



	private String name;
	private String passwordhash;
	private String salt;
	private String type;
	
	
	
	public static User authenticate(String name, String Password) {
		User user = DB.getUserByName(name);
		if (user !=null) {
			
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



	public String getType() {
		return type;
	}
}
