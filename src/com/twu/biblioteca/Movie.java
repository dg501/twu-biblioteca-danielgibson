package com.twu.biblioteca;

public class Movie extends EntertainmentItems {

    private String rating;
    private boolean checkoutMovie = false;

    public Movie(String name, String director, String year, String rating) {
        super(name, director, year);
        this.rating = rating;
    }

    public String getRating() {
        return rating;
    }

}
