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
        printWriter.print("<table border = 1 style=\"border: solid 1px red\">");
        printWriter.print("<tr><td>Product Description </td><td>" + product + "</td></tr>");
        printWriter.print("<tr><td>List Price </td><td>" + price + "</td></tr>");
        printWriter.print("<tr><td>Discount Percent </td><td>" + percent + "</td></tr>");
        printWriter.print("<tr><td>Discount Amount </td><td>" + discountAmount + "</td></tr>");
        printWriter.print("<tr><td>Discount Price </td><td>" + discountPrice + "</td></tr>");
        printWriter.print("</table>");

    }
}
