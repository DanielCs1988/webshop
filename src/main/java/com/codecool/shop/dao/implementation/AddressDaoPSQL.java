package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.AddressDao;
import com.codecool.shop.dao.ModelAssembler;
import com.codecool.shop.dao.utils.QueryProcessor;
import com.codecool.shop.model.Address;

public class AddressDaoPSQL implements AddressDao {

    private ModelAssembler<Address> assembler = rs -> new Address(
            rs.getString("zip_code"),
            rs.getString("country"),
            rs.getString("city"),
            rs.getString("street"),
            rs.getInt("user_id"),
            rs.getInt("id")
    );

    @Override
    public void add(Address address) {
        QueryProcessor.ExecuteUpdate("INSERT INTO addresses (zip_code, country, city, street, user_id)" +
                                                "VALUES (?,?,?,?,?)",
                                                address.getZipcode(),address.getCountry(),address.getCity(),
                                                address.getStreet(),String.valueOf(address.getUserId()));
    }

    @Override
    public Address find(int id) {
        return QueryProcessor.FetchOne("SELECT * FROM addresses WHERE id = ?;", assembler, String.valueOf(id));
    }

    @Override
    public void remove(int id) {
        QueryProcessor.ExecuteUpdate("DELETE FROM addresses WHERE id = ?;",String.valueOf(id));
    }

    @Override
    public void modify(Address address) {
        QueryProcessor.ExecuteUpdate("UPDATE addresses SET zip_code = ?, country = ?, city = ? street = ?" +
                "                               WHERE user_id = ?;",address.getZipcode(),address.getCountry(),
                                                address.getCity(),address.getStreet(),String.valueOf(address.getUserId()));
    }
}
