package com.codecool.shop.model;

import java.util.Date;

public class Order {

    private int id;
    private int userId;
    private long paymentId;
    private String status;
    private Date date;

    public Order(int id, int userId) {
        this.id = id;
        this.userId = userId;
    }

    public Order(int id, int userId, long paymentId, String status, Date date) {
        this.id = id;
        this.userId = userId;
        this.paymentId = paymentId;
        this.status = status;
        this.date = date;
    }

    public Order(int userId, long paymentId, String status, Date date) {
        this.userId = userId;
        this.paymentId = paymentId;
        this.status = status;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public long getPaymentId() {
        return paymentId;
    }

    public String getStatus() {
        return status;
    }

    public Date getDate() {
        return date;
    }
}
