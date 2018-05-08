package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ModelAssembler;
import com.codecool.shop.dao.UserDao;
import com.codecool.shop.model.Address;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.User;

public class UserDaoPSQL implements UserDao {

    ModelAssembler<User> assembler = rs -> new User(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("email"),
            rs.getString("password"),
            rs.getString("phone"),
            new Address(
                    rs.getString("billing_zipcode"),
                    rs.getString("billing_country"),
                    rs.getString("billing_city"),
                    rs.getString("billing_address")
            ),
            new Address(
                    rs.getString("shipping_zipcode"),
                    rs.getString("shipping_country"),
                    rs.getString("shipping_city"),
                    rs.getString("shipping_address")
            )
    );

    @Override
    public void add(Product product) {

    }

    @Override
    public Product find(int id) {
        return null;
    }

    @Override
    public void remove(int id) {

    }
}
