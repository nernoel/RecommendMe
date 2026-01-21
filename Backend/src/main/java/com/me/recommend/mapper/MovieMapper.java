package com.me.recommend.mapper;

import com.me.recommend.dtos.MovieDTO;
import com.me.recommend.dtos.WatchAvailabilityDTO;
import com.me.recommend.entities.Movie;
import com.me.recommend.entities.WatchAvailability;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    /*  This line is not necessary when using Spring
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);
    */

    MovieDTO toDTO(Movie movie);

    Movie toEntity(MovieDTO movieDTO);

    WatchAvailabilityDTO toWatchAvailabilityDTO(WatchAvailability watch);

    WatchAvailability toWatchAvailabilityEntity(WatchAvailabilityDTO watchDto);
}
