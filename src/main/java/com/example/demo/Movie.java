package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Movie {

    private @Id
    @GeneratedValue
    Long id;
    private String title;
    private String description;

    Movie(){}

    public Movie(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Movie))
            return false;
        Movie movie = (Movie) o;
        return Objects.equals(this.id, movie.id) && Objects.equals(this.title, movie.title)
                && Objects.equals(this.description, movie.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.title, this.description);
    }
    @Override
    public String toString() {
        return "Movie{" + "id=" + this.id + ", title='" + this.title + '\'' + ", description='" + this.description + '\'' + '}';
    }



}
