package com.pluralsight;

public class Actor {

    protected int id;
    protected String firstName;

    protected String lastName;

    public Actor(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }



    @Override
    public String toString() {
        return "Actor ID: " + id + "\n----------" +
                "\nFirst Name: " + firstName +
                "\nLast Name='" + lastName + "\n";

    }

}
