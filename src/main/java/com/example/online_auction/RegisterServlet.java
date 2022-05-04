package com.example.online_auction;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Inside Post");
        response.setContentType("text/html");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String username = request.getParameter("uname");
        String password = request.getParameter("pass");
        System.out.println("Entered Name: " + name);
        System.out.println("Entered EMail: " + email);
        System.out.println("Entered Username: " + username);
        System.out.println("Entered Password: " + password);
        RegisterBean bean = new RegisterBean(name, email, username, password);
        RegisterDao dao = new RegisterDao();
        String result = null;
        try {
            result = dao.Registerindb(bean);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (result.equals("User is registered")){
            System.out.println("Success!!");
            String htmlRespone = "<html>";
            htmlRespone += "<style> body{background-color: pink;}" +
                    "</style>";

            htmlRespone += "<h1>Successfully Registered"  + "</h1>";
            htmlRespone += "<button> <a href='index.jsp'> Back</button>";
            htmlRespone += "</html>";
            PrintWriter writer = response.getWriter();
            writer.println(htmlRespone);
//            response.sendRedirect("index.jsp");
        } else{
            System.out.println("Failed!!");
            PrintWriter out = response.getWriter();
            out.println("Failed!!");
//            response.sendRedirect("index.jsp");
        }

    }
}
