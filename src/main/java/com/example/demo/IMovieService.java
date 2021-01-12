package com.example.demo;
import java.util.List;
import java.util.Optional;

public interface IMovieService {

    Optional<Movie> getBrian();

    List<Movie> all();

    Movie newMovie(Movie movie);

    Movie findOne(Long id);

    Movie replaceMovie(Movie newMovie, Long id);

    List<Movie> search(String word);

    void removeMovie(Long id);
}
