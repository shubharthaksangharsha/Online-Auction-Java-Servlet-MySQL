package com.example.online_auction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Inside Login Servlet");
        response.setContentType("text/html");
        String username = request.getParameter("user");
        String password = request.getParameter("pass");
        LoginBean bean = new LoginBean(username, password);
        LoginDao dao = new LoginDao();
        System.out.println("User entered username: " + username);
        System.out.println("User entered password: " + username);
        bean.setUserName(username);
        bean.setPassword(password);
        if (dao.validate(bean)) {
            System.out.println("Successfully login");
            System.out.println("YOUR USERNAME: " + username);
            ProductBean product_bean = new ProductBean(username, "None", "None");
            ProductDAO product_dao = new ProductDAO();

            System.out.println("Inside product_available");
            String htmlResponse = "<html>";
            htmlResponse += "<style> body{background-color: pink;}" +
                    "</style>";
            htmlResponse += "<h1>Welcome " + username + "</h1>";
            htmlResponse += "<h4> Choose and Bid your product </h4>";
            htmlResponse += "<form action = 'Show_Details' method='post'>";
            htmlResponse += "<input type='hidden' value=" + username + " name='username' />";
            htmlResponse += "<input type='hidden' value=" + password + " name='password' />";
            htmlResponse += "Product:";
            htmlResponse += "<select name='productName'>";
            htmlResponse += "<option>Dell</option>";
            htmlResponse += "<option>Lenovo</option>";
            htmlResponse += "<option>HP</option>";
            htmlResponse += "<option>Sony</option> </select> <br/> <br/>";
            htmlResponse += "Bid Value: <input type='text' name='bidValue' /> <br/> <br/>";
            htmlResponse += "<input type='submit' value='Bid the product'/>";
            htmlResponse += "</form>";
            htmlResponse += "<h5>Current Bidding Winning Chart </h5>";
            htmlResponse += "<p>" + "Product Name       Bid Value       Current Winner";
            htmlResponse += "</br>";
            ProductDAO dao2 = new ProductDAO();
            ArrayList<String> hp = dao2.findTable("HP");
            ArrayList<String> sony = dao2.findTable("Sony");
            ArrayList<String> lenovo = dao2.findTable("Lenovo");
            ArrayList<String> dell = dao2.findTable("Dell");


            for(int i = 0; i < hp.size(); i++){
                htmlResponse += hp.get(i) + "         ";
            }
            htmlResponse += "<br/>";
            for(int i = 0; i < dell.size(); i++){
                htmlResponse += dell.get(i) + "         ";
            }
            htmlResponse += "<br/>";
            for(int i = 0; i < lenovo.size(); i++){
                htmlResponse += lenovo.get(i) + "         ";
            }
            htmlResponse += "<br/>";
            for(int i = 0; i < sony.size(); i++){
                htmlResponse += sony.get(i) + "         ";
            }
            htmlResponse += "<br/>";
            htmlResponse += "<br/>";

            htmlResponse += "<button> <a href='index.jsp'> Logout</button>";
            htmlResponse += "</html>";
            PrintWriter writer = response.getWriter();
            writer.println(htmlResponse);
        } else{
            System.out.println("Error Occurred!!");
            response.sendRedirect("Login.jsp");
        }

    }
}
