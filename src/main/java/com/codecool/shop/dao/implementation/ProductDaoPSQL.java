package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ModelAssembler;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
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
        public Product assemble(ResultSet rs) throws SQLException {
            return new Product(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getFloat("price"),
                    rs.getString("currency"),
                    rs.getString("image"),
                    rs.getInt("product_category_id"),
                    rs.getInt("supplier_id")
            );
        }
    }

}
