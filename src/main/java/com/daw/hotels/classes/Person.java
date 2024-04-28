package com.daw.hotels.classes;

import com.daw.hotels.classes.interfaces.PersonInterface;

public abstract class Person implements PersonInterface {
    protected String identifier;
    protected String name;

    //////////////////////// TO STRING///////////////////////////

    @Override
    public String toString() {
        return "Person [identifier=" + identifier + ", name=" + name + "]";
    }

    /////////////////////// CONSTRUCTORS//////////////////////////

    public Person() {
    }

    public Person(String identifier, String name) {
        this.identifier = identifier;
        this.name = name;
    }

    //////////////////// GETTERS AND SETTERS ///////////////

    /**
     * <strong>Getter</strong> for the "identifier" String attribute of <strong>Person
     * or inherited object</strong> object.
     * 
     * @return The "identifier" String attribute of the <strong>Person or inherited
     *         object</strong> object.
     * @version 1.0
     * @author Karlo1938
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * <strong>Setter</strong> for the "identifier" String attribute of <strong>Person
     * or inherited object</strong> object.
     * 
     * @param name The String identifier to set the "identifier" String attribute of <strong>Person
     * or inherited object</strong> object.
     * @version 1.0
     * @author Karlo1938
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    /**
     * <strong>Getter</strong> for the "name" String attribute of <strong>Person or
     * inherited object</strong> object.
     * 
     * @return the "name" String attribute of the <strong>Person or inherited
     *         object</strong> object.
     * @version 1.0
     * @author Karlo1938
     */
    public String getName() {
        return name;
    }

    /**
     * <strong>Setter</strong> for the "name" String attribute of <strong>Person or
     * inherited object</strong> object.
     * 
     * @param name The String name to set the "name" String attribute of the <strong>Person or inherited
     *          object</strong> object.
     * @version 1.0 
     * @author Karlo1938
     */
    public void setName(String name) {
        this.name = name;
    }

    /////////////////////// METHODS ///////////////////////////

}
