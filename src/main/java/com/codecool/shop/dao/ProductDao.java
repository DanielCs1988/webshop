package com.codecool.shop.dao;

import com.codecool.shop.model.Supplier;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;

import java.util.List;

public interface ProductDao {

    void add(Product product);
    Product find(int id);
    void remove(int id);

    List<Product> getAll();
    List<Product> getBySupplier(int supplierId);
    List<Product> getByProductCategory(int productCategoryId);
    List<Product> getBySupplierAndCategory(int supplierId, int productCategoryId);

}
