package com.qih.moviecatalogservice.model;

public class Movie {
    private String movieId;
    private String name;

    // It's needed when you unmarshall something to this object
    public Movie() {

    }

    public Movie(String movieId, String name) {
        this.movieId = movieId;
        this.name = name;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
