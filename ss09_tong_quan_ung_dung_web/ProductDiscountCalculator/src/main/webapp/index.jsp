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
    <style>
        div{
            margin: 10px 50px;
        }
    </style>
</head>
<body>
<form action="/DisplayDiscount" method="post">
    <div><h1>Product Discount Calculator</h1></div>
    <div><label for="des">Product Description:</label></div>
    <div><input type="text" id="des" name="description" placeholder="Description"></div>
    <div><label for="price">List Price:</label></div>
    <div><input type="text" id="price" name="price" placeholder="Price"></div>
    <div><label for="percent">Discount Percent:</label></div>
    <div><input type="text" id="percent" name="percent" placeholder="Percent"></div>
    <div><input type="submit" value="Calculator Discount"></div>

</form>
</body>
</html>