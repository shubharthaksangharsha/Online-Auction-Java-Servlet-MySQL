package com.example.online_auction;

import java.sql.*;

public class LoginDao {
    public boolean validate(LoginBean bean){
        String myUrl = "jdbc:mysql://localhost:3306/mydatabase";
        RegisterDao obj = new RegisterDao();
        obj.showTable();
        boolean result = false;
        try{
            Connection con = DriverManager.getConnection(myUrl, "shubharthak", "shubhi21");
            String sql = "select * from user_register where userName = "  + "? " + "and password = "  + "?";
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println(bean.getUserName());
            System.out.println(bean.getPassword());
            ps.setString(1, bean.getUserName());
            ps.setString(2, bean.getPassword());
            ResultSet rs = ps.executeQuery();
            result = rs.next();
            if (rs.next()){
                System.out.println("hello");
                System.out.println(rs.getString("userName"));
            }
            System.out.println("Boolean Result:" +  result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
