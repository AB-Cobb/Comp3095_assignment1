package ca.assignment1.classes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class LoginAuthenticate {
	public static int Authenticate(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username").toString();
		String password = request.getParameter("password").toString();
		if (username.equals("") || username == null || password.equals("") || password == null) {
			return 1; //not all fields filled out
		}
		if (username.equals("client@isp.net") && password.equals("P@ssword0")) {
			return 2; //client logged in
		}
		else if (username.equals("admin@isp.net") && password.equals("P@ssword1")) {
			return 3; //admin logged in
		}
		return 0; //Provided credentials are invalid
	}
}
