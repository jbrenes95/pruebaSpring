package com.example.demo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
public class Movie {

    private @Id
    @GeneratedValue
    Long id;
    private String title;
    private String description;

}
