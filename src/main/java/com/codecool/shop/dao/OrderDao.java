package com.codecool.shop.dao;

import com.codecool.shop.model.Order;

import java.util.List;

public interface OrderDao {

    Order findActive(int userId);
    Order findById(int id);
    int add(Order order);
    void update(Order order);
    void remove(int id);
    List<Order> getAllCompleted(int userId);

}
