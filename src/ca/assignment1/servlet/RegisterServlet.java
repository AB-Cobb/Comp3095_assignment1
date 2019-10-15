package ca.assignment1.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import ca.assignment1.classes.User;
import ca.assignment1.classes.Email;

import ca.assignment1.classes.RegisterAuthenticate;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
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
			try {
			if (user.save()) {
				ca.assignment1.classes.Email.send_email(user);
				HttpSession session = request.getSession();
				session.setAttribute("User", user);
				request.setAttribute("User", user);
				request.getRequestDispatcher("registration_sucsess.jsp").forward(request, response);
			}
			} catch (Exception e){
				PrintWriter out = response.getWriter();
				e.printStackTrace(out);
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
			request.setAttribute("error", "Email already in use");
			request.getRequestDispatcher("register.jsp").forward(request, response);
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