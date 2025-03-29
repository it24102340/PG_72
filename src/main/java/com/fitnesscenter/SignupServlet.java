package com.fitnesscenter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String location = request.getParameter("location");
        String role = request.getParameter("role");

        if (UserStore.userExists(username)) {
            response.sendRedirect("signup.html?error=Username+already+exists");
        } else {
            User user = new User(username, password, email, location, role);
            UserStore.addUser(user);
            response.sendRedirect("login.html");
        }
    }
}