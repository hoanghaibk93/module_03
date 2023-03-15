package controller;

import model.User;
import service.IUserService;
import service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
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
                showCreateForm(request, response);
                break;
            case "update":
                showEditForm(request, response);
                break;
            case "view":
                showViewUser(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "search":
                searchByCountryForm(request, response);
                break;
            case "sort":
                sortByName(request, response);
                break;
            default:
//                showListUsers(request, response);
                showListUsersMethod(request, response);
                break;
        }
    }

    private void showListUsersMethod(HttpServletRequest request, HttpServletResponse response) {
        List<User> listUsers = service.findAllMethod();
        request.setAttribute("listUsers", listUsers);
        try {
            request.getRequestDispatcher("/user/list.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showViewUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = service.findById(id);
        request.setAttribute("user", user);
        try {
            request.getRequestDispatcher("/user/view.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void sortByName(HttpServletRequest request, HttpServletResponse response) {
        List<User> userList = service.sortByName();
        request.setAttribute("listUsers", userList);
        try {
            request.getRequestDispatcher("user/list.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void searchByCountryForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/user/search.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = service.findById(id);
        request.setAttribute("user", user);
        try {
            request.getRequestDispatcher("/user/delete.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = service.findById(id);
        if (user == null) {
            try {
                response.sendRedirect("/user/error-404.jsp");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            request.setAttribute("user", user);
            try {
                request.getRequestDispatcher("/user/edit.jsp").forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void showListUsers(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<User> listUsers = service.findAll();
        request.setAttribute("listUsers", listUsers);
        try {
            request.getRequestDispatcher("/user/list.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("/user/create.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
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
                createUser(request, response);
                break;
            case "update":
//                editUser(request, response);
                updateUserMethod(request, response);
                break;
            case "view":
                break;
            case "delete":
                deleteUser(request, response);
                break;
            case "search":
                searchByCountry(request, response);
                break;
            default:
//                showListUsers(request, response);
                break;
        }
    }

    private void updateUserMethod(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(id, name, email, country);
        service.updateUserMethod(user);
        request.setAttribute("user", user);
        request.setAttribute("message", "update successful");
        try {
            request.getRequestDispatcher("/user/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void searchByCountry(HttpServletRequest request, HttpServletResponse response) {
        String country = request.getParameter("country");
        List<User> userList = service.searchByCountry(country);

        if (userList.isEmpty()) {
            request.setAttribute("message", "Not found");
            try {
                request.getRequestDispatcher("/user/list.jsp").forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            request.setAttribute("listUsers", userList);
            try {
                request.getRequestDispatcher("/user/list.jsp").forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        service.deleteUser(id);
        try {
            response.sendRedirect("/user");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void editUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(id, name, email, country);
        service.updateUser(id, user);
        request.setAttribute("user", user);
        request.setAttribute("message", "update successful");
        try {
            request.getRequestDispatcher("/user/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String country = request.getParameter("country");
//        User user = service.findById(id);
//        if(user == null){
//            try {
//                response.sendRedirect("/user/error-404.jsp");
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        } else {
//            user.setName(name);
//            user.setEmail(email);
//            user.setCountry(country);
//            service.updateUser(id,user);
//            request.setAttribute("user",user);
//            request.setAttribute("message", "update successful");
//            try {
//                request.getRequestDispatcher("/user/edit.jsp").forward(request,response);
//            } catch (ServletException e) {
//                throw new RuntimeException(e);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(name, email, country);
        service.insertUser(user);
        request.setAttribute("message", "Create successful");
        request.setAttribute("user", user);
        try {
            request.getRequestDispatcher("/user/create.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
