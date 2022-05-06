package com.example.online_auction;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "ResetServlet", value = "/ResetServlet")
public class ResetServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Inside Reset Servlet");
        response.setContentType("text/html");
        String username = request.getParameter("user");
        String password = "None";
        LoginBean bean = new LoginBean(username, "None");
        LoginDao dao = new LoginDao();
        System.out.println("User entered username: " + username);
        bean.setUserName(username);
        bean.setPassword(password);
        if (dao.validate2(bean)){
            System.out.println("User exists");
            System.out.println("YOUR USERNAME: " + username);
            String htmlResponse = "<html>";
            htmlResponse += "<style> body{background-color: pink;}" +
                    "</style>";
            htmlResponse += "<h1>Welcome " + username + "</h1>";
            htmlResponse += "<form action = 'ResetServlet2' method='post'>";
            htmlResponse += "<input type='hidden' value=" + username + " name='username' />";
            htmlResponse += "Enter your new password: <input type='password' name='pass' id='pass'/>";
            htmlResponse += "<br/>";
            htmlResponse += "Confirm your password: <input type='password' name='pass2' id='conf-pass'/>";
            htmlResponse += "<br/>";
            htmlResponse += "<input type='submit' value='Reset the password'/>";
            htmlResponse += "</form>";
            htmlResponse += "<button> <a href='reset.jsp'> Back</button>";
            htmlResponse += "</html>";
            PrintWriter writer = response.getWriter();
            writer.println(htmlResponse);
        } else{
            System.out.println("Error Occurred!!");
            response.sendRedirect("Login.jsp");
        }
    }
}

