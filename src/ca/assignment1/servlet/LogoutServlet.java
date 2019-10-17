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
*      Description:           Logs user out 
 ******************************************************************************** */

package ca.assignment1.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LogoutServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getSession().invalidate();
		response.sendRedirect("login.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}