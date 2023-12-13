package com.pluralsight;


import java.sql.*;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.dbcp2.BasicDataSource;

public class SakilaDataManager {

    private DataSource dataSource;

    public SakilaDataManager(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public List<Actor> getActors(String last) throws SQLException {

        List<Actor> actorList = new ArrayList<>();

        String sql = "SELECT actor_id, first_name, last_name FROM actor " +
                "WHERE last_name = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, last);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("actor_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");

                Actor actor = new Actor(id, firstName, lastName);
                actorList.add(actor);
            }

        }

        return actorList;
    }




}
