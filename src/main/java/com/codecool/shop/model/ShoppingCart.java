package com.codecool.shop.model;

import java.util.Collections;
import java.util.Map;

public class ShoppingCart {

    private int id;
    private int userId;
    private Map<Integer, Integer> orders;
    private long paymentId;

    public ShoppingCart(Map<Integer, Integer> orders, long paymentId) {
        this.orders = orders;
        this.paymentId = paymentId;
    }

    public ShoppingCart(Map<Integer, Integer> orders, long paymentId, int userId) {
        this.userId = userId;
        this.orders = orders;
        this.paymentId = paymentId;
    }

    public ShoppingCart(Map<Integer, Integer> orders, int id, long paymentId) {
        this.id = id;
        this.orders = orders;
        this.paymentId = paymentId;
    }

    public ShoppingCart() {
    }

    public Map<Integer, Integer> getOrders() {
        return Collections.unmodifiableMap(orders);
    }

    public void setOrders(Map<Integer, Integer> orders) {
        this.orders = orders;
    }

    public void addOrder(int productId, int productNumber) {
        this.orders.put(productId, productNumber);
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public void setId() {

    }

    public long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(long paymentId) {
        this.paymentId = paymentId;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + id +
                ", orders=" + orders +
                ", paymentId=" + paymentId +
                '}';
    }
}
