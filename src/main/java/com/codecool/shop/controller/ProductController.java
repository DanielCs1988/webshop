package com.codecool.shop.controller;

import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.model.Product;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/webshop/product")
public class ProductController extends HttpServlet {

    private Gson gson = new Gson();
    private ProductDao productDataStore = ProductDaoMem.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productId = req.getParameter("product-id");
        if (productId != null) {
            PrintWriter out = resp.getWriter();
            Product product = productDataStore.find(Integer.valueOf(productId));
            out.println(gson.toJson(product));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (isUnauthorized(req, resp)) return;
        String input = req.getParameter("product");
        Product newProduct = gson.fromJson(input, Product.class);
        productDataStore.add(newProduct);
        System.out.println(newProduct);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO: handle getting wrong id input
        String productId = req.getParameter("product-id");
        if (isUnauthorized(req, resp) || productId == null) return;
        productDataStore.remove(Integer.valueOf(productId));
        System.out.println("Product number " + productId + " was removed from the store.");
    }

    private boolean isUnauthorized(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String password = req.getParameter("password");
        if (password == null || !password.equals(System.getenv("ADMIN_PASSWORD"))) {
            resp.sendError(401);
            return true;
        }
        return false;
    }
}
