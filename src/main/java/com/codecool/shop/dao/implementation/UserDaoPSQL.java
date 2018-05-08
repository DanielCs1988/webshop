package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ModelAssembler;
import com.codecool.shop.dao.UserDao;
import com.codecool.shop.dao.utils.QueryProcessor;
import com.codecool.shop.model.Address;
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
    public void add(User user) {
        Address billing = user.getBillingAddress();
        Address shipping = user.getShippingAddress();
        QueryProcessor.ExecuteUpdate(
                "INSERT INTO users (name, email, password, phone, " +
                                             "billing_zipcode, billing_country, billing_city, billing_address, " +
                                             "shipping_zipcode, shipping_country, shipping_city, shipping_address)" +
                           "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                user.getName(), user.getEmail(), user.getPassword(), user.getPhone(),
                billing.getZipcode(), billing.getCountry(), billing.getCity(), billing.getAddress(),
                shipping.getZipcode(), shipping.getCountry(), shipping.getCity(), shipping.getAddress()
        );
    }

    @Override
    public User find(int id) {
        return QueryProcessor.FetchOne("SELECT * FROM users WHERE id = ?;", assembler, String.valueOf(id));
    }

    @Override
    public void remove(int id) {
        QueryProcessor.ExecuteUpdate("DELETE FROM users WHERE id = ?;", String.valueOf(id));
    }
}
