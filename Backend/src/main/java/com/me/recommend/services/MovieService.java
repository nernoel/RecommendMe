package com.me.recommend.services;

import com.me.recommend.dtos.MovieDTO;
import com.me.recommend.entities.Movie;

import java.util.List;

public interface MovieService {

    // Create a new movie object
    MovieDTO createMovie(MovieDTO movieDTO);

    // Create a new list of movie objects
    List<MovieDTO> createMovies(List<MovieDTO> movieDTOList);

    // Get all movies from repository
    List<MovieDTO> getAllMovies();



}