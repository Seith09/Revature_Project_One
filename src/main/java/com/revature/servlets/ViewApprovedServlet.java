package com.revature.servlets;

import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class ViewApprovedServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        System.out.println("submitting request...");

        int empId = Integer.parseInt(request.getParameter("emp_id"));

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "]eT*LA;a6m3lqTs-");
            Statement statement = con.createStatement();
            String sql = "select * from rei_request where emp_id ="+empId+" and approved = 1;";
            ResultSet resultSet = statement.executeQuery(sql);
            request.getRequestDispatcher("employee-navbar.html").include(request, response);
            out.println("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>Approved Servlet</title>\n" +
                    "\n" +
                    "    <style>\n" +
                    "        table, th, td {\n" +
                    "        border: 1px solid;\n" +
                    "        margin: absolute;\n" +
                    "        box-shadow: 20px 20px 15px rgba(0,0,0,0.09);\n" +
                    "        }\n" +
                    "\n" +
                    "        .center{\n" +
                    "        position: absolute;\n" +
                    "        top: 50%;\n" +
                    "        left: 50%;\n" +
                    "        transform: translate(-50%, -50%);\n" +
                    "        width: 400px;\n" +
                    "        background: white;\n" +
                    "        border-radius: 10px;\n" +
                    "        }\n" +
                    "    body{\n" +
                    "          margin: 0;\n" +
                    "          padding: 0;\n" +
                    "          background: #DBDBDB;\n" +
                    "          height: 100vh;\n" +
                    "          overflow: hidden;\n" +
                    "        }" +
                    "    </style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <div>\n" +
                    "        <table class=\"center\">\n" +
                    "            <tr>\n" +
                    "                <th>Employee ID</th>\n" +
                    "                <th>Amount Requested</th>\n" +
                    "                <th>Details</th>\n" +
                    "                <th>Approval Status</th>\n" +
                    "            </tr>"
                    );
                        while(resultSet.next()){
                        int result1 = resultSet.getInt(1);
                        int result2 = resultSet.getInt(2);
                        String result3 = resultSet.getString(3);
                        boolean result4 = resultSet.getBoolean(4);
                        out.println("<tr>\n" +
                        "                <td>"+ result1 +"</td>\n" +
                        "                <td>"+ result2 +"</td>\n" +
                        "                <td>"+ result3 +"</td>\n" +
                        "                <td>"+ result4 +"</td>\n" +
                        "</tr>\n");
            }
            out.println(
                    "</table>\n" +
                            "    </div>\n" +
                            "</body>\n" +
                            "</html>");
            con.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
