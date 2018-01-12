package fr.centralesupelec.sio.data;

import fr.centralesupelec.sio.model.Movie;
import fr.centralesupelec.sio.model.MovieGenre;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * A concrete {@link MoviesRepository} backed by an in-memory list of static {@link Movie} entities.
 */
// This class is not accessible outside of its package.
class DummyMoviesRepository extends MoviesRepository {

    // Hold entities in lists.
    private final List<Movie> mMovies;
    private final List<String> mTitles;
    private final List<String> mGenres;
    private final List<String> mDirectors;
    private final List<String> mActors;

    DummyMoviesRepository() {
        // Define some static movies on creation (source from IMDB front page of the movie).

        Movie m1 = new Movie();
        m1.setId(1);
        m1.setTitle("The Lord of the Rings: The Fellowship of the Ring");
        m1.setGenres(MovieGenre.ADVENTURE.name());
        m1.setGenres(MovieGenre.DRAMA.name());
        m1.setGenres(MovieGenre.FANTASY.name());
        m1.setDirectors("Peter Jackson");
        m1.setActors("Elijah Wood");
        m1.setActors("Ian McKellen");
        m1.setActors("Orlando Bloom");

        Movie m2 = new Movie();
        m2.setId(2);
        m2.setTitle("The Lord of the Rings: The Two Towers");
        m2.setGenres(MovieGenre.ADVENTURE.name());
        m2.setGenres(MovieGenre.DRAMA.name());
        m2.setGenres(MovieGenre.FANTASY.name());
        m2.setDirectors("Peter Jackson");
        m2.setActors("Elijah Wood");
        m2.setActors("Ian McKellen");
        m2.setActors("Viggo Mortensen");

        Movie m3 = new Movie();
        m3.setId(3);
        m3.setTitle("The Lord of the Rings: The Return of the King");
        m3.setGenres(MovieGenre.ADVENTURE.name());
        m3.setGenres(MovieGenre.DRAMA.name());
        m3.setGenres(MovieGenre.FANTASY.name());
        m3.setDirectors("Peter Jackson");
        m3.setActors("Elijah Wood");
        m3.setActors("Viggo Mortensen");
        m3.setActors("Ian McKellen");

        Movie m4 = new Movie();
        m4.setId(4);
        m4.setTitle("Star Wars: Episode I - The Phantom Menace");
        m4.setGenres(MovieGenre.ACTION.name());
        m4.setGenres(MovieGenre.ADVENTURE.name());
        m4.setGenres(MovieGenre.FANTASY.name());
        m4.setDirectors("George Lucas");
        m4.setActors("Ewan McGregor");
        m4.setActors("Liam Neeson");
        m4.setActors("Natalie Portman");

        Movie m5 = new Movie();
        m5.setId(5);
        m5.setTitle("Star Wars: Episode II - Attack of the Clones");
        m5.setGenres(MovieGenre.ACTION.name());
        m5.setGenres(MovieGenre.ADVENTURE.name());
        m5.setGenres(MovieGenre.FANTASY.name());
        m5.setDirectors("George Lucas");
        m5.setActors("Hayden Christensen");
        m5.setActors("Natalie Portman");
        m5.setActors("Ewan McGregor");

        Movie m6 = new Movie();
        m6.setId(6);
        m6.setTitle("Star Wars: Episode III - Revenge of the Sith");
        m6.setGenres(MovieGenre.ACTION.name());
        m6.setGenres(MovieGenre.ADVENTURE.name());
        m6.setGenres(MovieGenre.FANTASY.name());
        m6.setDirectors("George Lucas");
        m6.setActors("Hayden Christensen");
        m6.setActors("Natalie Portman");
        m6.setActors("Ewan McGregor");

        Movie m7 = new Movie();
        m7.setId(7);
        m7.setTitle("Star Wars: Episode IV - A New Hope");
        m7.setGenres(MovieGenre.ACTION.name());
        m7.setGenres(MovieGenre.ADVENTURE.name());
        m7.setGenres(MovieGenre.FANTASY.name());
        m7.setDirectors("George Lucas");
        m7.setActors("Mark Hamill");
        m7.setActors("Harrison Ford");
        m7.setActors("Carrie Fisher");

        Movie m8 = new Movie();
        m8.setId(8);
        m8.setTitle("Star Wars: Episode V - The Empire Strikes Back");
        m8.setGenres(MovieGenre.ACTION.name());
        m8.setGenres(MovieGenre.ADVENTURE.name());
        m8.setGenres(MovieGenre.FANTASY.name());
        m8.setDirectors("Irvin Kershner");
        m8.setActors("Mark Hamill");
        m8.setActors("Harrison Ford");
        m8.setActors("Carrie Fisher");

        Movie m9 = new Movie();
        m9.setId(9);
        m9.setTitle("Star Wars: Episode VI - Return of the Jedi");
        m9.setGenres(MovieGenre.ACTION.name());
        m9.setGenres(MovieGenre.ADVENTURE.name());
        m9.setGenres(MovieGenre.FANTASY.name());
        m9.setDirectors("Richard Marquand");
        m9.setActors("Mark Hamill");
        m9.setActors("Harrison Ford");
        m9.setActors("Carrie Fisher");

        Movie m10 = new Movie();
        m10.setId(10);
        m10.setTitle("Schindler's List");
        m10.setGenres(MovieGenre.BIOGRAPHY.name());
        m10.setGenres(MovieGenre.DRAMA.name());
        m10.setGenres(MovieGenre.HISTORY.name());
        m10.setDirectors("Steven Spielberg");
        m10.setActors("Liam Neeson");
        m10.setActors("Ralph Fiennes");
        m10.setActors("Ben Kingsley");

        Movie m11 = new Movie();
        m11.setId(11);
        m11.setTitle("Forrest Gump");
        m11.setGenres(MovieGenre.DRAMA.name());
        m11.setGenres(MovieGenre.ROMANCE.name());
        m11.setDirectors("Robert Zemeckis");
        m11.setActors("Tom Hanks");
        m11.setActors("Robin Wright");
        m11.setActors("Gary Sinise");

        Movie m12 = new Movie();
        m12.setId(12);
        m12.setTitle("The Tree of Life");
        m12.setGenres(MovieGenre.DRAMA.name());
        m12.setGenres(MovieGenre.FANTASY.name());
        m12.setDirectors("Terrence Malick");
        m12.setActors("Brad Pitt");
        m12.setActors("Sean Penn");
        m12.setActors("Jessica Chastain");

        Movie m13 = new Movie();
        m13.setId(13);
        m13.setTitle("Perfect Sense");
        m13.setGenres(MovieGenre.DRAMA.name());
        m13.setGenres(MovieGenre.ROMANCE.name());
        m13.setGenres(MovieGenre.SCIENCE_FICTION.name());
        m13.setDirectors("David Mackenzie");
        m13.setActors("Ewan McGregor");
        m13.setActors("Eva Green");
        m13.setActors("Lauren Tempany");

        Movie m14 = new Movie();
        m14.setId(14);
        m14.setTitle("Kingsman: The Secret Service");
        m14.setGenres(MovieGenre.ACTION.name());
        m14.setGenres(MovieGenre.ADVENTURE.name());
        m14.setGenres(MovieGenre.COMEDY.name());
        m14.setDirectors("Matthew Vaughn");
        m14.setActors("Colin Firth");
        m14.setActors("Taron Egerton");
        m14.setActors("Samuel L. Jackson");

        Movie m15 = new Movie();
        m15.setId(15);
        m15.setTitle("Kingsman 2: The Golden Circle");
        m15.setGenres(MovieGenre.ACTION.name());
        m15.setGenres(MovieGenre.ADVENTURE.name());
        m15.setGenres(MovieGenre.COMEDY.name());
        m15.setDirectors("Matthew Vaughn");
        m15.setActors("Taron Egerton");
        m15.setActors("Colin Firth");
        m15.setActors("Mark Strong");

        // A list containing all the movies
        mMovies = Arrays.asList(m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, m12, m13, m14, m15);

        // A list that will contain all the titles
        mTitles = new ArrayList<>();
        // A list that will contain all the genres
        mGenres = new ArrayList<>();
        // A list that will contain all the directors
        mDirectors = new ArrayList<>();
        // A list that will contain all the actors
        mActors = new ArrayList<>();

        // Filling the lists with the appropriate values.
        for (Movie m : mMovies) {
            mTitles.add(m.getTitle());
            mGenres.addAll(m.getGenres());
            mDirectors.addAll(m.getDirectors());
            mActors.addAll(m.getActors());
        }

    }

