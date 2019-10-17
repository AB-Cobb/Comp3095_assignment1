/*
*********************************************************************************
* Project:	Comp3095_assignment1
* Assignment: Assignment One
* Author(s):
*      Andrew Cobb:		101142044
*      Giuseppe Ragusa; 101109502
*      Arsalan Farooqui:101144384
*       
*      Date: 17/10/2019
*      Description:           CCalls authenticate class to check user login
 ******************************************************************************** */

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
import ca.assignment1.classes.reCaptcha_validate;

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
		String url = "";
			
		try {
			String reCapchtaValue = request.getParameter("g-recaptcha-response");
			if (!reCaptcha_validate.check_reCaptcha(reCapchtaValue) ) {
				request.setAttribute("Message", "Prove you are not a robot");
				if (request.getAttribute("username") != null)
					request.setAttribute("Username", request.getAttribute("username").toString());
				url = "login.jsp";
			}
			else {
				int resultCode = LoginAuthenticate.Authenticate(request, response);
				if (resultCode == 0) {
					request.setAttribute("Message", "Invalid credentials");
					if (request.getAttribute("username") != null)
						request.setAttribute("Username", request.getAttribute("username").toString());
					url = "login.jsp";
				}
				else if (resultCode == 1) {
					request.setAttribute("Message", "Please enter a user name and password");
					if (request.getAttribute("username") != null)
						request.setAttribute("Username", request.getAttribute("username").toString());
					url = "login.jsp";
				}
				else {
					User user =User.getUserByLogin(request.getParameter("username"));
		
					HttpSession session = request.getSession();
					session.setAttribute("User", user);
					request.setAttribute("User", user);
					url = "dashboard.jsp";
					} 
			}
		}catch (Exception e){
			PrintWriter out = response.getWriter();
			out.print(e.getMessage());
			url = "error.jsp";
		} finally {
			request.getRequestDispatcher(url).forward(request, response);
		}
	}

}
