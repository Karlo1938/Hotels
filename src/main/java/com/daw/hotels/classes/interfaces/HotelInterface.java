package com.daw.hotels.classes.interfaces;

import com.daw.hotels.classes.Guest;
import com.daw.hotels.classes.Manager;
import com.daw.hotels.classes.Room;
import com.daw.hotels.classes.enumerations.Enumerations.HotelCategory;

public interface HotelInterface {

      ////////////////////////////////////////////// GETTERS AND SETTERS/////////////////////////////////////////

      /**
       * <strong>Getter</strong> for the String name attribute of <strong>Hotel</strong> object.
       * @return The String name attribute of the <strong>Hotel</strong> object.
       * @version 1.0
       * @author Karlo1938
       */
      public String getName();

      /**
       * <strong>Setter</strong> for the String name attribute of <strong>Hotel</strong> object.
       * @param name The String name to set.
       * @version 1.0
       * @author Karlo1938
       */
      public void setName(String name);

      /**
       * <strong>Getter</strong> for the String address attribute of <strong>Hotel</strong> object.
       * @return The String address attribute of the <strong>Hotel</strong> object.
       * @version 1.0
       * @author Karlo1938
       */
      public String getAddress();

      /**
       *<strong>Setter</strong> for the String address attribute of <strong>Hotel</strong> object.
       * @param address The String address to set.
       * @version 1.0
       * @author Karlo1938
       */
      public void setAddress(String address);

      /**
       * <strong>Getter</strong> for the String web attribute of <strong>Hotel</strong> object.
       * @return The String web attribute of the <strong>Hotel</strong> object.
       * @version 1.0
       * @author Karlo1938
       */
      public String getWeb();

      /**
       * <strong>Setter</strong> for the String web attribute of <strong>Hotel</strong> object.
       * @param web The String web to set.
       * @version 1.0
       * @author Karlo1938
       */
      public void setWeb(String web);

      /**
       * <strong>Getter</strong> for the Enum category attribute of <strong>Hotel</strong> object.
       * @return The Enum category attribute of the <strong>Hotel</strong> object.
       * @version 1.0
       * @author Karlo1938
       */
      public HotelCategory getCategory();
      
      /**
       * <strong>Setter</strong> for the Enum category attribute of <strong>Hotel</strong> object.
       * @param nationality The Enum category to set.
       * @version 1.0
       * @author Karlo1938
       */
      public void setCategory(HotelCategory category);

      /**
       * <strong>Getter</strong> for the array of rooms objects attribute of <strong>Hotel</strong> object.
       * @return The array of room object of the <strong>Hotel</strong> object.
       * @version 1.0
       * @author Karlo1938
       */
      public Room[] getRooms();

      /**
       * <strong>Setter</strong> for the array of rooms objects attribute of the <strong>Hotel</strong> object.
       * @param rooms The array of room objects to set for the <strong>Hotel</strong> object.
       * @version 1.0
       * @author Karlo1938
       */
      public void setRooms(Room[] rooms);

      /**
       * <strong>Getter</strong> for the manager object attribute of <strong>Hotel</strong> object.
       * @return The manager object attribute of the <strong>Hotel</strong> object.
       * @version 1.0
       * @author Karlo1938
       */
      public Manager getManager();

      /**
       * <strong>Setter</strong> for the manager object attribute of <strong>Hotel</strong> object.
       * @param manager The manager object to set for the <strong>Hotel</strong> object.
       * @version 1.0
       * @author Karlo1938
       */
      public void setManager(Manager manager);

      ///////////////////////////////////////////// METHODS///////////////////////////////////////////////////

      /**
       * Assigns or changes the <strong>Manager</strong> object attribute in the <strong>Hotel</strong> object, ensuring 
       * that in the manager object, the hotel is also changed, eliminating the previous reference and fulfilling the 
       * binary relationship (1..1).
       * @param manager The manager object to be asigned.
       * @version 1.0
       * @author Karlo1938
       */
      public void addManager(Manager manager);

      /**
       * <strong>Retrieves the Room object</strong> from the rooms array when the room number is specified.
       * @param number integer number of the room. 
       * @return Room object if it exists in the array of room objects attribute of the <strong>Hotel</strong> object.
       * @version 1.0
       * @author Karlo1938
       */
      public Room getRoom(int number);

      /**
       * <strong>Searches for a Guest</strong> object within the ArrayList attributes of Guest objects within the Stay objects
       * contained in the ArrayList Stays attribute of the Room objects contained in the array of room objects attribute.
       * @param identifer The String identifier attribute of Guest object. 
       * @return The Guest object corresponding to the provided identifier, or null if not found.
       * @version 1.0
       * @author Karlo1938
       */
      public Guest getGuestOfStays(String identifer);

      /**
       * <strong>Updates the Disponibility attribute of Room objects</strong> in correspondence to the stays at the time of execution.
       * This method adjusts the availability of rooms based on current stays.
       * @version 1.0
       * @author Karlo1938
       */
      public void setDisponibility();

}
