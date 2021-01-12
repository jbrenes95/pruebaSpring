package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService implements IMovieService {
    @Autowired
    private MovieRepository repository;

    public List<Movie> all() {
        return repository.findAll();
    }

    public Movie newMovie(Movie newMovie) {
        return repository.save(newMovie);
    }

    public Movie findOne(Long id) {
        return repository.findById(id).orElseThrow(() -> new MovieNotFoundException());
    }

    public Movie replaceMovie(Movie newMovie, Long id) {
        return repository.findById(id).map(movie -> {
            movie.setTitle(newMovie.getTitle());
            movie.setDescription(newMovie.getDescription());
            return repository.save(movie);
        }).orElseGet(() -> {
            newMovie.setId(id);
            return repository.save(newMovie);
        });
    }

    public void removeMovie(Long id) {
        repository.deleteById(id);
    }

    public List<Movie> search(String word) {
        return repository.findAll((Sort) MovieRepository.searchDescription(word));
    }

    public Optional<Movie> getBrian() {
        return repository.findAll(MovieRepository.isBrian()).stream().findFirst();
    }

}
