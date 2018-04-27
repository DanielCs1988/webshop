package com.codecool.shop.model;

public class Supplier extends BaseModel {

    private static int idSequence;

    public Supplier(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    protected int generateId() {
        return idSequence ++;
    }

    public String toString() {
        return String.format("id: %1$d, " +
                        "name: %2$s, " +
                        "description: %3$s",
                this.getId(),
                this.name,
                this.description
        );
    }
}