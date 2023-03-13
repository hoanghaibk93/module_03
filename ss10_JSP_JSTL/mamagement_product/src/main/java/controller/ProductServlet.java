package controller;

import model.Product;
import service.IProductService;
import service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    private IProductService service = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreareForm(request,response);
                break;
            case "edit":
                break;
            case "delete":
                break;
            case "reseach":
                break;
            case "view":
                break;
            default:
                listProducts(request, response);
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
            case "edit":
                break;
            case "delete":
                break;
            case "reseach":
                break;
            case "view":
                break;
            default:
                break;
        }
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = service.findAll();
        request.setAttribute("productList", productList);
        try {
            request.getRequestDispatcher("/product/list.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void showCreareForm(HttpServletRequest request, HttpServletResponse response){
        
    }
}
