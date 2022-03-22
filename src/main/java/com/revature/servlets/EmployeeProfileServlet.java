package com.revature.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

public class EmployeeProfileServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("email");
        request.getParameter("email");

        if(cookies != null){
            cookies[0].getValue();
            if(!(user.equals("") || user == null)){
                request.getRequestDispatcher("selection-page.html").include(request, response);
            } else{
                out.println("Please sign in...");
                request.getRequestDispatcher("index.html").include(request, response);
            }
        }
    }
}
