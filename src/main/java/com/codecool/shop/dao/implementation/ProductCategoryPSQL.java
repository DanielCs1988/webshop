package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ModelAssembler;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.utils.QueryProcessor;
import com.codecool.shop.model.ProductCategory;

import java.util.List;

public class ProductCategoryPSQL implements ProductCategoryDao {

    private ModelAssembler<ProductCategory> assembler = rs -> new ProductCategory(
            rs.getString("name"),
            rs.getString("department"),
            rs.getString("description")
    );


    @Override
    public void add(ProductCategory category) {
        QueryProcessor.ExecuteUpdate("INSERT INTO product_category(name,department,description)" +
                "VALUES (?,?,?);",category.getName(),category.getDepartment(),category.getDescription());
    }

    @Override
    public ProductCategory find(int id) {
        return QueryProcessor.FetchOne("SElECT * FROM product_category WHERE id = ?;", assembler,
                                        String.valueOf(id));
    }

    @Override
    public void remove(int id) {
        QueryProcessor.ExecuteUpdate("DELETE FROM product_category WHERE id = ?;", String.valueOf(id));
    }

    @Override
    public List<ProductCategory> getAll() {
        return QueryProcessor.FetchAll("SELECT * FROM product_category;", assembler);
    }
}

