package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ModelAssembler;
import com.codecool.shop.dao.OrderDao;
import com.codecool.shop.dao.utils.QueryProcessor;
import com.codecool.shop.model.Order;

import java.time.LocalDate;
import java.util.*;

public class OrderDaoPSQL implements OrderDao {

    ModelAssembler<Order> assembler = rs -> new Order(
            rs.getInt("id"),
            rs.getInt("user_id"),
            rs.getLong("payment_id"),
            rs.getString("status"),
            rs.getDate("date"),
            new ProductOrderDaoPSQL().getByOrder(rs.getInt("id"))
    );

    @Override
    public void add(Order order) {
        QueryProcessor.ExecuteUpdate(
                "INSERT INTO orders (user_id) VALUES (?);",
                String.valueOf(order.getUserId())
        );
    }

    @Override
    public Order findActive(int userId) {
        return QueryProcessor.FetchOne(
                "SELECT id, user_id FROM orders WHERE user_id = ? AND status = 'NEW';",
                rs -> {
                    return new Order(
                            rs.getInt("id"), rs.getInt("user_id"),
                            new ProductOrderDaoPSQL().getByOrder(rs.getInt("id"))
                    );
                },
                String.valueOf(userId)
        );
    }

    @Override
    public void remove(int id) {
        QueryProcessor.ExecuteUpdate("DELETE FROM orders WHERE id = ?;", String.valueOf(id));
    }

    @Override
    public List<Order> getAllCompleted(int userId) {
        return QueryProcessor.FetchAll(
                "SELECT * FROM orders WHERE user_id = ? AND status != 'NEW';",
                assembler, String.valueOf(userId)
        );
    }

    @Override
    public void update(Order order) {
        QueryProcessor.ExecuteUpdate(
                "UPDATE orders SET status = ?, payment_id = ?, date = ? WHERE id = ?;",
                "PAID", String.valueOf(order.getPaymentId()),
                LocalDate.now().toString(), String.valueOf(order.getId())
        );
    }
}
