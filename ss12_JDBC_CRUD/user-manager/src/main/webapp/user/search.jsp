<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 15/3/2023
  Time: 5:19 AM
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
<h1>Search user by country</h1>
<h3>
    <c:if test="${message != null}">
        <p style="color: coral">${message}</p>
    </c:if>
</h3>
<h4><a href="/user">Back to the user list</a></h4>
<form method="post">
    <p>Country:</p>
    <p><input type="text" name="country"></p>
    <p><input type="submit" value="search"></p>
</form>
</body>
</html>
