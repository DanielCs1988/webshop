package com.codecool.shop.model;

import java.util.Currency;

public class Product extends BaseModel {

    private float defaultPrice;
    private Currency defaultCurrency;
    private int productCategoryId;
    private int supplierId;


    public Product(String name, float defaultPrice, String currencyString, String description, int productCategoryId, int supplierId) {
        super(name, description);
        this.setPrice(defaultPrice, currencyString);
        this.productCategoryId = productCategoryId;
        this.supplierId = supplierId;

    }

    public float getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(float defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public Currency getDefaultCurrency() {
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

    @Override
    public String toString() {
        return String.format("id: %2$d, " +
                        "name: %2$s, " +
                        "defaultPrice: %3$f, " +
                        "defaultCurrency: %4$s, " +
                        "productCategory: %5$s, " +
                        "supplierId: %2$d",
                this.id,
                this.name,
                this.defaultPrice,
                this.defaultCurrency.toString(),
                this.productCategoryId,
                this.supplierId);
    }
}
