<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 10/3/2023
  Time: 10:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
<style>
    table{
        /*border: 1px solid red;*/
        border-style: groove;
    }
    td, th{
        /*border: 1px solid red;*/
        border: 1px solid grey;
    }
</style>
</head>
<body>
<h1> Customer List </h1>
<table  action="CustomerListServlet">
    <tr class="text-primary">
        <th>No</th>
        <th>Name</th>
        <th>Date Of Birth</th>
        <th>Address</th>
        <th>Picture</th>
    </tr>
    <c:forEach items="${customerList}" var="customer" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${customer.name}</td>
            <td>${customer.dateOfBirth}</td>
            <td>${customer.address}</td>
            <td><img width="100" height="100" src="${customer.picture}"></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
