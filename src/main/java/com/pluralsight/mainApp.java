package com.pluralsight;

import java.sql.*;
import java.util.List;
import java.util.Scanner;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
public class mainApp {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {


        String username = "root";
        String password = System.getenv("MY_DB_PASSWORD");


        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setUrl("jdbc:mysql://localhost:3306/sakila");
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        SakilaDataManager dataManager = new SakilaDataManager(dataSource);

        System.out.println("Welcome.");

        ActorSearch(dataManager);


//        getActorLastName(dataSource);
//
//        getFirstAndLastName(dataSource);


    }

//    public static void getActorLastName(DataSource dataSource) throws SQLException {
//        System.out.println("Enter the lastname of an actor you fancy: ");
//        String response = input.nextLine().toUpperCase().trim();
//
//        try (
//                Connection connection = dataSource.getConnection();
//
//                PreparedStatement preparedStatement = connection.prepareStatement(
//                        "SELECT first_name, last_name FROM actor " +
//                                "WHERE last_name = ?")
//        ) {
//            preparedStatement.setString(1, response);
//
//            try (ResultSet resultSet = preparedStatement.executeQuery()) {
//
//                while (resultSet.next()) {
//                  String lastName =  resultSet.getString("last_name");
//                  String firstName = resultSet.getString("first_name");
//                    System.out.println(firstName + " " + lastName);
//
//                }
//
//            }
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
//    }


    public static void ActorSearch(SakilaDataManager dataManager) throws SQLException {

        System.out.println("Enter the last name of an actor you fancy: ");
        String last = input.nextLine().toUpperCase().trim();

        List<Actor> actorList = dataManager.getActors(last);

        actorList.forEach(System.out::println);


    }

//    public static void getFirstAndLastName(DataSource dataSource){
//        System.out.println("Enter the first and last name of an actor you fancy: ");
//        System.out.println("First Name: ");
//        String first = input.nextLine().toUpperCase().trim();
//        System.out.println("Last Name: ");
//        String last =  input.nextLine().toUpperCase().trim();
//
//        try (
//                Connection connection = dataSource.getConnection();
//
//                PreparedStatement preparedStatement = connection.prepareStatement(
//                        "SELECT first_name, last_name FROM actor " +
//                                "WHERE first_name = ? AND last_name = ?")
//        ) {
//            preparedStatement.setString(1, first);
//            preparedStatement.setString(2, last);
//            try (ResultSet resultSet = preparedStatement.executeQuery()) {
//
//                while (resultSet.next()) {
//                    String lastName =  resultSet.getString("last_name");
//                    String firstName = resultSet.getString("first_name");
//                    System.out.println(firstName + " " + lastName);
//
//                }
//
//            }
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
//    }
}