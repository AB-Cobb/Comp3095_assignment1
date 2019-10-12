package ca.assignment1.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.assignment1.classes.User;

@WebServlet("/Authenticate")
public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/*
	 * reCaptcha keys
	 * site:	6LdpNb0UAAAAAB8tqgKCVswqCtBuJhU_G0gst7OE
	 * secret:	6LdpNb0UAAAAAB2heT3JXQUudCK6IfAbsc4aQYff
	 */

    public Authenticate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO validate form
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user = User.authenticate(email,password);
		String url = "/dasnboard";
		if (user == null) {
			request.setAttribute("msg", "Invalid Username or Password");
			url = "/login";
		} 
		else {
			request.setAttribute("firstname", user.getFirstname());
			request.setAttribute("lastname", user.getLastname());
			if (user.getRole().equals("admin")) {
				//do something
			}
				
			if (user.getRole().equals("client")) {
				//do something else
			}
			
		}
		request.getRequestDispatcher(url).include(request, response);
	}

}
