package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ModelAssembler;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.utils.QueryProcessor;
import com.codecool.shop.model.Product;

import java.util.List;

public class ProductDaoPSQL implements ProductDao {

    private ModelAssembler<Product> assembler = rs -> new Product(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("description"),
            rs.getFloat("price"),
            rs.getString("currency"),
            rs.getString("image"),
            rs.getInt("product_category_id"),
            rs.getInt("supplier_id")
    );

    @Override
    public void add(Product product) {
        QueryProcessor.ExecuteUpdate(
                "INSERT INTO products (name, description, price, currency, image, product_category_id, supplier_id)",
                product.getName(),
                product.getDescription(),
                String.valueOf(product.getPrice()),
                product.getDefaultCurrency().toString(),
                product.getImageName(),
                String.valueOf(product.getProductCategory()),
                String.valueOf(product.getSupplier())
        );
    }

    @Override
    public Product find(int id) {
        return QueryProcessor.FetchOne("SELECT * FROM products WHERE id = ?;", assembler, String.valueOf(id));
    }

    @Override
    public void remove(int id) {
        QueryProcessor.ExecuteUpdate("DELETE FROM products WHERE id = ?;", String.valueOf(id));
    }

    @Override
    public List<Product> getAll() {
        return QueryProcessor.FetchAll("SELECT * FROM products;", assembler);
    }

    @Override
    public List<Product> getBySupplier(int supplierId) {
        return QueryProcessor.FetchAll(
                "SELECT * FROM products WHERE supplier_id = ?;",
                assembler, String.valueOf(supplierId)
        );
    }

    @Override
    public List<Product> getByProductCategory(int productCategoryId) {
        return null;
    }

    @Override
    public List<Product> getBySupplierAndCategory(int supplierId, int productCategoryId) {
        return null;
    }
}
