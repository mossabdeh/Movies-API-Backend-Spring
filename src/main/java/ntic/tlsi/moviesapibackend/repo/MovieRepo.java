package ntic.tlsi.moviesapibackend.repo;

import ntic.tlsi.moviesapibackend.entity.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepo extends MongoRepository<Movie , ObjectId> {

}
