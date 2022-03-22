package com.revature.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class ReiServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        System.out.println("submitting request...");

        int empId = Integer.parseInt(request.getParameter("emp_id"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        String details = request.getParameter("details");
        request.getRequestDispatcher("employee-navbar.html").include(request, response);

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "]eT*LA;a6m3lqTs-");
            String sql = "insert into rei_request (emp_id, amount, details, approved) values (?, ?, ?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, empId);
            preparedStatement.setInt(2, amount);
            preparedStatement.setString(3,details);
            preparedStatement.setBoolean(4, false);
            int count = preparedStatement.executeUpdate();
            if(count > 0){
                request.getRequestDispatcher("request-submitted.html").include(request, response);
            } else{
                out.println("Something went wrong");
            }
            con.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
