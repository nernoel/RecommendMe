package com.me.recommend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToMany(
            mappedBy = "movie",
            cascade = CascadeType.ALL, // Applies to all cascade types
            orphanRemoval = true       // Auto deletion of child entities when no longer referenced by parent
    )
    private List<WatchAvailability> watchAvailabilities = new ArrayList<>();

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
