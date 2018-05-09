package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ModelAssembler;
import com.codecool.shop.dao.ProductOrderDao;
import com.codecool.shop.dao.utils.QueryProcessor;
import com.codecool.shop.model.ProductOrder;

import java.util.List;

public class ProductOrderDaoPSQL implements ProductOrderDao {

    private ModelAssembler<ProductOrder> assembler = rs -> new ProductOrder(
            rs.getInt("id"),
            rs.getInt("order_id"),
            rs.getInt("product_id"),
            rs.getInt("quantity"),
            new ProductDaoPSQL().find(rs.getInt("product_id"))
    );

    @Override
    public void add(ProductOrder productOrder) {
        QueryProcessor.ExecuteUpdate("INSERT INTO product_orders (order_id,product_id,quantity)" +
                                                "VALUES (?,?,1)",String.valueOf(productOrder.getOrderId()),
                                                String.valueOf(productOrder.getProductId()));
    }

    @Override
    public void updateQuantity(int id, int quantity) {
        QueryProcessor.ExecuteUpdate(
                "UPDATE product_orders SET quantity = ?r WHERE id = ?",
                String.valueOf(quantity), String.valueOf(id)
        );
    }

    @Override
    public void remove(int id) {
        QueryProcessor.ExecuteUpdate("DELETE FROM product_orders WHERE id = ?", String.valueOf(id));
    }

    @Override
    public List<ProductOrder> getByOrder(int orderId) {

        return QueryProcessor.FetchAll("SELECT * FROM product_orders WHERE order_id = ?;",
                assembler, String.valueOf(orderId));
    }
}
