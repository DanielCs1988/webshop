package com.codecool.shop.model;

import java.util.ArrayList;

public class ProductCategory extends BaseModel {

    private static int idSequence;
    private String department;
    private ArrayList<Integer> suppliers;

    public ProductCategory(String name, String department, String description) {
        super(name, description);
        this.department = department;
    }

    @Override
    protected int generateId() {
        return idSequence ++;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSuppliers(Integer supplierId) { this.suppliers.add(supplierId); }

    public String toString() {
        return String.format(
                "id: %1$d," +
                        "name: %2$s, " +
                        "department: %3$s, " +
                        "description: %4$s",
                this.getId(),
                this.name,
                this.department,
                this.description);
    }
}