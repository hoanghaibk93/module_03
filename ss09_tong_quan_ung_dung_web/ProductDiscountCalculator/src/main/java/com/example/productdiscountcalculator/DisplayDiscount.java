package com.example.productdiscountcalculator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DisplayDiscount", value = "/DisplayDiscount")
public class DisplayDiscount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product = request.getParameter("description");
        float price = Float.parseFloat(request.getParameter("price"));
        float percent = Float.parseFloat(request.getParameter("percent"));
        float discountAmount = price * percent * 0.01f;
        float discountPrice = price - discountAmount;
        PrintWriter printWriter = response.getWriter();
        printWriter.print("<h1>Product Description: " + product + "<h1>");
        printWriter.print("<h1>List Price: " + price + "<h1>");
        printWriter.print("<h1>Discount Percent: " + percent + "<h1>");
        printWriter.print("<h1>Discount Amount: " + discountAmount + "<h1>");
        printWriter.print("<h1>Discount Price: " + discountPrice + "<h1>");
    }
}
