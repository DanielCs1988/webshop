package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ShoppingCartDao;
import com.codecool.shop.model.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartDaoMem implements ShoppingCartDao {
    private static List<ShoppingCart> data = new ArrayList<>();
    private static ShoppingCartDaoMem instance = null;

    /* A private Constructor prevents any other class from instantiating.
     */

    private ShoppingCartDaoMem() {
    }

    public static ShoppingCartDaoMem getInstance() {
        if (instance == null) {
            instance = new ShoppingCartDaoMem();
        }
        return instance;
    }

    @Override
    public void add(ShoppingCart shoppingCart) {
        data.add(shoppingCart);
    }

    @Override
    public ShoppingCart find(int id) {
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<ShoppingCart> getAll(int userId) {
        return null;
    }

}