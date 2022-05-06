package com.example.online_auction;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ResetServlet2", value = "/ResetServlet2")
public class ResetServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String username = request.getParameter("username");
        String password = request.getParameter("pass");
        String password2 = request.getParameter("pass2");
        System.out.println(username + password + password2);
        if (password.equals(password2)){
            LoginBean bean = new LoginBean(username, password);
            LoginDao dao = new LoginDao();
            System.out.println("User entered username: " + username);
            bean.setUserName(username);
            bean.setPassword(password);
            dao.validate3(bean);
            if (true){
                PrintWriter out = response.getWriter();
                String htmlResponse = "<html>";
                htmlResponse += "<style> body{background-color: pink;}" +
                        "</style>";
                htmlResponse += "<h1>Successfully Changed your password </br>";
                htmlResponse += "<button> <a href='index.jsp'> Home</button>";
                htmlResponse += "</html>";
                out.println(htmlResponse);
            }
        } else{
            System.out.println("Password and confirm password is incorrect");
            PrintWriter out = response.getWriter();
            out.println("password and confirm password incorrect");
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
            out.println(htmlResponse);
        }


    }
}
