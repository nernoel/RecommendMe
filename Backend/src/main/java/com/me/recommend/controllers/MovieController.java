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

    @PostMapping("/create-movie")
    public ResponseEntity<MovieDTO> createMovie(@RequestBody MovieDTO movieDTO) {
        MovieDTO createdMovie = movieService.createMovie(movieDTO);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(createdMovie);
    }

    @PostMapping("/create-movies")
    public ResponseEntity<List<MovieDTO>> createMovies(@RequestBody List<MovieDTO> movieDTOList) {
        List<MovieDTO> createdMovies = movieService.createMovies(movieDTOList);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(createdMovies);
    }

    @GetMapping
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        List<MovieDTO> getAllMovies = movieService.getAllMovies();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(getAllMovies);
    }

    @GetMapping("/get-movie/{id}")
    public ResponseEntity<MovieDTO> getMovieById(@PathVariable Long id) {
        MovieDTO movieDTO = movieService.getMovieById(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(movieDTO);
    }

    @PatchMapping("/update-movie/{id}")
    public ResponseEntity<MovieDTO> updateMovieById(@PathVariable Long id, @RequestBody MovieDTO movieDTO) {
        MovieDTO updatedMovie = movieService.updateMovieById(id, movieDTO);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updatedMovie);
    }
}