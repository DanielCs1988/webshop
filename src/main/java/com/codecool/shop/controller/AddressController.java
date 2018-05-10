package com.codecool.shop.controller;

import com.codecool.shop.dao.AddressDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.AddressDaoPSQL;
import com.codecool.shop.dao.implementation.ProductDaoPSQL;
import com.codecool.shop.model.Address;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddressController extends HttpServlet {

    private Gson gson = new Gson();
    AddressDao addressDataStore = new AddressDaoPSQL();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        int userId = Integer.valueOf(req.getParameter("user-id"));
        out.println(gson.toJson(addressDataStore.find(userId)));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String addressJson = ControllerUtil.requestJsonProcessor(req);
        Address address = gson.fromJson(addressJson, Address.class);
        out.println(addressDataStore.add(address));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String addressJson = ControllerUtil.requestJsonProcessor(req);
        Address address = gson.fromJson(addressJson, Address.class);
        addressDataStore.modify(address);
    }
}
