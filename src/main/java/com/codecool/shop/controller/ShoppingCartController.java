package com.codecool.shop.controller;

import com.codecool.shop.dao.ShoppingCartDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ShoppingCartDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ShoppingCart;
import com.codecool.shop.model.Supplier;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;


@WebServlet(urlPatterns = {"/webshop/checkout"})
public class ShoppingCartController extends HttpServlet {

    private Gson gson = new Gson();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ShoppingCartDao shoppingCartDataStore = ShoppingCartDaoMem.getInstance();
        StringBuilder rawData = new StringBuilder();
        BufferedReader reader = req.getReader();
        String input;

        while ((input = reader.readLine()) != null) {
            rawData.append(input);
        }
        ShoppingCart order = gson.fromJson(rawData.toString(), ShoppingCart.class);
        order.setId();
        shoppingCartDataStore.add(order);
        System.out.println(order);
    }

}

/* Mock for the correct shopping cart JSON:
{
    'user': {
        'name': 'Jack',
        'email': 'asd',
        'phone': '21223312',
        'billingAddress': {
            'zipcode': '1234',
            'country': 'Hungary',
            'city': 'Budapest',
            'address': 'KEKVILLE'
        },
        'shippingAddress': {
            'zipcode': '1234',
            'country': 'Hungary',
            'city': 'Budapest',
            'address': 'KEKVILLE'
        }
    },
    'paymentId': 123456789,
    'orders': {
        1: 1,
        2: 2,
        3: 3
    }
}*/
