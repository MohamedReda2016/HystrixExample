package com.reda.movie.with.hystrix.rxjava;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.HystrixThreadPoolProperties;

public class HystrixMovieRatingCommand extends HystrixCommand<String> {

    MovieClient movieClient=new MovieClient();
    private static int count=0;
    protected HystrixMovieRatingCommand() {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("MovieRatingCommand"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("MovieRatingPool"))
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(10)));
    }

    @Override
    protected String run() throws Exception {
        System.out.println("movie ratings loading "+count++);
        return movieClient.getRatings(1L);
    }

    @Override
    protected String getFallback() {
        return "Hystrix Movie Rating Command failed";
    }
}
