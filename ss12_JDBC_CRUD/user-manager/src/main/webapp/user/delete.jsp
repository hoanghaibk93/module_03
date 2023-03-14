<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 15/3/2023
  Time: 3:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="../bootstrap-5.1.3-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<script src="../bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Delete User</h1>
<h4><a href="/user">Back to the user list</a></h4>
<form class="container-fluid" method="post">
    <table class="table table-bordered table-inverse table-responsive">
        <tbody>
        <tr>
            <td scope="row">ID</td>
            <td>${user.id}</td>
        </tr>
        <tr>
            <td scope="row">Name</td>
            <td>${user.name}</td>
        </tr>
        <tr>
            <td scope="row">Email</td>
            <td>${user.email}</td>
        </tr>
        <tr>
            <td scope="row">Country</td>
            <td>${user.country}</td>
        </tr>
        <tr>
            <td>
                <button type="submit" class="btn btn-primary">Submit</button>
            </td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>
