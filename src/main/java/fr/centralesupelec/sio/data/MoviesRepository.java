package fr.centralesupelec.sio.data;

import fr.centralesupelec.sio.model.Actor;
import fr.centralesupelec.sio.model.Director;
import fr.centralesupelec.sio.model.Movie;

import java.util.EnumSet;
import java.util.List;

/**
 * A data repository to expose movie-related entities.
 */
// A clean approach is to expose only capabilities of the repository to other parts of the project.
// This is achieved by defining here a public interface with data-access methods.
// The concrete implementation is done in non-public specific classes.
// We switched to an "abstract class" instead of an interface just to add the singleton below.
public abstract class MoviesRepository {

    // Singleton pattern: Hold a unique instance of the repository in a private static field.
    private static MoviesRepository sRepository;

    /**
     * Obtain a shared instance of the repository.
     * @return The shared {@link MoviesRepository} instance.
     */
    // Singleton pattern: Expose a public static method to obtain the unique instance.
    public static MoviesRepository getInstance() {
        // The unique instance is null by default, create if needed.
        if (sRepository == null) {
            // Here we choose which concrete class to use for the repository.
            // This choice is not visible to the outside, since the singleton only exposes the parent abstract class.
            sRepository = new DummyMoviesRepository();
            //sRepository = new DatabaseMoviesRepository();
        }
        return sRepository;
    }

    // Singleton pattern: Prevent instantiation of the class from the outside using a restrictive visibility modifier.
    // The only way to get a MovieRepository from the outside is MovieRepository.getInstance().
    protected MoviesRepository() { }

    /**
     * Query all available movies.
     * @return A list of {@link Movie} entities.
     */
    // We only define the interface of a repository, concrete implementation is delegated to subclasses.
    // TODO: Add another method or parameters for pagination (get a subset of the list)
    public abstract List<Movie> getMovies();
    public abstract List<String> getTitles();
    public abstract List<String> getGenres();
    public abstract List<String> getDirectors();
    public abstract List<String> getActors();

    /**
     * @param id: The id of the movie.
     * @return The {@link Movie} entity, or null of the movie does not exist.
     */
    // We have several choices to handle the problem of unknown id:
    // - return null.
    // - use java.util.Optional<Movie> as the return type, which explicitly handles the missing case.
    // - throw an exception, such as java.util.NoSuchElementException.
    public abstract Movie getMovie(long id);

    public abstract Movie getMovie(String title);

    public abstract List<Movie> getMoviesByTitlePart(String title);

    public abstract List<Movie> getMoviesByGenre(String genre);

    public abstract List<Movie> getMoviesByDirector(String director);

    public abstract List<Movie> getMoviesByActor(String actor);

    public abstract List<Movie> getMoviesFilteredByParameters(String title, String genre, String director,
                                                              String actor, int limit, int offset);

}
