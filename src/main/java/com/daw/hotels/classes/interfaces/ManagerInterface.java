package com.daw.hotels.classes.interfaces;

import java.time.LocalDate;

import com.daw.hotels.classes.Hotel;
import com.daw.hotels.classes.Stay;

public interface ManagerInterface extends PersonInterface {

      ////////////////////////////////////////////// GETTERS AND SETTERS///////////////////////////////////////////////////
      
      /**
       * <strong>Getter</strong> for the LocalDate startDate attribute of <strong>Manager</strong> object.
       * @return The LocalDate startDate attribute of the <strong>Manager</strong> object.
       * @version 1.0
       * @author Karlo1938
       */
      LocalDate getStartDate();

      /**
       * <strong>Setter</strong> for the LocalDate startDate attribute of <strong>Manager</strong> object.
       * @param name The LocalDate startDate to set.
       * @version 1.0
       * @author Karlo1938
       */
      void setStartDate(LocalDate startDate);

      /**
       * <strong>Getter</strong> for the int experience attribute of <strong>Manager</strong> object.
       * @return The int experience attribute of the <strong>Manager</strong> object.
       * @version 1.0
       * @author Karlo1938
       */
      int getExperience();

      /**
       * <strong>Setter</strong> for the int experience attribute of <strong>Manager</strong> object.
       * @param name The int experience to set.
       * @version 1.0
       * @author Karlo1938
       */
      void setExperience(int experience);

      /**
       * <strong>Getter</strong> for the Object hotel attribute of <strong>Manager</strong> object.
       * @return The Object hotel attribute of the <strong>Manager</strong> object.
       * @version 1.0
       * @author Karlo1938
       */
      Hotel getHotel();

      /**
       * <strong>Setter</strong> for the Object hotel attribute of <strong>Manager</strong> object.
       * @param name The Object hotel to set.
       * @version 1.0
       * @author Karlo1938
       */
      void setHotel(Hotel hotel);

      /**
       * <strong>Getter</strong> for the String username attribute of <strong>Manager</strong> object.
       * @return The String username attribute of the <strong>Manager</strong> object.
       * @version 1.0
       * @author Karlo1938
       */
      String getUsername();

      /**
       * <strong>Setter</strong> for the String username attribute of <strong>Manager</strong> object.
       * @param name The String username to set.
       * @version 1.0
       * @author Karlo1938
       */
      void setUsername(String username);

      /**
       * <strong>Getter</strong> for the String password attribute of <strong>Manager</strong> object.
       * @return The String password attribute of the <strong>Manager</strong> object.
       * @version 1.0
       * @author Karlo1938
       */
      String getPassword();

      /**
       * <strong>Setter</strong> for the String password attribute of <strong>Manager</strong> object.
       * @param name The String password to set.
       * @version 1.0
       * @author Karlo1938
       */
      void setPassword(String password);

      public boolean isAuthenticated();

      public void setAuthenticated(boolean authenticated);
      
      ///////////////////////////////////////////// METHODS///////////////////////////////////////////////////

      
      public void addHotel(Hotel hotel);

      public boolean authenticateUser(String username, String password);

      public int addStayToTheRoom(Stay stay);


}
