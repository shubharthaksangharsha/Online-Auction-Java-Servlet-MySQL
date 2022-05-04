package com.example.online_auction;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;

public class ProductDAO {
    public boolean validate(ProductBean bean){
        String myUrl = "jdbc:mysql://localhost:3306/mydatabase";
        ProductDAO obj = new ProductDAO();
        boolean result = false;
        System.out.println("Inside product validate");
        try{
            Connection con = DriverManager.getConnection(myUrl, "shubharthak", "shubhi21");
            String sql = "select * from product where userName = '" +  bean.getUserName() + "';" ;
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            result = rs.next();
            if (rs.next()){
                System.out.println(rs.getString("userName"));
            }
            System.out.println("Boolean Result:" +  result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    public String Productindb(ProductBean bean) throws SQLException {
        String myUrl = "jdbc:mysql://localhost:3306/mydatabase";
        System.out.println("Inside Product Bean int db");
        int i;
        try {
            Connection con = DriverManager.getConnection(myUrl, "shubharthak", "shubhi21");
            String sql = "insert into product values(null, ?,?,?)";
            i = 0;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, bean.getUserName());
            ps.setString(2, bean.getProductName());
            ps.setString(3, bean.getVal());
            i = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (i != 0) {
            return "Added";
        } else {
            return "Error!!!";
        }
    }
    public ArrayList<String> getTable() {
        System.out.println("Inside Find table");
        ArrayList<String> get_table_details = new ArrayList<>();
        String myUrl = "jdbc:mysql://localhost:3306/mydatabase";
        int i;
        try {
            Connection con = DriverManager.getConnection(myUrl, "shubharthak", "shubhi21");
            String sql = "select * from product";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String sno = Integer.toString(rs.getInt("sno"));
                String userName = rs.getString("userName");
                String productname = rs.getString("productName");
                Double bidValue = rs.getDouble("val");
                System.out.println(sno + userName+  productname + bidValue);
                get_table_details.add(sno);
                get_table_details.add(userName);
                get_table_details.add(productname);
                get_table_details.add(Double.toString(bidValue));
            }
            return get_table_details;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<String> findTable(String productName) {
        System.out.println("Inside Find table");
        System.out.println("Product name: " + productName);
        ArrayList<String> get_product_details = new ArrayList<>();
        String myUrl = "jdbc:mysql://localhost:3306/mydatabase";
        int i;
        try {
            Connection con = DriverManager.getConnection(myUrl, "shubharthak", "shubhi21");
            String sql = "select userName, productName, val  from product where val = (select max(val) from product where productName = ?) and productName = ? limit 1;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, productName);
            ps.setString(2, productName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String username = rs.getString("userName");
                String productname = rs.getString("productName");
                Double bidValue = rs.getDouble("val");
                System.out.println(username +  productname + bidValue);
                get_product_details.add(productname);
                get_product_details.add(Double.toString(bidValue));
                get_product_details.add(username);

            }
            return get_product_details;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<String> current_user_details(ProductBean bean) {
        String myUrl = "jdbc:mysql://localhost:3306/mydatabase";
        boolean result = false;
        ArrayList<String> curr_user_details = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection(myUrl, "shubharthak", "shubhi21");
            String sql = "select * from product where userName = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println("username:" + bean.getUserName());
            ps.setString(1, bean.getUserName());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String sno = Integer.toString(rs.getInt("sno"));
                System.out.println(sno);
                String userName = rs.getString("userName");
                String productName = rs.getString("productName");
                System.out.println(userName + productName);
                String val = Double.toString(rs.getDouble("val"));
                System.out.println(val);
                curr_user_details.add(sno);
                curr_user_details.add(userName);
                curr_user_details.add(productName);
                curr_user_details.add(val);
            }
            System.out.println("Values");
            for(int i = 0; i < curr_user_details.size(); i++){
                System.out.println(curr_user_details.get(i));
            }
            System.out.println("Boolean Result:" + result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return curr_user_details;
    }
}
