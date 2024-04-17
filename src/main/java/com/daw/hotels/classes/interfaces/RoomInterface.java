package com.daw.hotels.classes.interfaces;

import java.util.ArrayList;

import com.daw.hotels.classes.Hotel;
import com.daw.hotels.classes.Stay;
import com.daw.hotels.classes.enumerations.Enumerations.RoomType;

public interface RoomInterface {
    
    ///////////////////////////////////////////GETTERS AND SETTERS///////////////////////////////////////////

    public int getNumber();
    
    public void setNumber(int number);

    public RoomType gettRoom();

    public void settRoom(RoomType tRoom);

    public Hotel getHotel();

    public void setHotel(Hotel hotel);

    public ArrayList<Stay> getStays();

    public void setStays(ArrayList<Stay> stays);

    public boolean isDisponibility();

    public void setDisponibility(boolean disponibility);
    
    /////////////////////////////////////////////METHODS///////////////////////////////////////////////////

    public void setDiponibility();

    /**
    * Adds <strong>stay</strong> objects to the <strong>stays</strong> ArrayList.
    * @param stay A properly constructed <strong>stay</strong> object.
    * @return true if the room is available and false if it is not available.
    * @version 1.0
    * @author Karlo1938
    */
    public boolean addStay (Stay stay);


    
    
    

}
