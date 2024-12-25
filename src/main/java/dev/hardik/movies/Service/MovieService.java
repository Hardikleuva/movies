package dev.hardik.movies.Service;

import dev.hardik.movies.Model.Movie;
import dev.hardik.movies.Repository.MoviesRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MoviesRepository moviesRepository;

    public List<Movie> AllMovies(){
        return moviesRepository.findAll();
    }


    public Optional<Movie> SingleMovie(String imdbId) {
        return moviesRepository.findMovieByImdbId(imdbId);
    }
}
