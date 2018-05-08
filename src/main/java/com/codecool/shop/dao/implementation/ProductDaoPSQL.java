package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ModelAssembler;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.model.Product;

import java.sql.ResultSet;
import java.util.List;

public class ProductDaoPSQL implements ProductDao {

    @Override
    public void add(Product product) {

    }

    @Override
    public Product find(int id) {
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public List<Product> getBySupplier(int supplierId) {
        return null;
    }

    @Override
    public List<Product> getByProductCategory(int productCategoryId) {
        return null;
    }

    @Override
    public List<Product> getBySupplierAndCategory(int supplierId, int productCategoryId) {
        return null;
    }

    private final class ProductAssembler implements ModelAssembler<Product> {

        @Override
        public Product assemble(ResultSet resultSet) {
            return new Product(
                    resultSet.
            );
        }
    }

}
