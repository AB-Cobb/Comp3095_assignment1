package ca.assignment1.classes;

public abstract class RegisterAuthenticate {
	public static String Register(String firstName, String lastName, String email, String address, String password, String confirm, String termsCheck) {
		if (firstName == "" || firstName == null) {
			return "First Name cannot be left blank";
		}
		for (int f = 0; f < firstName.length(); f++) {
			if (!Character.isLetter(firstName.charAt(0)))
				return "First Name must only contain letters";
		}
		
		if (lastName == "" || lastName == null) {
			return "Last Name cannot be left blank";
		}
		for (int l = 0; l < lastName.length(); l++)
			if (!Character.isLetter(lastName.charAt(0)))
				return "Last Name must only contain letters";
		
		if (email == "" || email == null) {
			return "Email cannot be left blank";
		}
		else if (address == "" || email == null) {
			return "address cannot be left blank";
		}
		else if (password == "" || password == null) {
			return "password cannot be left blank";
		}
		else if (!confirm.equals(password)) {
			return "Your password and confirmation password do not match";
		}
		
		boolean capital = false;
		boolean lowercase = false;
		
		for(int x = 0; x < password.length(); x++) {
			if(Character.isUpperCase(password.charAt(x))) {
				capital = true;
			}
			else {
				lowercase = true;
			}
		}
		
		if (password.length() < 8 || !capital || !lowercase) {
			return "passwords must at least 8 characters, have 1 uppercase and 1 lowercase";
		}
		else if (!termsCheck.equals("true")) {
			return "you must agree to the terms and service";
		}
		return "valid";
	}
}

