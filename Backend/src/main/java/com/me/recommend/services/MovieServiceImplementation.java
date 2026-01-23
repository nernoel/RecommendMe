package com.me.recommend.services;

import com.me.recommend.dtos.MovieDTO;
import com.me.recommend.entities.Movie;
import com.me.recommend.mapper.MovieMapper;
import com.me.recommend.repositories.MovieRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MovieServiceImplementation implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    @Autowired
    public MovieServiceImplementation(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    @Override
    public MovieDTO createMovie(MovieDTO movieDTO) {
        Movie movie = movieMapper.toEntity(movieDTO);
        Movie savedMovie = movieRepository.save(movie);
        return movieMapper.toDTO(savedMovie);
    }

    @Override
    public MovieDTO getMovieById(Long id) {
        return null;
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        List<Movie> movieList = movieRepository.findAll();
        List<MovieDTO> movieDTOList = new ArrayList<>();

        // Map each movie
        for (Movie movie : movieList) {
            MovieDTO movieDTO = movieMapper.toDTO(movie);
            movieDTOList.add(movieDTO);
        }
        return movieDTOList;
    }
}