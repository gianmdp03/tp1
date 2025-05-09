package com.trabajo.proyecto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable=false)
    private String title;

    @NotNull
    @Column(nullable=false)
    private String director;

    @NotNull
    @Column(nullable = false)
    private Integer releaseYear;

    private String gender;

    public Movie() {
    }

    public Movie(String director, String title, Integer releaseYear, Long id) {
        this.director = director;
        this.title = title;
        this.releaseYear = releaseYear;
        this.id = id;
    }

    public Movie(String director, String title, Integer releaseYear, Long id, String gender) {
        this.director = director;
        this.title = title;
        this.releaseYear = releaseYear;
        this.id = id;
        this.gender = gender;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
