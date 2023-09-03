package ntic.tlsi.moviesapibackend.web;

import lombok.AllArgsConstructor;
import ntic.tlsi.moviesapibackend.entity.Movie;
import ntic.tlsi.moviesapibackend.service.MovieService;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
@AllArgsConstructor // dependency injection
public class MovieController {
    private MovieService movieService;

    @GetMapping()
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<List<Movie>>(movieService.allMovies() , HttpStatus.OK);
    }


    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movie>>(movieService.movieByImdbId(imdbId) , HttpStatus.OK );
    }


}
