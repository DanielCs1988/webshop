package com.codecool.shop.controller;

import com.codecool.shop.dao.OrderDao;
import com.codecool.shop.dao.implementation.OrderDaoPSQL;
import com.codecool.shop.model.Order;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.time.LocalDateTime;
import java.util.List;


@WebServlet(urlPatterns = {"/webshop/checkout2"})
public class OrderController extends HttpServlet {

    private Gson gson = new Gson();
    OrderDao orderDaoDataStore = new OrderDaoPSQL();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //OrderDao shoppingCartDataStore = OrderDaoMem.getInstance();


        String jsonFromReq = ControllerUtil.requestJsonProcessor(req);
        Order order = gson.fromJson(jsonFromReq, Order.class);
        //shoppingCartDataStore.add(order);
        System.out.println(order);
        orderDaoDataStore.add(order);
        logOrder(jsonFromReq, order.getId());
        // sendMail(order);
    }

    /*private void sendMail(Order order) {
        String subject = "Information about order number " + order.getId();
        Address address = order.getUser().getShippingAddress();
        String content = "<h2>Dear " + order.getUser().getName() + "!</h2>" +
                "<p>Thank you for the purchase, we have received your order.</p>" +
                "<p>The items will arrive at the following address: </p>" +
                "" + address.getZipcode() + " " + address.getCountry() + ", " + address.getStreet() + "" +
                "<p>Payment identifier: " + order.getPaymentId() + "</p>" +
                "<br><p>We hope you have a nice day!<br>Team Codeberg</p>";
        MailSender mailSender = new MailSender(order.getUser().getEmail(), subject, content);
        mailSender.start();
    }*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        int userId = Integer.valueOf(req.getParameter("user-id"));
        if (req.getParameter("get-all") != null) {
            out.println(gson.toJson(orderDaoDataStore.getAllCompleted(userId)));
        } else if (req.getParameter("get-new")!= null) {
            out.println(gson.toJson(orderDaoDataStore.findActive(userId)));
        }
    }


    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderJson = ControllerUtil.requestJsonProcessor(req);
        Order order = gson.fromJson(orderJson,Order.class);
        orderDaoDataStore.update(order);
    }

    private void logOrder(String order, int id) {
        LocalDateTime currentDT = LocalDateTime.now();
        String filename = "./orders/order" + id + "_" + currentDT.getYear() + currentDT.getMonthValue()
                + currentDT.getDayOfMonth() + ".json";
        try {
            PrintWriter writer = new PrintWriter(filename, "UTF-8");
            writer.println(order);
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
