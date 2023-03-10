<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
</head>
<body>
<h1>Simple Calculator</h1>
<form action="/CalculatorServlet" method="post">
    <table>
        <tr>
            <td><label>First operand:</label></td>
            <td><input type="text" name="first" value="${first}"></td>
        </tr>
        <tr>
            <td><label>Operand:</label></td>
            <td>
                <select name="Operator" >
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
            <td><input type="submit" name="first"></td>
        </tr>
        <tr>
            <td><h1>Result:</h1></td>
            <td><h1>${first} ${operatorCalculator} ${second} = ${resultCalculator}   </h1></td>
        </tr>
    </table>
</form>
</body>
</html>