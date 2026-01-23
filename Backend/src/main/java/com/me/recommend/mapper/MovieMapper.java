package com.me.recommend.mapper;

import com.me.recommend.dtos.MovieDTO;
import com.me.recommend.entities.Movie;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public MovieMapper(ModelMapper modelMapper) {
        this.modelMapper = new ModelMapper();
    }

    public MovieDTO toDTO(Movie movie) {
        return modelMapper.map(movie, MovieDTO.class);
    }

    public Movie toEntity(MovieDTO movieDTO) {
        return modelMapper.map(movieDTO, Movie.class);
    }
}