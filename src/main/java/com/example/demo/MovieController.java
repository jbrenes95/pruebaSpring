package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class MovieController implements IMovieController {

    @Autowired
    IMovieService service;

    public ResponseEntity<List<Movie>> getall() {
        return ResponseEntity.ok(service.all());
    }

    @Override
    public ResponseEntity<String> searchDescription(String word) {
        return null;
    }

    public ResponseEntity<Movie> one(@PathVariable Long id) {
        return ResponseEntity.ok(service.findOne(id));
    }

    public ResponseEntity<Movie> putMovie(Movie newMovie, @PathVariable Long id) {
        return ResponseEntity.ok(service.replaceMovie(newMovie, id));
    }

    public void removeMovie(@PathVariable Long id) {
        service.removeMovie(id);
    }

    @Override
    public ResponseEntity<Movie> getBrian() {
        Optional<Movie> movie = service.getBrian();
        if (movie.isPresent()) {
            return ResponseEntity.ok(movie.get());
        }
        return (ResponseEntity<Movie>) ResponseEntity.badRequest();
    }

    @Override
    public ResponseEntity<Movie> newMoview(Movie movie) {
        return ResponseEntity.ok(service.newMovie(movie));
    }
}
