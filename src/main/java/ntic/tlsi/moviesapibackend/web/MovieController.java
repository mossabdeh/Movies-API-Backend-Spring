package ntic.tlsi.moviesapibackend.web;

import lombok.AllArgsConstructor;
import ntic.tlsi.moviesapibackend.entity.Movie;
import ntic.tlsi.moviesapibackend.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
@AllArgsConstructor // dependency injection
public class MovieController {
    private MovieService movieService;

    @GetMapping("/all")
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<List<Movie>>(movieService.allMovies() , HttpStatus.OK);
    }




}
