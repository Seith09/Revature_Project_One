package com.revature.servlets;

import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ManagerLoginServlet extends HttpServlet{

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String userEmail = request.getParameter("email");
        String password = request.getParameter("password");

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "]eT*LA;a6m3lqTs-");

            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from manager where email = '" + userEmail + "' and password = '" + password + "'");
            if(rs.next()){
                Cookie cookie = new Cookie("email", userEmail);
                response.addCookie(cookie);
                request.getRequestDispatcher("managerprofile").include(request, response);
            } else{
                out.println("wrong credentials...");
            }
            con.close();

        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}