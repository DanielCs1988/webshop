package com.codecool.shop.dao;

import java.sql.ResultSet;

@FunctionalInterface
public interface ModelAssembler <T> {

    T assemble(ResultSet resultSet);

}
