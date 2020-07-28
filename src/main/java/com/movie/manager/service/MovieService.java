package com.movie.manager.service;

import com.movie.manager.entity.MovieEntity;
import com.movie.manager.entity.MultiplexEntity;
import com.movie.manager.entity.ScreenEntity;
import com.movie.manager.model.Movie;
import com.movie.manager.model.MovieSearchResult;
import com.movie.manager.model.MovieSearchResult;
import com.movie.manager.model.Multiplex;
import com.movie.manager.model.Screen;
import com.movie.manager.repository.MovieRepository;
import com.movie.manager.repository.MultiPlexRepository;
import com.movie.manager.repository.ScreenRepository;
import com.movie.manager.util.EntityMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private static final Logger log = LoggerFactory.getLogger(MovieService.class);

    @Autowired MovieRepository movieRepository;

    @Autowired
    ScreenRepository screenRepository;

    @Autowired
    MultiPlexRepository multiPlexRepository;


    @Autowired
    private EntityMapper entityMapper;


    public void saveMovie(Movie movie){
        this.movieRepository.save(entityMapper.mapMovieModelToEntity(movie));
        log.info("Movie added successfully{}", movie.getName());
    }

   public void saveMutliplex(Multiplex multiplex){
        this.multiPlexRepository.save(entityMapper.mapMultiplexModelToEntity(multiplex));
        log.info("Multiplex added successfully{}-",multiplex.getMultiplexName());
    }

    public void saveScreen(Screen screen){
        this.screenRepository.save(entityMapper.mapScreenModelToEntity(screen));
        log.info("Screen added successfully{}-",screen.getScreenNumber());
    }

    public List<Movie> getAllMovies(){
        List<MovieEntity> movieList = this.movieRepository.findAll();
        return entityMapper.mapMovieEntityToModel(movieList);
    }

    public List<Screen> getAllScreens(){
        List<ScreenEntity> screenEntityList = this.screenRepository.findAll();
        return entityMapper.mapScreenEntityToModel(screenEntityList);
    }

    public Multiplex getMultiplexById(Integer multiplexId){
        MultiplexEntity multiplexEntity =  multiPlexRepository.findByMultiplexId(multiplexId);
        return entityMapper.mapMultiplexEntityToModel(multiplexEntity);
    }

    public Movie searchMovie(String movieName){
        MovieEntity movieEntity = movieRepository.findMovieEntityByName(movieName);
        List<MovieEntity> movieEntityList = new ArrayList<>();
        movieEntityList.add(movieEntity);
        return entityMapper.mapMovieEntityToModel(movieEntityList).get(0);
    }

}
