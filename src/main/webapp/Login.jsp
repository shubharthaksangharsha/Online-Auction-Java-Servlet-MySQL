<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page- Online Auction</title>
</head>
<body>
<style>
    body{
        /*background-image: url("https://www.scnsoft.com/blog-pictures/ecommerce/auction-website.png");*/
        background-color: pink;
    }
</style>

<h1><%= "Welcome to Online Auction by Shubharthak, 20BCS6872" %></h1>
<h3>Login Page</h3>
<form action="LoginServlet" method="post">
    Enter username : <input type="text" name="user"><br>
    Enter password : <input type="password" name="pass"><br>
    <input type="submit" value="Login">
    <button> <a href="index.jsp" > Back</a></button>
</form>
<%--<a href="hello-servlet">Hello Servlet</a>--%>
</body>
</html>