package com.example.demo;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
public class Movie {

    private @Id
    @GeneratedValue
    Long id;

    @JsonView(MovieController.class)
    private String title;

    @JsonView(MovieController.class)
    private String description;

}
