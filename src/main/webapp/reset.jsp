<%--
  Created by IntelliJ IDEA.
  User: ubuntu
  Date: 4/29/22
  Time: 5:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Reset Password Page- Online Auction</title>
</head>
<body>
<style>
  body{
    background-color: pink;
  }
</style>
<h1><%= "Welcome to Online Auction by Shubharthak, 20BCS6872" %></h1>
<h3>Reset the password</h3>
<form action="ResetServlet" method="post">
  Enter your  username : <input type="text" name="user"><br>
  <input type="submit" value="Submit">
  <button> <a href="index.jsp" > Back</a></button>
</form>
</body>
</html>
