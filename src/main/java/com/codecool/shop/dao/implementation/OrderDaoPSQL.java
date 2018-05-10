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
    public int add(Order order) {
        return QueryProcessor.fetchOne(
                "INSERT INTO orders (user_id) VALUES (?::INTEGER) RETURNING id;",
                rs -> rs.getInt("id"),
                String.valueOf(order.getUserId())
        );
    }

    @Override
    public Order findActive(int userId) {
        return QueryProcessor.fetchOne(
                "SELECT id, user_id FROM orders WHERE user_id = ?::INTEGER AND status = 'NEW';",
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
        QueryProcessor.executeUpdate("DELETE FROM orders WHERE id = ?::INTEGER;", String.valueOf(id));
    }

    @Override
    public List<Order> getAllCompleted(int userId) {
        return QueryProcessor.fetchAll(
                "SELECT * FROM orders WHERE user_id = ?::INTEGER AND status != 'NEW';",
                assembler, String.valueOf(userId)
        );
    }

    @Override
    public void update(Order order) {
        QueryProcessor.executeUpdate(
                "UPDATE orders SET status = ?, payment_id = ?::INTEGER, date = ? WHERE id = ?::INTEGER;",
                "PAID", String.valueOf(order.getPaymentId()),
                LocalDate.now().toString(), String.valueOf(order.getId())
        );
    }
}
