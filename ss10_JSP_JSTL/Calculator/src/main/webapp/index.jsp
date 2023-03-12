<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Simple Calculator</h1>
<form action="/CalculatorServlet" method="post" style="width: 500px">
    <fieldset>
        <legend>Calculator</legend>
        <table>
            <tr>
                <td><label>First operand:</label></td>
                <td><input type="text" name="first" value="${first}"></td>
            </tr>
            <tr>
                <td><label>Operand:</label></td>
                <td>
                    <select name="Operator">
                        <option>Addition</option>
                        <option>Subtraction</option>
                        <option>Multiplication</option>
                        <option>Division</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label>Second operand:</label></td>
                <td><input type="text" name="second" value="${second}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Calculate"></td>
            </tr>
            <tr>
                <td><h1>Result:</h1></td>
                <td><h1>${first} ${operatorCalculator} ${second} = ${resultCalculator}  </h1></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>