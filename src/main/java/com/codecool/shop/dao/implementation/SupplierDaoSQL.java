package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ModelAssembler;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.model.Supplier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SupplierDaoSQL implements SupplierDao {
    private ModelAssembler assembler = new SupplierAssembler();


    @Override
    public void add(Supplier supplier) {

    }

    @Override
    public Supplier find(int id) {

        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Supplier> getAll() {
        return null;
    }

    private final class SupplierAssembler implements ModelAssembler<Supplier> {
        @Override
        public Supplier assemble(ResultSet resultSet) throws SQLException {
            return new Supplier(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("description")
            );
        }
    }
}
