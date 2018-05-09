package com.codecool.shop.dao;

import com.codecool.shop.model.ShoppingCart;

import java.util.List;

public interface OrderDao {

    void add(ShoppingCart shoppingCart);
    ShoppingCart find(int id);
    void remove(int id);
    List<ShoppingCart> getAll(int userId);

}
