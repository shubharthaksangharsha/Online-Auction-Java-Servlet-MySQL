package com.example.online_auction;

import java.sql.*;


public class RegisterDao {
    public String Registerindb(RegisterBean bean) throws SQLException {
        String myUrl = "jdbc:mysql://localhost:3306/mydatabase";
        int i;
        showTable();
        try {
            Connection con = DriverManager.getConnection(myUrl, "shubharthak", "shubhi21");
            String sql = "insert into user_register values(NULL,?,?,?,?)";
            i = 0;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, bean.getName());
            ps.setString(2, bean.getEMail());
            ps.setString(3, bean.getUserName());
            ps.setString(4, bean.getPassword());

            i = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (i != 0) {
            return "User is registered";
        } else {
            return "Error!!!";
        }
    }

    public void showTable() {
        String myUrl = "jdbc:mysql://localhost:3306/mydatabase";
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            Connection conn = DriverManager.getConnection(myUrl, "shubharthak", "shubhi21");
            String query = "Select * from user_register";
            // create the mysql insert preparedstatement
            Statement st = conn.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            System.out.println("id\t\t\tname\t\t\temail\t\t\tusername\t\t\tpassword");
            while (resultSet.next()) {
                System.out.print(resultSet.getInt("id") + "\t\t");
                System.out.print(resultSet.getString("Name") + "\t\t\t");
                System.out.print(resultSet.getString("Email") + "\t\t\t");
                System.out.print(resultSet.getString("userName") + "\t\t\t");
                System.out.print(resultSet.getString("password") + "\t\t\t");
                System.out.println();
            }
            System.out.println();
            conn.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}

