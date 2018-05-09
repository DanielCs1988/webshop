package com.codecool.shop.dao;

import com.codecool.shop.model.ProductOrder;

import java.util.List;

public interface ProductOrderDao {

    void add(ProductOrder productOrder);
    void updateQuantity(int id, int quantity);
    void remove(int id);
    List<ProductOrder> getByOrder(int orderId);

}
