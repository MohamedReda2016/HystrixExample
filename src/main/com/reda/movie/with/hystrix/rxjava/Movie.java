package com.reda.movie.with.hystrix.rxjava;

import lombok.Data;

@Data
public class Movie {

    private int id;
    private String name;
    private Movie recommendedMovie;
    private String genre;

    public Movie(int id, String name, String genre, Movie recommendedMovie) {
        this.id = id;
        this.name = name;
        this.recommendedMovie = recommendedMovie;
        this.genre = genre;
    }
}
