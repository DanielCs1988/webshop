package com.codecool.shop.model;

import java.util.Collections;
import java.util.Map;

public class ShoppingCart {

    private static int idSequence;
    private int id;
    private User user;
    private Map<Integer, Integer> orders;
    private long paymentId;

    public ShoppingCart(User user, Map<Integer, Integer> orders, long paymentId) {
        this.user = user;
        this.orders = orders;
        this.paymentId = paymentId;
        this.id = idSequence++;
    }

    public ShoppingCart() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public int getId() {
        return id;
    }

    public void setId() {
        if (id == 0) {
            id = idSequence++;
        }
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
                ", user=" + user +
                ", orders=" + orders +
                ", paymentId=" + paymentId +
                '}';
    }
}
