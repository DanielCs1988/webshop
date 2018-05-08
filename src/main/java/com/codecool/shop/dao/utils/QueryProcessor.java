package com.codecool.shop.dao.utils;

import com.codecool.shop.dao.ModelAssembler;
import java.sql.*;

public class QueryProcessor {

    public void ExecuteUpdate(String queryLine, String... params) {
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

    public <T> T ExecuteQuery(String queryLine, ModelAssembler<T> assembler, String... params) {
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
}
