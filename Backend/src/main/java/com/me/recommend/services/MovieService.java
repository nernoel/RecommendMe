package com.me.recommend.services;

import com.me.recommend.dtos.MovieDTO;
import com.me.recommend.dtos.WatchAvailabilityDTO;
import com.me.recommend.entities.Movie;

import java.util.List;

public interface MovieService {

    // Create a new movie object
   // MovieDTO createMovie(MovieDTO movieDTO);

    public Movie createMovie();

    // Get movie by id
    MovieDTO getMovieById(Long id);

    // Get all movies from repository
    List<MovieDTO> getAllMovies();

    // Get movies by category from repository
    List<MovieDTO> getMoviesByCategory(String category);

    // Update a movie from the repository
    MovieDTO updateMovie(Long id, MovieDTO movie);

    // Delete movie from the repository
    void delete(Long id);

    // Add watchability category
    WatchAvailabilityDTO createWatchAvailability(Long movieId, WatchAvailabilityDTO watchAvailability);

    // Remove watchability category
    void removeWatchAvailability(Long movieId, Long watchAvailabilityId);

}
