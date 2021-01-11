package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieService service;

    @GetMapping("/movies")
    List<Movie> getall() {
        return service.all();
    }

    @PostMapping("/movies")
    Movie newMovie(Movie newMovie) {
        return service.newMovie(newMovie);
    }

    @GetMapping("/movies/{id}")
    Movie one(@PathVariable Long id) {
        return service.findOne(id);
    }

    @PutMapping("/movies/{id}")
    Movie putMovie(Movie newMovie, @PathVariable Long id) {
        return service.replaceMovie(newMovie, id);
    }

    @DeleteMapping("/movies/{id}")
    void removeMovie(@PathVariable Long id) {
        service.removeMovie(id);
    }

}
