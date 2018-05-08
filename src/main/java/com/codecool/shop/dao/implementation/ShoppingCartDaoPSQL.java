package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ModelAssembler;
import com.codecool.shop.dao.ShoppingCartDao;
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
