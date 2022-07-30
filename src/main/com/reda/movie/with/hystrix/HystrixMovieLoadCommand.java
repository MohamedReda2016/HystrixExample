package com.reda.movie.with.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.HystrixThreadPoolProperties;
import com.reda.movie.MovieClient;

public class HystrixMovieLoadCommand extends HystrixCommand<String> {

    MovieClient movieClient=new MovieClient();
    private static int count=0;
    protected HystrixMovieLoadCommand() {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("MovieLoadGroup"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("MovieLoadPool"))
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(10)));
    }

    @Override
    protected String run() throws Exception {
        System.out.println("Load Movie "+ count++);
        Thread.sleep(30000);
        return movieClient.loadMovie(1L);
    }

    @Override
    protected String getFallback() {
        System.out.println("Hystrix Movie Load Command failed");
        return "Hystrix Movie Load Command failed";
    }
}
