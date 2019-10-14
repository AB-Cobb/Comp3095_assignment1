package ca.assignment1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ca.assignment1.classes.LoginAuthenticate;
import ca.assignment1.classes.User;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public LoginServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		int resultCode = LoginAuthenticate.Authenticate(request, response);
		if (resultCode == 0) {
			request.setAttribute("Message", "Invalid credentials");
			if (request.getAttribute("username") != null)
				request.setAttribute("Username", request.getAttribute("username").toString());
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else if (resultCode == 1) {
			if (request.getAttribute("username") != null)
				request.setAttribute("Username", request.getAttribute("username").toString());
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else {
			User user =User.getUserByLogin(request.getParameter("username"));

			HttpSession session = request.getSession();
			session.setAttribute("User", user);
			request.setAttribute("User", user);
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);;
			} 
		} catch (Exception e){
			PrintWriter out = response.getWriter();
			out.print(e.getMessage());
		}
	}

}
