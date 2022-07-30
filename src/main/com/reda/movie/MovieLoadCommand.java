package com.reda.movie;

import java.util.concurrent.Callable;

public class MovieLoadCommand implements Callable<String> {

    MovieClient movieClient=new MovieClient();
    public static int count=0;
    @Override
    public String call() throws Exception {
        System.out.println("load movie "+ count++);
        Thread.sleep(100);
        return movieClient.loadMovie(1L);
    }
}
