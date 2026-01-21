package com.me.recommend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class WatchAvailability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    private String streamingPlatform; // Netflix, Hulu, Prime etc.

    private String watchUrl; // Link to watch

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
