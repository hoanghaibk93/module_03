<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%--<h1><%= "Hello World!" %>--%>
<%--</h1>--%>
<%--<h2 style="color: coral">${dspName}</h2>--%>
<%--<c:out value="con ga ><&"/>--%>
<%--<c:out  value="<"></c:out>--%>
<%--<h1><>&</h1>--%>
<%--<%="con meo <>&"%>--%>
<%--<c:out value="${dspName}"></c:out>--%>
<%--<br>--%>
<%--<c:out value="${fsg}">jghf</c:out>--%>
<%--<c:out value="${'<>&'}"></c:out>--%>
<%--<br/>--%>
<%--<a href="hello-servlet">Hello Servlet</a>--%>
<%--<h1>chao ngay moi</h1>--%>
<%--<c:set  var="bien" value="chao ngay moi ok"/>--%>
<%--<c:out value="${bien}"></c:out>--%>
<h2>catch vi du</h2>
<c:catch var="ex">
    <%
        int a = 100/0;
    %>
</c:catch>
<c:if test="${ex != null}">
    Exception : ${ex}
    <br>
    Thong bao: ${ex.message}
</c:if>
<c:forEach var="i" begin="1" end="6">
    item ${i}
    <br>
</c:forEach>
</body>
</html>