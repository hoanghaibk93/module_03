<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 12/3/2023
  Time: 6:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sách học sinh</h1>
<table border="1" style="width: 500px" >
    <tr>
        <th>No</th>
        <th>Id</th>
        <th>Name</th>
        <th>DateOfBirth</th>
        <th>Gender</th>
        <th>Grade</th>
    </tr>
    <c:forEach items="${listStudent}" var="student" varStatus="lap">
        <tr>
            <td>${lap.count}</td>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.dateOfBirth}</td>
            <td>
                <c:if test="${student.gender==0}">
                    <h2>Female</h2>
                </c:if>
                <c:if test="${student.gender == 1}">
                    male
                </c:if>
            </td>
            <td>
              <c:choose>
                  <c:when test="${student.grade <=6}">Bad</c:when>
                  <c:when test="${student.grade >=8}">Good</c:when>
                  <c:otherwise>
                      Error
                  </c:otherwise>
              </c:choose>  
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
