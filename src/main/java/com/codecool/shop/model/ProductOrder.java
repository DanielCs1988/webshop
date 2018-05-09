package com.codecool.shop.model;

public class ProductOrder {

    private int id;
    private int orderId;
    private int productId;
    private int quantity;

    private Product product;

    public ProductOrder(int id, int orderId, int productId, int quantity, Product product) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.product = product;
    }

    public ProductOrder(int orderId, int productId, int quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }
}
