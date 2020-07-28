package com.movie.manager.model;

public class MovieSearchResult {

    private Movie movie;
    private Multiplex multiplex;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Multiplex getMultiplex() {
        return multiplex;
    }

    public void setMultiplex(Multiplex multiplex) {
        this.multiplex = multiplex;
    }
}
