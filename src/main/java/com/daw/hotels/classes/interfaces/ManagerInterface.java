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

      /**
       * <strong>Getter</strong> for the boolean authenticated attribute of <strong>Manager</strong> object.
       * @return The boolean authenticated attribute of the <strong>Manager</strong> object.
       * @version 1.0
       * @author Karlo1938
       */
      boolean isAuthenticated();

      /**
       * <strong>Setter</strong> for the boolean authenticated attribute of <strong>Manager</strong> object.
       * @param name The boolean authenticated variable to set.
       * @version 1.0
       * @author Karlo1938
       */
      void setAuthenticated(boolean authenticated);

      ///////////////////////////////////////////// METHODS///////////////////////////////////////////////////

      /**
       * This method changes or add an instance of hotel for one manager Object, this method ensures that 
       * the binary relationship one to ona is right.
       * @param hotel An instant of hotel object that is properly formed.
       * @author Karlo1938
       * @version 1.0
       */
      void addHotel(Hotel hotel);

      /**
       * This method changes the boolean authenticated attribute of the Manager object if the credentials 
       * are correct or return a false if arre'nt correct.
       * @param username An String username variable to validate the login.
       * @param password An String username variable to validate the login.
       * @author Karlo1938
       * @version 1.0
       */
      boolean validate(String username, String password);
      
      /**
       * Este metodo agrega una instancia de un objeto stay en la lista de objectos stay de la instancia room 
       * que pertenece al hotel que administra el manager.
       * @param stay An instant of stay object properly formed.
       * @return A integer state code
       * @author Karlo1938
       * @version 1.0
       */
      int addStayToTheRoom(Stay stay);

}
