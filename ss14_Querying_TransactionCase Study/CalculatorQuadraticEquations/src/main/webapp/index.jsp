<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Giải Phương Trình Bậc 2</h1>
<h3>ax2+bx+c=0</h3>
<form method="post" action="/Calculator">
    <table>
        <tr>
            <td><label for="a">Nhập a</label></td>
            <td><input name="a" id="a" type="text"></td>
        </tr>
        <tr>
            <td><label for="b">Nhập b</label></td>
            <td><input name="b" id="b" type="text"></td>
        </tr>
        <tr>
            <td><label for="c">Nhập c</label></td>
            <td><input name="c" id="c" type="text"></td>
        </tr>
        <tr>
            <td><button type="submit">Calculate</button></td>
        </tr>
    </table>

</form>
</body>
</html>