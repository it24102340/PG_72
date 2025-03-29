package com.fitnesscenter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = UserStore.getUser(username);
        if (user != null && user.getPassword().equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("role", user.getRole());

            if ("Admin".equals(user.getRole())) {
                response.sendRedirect("admin-dashboard.html");
            } else {
                response.sendRedirect("home.html");
            }
        } else {
            response.sendRedirect("login.html?error=Invalid+credentials");
        }
    }
}