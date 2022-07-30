package com.reda.movie.with.hystrix.rxjava;

public class Main {

    public static void main(String[] args) {

        new HystrixMovieLoadCommand().observe().flatMap(movie -> new HystrixRecommendedMovieCommand().observe()).zipWith(
                new HystrixMovieRatingCommand().observe(),
                        (recommendedMovie, ratings) -> "loading movie with name "+recommendedMovie.getName()+ " and ratings: "+ratings+" has recomended film "+recommendedMovie.getGenre())
                .toBlocking()
                .subscribe(System.out::println);

    }
}
