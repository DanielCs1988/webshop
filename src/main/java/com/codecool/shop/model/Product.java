package com.codecool.shop.model;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;

import java.util.Currency;

public class Product extends BaseModel {

    private float defaultPrice;
    private String currencyString;
    private Currency defaultCurrency;
    private String imageName;
    private int productCategoryId;
    private int supplierId;


    public Product(String name, float defaultPrice, String currencyString, String description, String imageName,
                   int productCategoryId, int supplierId) {
        super(name, description);
        this.imageName = imageName;
        this.setPrice(defaultPrice, currencyString);
        this.productCategoryId = productCategoryId;
        this.supplierId = supplierId;
        this.addSupplierId();

    }

    public Product(int id, String name, float defaultPrice, String currencyString, String description, String imageName,
                   int productCategoryId, int supplierId) {
        super(id, name, description);
        this.imageName = imageName;
        this.setPrice(defaultPrice, currencyString);
        this.productCategoryId = productCategoryId;
        this.supplierId = supplierId;
        this.addSupplierId();
    }

    public float getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(float defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public Currency getDefaultCurrency() {
        if (defaultCurrency == null) {
            defaultCurrency = Currency.getInstance(currencyString);
        }
        return defaultCurrency;
    }

    public void setDefaultCurrency(Currency defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }

    public String getPrice() {
        return String.valueOf(this.defaultPrice) + " " + this.defaultCurrency.toString();
    }

    public void setPrice(float price, String currency) {
        this.defaultPrice = price;
        this.defaultCurrency = Currency.getInstance(currency);
    }

    public int getProductCategory() {
        return productCategoryId;
    }

    public void setProductCategory(int productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public int getSupplier() {
        return supplierId;
    }

    public void setSupplier(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    private void addSupplierId() {
        ProductCategoryDaoMem.getInstance().find(this.productCategoryId).setSuppliers(this.supplierId);
    }

    @Override
    public String toString() {
        return String.format("id: %1$d, " +
                        "name: %2$s, " +
                        "defaultPrice: %3$f, " +
                        "defaultCurrency: %4$s, " +
                        "productCategory: %5$s, " +
                        "supplierId: %6$d",
                this.getId(),
                this.name,
                this.defaultPrice,
                this.getDefaultCurrency(),
                this.productCategoryId,
                this.supplierId);
    }
}
