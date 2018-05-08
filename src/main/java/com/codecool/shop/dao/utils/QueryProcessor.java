package com.codecool.shop.dao.utils;

import com.codecool.shop.dao.ModelAssembler;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class QueryProcessor {

    public static void ExecuteUpdate(String queryLine, String... params) {
        try (Connection connection = DatabaseConnectionHandler.getConnection();
             PreparedStatement statement = connection.prepareStatement(queryLine)
        ){
            int counter = 1;
            for (String param : params) {
                statement.setString(counter++, param);
            }
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Database Error!");
            e.printStackTrace();
        }
    }

    public static <T> T FetchOne(String queryLine, ModelAssembler<T> assembler, String... params) {
        try (Connection connection = DatabaseConnectionHandler.getConnection();
             PreparedStatement statement = connection.prepareStatement(queryLine)) {

            int counter = 1;
            for (String param : params) {
                statement.setString(counter++, param);
            }

            ResultSet rs = statement.executeQuery();
            return assembler.assemble(rs);

        } catch (SQLException e) {
            System.out.println("Database Error!");
            e.printStackTrace();
        }
        return null;
    }

    public static <T> List<T> FetchAll(String queryLine, ModelAssembler<T> assembler, String... params) {
        try (Connection connection = DatabaseConnectionHandler.getConnection();
             PreparedStatement statement = connection.prepareStatement(queryLine)) {

            int counter = 1;
            for (String param : params) {
                statement.setString(counter++, param);
            }

            ResultSet rs = statement.executeQuery();
            List<T> results = new LinkedList<>();
            while (rs.next()) {
                T newObject = assembler.assemble(rs);
                results.add(newObject);
            }
            return results;

        } catch (SQLException e) {
            System.out.println("Database Error!");
            e.printStackTrace();
        }
        return null;
    }
}
