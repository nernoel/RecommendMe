package com.me.recommend.controllers;

import com.me.recommend.dtos.MovieDTO;
import com.me.recommend.entities.Movie;
import com.me.recommend.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService)   {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<MovieDTO> createMovie(@RequestBody MovieDTO movieDTO) {
        MovieDTO createdMovie = movieService.createMovie(movieDTO);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(createdMovie);
    }

    @GetMapping
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        List<MovieDTO> getAllMovies = movieService.getAllMovies();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(getAllMovies);
    }
}