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
        Supplier dell = new Supplier("Dell", "All things screen related");
        supplierDataStore.add(dell);
        Supplier bosch = new Supplier("Bosch", "Kitchen stuff");
        supplierDataStore.add(bosch);
        Supplier codecool = new Supplier("Codecool", "L33t programming");
        supplierDataStore.add(codecool);

        //setting up a new product category
        ProductCategory tablet = new ProductCategory("Tablet", "Hardware",
                "A tablet computer, commonly shortened to tablet, is a thin, flat mobile computer with a touchscreen display.");
        productCategoryDataStore.add(tablet);
        ProductCategory smartDevice = new ProductCategory("Smart device", "Hardware",
                "A smart phone. Able to think instead of you.");
        productCategoryDataStore.add(smartDevice);
        ProductCategory console = new ProductCategory("Console", "Hardware",
                "Optimized for pure gaming experience.");
        productCategoryDataStore.add(console);
        ProductCategory webapp = new ProductCategory("Web Application", "Software",
                "A collection of fancy web applications.");
        productCategoryDataStore.add(webapp);


        //setting up products and printing it
        productDataStore.add(new Product("Amazon Fire", 49.9f, "USD",
                "Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.",
                "amazon_fire.jpg", tablet.getId(), amazon.getId()));
        productDataStore.add(new Product("Lenovo IdeaPad Miix 700", 479, "USD",
                "Keyboard cover is included. Fanless Core m5 processor. Full-size USB ports. Adjustable kickstand.",
                "lenovo_miix_700.png", tablet.getId(), lenovo.getId()));
        productDataStore.add(new Product("Samsung Galaxy S8", 579.89f, "USD",
                "Samsung's latest cutting edge mobile phone. No more buttons!",
                "samsung_galaxy_s8.jpg", smartDevice.getId(), samsung.getId()));
        productDataStore.add(new Product("Coffee Machine", 329.89f, "USD",
                "The source of life in the Galaxy. Central device of every office around the world.",
                "coffee.png", smartDevice.getId(), bosch.getId()));
        productDataStore.add(new Product("XBox 1337", 779.89f, "USD",
                "Latest invention of the hardware deps of CC. Who would have thought we made hardware?",
                "xbox.png", console.getId(), codecool.getId()));
        productDataStore.add(new Product("ProMan", 1579.89f, "USD",
                "Who needs Trello when you have ProMan? Schedule your tasks today... or maybe later.",
                "trello.png", webapp.getId(), codecool.getId()));
        productDataStore.add(new Product("Webshop", 1337, "USD",
                "I heard you like webshops. So we made a webshop inside a webshop!",
                "webshop.jpg", webapp.getId(), codecool.getId()));
        productDataStore.add(new Product("Snake", 279.89f, "USD",
                "Now with even more snakes. Because there is nothing more fun then not being able to" +
                        "move from everyone else's snakes.","snake.png", webapp.getId(), codecool.getId()));
    }
}
