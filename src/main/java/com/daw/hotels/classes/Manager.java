package com.daw.hotels.classes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

import com.daw.hotels.classes.interfaces.ManagerInterface;

public class Manager extends Person implements ManagerInterface {

    private LocalDate startDate;
    private int experience;
    private Hotel hotel;
    private String username;
    private String password;
    private boolean authenticated;

    ////////////////////////////////////////////// TO
    ////////////////////////////////////////////// STRING///////////////////////////////////////////////////

    @Override
    public String toString() {
        return "Manager [startDate=" + startDate + ", experience=" + experience + ", hotel=" + ", username="
                + username + "]";
    }

    ////////////////////////////////////////////// CONSTRUCTORS///////////////////////////////////////////////////

    public Manager(String username, String password, Hotel hotel) {
        this.username = username;
        this.password = password;
        this.hotel = hotel;
    }

    public Manager(String identifier, String name, LocalDate startDate, String username, String password, Hotel hotel) {
        super(identifier, name);
        this.startDate = startDate;
        this.experience = Period.between(LocalDate.now(), startDate).getYears();
        this.username = username;
        this.password = password;
        addHotel(hotel);
    }

    ////////////////////////////////////////////// GETTERS AND
    ////////////////////////////////////////////// SETTERS///////////////////////////////////////////////////

    /**
     * <strong>Getter</strong> for the LocalDate startDate attribute of
     * <strong>Manager</strong> object.
     * 
     * @return The LocalDate startDate attribute of the <strong>Manager</strong>
     *         object.
     * @version 1.0
     * @author Karlo1938
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * <strong>Setter</strong> for the LocalDate startDate attribute of
     * <strong>Manager</strong> object.
     * 
     * @param name The LocalDate startDate to set.
     * @version 1.0
     * @author Karlo1938
     */
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     * <strong>Getter</strong> for the int experience attribute of
     * <strong>Manager</strong> object.
     * 
     * @return The int experience attribute of the <strong>Manager</strong> object.
     * @version 1.0
     * @author Karlo1938
     */
    public int getExperience() {
        return experience;
    }

    /**
     * <strong>Setter</strong> for the int experience attribute of
     * <strong>Manager</strong> object.
     * 
     * @param name The int experience to set.
     * @version 1.0
     * @author Karlo1938
     */
    public void setExperience(int experience) {
        this.experience = experience;
    }

    /**
     * <strong>Getter</strong> for the Object hotel attribute of
     * <strong>Manager</strong> object.
     * 
     * @return The Object hotel attribute of the <strong>Manager</strong> object.
     * @version 1.0
     * @author Karlo1938
     */
    public Hotel getHotel() {
        return hotel;
    }

    /**
     * <strong>Setter</strong> for the Object hotel attribute of
     * <strong>Manager</strong> object.
     * 
     * @param name The Object hotel to set.
     * @version 1.0
     * @author Karlo1938
     */
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    /**
     * <strong>Getter</strong> for the String username attribute of
     * <strong>Manager</strong> object.
     * 
     * @return The String username attribute of the <strong>Manager</strong> object.
     * @version 1.0
     * @author Karlo1938
     */
    public String getUsername() {
        return username;
    }

    /**
     * <strong>Setter</strong> for the String username attribute of
     * <strong>Manager</strong> object.
     * 
     * @param name The String username to set.
     * @version 1.0
     * @author Karlo1938
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * <strong>Getter</strong> for the String password attribute of
     * <strong>Manager</strong> object.
     * 
     * @return The String password attribute of the <strong>Manager</strong> object.
     * @version 1.0
     * @author Karlo1938
     */
    public String getPassword() {
        return password;
    }

    /**
     * <strong>Setter</strong> for the String password attribute of
     * <strong>Manager</strong> object.
     * 
     * @param name The String password to set.
     * @version 1.0
     * @author Karlo1938
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }
    
    ///////////////////////////////////////////// METHODS///////////////////////////////////////////////////

    public void addHotel(Hotel hotel) {
        if (hotel.getManager() != null)
            hotel.setManager(null);
        this.hotel = hotel;
        hotel.setManager(this);
    }

    public boolean authenticateUser(String username, String password) {

        if (this.username.equals(username) && this.password.equals(password)) {
            this.authenticated = true;
            return true;

        }
        return false;

    }

    public int addStayToTheRoom(Stay stay) {
        hotel.setDisponibility();

        if (stay.getEndDate().isBefore(stay.getStartDate()))
            return 1;
        if (stay.getStartDate().isBefore(LocalDateTime.now().minusMinutes(30)))
            return 2;

        Room room = hotel.getRoom(stay.getRoom().getNumber());
        if (!room.addStay(stay))
            return 3;

        return 0;
    }

    

    public boolean reserveRoom(Stay stay) {
        Room room = hotel.getRoom(stay.getRoom().getNumber());
        if (stay.getStartDate().isBefore(room.nextDisponibilty()))
            return false;
        room.addStayForce(stay);
        return true;

    }

}
