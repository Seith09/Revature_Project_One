package com.revature.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class ManagerProfileServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();
        String name = request.getParameter("email");

        if(cookies != null){
            String user = cookies[0].getValue();
            if(!(user.equals("") || user == null)){
                request.getRequestDispatcher("manager-home.html").include(request, response);
            } else{
                out.println("Please sign in...");
                request.getRequestDispatcher("index.html");
            }
        }


    }
}
