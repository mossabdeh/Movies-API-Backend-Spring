package ntic.tlsi.moviesapibackend.service;

import lombok.AllArgsConstructor;
import ntic.tlsi.moviesapibackend.entity.Movie;
import ntic.tlsi.moviesapibackend.entity.Review;
import ntic.tlsi.moviesapibackend.repo.ReviewRepo;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReviewService {
    private ReviewRepo reviewRepo ;
    private MongoTemplate mongoTemplate ;

    public Review insertReview(String reviewBody , String imdbId){
        Review review = reviewRepo.insert(new Review(reviewBody));
        ;

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();
        return review;
    }
}
