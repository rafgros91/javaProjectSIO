package fr.centralesupelec.sio.data;

import fr.centralesupelec.sio.model.Actor;
import fr.centralesupelec.sio.model.Director;
import fr.centralesupelec.sio.model.Movie;

import java.util.EnumSet;
import java.util.List;

/**
 * A {@link MoviesRepository} backed by a database.
 */
// Database Storage implementation (NOT IMPLEMENTED)
class DatabaseMoviesRepository extends MoviesRepository {

    // Simple methods without arguments
    @Override
    public List<Movie> getMovies() {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public List<String> getTitles() {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public List<String> getGenres() {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public List<String> getDirectors() {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public List<String> getActors() {
        throw new UnsupportedOperationException("Not implemented!");
    }

    // Methods with arguments
    @Override
    public Movie getMovie(long id) {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public List<Movie> getMoviesByTitlePart(String title) {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public List<Movie> getMoviesByGenres(String listOfGenres) {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public List<Movie> getMoviesByDirectors(String listOfDirectors) {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public List<Movie> getMoviesByActors(String listOfActors) {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public List<Movie> getMoviesFilteredByParameters(String title, String genre, String director,
                                                     String actor, int limit, int offset) {
        throw new UnsupportedOperationException("Not implemented!");
    }
}
