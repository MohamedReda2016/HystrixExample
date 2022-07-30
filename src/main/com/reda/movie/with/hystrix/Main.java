package com.reda.movie.with.hystrix;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        HystrixMovieLoadCommand hystrixMovieLoadCommand=new HystrixMovieLoadCommand();
        HystrixMovieRatingCommand hystrixMovieRatingCommand=new HystrixMovieRatingCommand();
        while(true) {
            hystrixMovieLoadCommand.queue();
            hystrixMovieRatingCommand.queue();
            Thread.sleep(100);
            hystrixMovieLoadCommand = new HystrixMovieLoadCommand();
            hystrixMovieRatingCommand = new HystrixMovieRatingCommand();
        }
    }


}
