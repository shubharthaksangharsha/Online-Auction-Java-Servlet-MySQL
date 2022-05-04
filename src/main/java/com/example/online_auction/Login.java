package com.example.online_auction;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "/Login",  value = "/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("user");
        String pass = request.getParameter("pass");
        System.out.println("Entered Username: " + name);
        System.out.println("Entered Password: " + pass);

        if (name.equals("shubharthak") && pass.equals("shubhi21")){
            response.sendRedirect("index.jsp");
        } else{
            response.sendRedirect("Login.jsp");
        }

    }
}
