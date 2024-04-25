package com.daw.hotels.classes.interfaces;

import java.util.ArrayList;

import com.daw.hotels.classes.Stay;

public interface GuestInterface extends PersonInterface {

      ////////////////////////////////////////////// GETTERS AND SETTERS///////////////////////////////////////////////////

      /**
       * <strong>Getter</strong> for the nationality attribute of <strong>Guest</strong> object.
       * @return The nationality attribute of the <strong>Guest</strong> object.
       * @version 1.0
       * @author Karlo1938
       */
      public String getNationality();

      /**
       *<strong>Setter</strong> for the nationality attribute of <strong>Guest</strong> object.
       * @param nationality The nationality attribute to set.
       * @version 1.0
       * @author Karlo1938
       */
      public void setNationality(String nationality);

      /**
       * <strong>Getter</strong> for the ArrayList of stays attribute of <strong>Guest</strong> object.
       * @return The array of stays attribute of the <strong>Guest</strong> object.
       * @version 1.0
       * @author Karlo1938
       */
      public ArrayList<Stay> getStays();

      /**
       * <strong>Setter</strong> for the ArrayList of stays attribute of the <strong>Guest</strong> object.
       * @param stays The ArrayList of stays attribute to set for the <strong>Guest</strong> object.
       * @version 1.0
       * @author Karlo1938
       */
      public void setStays(ArrayList<Stay> stays);

      ///////////////////////////////////////////// METHODS///////////////////////////////////////////////////
      
      /**
       * Adds stay objects to the arraylist stays attribute of the guest object.
       * @param stay A properly constructed stay object.
       * @version 1.0
       * @author Karlo1938
       */
      public void addStay(Stay stay);
}
