package com.reda.movie;

import java.util.concurrent.Callable;

public class MovieRatingCommand implements Callable<String> {

    MovieClient movieClient=new MovieClient();
    public static int count = 0;

    @Override
    public String call() throws Exception {
        System.out.println("loading movie ratings "+count++);
        Thread.sleep(70000);
        return movieClient.getRatings(1L);
    }
}
