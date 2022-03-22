package com.revature.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class ChangeInfoServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        request.getRequestDispatcher("/profile-change-buttons.html").include(request, response);
        String userEmail = String.valueOf(request.getAttribute("email"));

        String changeEmail = request.getParameter("changeEmail");
        String changeDetails = request.getParameter("changeDetails");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "]eT*LA;a6m3lqTs-");
            String sql = "update employee set email = " + changeEmail + " values (?) where email = " + userEmail;
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(2, changeEmail);
            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                out.println("Success");
            } else {
                out.println("Something went wrong");
            }
            con.close();
        } catch (Exception e) {
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "]eT*LA;a6m3lqTs-");
            String sql = "insert into employee (email) values (?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(2, changeEmail);
            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                out.println("Success");
            } else {
                out.println("Something went wrong");
            }
            con.close();
        } catch (Exception e) {
        }
    }
}
