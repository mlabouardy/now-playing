package com.labouardy.nowplaying.model;

/**
 * Created by Mohamed on 05/01/2017.
 */

public class BucketStorage {
    private Movie[] movies;

    private Serie[] series;

    public BucketStorage(){}

    public Movie[] getMovies() {
        return movies;
    }

    public void setMovies(Movie[] movies) {
        this.movies = movies;
    }

    public Serie[] getSeries() {
        return series;
    }

    public void setSeries(Serie[] series) {
        this.series = series;
    }
}
