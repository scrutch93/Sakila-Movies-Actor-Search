package com.pluralsight;


import java.sql.*;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


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


    public List<Film> getFilms(int actorId) throws SQLException {

       List<Film> filmList = new ArrayList<>();

       String sql = "SELECT f.film_id, title, description, release_year, length FROM film f" +
               "JOIN film_actor a ON f.film_id = a.film_id " +
               "WHERE actor_id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, actorId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                int filmId = resultSet.getInt("film_id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                int releaseYear = resultSet.getInt("release_year");
                int length = resultSet.getInt("length");

                Film film = new Film(filmId, title, description, releaseYear, length);

                filmList.add(film);

            }

        return filmList;

        }

    }






}
