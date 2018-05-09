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
            rs.getString("phone")
    );

    @Override
    public void add(User user) {
        QueryProcessor.ExecuteUpdate(
                "INSERT INTO users (name, email, password, phone) VALUES (?, ?, ?, ?);",
                user.getName(), user.getEmail(), user.getPassword(), user.getPhone()
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
