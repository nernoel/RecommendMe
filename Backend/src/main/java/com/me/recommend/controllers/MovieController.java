package com.me.recommend.controllers;

import com.me.recommend.dtos.MovieDTO;
import com.me.recommend.dtos.WatchAvailabilityDTO;
import com.me.recommend.entities.Movie;
import com.me.recommend.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    /*
    Movie Controller requests
     */

    /*
    @PostMapping
    public ResponseEntity<MovieDTO> createMovie(@RequestBody Movie movie) {
        MovieDTO createdMovie = movieService.createMovie(movie);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdMovie);
    }
     */

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        Movie createdMovie = movieService.createMovie();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(movie);
    }

    @GetMapping
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        List<MovieDTO> listOfMovies = movieService.getAllMovies();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(listOfMovies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getMovieById(@PathVariable Long id) {
        MovieDTO movie = movieService.getMovieById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(movie);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<MovieDTO>> getMoviesByCategory(@PathVariable String category) {
        List<MovieDTO> listOfMovies = movieService.getMoviesByCategory(category);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(listOfMovies);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDTO> updateMovie(@PathVariable Long id, @RequestBody MovieDTO movieDTO) {
        MovieDTO updatedMovie = movieService.updateMovie(id, movieDTO);
        return ResponseEntity.ok(updatedMovie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        movieService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/watch")
    public ResponseEntity<WatchAvailabilityDTO> addWatchAvailability(
            @PathVariable Long id,
            @RequestBody WatchAvailabilityDTO watchAvailabilityDTO
    ) {
        WatchAvailabilityDTO createdWatch =
                movieService.createWatchAvailability(id, watchAvailabilityDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdWatch);
    }

    @DeleteMapping("/{id}/watch/{watchId}")
    public ResponseEntity<Void> removeWatchAvailability(@PathVariable Long id, @PathVariable Long watchId
    ) {
        movieService.removeWatchAvailability(id, watchId);
        return ResponseEntity.noContent().build();
    }
}
