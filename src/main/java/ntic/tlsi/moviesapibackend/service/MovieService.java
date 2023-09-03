package ntic.tlsi.moviesapibackend.service;

import lombok.AllArgsConstructor;
import ntic.tlsi.moviesapibackend.entity.Movie;
import ntic.tlsi.moviesapibackend.repo.MovieRepo;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MovieService {
    private MovieRepo movieRepo;
    public List<Movie> allMovies(){
       return movieRepo.findAll();

    }

    public Optional<Movie> movieByImdbId(String  imdbId) {
        return movieRepo.findMovieByImdbId(imdbId);
    }
}
