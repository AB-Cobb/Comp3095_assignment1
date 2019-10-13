package ca.assignment1.servlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ca.assignment1.classes.LoginAuthenticate;
import ca.assignment1.classes.User;
import ca.assignment1.classes.DB;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int resultCode = LoginAuthenticate.Authenticate(request, response);
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
			User user;
			//ResultSet data = DB.getUserByEmail(request.getAttribute("username").toString());
			//user = User.authenticate(request.getParameter("username"), request.getParameter("password"));
			if (resultCode == 2) {
				user = new User(request.getParameter("username"), request.getParameter("password"), "client");
			}
			else {
				user = new User(request.getParameter("username"), request.getParameter("password"), "admin");
			}
			HttpSession session = request.getSession();
			session.setAttribute("User", user);
			request.setAttribute("User", user);
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		}
	}

}
