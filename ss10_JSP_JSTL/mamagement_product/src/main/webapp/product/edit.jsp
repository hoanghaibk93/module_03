<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 13/3/2023
  Time: 2:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update product</title>
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
        <legend>Edit Product</legend>
        <table>

            <tr>
                <td>Name</td>
                <td><input type="text" name ="name" value="${product.name}"></td>
            </tr>
            <tr>
                <td>Price</td>
                <td><input type="text" name ="price" value="${product.price}"></td>
            </tr>
            <tr>
                <td>Description</td>
                <td><textarea name="description">${product.description}</textarea></td>
            </tr>
            <tr>
                <td>Manufacturer</td>
                <td><input type="text" name ="manufacturer" value="${product.manufacturer}"></td>
            </tr>
            <tr>
                <td></td>
                <td><button type="submit" name="submit">Update</button></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
