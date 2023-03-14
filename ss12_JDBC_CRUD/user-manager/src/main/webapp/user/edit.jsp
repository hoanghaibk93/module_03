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
<h1>Update new User</h1>
<h4><a href="/user">Back to the product list</a></h4>
<h3>
    <c:if test="${message != null}">
        <p style="color: coral">${message}</p>
    </c:if>
</h3>
<form class="container-fluid" method="post">
    <div class="mb-3">
        <label for="formGroupExampleInput2" class="form-label">NAME</label>
        <input type="text" class="form-control" id="formGroupExampleInput2" name="name" value="${user.name}">
    </div>
    <div class="mb-3">
        <label for="formGroupExampleInput3" class="form-label">EMALI</label>
        <input type="text" class="form-control" id="formGroupExampleInput3" name="email" value="${user.email}">
    </div>
    <div class="mb-3">
        <label for="formGroupExampleInput4" class="form-label">COUNTRY</label>
        <input type="text" class="form-control" id="formGroupExampleInput4" name="country" value="${user.country}">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
