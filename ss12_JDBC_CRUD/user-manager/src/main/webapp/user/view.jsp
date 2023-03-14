<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 15/3/2023
  Time: 5:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="../bootstrap-5.1.3-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script src="../bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
</head>
<body>
<h1>Detail User</h1>
<h4><a href="/user">Back to the user list</a></h4>
<form style="width: 500px">
    <fieldset>
        <legend>User information</legend>
        <table>
            <tr>
                <td>Id</td>
                <td>${user.id}</td>
            </tr>
            <tr>
                <td>Name</td>
                <td>${user.name}</td>
            </tr>
            <tr>
                <td>Email</td>
                <td>${user.email}</td>
            </tr>
            <tr>
                <td>Country</td>
                <td>${user.country}</td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
