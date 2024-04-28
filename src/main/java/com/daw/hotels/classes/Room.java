package com.daw.hotels.classes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.daw.hotels.classes.enumerations.Enumerations.RoomType;
import com.daw.hotels.classes.interfaces.RoomInterface;

public class Room implements RoomInterface {
    private int number;
    private RoomType tRoom;
    private Hotel hotel;
    private boolean availability;
    private ArrayList<Stay> stays;

    //////////////////// TO STRING///////////////////////////////////

    @Override
    public String toString() {
        return "Room [number=" + number + ", tRoom=" + tRoom + ", hotel=" + hotel + ", disponibility=" + availability
                + "]";
    }

    ///////////////////////// CONSTRUCTORS /////////////////////////////

    public Room(int number, RoomType tRoom, Hotel hotel) {
        this.number = number;
        this.tRoom = tRoom;
        this.hotel = hotel;
        this.stays = new ArrayList<>();
        this.availability = true;
    }

    //////////////////////// GETTERS AND SETTERS ///////////////////////////
    /**
     * <strong>Getter</strong> for the "number" int attribute of <strong>Room</strong>
     * object.
     * 
     * @return The "number" int attribute of the <strong>Room</strong> object.
     * @version 1.0
     * @author Karlo1938
     */
    public int getNumber() {
        return number;
    }

    /**
     * <strong>Setter</strong> for the "number" int attribute of <strong>Room</strong> object.
     * 
     * @param number The "number" int to set the "number" attribute.
     * @version 1.0
     * @author Karlo1938
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * <strong>Getter</strong> for the "tRoom" enum attribute of <strong>Room</strong>
     * object.
     * 
     * @return The "tRoom" enum attribute of the <strong>Room</strong> object.
     * @version 1.0
     * @author Karlo1938
     */
    public RoomType gettRoom() {
        return tRoom;
    }

    /**
     * <strong>Setter</strong> for the "tRoom" enum attribute of <strong>Room</strong>
     * object.
     * 
     * @param tRoom The "tRoom" enum to set the "tRoom" attribute.
     * @version 1.0
     * @author Karlo1938
     */
    public void settRoom(RoomType tRoom) {
        this.tRoom = tRoom;
    }

    /**
     * <strong>Getter</strong> for the "hotel" object attribute of <strong>Room</strong>
     * object.
     * 
     * @return The "hotel" object attribute of the <strong>Room</strong> object.
     * @version 1.0
     * @author Karlo1938
     */
    public Hotel getHotel() {
        return hotel;
    }

    /**
     * <strong>Setter</strong> for the "hotel" object attribute of <strong>Room</strong>
     * object.
     * 
     * @param hotel The "hotel" object to set the "hotel" attribute.
     * @version 1.0
     * @author Karlo1938
     */
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    /**
     * <strong>Getter</strong> for the "stays" attribute of <strong>Room</strong> object.
     * 
     * @return The "stays" ArrayList of stay objects attribute of the <strong>Room</strong> object.
     * @version 1.0
     * @author Karlo1938
     */
    public ArrayList<Stay> getStays() {
        return stays;
    }

    /**
     * <strong>Setter</strong> for the "stays" attribute of the <strong>Room</strong> object.
     * 
     * @param stays The ArrayList of stay objects to set the "stays" Attribute.
     * @version 1.0
     * @author Karlo1938
     */
    public void setStays(ArrayList<Stay> stays) {
        this.stays = stays;
    }
    /**
     * <strong>Getter</strong> for the "availability" boolean attribute of <strong>Room</strong>
     * object.
     * 
     * @return The "availability" boolean attribute of the room object.
     * @version 1.0
     * @author Karlo1938
     */
    public boolean isAvailability() {
        return availability;
    }
    /**
     * <strong>Setter</strong> for the "availability" boolean attribute of <strong>Room</strong>
     * object.
     * 
     * @param number The boolean to set the "availability" boolean attribute.
     * @version 1.0
     * @author Karlo1938
     */
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    ///////////////////////////////////////////// METHODS///////////////////////////////////////////////////

    /**
     * Adds <strong>stay</strong> objects to the <strong>stays</strong> ArrayList.
     * 
     * @param stay A properly constructed <strong>stay</strong> object.
     * @return true if the room is available and false if it is not available.
     * @version 1.0
     * @author Karlo1938
     */
    public boolean addStay(Stay stay) {
        if (!this.availability)
            return false;
        stays.add(stay);
        setAvailability();
        return true;
    }

    /**
     * Adds <strong>stay</strong> objects to the <strong>stays</strong> ArrayList
     * without restrictions.
     * 
     * @param stay A properly constructed <strong>stay</strong> object.
     * @version 1.0
     * @author Karlo1938
     */
    public void addStayForce(Stay stay) {
        stays.add(stay);
    }

    /**
     * Updates the availability of the rooms in the Hotel object based on current
     * stays. This method checks if there are any active stays in the rooms and
     * updates
     * their availability accordingly.
     * 
     * @version 1.0
     * @author Karlo1938
     */
    public void setAvailability() {
        for (Stay stay : this.stays) {
            if (stay.getEndDate().isAfter(LocalDateTime.now()) && stay.getStartDate().isBefore(LocalDateTime.now())) {
                this.availability = false;
                return;
            }
        }
        this.availability = true;

    }

    /**
     * Returns an ArrayList of upcoming stays.
     * 
     * @return An ArrayList of upcoming stays.
     */
    public List<Stay> nextStays() {
        List<Stay> nextStays = new ArrayList<>();
        if (stays == null)
            return null;

        for (Stay stay : this.stays) {
            if ((stay.getEndDate().isAfter(LocalDateTime.now()) && stay.getStartDate().isBefore(LocalDateTime.now()))
                    || (stay.getStartDate().isAfter(LocalDateTime.now())))
                nextStays.add(stay);
        }

        return nextStays;
    }

}
