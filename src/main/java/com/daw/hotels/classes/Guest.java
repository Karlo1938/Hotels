package com.daw.hotels.classes;

import java.util.ArrayList;

import com.daw.hotels.classes.interfaces.GuestInterface;

public class Guest extends Person implements GuestInterface {
    private String nationality;
    private ArrayList<Stay> stays;

    ///////////////////////////// TO STRING///////////////////////////////////////////////////

    @Override
    public String toString() {
        return "Guest [identifier=" + identifier + ", name=" + name + ", nationality=" + nationality + "]";
    }

    ////////////////////////////////////////////// CONSTRUCTORS///////////////////////////////////////////////////

    public Guest() {
    }

    public Guest(String identifier, String name, String nationality) {
        super(identifier, name);
        this.nationality = nationality;
        this.stays = new ArrayList<>();
    }

    //////////////////////////GETTERS AND SETTERS///////////////////////////////////////////////////

    /**
     * <strong>Getter</strong> for the "nationality" String attribute of
     * <strong>Guest</strong> object.
     * 
     * @return The "nationality" String attribute of the <strong>Guest</strong> object.
     * @version 1.0
     * @author Karlo1938
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * <strong>Setter</strong> for the "nationality" String attribute of
     * <strong>Guest</strong> object.
     * 
     * @param nationality The nationality attribute to set the "nationality" String attribute.
     * @version 1.0
     * @author Karlo1938
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * <strong>Getter</strong> for the ArrayList of stays attribute of
     * <strong>Guest</strong> object.
     * 
     * @return The array of stays attribute of the <strong>Guest</strong> object.
     * @version 1.0
     * @author Karlo1938
     */
    public ArrayList<Stay> getStays() {
        return stays;
    }

    /**
     * <strong>Setter</strong> for the ArrayList of stays attribute of the
     * <strong>Guest</strong> object.
     * 
     * @param stays The ArrayList to set the ArrayList of stays attribute of the
     *              <strong>Guest</strong> object.
     * @version 1.0
     * @author Karlo1938
     */
    public void setStays(ArrayList<Stay> stays) {
        this.stays = stays;
    }

    ///////////////////////////////////////////// METHODS///////////////////////////////////////////////////
    /**
     * Adds stay objects to the arraylist stays attribute of the guest object.
     * 
     * @param stay A properly constructed stay object.
     * @version 1.0
     * @author Karlo1938
     */
    public void addStay(Stay stay) {
        stays.add(stay);
    }

}
