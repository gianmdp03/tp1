package com.trabajo.proyecto.controller;

import com.trabajo.proyecto.model.Movie;
import com.trabajo.proyecto.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/movies")
public class MovieController {
    private MovieService movieService;
    @Autowired
    public MovieController(MovieService movieService)
    {
        this.movieService = movieService;
    }
    @PostMapping
    public ResponseEntity<?> createMovie(@Valid @RequestBody Movie movie)
    {
        return ResponseEntity.ok(movieService.createMovie(movie));
    }
    @GetMapping
    public ResponseEntity<?> listAllMovies()
    {
        return ResponseEntity.ok(movieService.listAllMovies());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findMovieWithId(@PathVariable Long id)
    {
        return ResponseEntity.ok(movieService.findById(id));
    }
    @GetMapping("/year/{year}")
    public ResponseEntity<?> findMovieWithReleaseYear(@PathVariable Integer releaseYear)
    {
        return ResponseEntity.ok(movieService.findByReleaseYear(releaseYear));
    }

}
