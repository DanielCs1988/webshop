package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ProductOrderDao;
import com.codecool.shop.dao.utils.QueryProcessor;
import com.codecool.shop.model.ProductOrder;

import java.util.List;

public class ProductOrderDaoPSQL implements ProductOrderDao {

    @Override
    public void add(ProductOrder productOrder) {

    }

    @Override
    public void updateQuantity(int id, int quantity) {
        QueryProcessor.ExecuteUpdate(
                "UPDATE product_orders SET quantity = ? WHERE id = ?",
                String.valueOf(quantity), String.valueOf(id)
        );
    }

    @Override
    public void remove(int id) {
        QueryProcessor.ExecuteUpdate("DELETE FROM product_orders WHERE id = ?", String.valueOf(id));
    }

    @Override
    public List<ProductOrder> getByOrder(int orderId) {
        return null;
    }
}
