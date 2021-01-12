package com.example.demo;
import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IMovieController {

    @JsonView(MovieController.class)
    @GetMapping("/brian")
    ResponseEntity<Movie> getBrian();

    @PostMapping("/movies")
    ResponseEntity<Movie> newMoview(@RequestBody Movie movie);

    @GetMapping("/movies")
    ResponseEntity<List<Movie>> getall();

    @PostMapping("/descriptionMovie")
    ResponseEntity<List> searchDescription(@RequestBody String word);

    @GetMapping("/movies/{id}")
    ResponseEntity<Movie> one(@PathVariable Long id);

    @PutMapping("/movies/{id}")
    ResponseEntity<Movie> putMovie(Movie newMovie, @PathVariable Long id);

    @DeleteMapping("/movies/{id}")
    void removeMovie(@PathVariable Long id);

}
