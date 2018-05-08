package com.codecool.shop.dao;

import com.codecool.shop.model.Product;

public interface UserDao {

    void add(Product product);
    Product find(int id);
    void remove(int id);

}
