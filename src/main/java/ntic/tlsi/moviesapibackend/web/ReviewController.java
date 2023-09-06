package ntic.tlsi.moviesapibackend.web;

import lombok.AllArgsConstructor;
import ntic.tlsi.moviesapibackend.entity.Review;
import ntic.tlsi.moviesapibackend.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/v1/reviews")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class ReviewController {
    private ReviewService reviewService ;

    @PostMapping
    public ResponseEntity<Review> createReveiw(@RequestBody Map<String , String> payload){
        return new ResponseEntity<Review>(reviewService.insertReview
                (payload.get("reviewBody") , payload.get("imdbId")), HttpStatus.CREATED);

    }
}
