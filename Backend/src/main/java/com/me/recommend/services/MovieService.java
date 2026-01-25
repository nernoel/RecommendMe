package com.me.recommend.services;

import com.me.recommend.dtos.MovieDTO;
import com.me.recommend.entities.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    // Create a new movie object
    MovieDTO createMovie(MovieDTO movieDTO);

    // Create a new list of movie objects
    List<MovieDTO> createMovies(List<MovieDTO> movieDTOList);

    // Get all movies from repository
    List<MovieDTO> getAllMovies();

    // Get movie by ID
    MovieDTO getMovieById(Long id);

    // Update a movie by ID from the repository
    MovieDTO updateMovieById(Long movieId, MovieDTO movieDTO);



}