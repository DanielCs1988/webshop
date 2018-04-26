package com.codecool.shop.config;

import com.codecool.shop.dao.*;
import com.codecool.shop.dao.implementation.*;
import com.codecool.shop.model.*;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Initializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();

        //setting up a new supplier
        Supplier amazon = new Supplier("Amazon", "Digital content and services");
        supplierDataStore.add(amazon);
        Supplier lenovo = new Supplier("Lenovo", "Computers");
        supplierDataStore.add(lenovo);
        Supplier samsung = new Supplier("Samsung", "Phones and gadgets");
        supplierDataStore.add(samsung);

        //setting up a new product category
        ProductCategory tablet = new ProductCategory("Tablet", "Hardware",
                "A tablet computer, commonly shortened to tablet, is a thin, flat mobile computer with a touchscreen display.");
        productCategoryDataStore.add(tablet);
        ProductCategory smartphone = new ProductCategory("Smartphone", "Hardware",
                "A smart phone. Able to think instead of you stupid cunts.");

        //setting up products and printing it
        productDataStore.add(new Product("Amazon Fire", 49.9f, "USD",
                "Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.",
                "amazon_fire.jpg", tablet.getId(), amazon.getId()));
        productDataStore.add(new Product("Lenovo IdeaPad Miix 700", 479, "USD",
                "Keyboard cover is included. Fanless Core m5 processor. Full-size USB ports. Adjustable kickstand.",
                "lenovo_miix_700.png", tablet.getId(), lenovo.getId()));
        productDataStore.add(new Product("Samsung Galaxy S8", 579.89f, "USD",
                "Samsung's latest cutting edge mobile phone. No more buttons!",
                "samsung_galaxy_s8.jpg", smartphone.getId(), samsung.getId()));
    }
}