    // Simple methods with no arguments
    @Override
    public List<Movie> getMovies() {
        return mMovies;
    }

    @Override
    public List<String> getTitles() { return mTitles; }

    @Override
    public List<String> getGenres() { return mGenres; }

    @Override
    public List<String> getDirectors() { return mDirectors; }

    @Override
    public List<String> getActors() { return mActors; }

    // A method that returns a movie from its id.
    @Override
    public Movie getMovie(long id) {
        return mMovies.parallelStream()
                .filter(movie -> movie.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // A method that returns a movie from its title.
    @Override
    public Movie getMovie(String title) {
        return mMovies.parallelStream()
                .filter(movie -> movie.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    // Getters used for filtering search with parameter (Need to update to take multiple
    // genres, directors or actors.

    // A method that returns a list of movies with their title containing a part of title (case insensitive).
    @Override
    public List<Movie> getMoviesByTitlePart(String title) {
        List<Movie> moviesByTitlePart = new ArrayList<>();
        for (Movie m : mMovies) {
            if (Pattern.compile(Pattern.quote(title), Pattern.CASE_INSENSITIVE).matcher(m.getTitle()).find()) {
                moviesByTitlePart.add(m);
            }
        }
        return moviesByTitlePart;
    }

    // A method that returns a list of movies with one of their genres matching a genre (case insensitive).
    @Override
    public List<Movie> getMoviesByGenre(String genre) {
        List <Movie> moviesByGenre = new ArrayList<>();
        for (Movie m : mMovies) {
            for (String movieGenre : m.getGenres()) {
                if (genre.equalsIgnoreCase(movieGenre)) {
                    moviesByGenre.add(m);
                }
            }
        }
        return moviesByGenre;
    }

    // A method that returns a list of movies with one of their directors matching a director (case insensitive).
    @Override
    public List<Movie> getMoviesByDirector(String director) {
        List<Movie> moviesByDirector = new ArrayList<>();
        for (Movie m : mMovies) {
            for (String movieDirector : m.getDirectors()) {
                if (director.equalsIgnoreCase(movieDirector)) {
                    moviesByDirector.add(m);
                }
            }
        }
        return moviesByDirector;
    }

    // A method that returns a list of movies with one of their actors matching an actor (case insensitive).
    @Override
    public List<Movie> getMoviesByActor(String actor) {
        List<Movie> moviesByActor = new ArrayList<>();
        for (Movie m : mMovies) {
            for (String movieActor : m.getActors()) {
                if (actor.equalsIgnoreCase(movieActor)) {
                    moviesByActor.add(m);
                }
            }
        }
        return moviesByActor;
    }

    // A method that returns a list of movies filtered by different parameters (case insensitive).
    @Override
    public List<Movie> getMoviesFilteredByParameters(String title, String genre, String director,
                                                     String actor, int limit, int offset) {
        // A counter to compare to the limit parameter.
        int counter=0;
        // Initialization of empty lists.
        List<Movie> moviesByTitle;
        List<Movie> moviesByGenre;
        List<Movie> moviesByDirector;
        List<Movie> moviesByActor;
        List<Movie> moviesByParameters;
        // Filtering by title.
        if (title == "_") {
            moviesByTitle = mMovies;
        }
        else {
            moviesByTitle = getMoviesByTitlePart(title);
        }
        // Filtering by genre.
        if (genre == "_") {
            moviesByGenre = mMovies;
        }
        else {
            moviesByGenre = getMoviesByGenre(genre);
        }
        // Filtering by director.
        if (director == "_") {
            moviesByDirector = mMovies;
        }
        else {
            moviesByDirector = getMoviesByDirector(director);
        }
        // Filtering by actor.
        if (actor == "_") {
            moviesByActor = mMovies;
        }
        else {
            moviesByActor = getMoviesByActor(actor);
        }

        moviesByParameters = moviesByTitle;
        moviesByParameters.retainAll(moviesByGenre);
        moviesByParameters.retainAll(moviesByDirector);
        moviesByParameters.retainAll(moviesByActor);
        return moviesByParameters.stream()
                .limit(limit)
                .skip(offset)
                .collect(Collectors.toList());

    }

}
