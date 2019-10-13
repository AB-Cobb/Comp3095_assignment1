package ca.assignment1.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ca.assignment1.classes.User;
import ca.assignment1.classes.RegisterAuthenticate;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Register() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO validate form
		//User user = new User(email, firstname, lastname, password, address);
		//user.save();
		//TODO routing
		
		String firstName = request.getParameter("fName");
		String lastName = request.getParameter("lName");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String password = request.getParameter("password");
		String confirm = request.getParameter("confirmPass");
		String[] termsCheck = request.getParameterValues("termsCheck");

		String status = "";
		/* Try-catch is required for termsCheck variable */
		try {
			status = RegisterAuthenticate.Register(firstName, lastName, email, address, password, confirm, termsCheck[0]);
		}
		catch (Exception e) {
			status = RegisterAuthenticate.Register(firstName, lastName, email, address, password, confirm, "");
		}
		User user;
		if (status.equals("valid")) {
			user = new User(email, firstName, lastName, password, address);
			HttpSession session = request.getSession();
			session.setAttribute("User", user);
			request.setAttribute("User", user);
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		}
		else {
			request.setAttribute("error", status);
			if (firstName != "" || firstName != null)
				request.setAttribute("firstName", firstName);
			if (lastName != "" || lastName != null)
				request.setAttribute("lastName", lastName);
			if (email != "" || email != null)
				request.setAttribute("email", email);
			if (address != "" || address != null)
				request.setAttribute("address", address);
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}

}
