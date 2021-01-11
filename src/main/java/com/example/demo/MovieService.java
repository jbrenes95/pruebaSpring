package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Service
public class MovieService {
    @Autowired
    private  MovieRepository repository;

   public  List<Movie> all() {
        return repository.findAll();
    }

    public Movie newMovie( Movie newMovie) {
        return repository.save(newMovie);
    }

    Movie findOne( Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException());
    }

    Movie replaceMovie( Movie newMovie,Long id) {
       return repository.findById(id)
                .map(movie -> {
                    movie.setTitle(newMovie.getTitle());
                    movie.setDescription(newMovie.getDescription());
                    return repository.save(movie);
                })
                .orElseGet(() -> {
                    newMovie.setId(id);
                    return repository.save(newMovie);
                });
    }

    void removeMovie(Long id) {
        repository.deleteById(id);
    }

}
