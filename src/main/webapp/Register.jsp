<%--
  Created by IntelliJ IDEA.
  User: ubuntu
  Date: 4/29/22
  Time: 6:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Page- Online Auction</title>
</head>
<body>
<style>
    body{
        /*background-image: url("https://www.scnsoft.com/blog-pictures/ecommerce/auction-website.png");*/
        background-color: pink;
    }
</style>

<H1>Welcome to Online Auction by Shubharthak, 20BCS6872</H1>
<form action="RegisterServlet" method="post">
    <h1 align="center" >Registration Form</h1>
    <table align="center" >
        <tr>
            <td>Name</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>Email Id</td>
            <td><input type="email" name="email"></td>
        </tr>
        <tr>
            <td>UserName</td>
            <td><input type="text" name="uname"></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="pass"></td>
        </tr>
        <tr>
            <td>Confirm Password</td>
            <td><input type="password" name="cpass"></td>
        </tr>

        <tr>
            <td></td>
            <td><input type="submit" value="Submit" id="button-1" /></td>
        </tr>
    </table>
</form>
<div align="center">
    <button> <a href="index.jsp" > Back</a></button>
</div>
</body>
</html>
