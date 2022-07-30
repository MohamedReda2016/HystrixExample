package com.reda.movie.with.hystrix.rxjava;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.HystrixThreadPoolProperties;

public class HystrixMovieLoadCommand extends HystrixCommand<Movie> {

    MovieClient movieClient=new MovieClient();
    private static int count=0;
    protected HystrixMovieLoadCommand() {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("MovieLoadGroup"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("MovieLoadPool"))
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(10)));
    }

    @Override
    protected Movie run() throws Exception {
        System.out.println("Load Movie "+ count++);
        return movieClient.loadMovie(1);
    }

    @Override
    protected Movie getFallback() {
        System.out.println("Hystrix Movie Load Command failed");
        return new Movie(3,"la la land", "action", null);
    }
}
