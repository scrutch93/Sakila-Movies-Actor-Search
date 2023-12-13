package com.pluralsight;

public class Film {

    protected int filmId;

    protected String title;

    protected String description;

    protected int releaseYear;

    protected int length;

    public Film(int filmId, String title, String description, int releaseYear, int length) {
        this.filmId = filmId;
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.length = length;
    }

    @Override
    public String toString() {
        return "Film\n" +
                "---------\n" +
                "filmId: " + filmId + "\n" +
                "title: " + title + "\n" +
                "description: " + description + "\n" +
                "releaseYear: " + releaseYear + "\n" +
                "length: " + length + "\n";
    }






}
