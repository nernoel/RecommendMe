package com.me.recommend.services;

import com.me.recommend.dtos.MovieDTO;
import com.me.recommend.entities.Movie;

import java.util.List;

public interface MovieService {

    // Create a new movie object
    public MovieDTO createMovie(MovieDTO movieDTO);

    // Get movie by id
    MovieDTO getMovieById(Long id);

    // Get all movies from repository
    List<MovieDTO> getAllMovies();



}
