package com.codecool.shop.dao;

import com.codecool.shop.model.User;

public interface UserDao {

    int add(User user);
    User find(int id);
    void remove(int id);

}
