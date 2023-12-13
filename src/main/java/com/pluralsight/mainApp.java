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

        //ActorSearchByLastName(dataManager);

        FilmSearchByID(dataManager);
    }


    public static void ActorSearchByLastName(SakilaDataManager dataManager) throws SQLException {

        System.out.println("Enter the last name of an actor you fancy: ");
        String last = input.nextLine().toUpperCase().trim();

        List<Actor> actorList = dataManager.getActors(last);

        actorList.forEach(System.out::println);


    }

    public static void FilmSearchByID(SakilaDataManager dataManager) throws SQLException{

        System.out.println("Enter the ID of an actor to see all of their movies: ");
        int actorId = input.nextInt();

        List<Film> actorsFilms = dataManager.getFilms(actorId);

        actorsFilms.forEach(System.out::println);


    }


}