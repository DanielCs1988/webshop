package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.OrderDao;
import com.codecool.shop.dao.utils.DatabaseConnectionHandler;
import com.codecool.shop.model.Order;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderDaoPSQLTest {

    private OrderDao dao = new OrderDaoPSQL();
    private Order testOrder;

    @BeforeAll
    static void configConnection() {
        DatabaseConnectionHandler.setConfigPath("./src/main/java/com/codecool/shop/config/testConfig.json");
    }

    @BeforeEach
    void setUp() {
        testOrder = new Order(1);
    }

    @Test
    void add() {
        int id = dao.add(testOrder);
        testOrder.setId(id);
        dao.remove(id);
    }

    @Test
    void findActive() {
    }

    @Test
    void remove() {
    }

    @Test
    void getAllCompleted() {
    }

    @Test
    void update() {
    }
}