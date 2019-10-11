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

    public Authenticate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = User.authenticate(username,password);
		String url = "/dasnboard";
		if (user == null) {
			request.setAttribute("msg", "Invalid Username or Password");
			url = "/login";
		} 
		else {
			request.setAttribute("name", user.getName());
			if (user.getType().equals("admin")) {
				//do something
			}
				
			if (user.getType().equals("client")) {
				//do something else
			}
			
		}
		request.getRequestDispatcher(url).include(request, response);
	}

}
