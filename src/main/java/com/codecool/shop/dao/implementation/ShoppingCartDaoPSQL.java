package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ModelAssembler;
import com.codecool.shop.dao.ShoppingCartDao;
import com.codecool.shop.dao.utils.QueryProcessor;
import com.codecool.shop.model.ShoppingCart;

import java.util.*;

public class ShoppingCartDaoPSQL implements ShoppingCartDao {

    ModelAssembler<ShoppingCart> assembler = rs -> {
        Map<Integer, Integer> orders = new HashMap<>();
        int[] productIds = (int[])(rs.getArray("product_ids").getArray());
        int[] quantities = (int[])(rs.getArray("quantities").getArray());
        for (int i = 0; i < productIds.length; i++) {
            orders.put(productIds[i], quantities[i]);
        }
        return new ShoppingCart(
                rs.getInt("id"),
                rs.getInt("user_id"),
                rs.getLong("payment_id"),
                orders
        );
    };

    @Override
    public void add(ShoppingCart shoppingCart) {
        QueryProcessor.ExecuteUpdate(
                "INSERT INTO orders (user_id, payment_id) VALUES (?, ?);",
                String.valueOf(shoppingCart.getUserId()),
                String.valueOf(shoppingCart.getPaymentId())
        );
        int orderId = QueryProcessor.FetchOne("SELECT * FROM orders WHERE payment_id = ?", assembler,
                String.valueOf(shoppingCart.getPaymentId())).getId();

        StringBuilder sb = new StringBuilder("INSERT INTO product_orders (order_id, product_id, quantity) VALUES ");
        Map<Integer, Integer> orders = shoppingCart.getOrders();
        for (Integer productId : orders.keySet()) {
            sb.append("(")
                    .append(orderId).append(", ")
                    .append(productId).append(", ")
                    .append(orders.get(productId)) .append("), ");
        }
        sb.delete(-1, -3).append(";");
        QueryProcessor.ExecuteUpdate(sb.toString());
    }

    @Override
    public ShoppingCart find(int id) {
        return null;
    }

    @Override
    public void remove(int id) {
    }

    @Override
    public List<ShoppingCart> getAll() {
        return null;
    }
}
