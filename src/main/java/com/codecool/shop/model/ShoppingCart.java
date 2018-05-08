package com.codecool.shop.model;

import java.util.Collections;
import java.util.Map;

public class  ShoppingCart {

    private int id;
    private int userId;
    private long paymentId;
    private Map<Integer, Integer> orders;

    public ShoppingCart(int userId, long paymentId, Map<Integer, Integer> orders) {
        this.userId = userId;
        this.paymentId = paymentId;
        this.orders = orders;
    }

    public ShoppingCart(int id, int userId, long paymentId, Map<Integer, Integer> orders) {
        this.id = id;
        this.userId = userId;
        this.paymentId = paymentId;
        this.orders = orders;
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
