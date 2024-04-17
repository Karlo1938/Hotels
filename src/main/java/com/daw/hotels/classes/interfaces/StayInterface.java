package com.daw.hotels.classes.interfaces;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.daw.hotels.classes.Guest;
import com.daw.hotels.classes.Room;

public interface StayInterface {

      /////////////////////////////////////////// GETTERS AND SETTERS///////////////////////////////////////////

      public LocalDateTime getStartDate();

      public void setStartDate(LocalDateTime startDate);

      public LocalDateTime getEndDate();

      public void setEndDate(LocalDateTime endDate);

      public Room getRoom();

      public void setRoom(Room room);

      public ArrayList<Guest> getGuests();

      public void setGuests(ArrayList<Guest> guests);

      ///////////////////////////////////////////// METHODS///////////////////////////////////////////////////

      public boolean addGuest(String identifier, String name, String nationality);

      public boolean removeGuest(String identifierGuest);

}
