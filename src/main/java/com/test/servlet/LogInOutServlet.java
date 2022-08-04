package com.test.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
* Servlet implementation class LoginServlet
*/

@WebServlet(name = "LogInOutServlet")
public class LogInOutServlet extends HttpServlet {

    // zhujb： do you know the difference between get and post, when do you use post?
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {

        HttpSession session = request.getSession(true);
        String requestURL = (request.getRequestURI());
        boolean isLoggedIn = session.getAttribute("isLoggedIn") != null ? (boolean) session.getAttribute("isLoggedIn") : false;

        if (requestURL.equals("/LoginServlet")) {

            // else validate credentials
            String username = request.getParameter("un");
            String password = request.getParameter("pw");

            // static username and password
            if (username.equals("admin") && password.equals("admin")) {

                // set session variables
                session.setAttribute("isLoggedIn", true);
                session.setAttribute("name", username);

                // redirect to homepage
                response.sendRedirect("HomePage.jsp"); //logged-in page
            }

            else {
                // show error in log in page
                RequestDispatcher rd = request.getRequestDispatcher("LoginPage.jsp");
                request.setAttribute("errStatus", "invalid-credentials");
                rd.forward(request, response);
            }
        }

        else if (requestURL.equals("/LogoutServlet")) {
            // invalidating session and clearing out session variables
            session.invalidate();

            // redirect to log in page
            response.sendRedirect("LoginPage.jsp");
        }

        else {
            // if the user is logged in, redirect to homepage, else redirect to login page
            if (isLoggedIn) {
                response.sendRedirect("HomePage.jsp"); // home page
            }

            else {
                response.sendRedirect("LoginPage.jsp");
            }
        }
    }
}