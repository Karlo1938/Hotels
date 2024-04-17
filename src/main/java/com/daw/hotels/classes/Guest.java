package com.daw.hotels.classes;

import java.util.ArrayList;

import com.daw.hotels.classes.interfaces.GuestInterface;

public class Guest extends Person implements GuestInterface{
    private String nationality;
    private ArrayList<Stay> stays;

                //////////////////////////////////////////////TO STRING///////////////////////////////////////////////////

    @Override
    public String toString() {
        return "Guest [identifier=" + identifier + ", name=" + name + ", nationality=" + nationality + "]";
    }

                //////////////////////////////////////////////CONSTRUCTORS///////////////////////////////////////////////////

    public Guest() {}

    public Guest(String identifier, String name, String nationality) {
        super(identifier, name);
        this.nationality = nationality;
        this.stays = new ArrayList<>();
    }

                //////////////////////////////////////////////GETTERS AND SETTERS///////////////////////////////////////////////////
    
    
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public ArrayList<Stay> getStays() {
        return stays;
    }
    public void setStays(ArrayList<Stay> stays) {
        this.stays = stays;
    }

                /////////////////////////////////////////////METHODS///////////////////////////////////////////////////

    public void addStay(Stay stay){
        stays.add(stay);
    }
      
}
