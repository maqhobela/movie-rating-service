package com.opticsolutions.movieInfoService.controllers;

import com.opticsolutions.movieInfoService.models.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieIResource {
    @RequestMapping("/{movieId}")
    public Movie getMovie(@PathVariable("movieId") int movieId){
        return new Movie(movieId, "Transformer");
    }
}
