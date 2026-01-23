package com.me.recommend.repositories;

import com.me.recommend.dtos.MovieDTO;
import com.me.recommend.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {}