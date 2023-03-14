<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 14/3/2023
  Time: 1:48 PM
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
<h1 class="text-primary display-3">List user</h1>
<h3><a href="/user?action=create">Back to create user</a></h3>
<h3><a href="/user?action=search">Back to search user</a></h3>
<button><a href="/user?action=sort">Sort by name</a></button>
<table class="table table-hover table-inverse table-responsive">
    <thead class="thead-inverse">
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>EMAIL</th>
        <th>COUNTRY</th>
        <th>EDIT</th>
        <th>DELETE</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listUsers}" var="user">
        <tr>
            <td scope="row">${user.id}</td>
            <td><a href="/user?action=view&id=${user.id}">${user.name}</a></td>
            <td>${user.email}</td>
            <td>${user.country}</td>
            <td><a href="/user?action=update&id=${user.id}">edit</a></td>
            <td><a href="/user?action=delete&id=${user.id}">delete</a></td>
        </tr>
    </c:forEach>
    </tbody>

</table>

</body>
</html>
