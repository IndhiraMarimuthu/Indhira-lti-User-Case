package com.movie.manager.controller;

import com.movie.manager.model.*;
import com.movie.manager.service.MovieService;
import com.movie.manager.util.ResponseBuilder;
import io.swagger.annotations.ApiOperation;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class MovieController {

    @Autowired
    ResponseBuilder responseBuilder;

    @Autowired
    DozerBeanMapper dozerBeanMapper;

    @Autowired
    MovieService movieService;


    @PostMapping(path = "/movie/")
    @ApiOperation(value = "This operation perform to SAVE a movie")
    public ResponseEntity<RestResponse<RestResponse>> saveMovie(@RequestBody final Movie movieRequest){
        ResponseEntity<RestResponse<RestResponse>> response;
        RestResponse respons = new RestResponse();
        System.out.println(movieRequest);
        movieService.saveMovie(movieRequest);
        respons.setSuccess(true);
        response = responseBuilder.buildResponse(respons,HttpStatus.OK,"OK");

        return response;

    }

    @PutMapping(path = "/movie/update/")
    @ApiOperation(value = "This operation perform to UPDATE a movie")
    public ResponseEntity<RestResponse<RestResponse>> updateMovie(@RequestBody final Movie movieRequest){
        return saveMovie(movieRequest);
    }

   /* @PostMapping(path = "/screen/")
    @ApiOperation(value = "This operation perform to SAVE a screen")
    public ResponseEntity<RestResponse<RestResponse>> saveScreen(@RequestBody final Screen screenRequest){
        ResponseEntity<RestResponse<RestResponse>> response;
        RestResponse respons = new RestResponse();
        System.out.println(screenRequest);
        movieService.saveScreen(screenRequest);
        respons.setSuccess(true);
        response = responseBuilder.buildResponse(respons,HttpStatus.OK,"OK");

        return response;

    }*/

   /* @PutMapping(path = "/screen/update/")
    @ApiOperation(value = "This operation perform to UPDATE a screen")
    public ResponseEntity<RestResponse<RestResponse>> updateScreen(@RequestBody final Screen screenRequest){
        return saveScreen(screenRequest);
    }*/


    @PostMapping(path = "/multiplex/")
    @ApiOperation(value = "This operation perform to SAVE a Multiplex")
    public ResponseEntity<RestResponse<RestResponse>> saveMultiplex(@RequestBody final Multiplex multiplexRequest){
        ResponseEntity<RestResponse<RestResponse>> response;
        RestResponse respons = new RestResponse();
        System.out.println(multiplexRequest);
        movieService.saveMutliplex(multiplexRequest);
        respons.setSuccess(true);
        response = responseBuilder.buildResponse(respons,HttpStatus.OK,"OK");

        return response;

    }

    @PostMapping(path = "/multiplex/update/")
    @ApiOperation(value = "This operation perform to UPDATE a Multiplex")
    public ResponseEntity<RestResponse<RestResponse>> updateMultiplex(@RequestBody final Multiplex multiplexRequest){
        return saveMultiplex(multiplexRequest);
    }

    @GetMapping(path = "/movie/")
    @ApiOperation(value = "This operation perform to get all movies")
    public ResponseEntity<RestResponse<List<Movie>>> getAllMovies(){
        ResponseEntity<RestResponse<List<Movie>>> response;
        response = responseBuilder.buildResponse(movieService.getAllMovies(), HttpStatus.OK, "OK");
        return response;
    }

    /*@GetMapping(path = "/screen/")
    @ApiOperation(value = "This operation perform to get all screens")
    public ResponseEntity<RestResponse<List<Screen>>> getAllScreens(){
        ResponseEntity<RestResponse<List<Screen>>> response;
        response = responseBuilder.buildResponse(movieService.getAllScreens(), HttpStatus.OK, "OK");
        return  response;
    }*/

    @GetMapping(path = "/multiplex/")
    @ApiOperation(value = "This operation perform to get all multiplex")
    public ResponseEntity<RestResponse<Multiplex>> getMuliplexById(@RequestParam Integer multiplexId){
        ResponseEntity<RestResponse<Multiplex>> response;
        response = responseBuilder.buildResponse(movieService.getMultiplexById(multiplexId), HttpStatus.OK, "OK");
        return  response;
    }


    @GetMapping(path = "/movie/search/")
    @ApiOperation(value = "This operation perform to search a movie")
    public ResponseEntity<RestResponse<Movie>> searchMovie(@RequestParam String movieName){
        ResponseEntity<RestResponse<Movie>> response;
        response = responseBuilder.buildResponse(movieService.searchMovie(movieName), HttpStatus.OK, "OK");
        return response;
    }

}
