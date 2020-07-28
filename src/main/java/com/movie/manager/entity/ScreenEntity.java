package com.movie.manager.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "screen")
public class ScreenEntity {

    @Id
    private Integer movieId;
    private Integer multiplexId;
    private Integer screenNumber;

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getMultiplexId() {
        return multiplexId;
    }

    public void setMultiplexId(Integer multiplexId) {
        this.multiplexId = multiplexId;
    }

    public Integer getScreenNumber() {
        return screenNumber;
    }

    public void setScreenNumber(Integer screenNumber) {
        this.screenNumber = screenNumber;
    }
}
