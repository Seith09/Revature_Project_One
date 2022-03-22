package com.revature.servlets;

import com.revature.employee.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class EmployeeInfo extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String empEmail = (String) session.getAttribute("email");
        Employee employeeUser = new Employee();

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "]eT*LA;a6m3lqTs-");
            Statement statement = con.createStatement();
            String sql = "select * from employee where email = " + "'" + empEmail + "'";
            ResultSet resultSet = statement.executeQuery(sql);
                while(resultSet.next()){
                    employeeUser.setId(resultSet.getInt(1));
                    employeeUser.setEmail(resultSet.getString(2));
                    employeeUser.setName(resultSet.getString(3));
                    employeeUser.setDetails(resultSet.getString(5));
                }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        int empId = employeeUser.getId();
        String userEmail = employeeUser.getEmail();
        String empName = employeeUser.getName();
        String details = employeeUser.getDetails();

        request.getRequestDispatcher("employee-navbar.html").include(request, response);
        out.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "    <style>\n" +
                "        .container {\n" +
                "            margin: auto;\n" +
                "            width: 350px;\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "        .listFlex {display: flex; justify-content: center;}\n" +
                "\n" +
                "        img {\n" +
                "            width: 100%;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"container\">\n" +
                "        <br>\n" +
                "        <h1>"+ empName +"</h1>\n" +
                "        <br>\n" +
                "        <h3>My Information:</h3>\n" +
                "        <br>\n" +
                "        <h4>My Email</h4>\n" +
                "        <p>"+ userEmail +"</p>\n" +
                "        <br>\n" +
                "        <h4>My Employee ID:</h4>\n" +
                "        <p>"+ empId +"</p>\n" +
                "        <br>\n" +
                "        <h4>About Me</h4>\n" +
                "        <p>"+ details +"</p>\n" +
                "        </div>\n" +
                "    </div>\n<br><br>" +
                "</body>\n" +
                "</html>");

//        request.getRequestDispatcher("profile-change-buttons.html").include(request, response);
    }



}