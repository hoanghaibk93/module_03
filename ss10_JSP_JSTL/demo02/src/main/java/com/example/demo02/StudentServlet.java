package com.example.demo02;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "StudentServlet", value = "/student")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Da vao student Servlet");
        response.sendRedirect("https://www.youtube.com/watch?v=xwWe1-Xwylc");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Da vao Post");
        String username = request.getParameter("username");
        String pass = request.getParameter("password");
        System.out.println(username + "--" + pass);
        request.setAttribute("dspName",username);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
