package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.OrderDao;
import com.codecool.shop.model.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class OrderDaoMem implements OrderDao {
    private static List<ShoppingCart> data = new ArrayList<>();
    private static OrderDaoMem instance = null;

    /* A private Constructor prevents any other class from instantiating.
     */

    private OrderDaoMem() {
    }

    public static OrderDaoMem getInstance() {
        if (instance == null) {
            instance = new OrderDaoMem();
        }
        return instance;
    }

    @Override
    public void add(ShoppingCart shoppingCart) {
        data.add(shoppingCart);
    }

    @Override
    public ShoppingCart find(int id) {
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<ShoppingCart> getAll(int userId) {
        return null;
    }

}