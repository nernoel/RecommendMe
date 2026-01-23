package com.me.recommend.dtos;

import com.me.recommend.entities.Movie;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class MovieDTO {

    private Long id;

    private String title;

    private LocalDate releaseDate;

    private String posterUrl;

    private String watchUrl;

    private Movie.Category category;


}