package com.reda.movie;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool= Executors.newFixedThreadPool(20);
        while(true) {
            Future<String> loadMovieFutureCommand =pool.submit(new MovieLoadCommand());
            Future<String> RatingMovieFutureCommand= pool.submit(new MovieRatingCommand());
            Thread.sleep(100);
        }
    }
}
