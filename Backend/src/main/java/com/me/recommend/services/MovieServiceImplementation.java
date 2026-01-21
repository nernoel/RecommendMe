package com.me.recommend.services;

import com.me.recommend.dtos.MovieDTO;
import com.me.recommend.dtos.WatchAvailabilityDTO;
import com.me.recommend.entities.Movie;
import com.me.recommend.entities.WatchAvailability;
import com.me.recommend.mapper.MovieMapper;
import com.me.recommend.repositories.MovieRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MovieServiceImplementation implements MovieService{

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    @Autowired
    public MovieServiceImplementation(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    @Override
    public MovieDTO createMovie(MovieDTO movieDTO) {
        // Create new movie object and convert DTO to entity
        Movie movie = movieMapper.toEntity(movieDTO);


        // Set back‑references for nested objects (important!)
        // For each WatchAvailability in the list, set its parent Movie reference.
        // In a bidirectional OneToMany/ManyToOne relationship, JPA uses the "many" side
        // (WatchAvailability.movie) to determine the foreign key value in the database.
        // Without this, the child entities would not be linked to the parent when saved.
        if (movie.getWatchAvailabilities() != null) {
            movie.getWatchAvailabilities().forEach(w -> w.setMovie(movie));
        }

        // Save movie to repository
        Movie savedMovie = movieRepository.save(movie);

        // Return the saved movie to DTO
        return movieMapper.toDTO(savedMovie);
    }

    @Override
    public MovieDTO getMovieById(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie was not found"));
        return movieMapper.toDTO(movie);
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();

        // Using MapStruct map each movie to dto to a list
        return movies.stream()
                .map(movieMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<MovieDTO> getMovieByCategory(String category) {
        List<Movie> movies = movieRepository.findMovieByCategory(Movie.Category.valueOf(category));

        return movies.stream()
                .map(movieMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MovieDTO updateMovie(Long id, MovieDTO movieDTO) {
        Movie movieToUpdate = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        // Update entity fields
        movieToUpdate.setTitle(movieDTO.getTitle());
        movieToUpdate.setCategory(Movie.Category.valueOf(movieDTO.getCategory()));
        movieToUpdate.setPosterUrl(movieDTO.getPosterUrl());
        movieToUpdate.setReleaseDate(movieDTO.getReleaseDate());

        Movie updatedMovie = movieRepository.save(movieToUpdate);

        return movieMapper.toDTO(updatedMovie);

    }

    @Override
    public void delete(Long id) {
        movieRepository.deleteById(id);
    }

    @Override
    public WatchAvailabilityDTO createWatchAvailability(
            Long movieId,
            WatchAvailabilityDTO watchAvailabilityDTO
    ) {
        // Find parent movie
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        // Map DTO to entity
        WatchAvailability watchAvailability =
                movieMapper.toWatchAvailabilityEntity(watchAvailabilityDTO);

        // Set owning side (THIS IS NEEDED)!
        watchAvailability.setMovie(movie);

        // Add to parent collection to keep both in sync
        movie.getWatchAvailabilities().add(watchAvailability);

        // Save parent (cascade persists child)
        movieRepository.save(movie);

        // Return mapped DTO
        return movieMapper.toWatchAvailabilityDTO(watchAvailability);
    }

    @Override
    public void removeWatchAvailability(Long movieId, Long watchAvailabilityId) {

        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        boolean removed = movie.getWatchAvailabilities().removeIf(
                w -> w.getId().equals(watchAvailabilityId)
        );

        // Optional: throw if nothing was removed
        if (!removed) {
            throw new RuntimeException("WatchAvailability not found for this movie");
        }

        movieRepository.save(movie);

        /* EXTRA NOTE */
        // Because of orphanRemoval = true,
        // JPA will automatically delete the child row from the DB
    }
}
