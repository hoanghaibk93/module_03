<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 13/3/2023
  Time: 2:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List product</title>
</head>
<body>
<h1> List Product</h1>
<h4><a href="/product?action=create">Create new Product</a></h4>
<form>
    <table border="1">
        <tr>
            <th>id</th>
            <th>name</th>
            <th>price</th>
            <th> description</th>
            <th>manufacturer</th>
            <th>edit</th>
            <th>delete</th>
        </tr>
        <c:forEach items="${productList}" var="product">
            <tr>
                <td>${product.id}</td>
                <td><a href="/product?action=view&id=${product.id}">${product.name}</a></td>
                <td>${product.price}</td>
                <td>${product.description}</td>
                <td>${product.manufacturer}</td>
                <td><a href="/product?action=edit&id=${product.id}">edit</a></td>
                <td><a href="/product?action=delete&id=${product.id}">delete</a></td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
