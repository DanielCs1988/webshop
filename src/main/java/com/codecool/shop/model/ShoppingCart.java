package com.codecool.shop.model;

import java.util.Map;

public class ShoppingCart {

    private int userId;
    private Map<Integer, Integer> orders;

    public ShoppingCart(int userId, Map<Integer, Integer> orders) {
        this.userId = userId;
        this.orders = orders;
    }

    public ShoppingCart() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Map<Integer, Integer> getOrders() {
        return orders;
    }

    public void setOrders(Map<Integer, Integer> orders) {
        this.orders = orders;
    }
}
