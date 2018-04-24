package com.codecool.shop.model;

public class Supplier extends BaseModel {

    public Supplier(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String toString() {
        return String.format("id: %1$d, " +
                        "name: %2$s, " +
                        "description: %3$s",
                this.id,
                this.name,
                this.description
        );
    }
}