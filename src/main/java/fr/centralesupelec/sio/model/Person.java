package fr.centralesupelec.sio.model;

/**
 * Define the characteristics of a Person.
 */

public abstract class Person {

    // Only name was implemented in a first time, next step would have been to add an id.
    private String name;
    public String getName() { return name; }
    public void setName( String name ) { this.name = name; }

}
