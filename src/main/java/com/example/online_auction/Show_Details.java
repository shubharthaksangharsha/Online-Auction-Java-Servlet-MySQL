package com.example.online_auction;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "Show_Details", value = "/Show_Details")
public class Show_Details extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String password = request.getParameter("password");
        String userName = request.getParameter("username");
        String productName = request.getParameter("productName");
        String bidValue = request.getParameter("bidValue");
        System.out.println("Username:se " + userName);
        System.out.println("Product Name: " + productName);
        System.out.println("Bidding Amount: " + bidValue);
        ProductBean bean = new ProductBean(userName, productName, bidValue);
        ProductDAO dao = new ProductDAO();
        String result = null;
        try{
            result = dao.Productindb(bean);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (result.equals("Added")){
            System.out.println("Successfully Added in the product table!!");
            ArrayList<String> product_table = dao.getTable();
            ArrayList<String> hp = dao.findTable("HP");
            ArrayList<String> sony = dao.findTable("Sony");
            ArrayList<String> lenovo = dao.findTable("Lenovo");
            ArrayList<String> dell = dao.findTable("Dell");
            String htmlResponse = "<html>";
            htmlResponse+= "<style> body{background-color: pink;}" +
                    "</style>";
            htmlResponse += "<h1>Welcome " + userName + "</h1>";
            htmlResponse += "<h4> Your Bidding Product: " + productName + "</h4>";
            htmlResponse += "<h4> Your Bidding Value: " + bidValue + "</h4>";
            htmlResponse += "<h5> Bidding Winning Chart </h5>";
            htmlResponse += "<p>" + "Product Name       Bid Value       Current Winner";
            htmlResponse += "</br>";
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
            htmlResponse += "<h5> Bidding Log Chart </h5>";
            htmlResponse += "<p>" + "S.No       UserName       ProductName       Bid Value";
            htmlResponse += "<br/>";
            for(int i = 0; i < product_table.size(); i++){
                if (i == 0){
                    htmlResponse += product_table.get(i) + "    " + "    " + "    ";
                    continue;
                }
                if (i % 4 == 0){
                    htmlResponse += "<br/>";
                }
                htmlResponse += product_table.get(i)  + "    "  + "    " + "    ";

            }
            htmlResponse += "</p>";
            htmlResponse +=  "<br/>";
            htmlResponse +=  "<br/>";
            htmlResponse += "<button> <a href='index.jsp'> Logout</button>";
            htmlResponse += "<form action = 'LoginServlet' method='post'>";
            htmlResponse += "<input type='hidden' value=" + userName + " name='user' />";
            htmlResponse += "<input type='hidden' value=" + password + " name='pass' />";
            htmlResponse += "<input type='submit' value='Bid Again'/>";
            htmlResponse += "</form>";
            htmlResponse += "</html>";
            PrintWriter out = response.getWriter();
            out.println("Successfully added in the product table");

            out.println(htmlResponse);
        } else{
            System.out.println("Failed!!");
            PrintWriter out = response.getWriter();
            out.println("Failed!!");
        }
    }
}
