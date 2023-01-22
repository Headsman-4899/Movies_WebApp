package com.example.movies.controllers;

import com.example.movies.models.Movie;
import com.example.movies.services.MovieService;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> allMovies() {
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imbdId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imbdId) {
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imbdId), HttpStatus.OK);
    }
}
