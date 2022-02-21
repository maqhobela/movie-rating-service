package com.opticsolutions.ratingsdataservice.models;

public class Rating {
    private int movieId;
    private int rating;

    public Rating(int movieId, int rating) {
        this.movieId = movieId;
        this.rating = rating;
    }

    // default constructor
    public Rating(){}

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
