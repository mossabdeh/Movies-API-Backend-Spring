package ntic.tlsi.moviesapibackend.service;

import lombok.AllArgsConstructor;
import ntic.tlsi.moviesapibackend.entity.Movie;
import ntic.tlsi.moviesapibackend.repo.MovieRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieService {
    private MovieRepo movieRepo;
    public List<Movie> allMovies(){
       return movieRepo.findAll();

    }
}
