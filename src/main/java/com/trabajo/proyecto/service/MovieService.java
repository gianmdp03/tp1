package com.trabajo.proyecto.service;

import com.trabajo.proyecto.exception.DocumentalAnd1920Exception;
import com.trabajo.proyecto.exception.MovieNotFoundException;
import com.trabajo.proyecto.exception.TitleAndDirectorExisteException;
import com.trabajo.proyecto.model.Movie;
import com.trabajo.proyecto.repository.MovieRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private MovieRepository movieRepository;
    @Autowired
    public MovieService(MovieRepository movieRepository)
    {
        this.movieRepository = movieRepository;
    }

    public Movie createMovie(@Valid Movie movie)
    {
        if(movieRepository.existsByTitleAndDirector(movie.getTitle(), movie.getDirector()))
        {
            throw new TitleAndDirectorExisteException("Ya existe una película con ese título y director");
        }
        if(movie.getReleaseYear()<1920 && movie.getDirector().equalsIgnoreCase("documental"))
        {
            throw new DocumentalAnd1920Exception("La pelicula es documental y anterior a 1920");
        }
        return movieRepository.save(movie);
    }

    public Movie findById(Long id)
    {
        return movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException("Pelicula no encontrada"));
    }

    public List<Movie> listAllMovies()
    {
        return movieRepository.findAll();
    }

    public List<Movie> findByReleaseYear(Integer releaseYear)
    {
        return movieRepository.findByReleaseYear(releaseYear);
    }
}
