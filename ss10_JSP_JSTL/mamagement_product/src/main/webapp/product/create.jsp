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
    <title>Create new Product</title>
</head>
<body>
<h1>Create new Product</h1>
<h4><a href="/product">Back to the product list</a></h4>
<h3>
    <c:if test="${message != null}">
        <p style="color: coral">${message}</p>
    </c:if>
</h3>
<form style="width: 500px" method="post">
    <fieldset>
        <legend>New Product</legend>
        <table>
            <tr>
                <td>Id</td>
                <td><input type="text" name ="id"></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name ="name"></td>
            </tr>
            <tr>
                <td>Price</td>
                <td><input type="text" name ="price"></td>
            </tr>
            <tr>
                <td>Description</td>
                <td><textarea name="description"></textarea></td>
            </tr>
            <tr>
                <td>Manufacturer</td>
                <td><input type="text" name ="manufacturer"></td>
            </tr>
            <tr>
                <td></td>
                <td><button type="submit" name="submit">Create</button></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
