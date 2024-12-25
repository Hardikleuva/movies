package dev.hardik.movies.Controller;

import com.mongodb.MongoException;
import dev.hardik.movies.Model.Movie;
import dev.hardik.movies.Service.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<?> getAllMovies() {
//    public ResponseEntity<List<Movie>> getAllMovies() {
        try {
            return new ResponseEntity<List<Movie>>(movieService.AllMovies(), HttpStatus.OK);
//        return new ResponseEntity<String>("All Movies", HttpStatus.OK);
        }catch (MongoException e) {
            // Log the error
            System.err.println("MongoDB Exception: " + e.getMessage());

            // Return a custom error message
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>("Error fetching movies from the database. Please try again later.",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movie>>(movieService.SingleMovie(imdbId), HttpStatus.OK);
    }
}
