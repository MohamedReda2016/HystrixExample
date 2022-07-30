package com.reda.movie.with.hystrix.rxjava;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.HystrixThreadPoolProperties;

public class HystrixRecommendedMovieCommand extends HystrixCommand<Movie> {

    MovieClient movieClient=new MovieClient();
    private static int count=0;
    protected HystrixRecommendedMovieCommand() {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("RecommendedMovieGroup"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("RecommendedMoviePool"))
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(10)));
    }

    @Override
    protected Movie run() throws Exception {
        System.out.println("Load recommended Movie "+ count++);
        return movieClient.getRecommendation(movieClient.loadMovie(1));
    }

    @Override
    protected Movie getFallback() {
        System.out.println("Hystrix Movie Load Command failed");
        return new Movie(3,"la la land", "action", null);
    }
}
