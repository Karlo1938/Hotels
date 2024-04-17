package com.daw.hotels.classes;

import com.daw.hotels.classes.interfaces.PersonInterface;

public abstract class Person implements PersonInterface{
    protected String identifier;
    protected String name;

                //////////////////////////////////////////////TO STRING///////////////////////////////////////////////////

    @Override
    public String toString() {
        return "Person [identifier=" + identifier + ", name=" + name + "]";
    }

                //////////////////////////////////////////////CONSTRUCTORS///////////////////////////////////////////////////

    public Person() {
    }

    public Person(String identifier, String name) {
        this.identifier = identifier;
        this.name = name;
    }

                //////////////////////////////////////////////GETTERS AND SETTERS///////////////////////////////////////////////////
    
    public String getIdentifier() {
        return identifier;
    }
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

                /////////////////////////////////////////////METHODS///////////////////////////////////////////////////

    
}
