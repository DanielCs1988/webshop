package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ModelAssembler;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.utils.QueryProcessor;
import com.codecool.shop.model.Supplier;

import java.util.List;

public class SupplierDaoPSQL implements SupplierDao {
    private ModelAssembler<Supplier> assembler = rs -> new Supplier(
            rs.getString("name"),
            rs.getString("description")
    );


    @Override
    public void add(Supplier supplier) {
        QueryProcessor.ExecuteUpdate("INSERT INTO suppliers (name, description) VALUES (?,?);",
                supplier.getName(), supplier.getDescription());
    }

    @Override
    public Supplier find(int id) {
        return QueryProcessor.FetchOne("SELECT * FROM suppliers WHERE id = ?;",assembler,String.valueOf(id));
    }

    @Override
    public void remove(int id) {
        QueryProcessor.ExecuteUpdate("DELETE FROM suppliers WHERE id = ?;", String.valueOf(id));
    }

    @Override
    public List getAll() {
        return QueryProcessor.FetchAll("SELECT * FROM suppliers;", assembler);
    }
}
