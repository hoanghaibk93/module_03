package com.example.calculatorquadraticequations;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet", value = "/Calculator")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double a = Double.parseDouble(request.getParameter("a"));
        double b = Double.parseDouble(request.getParameter("b"));
        double c = Double.parseDouble(request.getParameter("c"));
        double delta = Math.pow(b, 2) - 4 * a * c;
        double x1 = (-b + Math.sqrt(delta))/(2*a);
        double x2 = (-b - Math.sqrt(delta))/(2*a);
        PrintWriter printWriter = response.getWriter();
        if(delta < 0){
            printWriter.println("<h1>Phương trình vô nghiệm<h1>");
        } else if(delta > 0){
            printWriter.println("<h1>Phương trình có 2 nghiệm<h1>");
            printWriter.print("<p>x1=</p>"+x1);
            printWriter.print("<p>x1=</p>"+x2);
        } else {
            printWriter.println("<h1>Phương trình có nghiệm kép<h1>");
            printWriter.println("<p>x1=x2=</p>"+x1);
        }
    }
}