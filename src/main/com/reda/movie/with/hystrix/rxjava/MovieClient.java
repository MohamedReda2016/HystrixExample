package com.reda.movie.with.hystrix.rxjava;

public class MovieClient {
    public Movie loadMovie(int movieId){
        for (int i=0; i<=5;i++) {
            System.out.println("waiting for movie to load ....");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return new Movie(movieId, "snurf", "romantic", null);
    }

    public String getRatings(Long movieId) {
        for (int i=0; i<=5;i++) {
            System.out.println("waiting for ratings to load ....");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return "5.0";
    }

    public Movie getRecommendation(Movie movie){
        for (int i=0; i<=5;i++) {
            System.out.println("loading recommended movie with genre "+movie.getGenre());
        }
        return new Movie(11, "Avengers", movie.getGenre(), movie);
    }
}
