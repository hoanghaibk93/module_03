package controller;

import model.User;
import service.IUserService;
import service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    private static IUserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                break;
            case "update":
                break;
            case "view":
                break;
            case "delete":
                break;
            default:
                showListUsers(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                break;
            case "update":
                break;
            case "view":
                break;
            case "delete":
                break;
            default:
                break;
        }
    }

    private void showListUsers(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<User> listUsers = service.findAll();
        request.setAttribute("listUsers", listUsers);
        try {
            response.sendRedirect("/user/list.jsp");
        } catch (IOException e) {
            response.sendRedirect("/user/error-404");
        }
    }
}
