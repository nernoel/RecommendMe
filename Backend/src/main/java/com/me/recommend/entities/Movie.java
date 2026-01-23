package com.me.recommend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/*
Class representing a movie entity
 */
@Getter
@Setter
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private LocalDate releaseDate;

    private String posterUrl;

    private String watchUrl;

    @Enumerated(EnumType.STRING)
    private Category category;

    public enum Category {
        ACTION,
        COMEDY,
        FAMILY,
        HORROR,
        DRAMA,
        FANTASY,
        ROMANCE,
        ANIMATION,
    }
}