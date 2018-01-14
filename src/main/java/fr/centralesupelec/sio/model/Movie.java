package fr.centralesupelec.sio.model;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 * An entity class for a movie.
 */
public class Movie {

    // Parameters of a movie.
    private long id;
    private String title;
    private List<String> genres = new ArrayList<>();
    private List<String> directors = new ArrayList<>();
    private List<String> actors = new ArrayList<>();

    // Getters and Setters.
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getGenres() {
        return genres;
    }
    public void setGenres(String genres) { this.genres.add(genres); }

    public List<String> getDirectors() { return directors; }

    public void setDirectors(String director) {
        Person person = new Director();
        person.setName(director);
        this.directors.add(person.getName()); }

    public List<String> getActors() { return actors; }
    public void setActors(String actor) {
        Person person = new Actor();
        person.setName(actor);
        this.actors.add(person.getName()); }

}