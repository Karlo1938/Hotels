package com.daw.hotels.classes.DTO;

import com.daw.hotels.classes.Guest;

public class SelectRoom {
    
    
    private Guest[] guests;
    private int roomNumber;


    public Guest[] getGuests() {
        return guests;
    }
    public void setGuests(Guest[] guests) {
        this.guests = guests;
    }
    public int getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    
}
