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
    <title>Delete product</title>
</head>
<body>
<h1>Delete Product</h1>
<h4><a href="/product">Back to the product list</a> </h4>
<form style="width: 500px" method="post">
    <h3>Are you sure ?</h3>
    <fieldset>
        <legend>Product information</legend>
        <table>
        <tr>
            <td>Id</td>
            <td>${product.id}</td>
        </tr>
        <tr>
            <td>Name</td>
            <td>${product.name}</td>
        </tr>
        <tr>
            <td>Price</td>
            <td>${product.price}</td>
        </tr>
        <tr>
            <td>Description</td>
            <td>${product.description}</td>
        </tr>
        <tr>
            <td>Manufacturer</td>
            <td>${product.manufacturer}</td>
        </tr>
        <tr>
            <td></td>
            <td><button type="submit">Delete</button></td>
        </tr>
        </table>
    </fieldset>
</form>

</body>
</html>
