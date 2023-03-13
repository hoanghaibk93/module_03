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
    <title>Search Product</title>
</head>
<body>
<h1>Search Product by name</h1>
<h3>
    <c:if test="${message != null}">
        <p style="color: coral">${message}</p>
    </c:if>
</h3>
<h4><a href="/product">Back to the product list</a></h4>
<form method="post">
    <p>Name:</p>
    <p><input type="text" name="name"></p>
    <p><input type="submit" value="search"></p>
</form>
</body>
</html>
