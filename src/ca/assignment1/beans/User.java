package ca.assignment1.beans;

import java.io.Serializable;

public class User implements Serializable {
	 
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	private String role;
	private String address;
	
	public User() {}
	
	public User(String username, String password, String role) {
		this.firstName = "Ben";
		this.lastName = "Franklin";
		this.email = username;
		this.address = "123 Street";
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	public User(String firstName, String lastName, String email, String address, String username, String password, String role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String fn) {
		firstName = fn;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastname(String ln) {
		lastName = ln;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String e) {
		email = e;
	}
	
	public String getUserName() {
		return username;
	}
	
	public void setUserName(String u) {
		username = u;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String p) {
		password = p;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String r) {
		role = r;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String a) {
		address = a;
	}
}
