package com.daw.hotels.classes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

import com.daw.hotels.classes.interfaces.ManagerInterface;

public class Manager extends Person implements ManagerInterface{

    private LocalDate startDate;
    private int experience;
    private Hotel hotel;
    private String username;
    private String password;
    private boolean authenticated;

    ////////////////////////// TO STRING/////////////

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

    ////////////////////////////// GETTERS AND SETTERS/////////

    /**
     * <strong>Getter</strong> for the "startDate" LocalDate attribute of
     * <strong>Manager</strong> object.
     * 
     * @return The "startDate" LocalDate attribute of the <strong>Manager</strong>
     *         object.
     * @version 1.0
     * @author Karlo1938
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * <strong>Setter</strong> for the "startDate" LocalDate attribute of
     * <strong>Manager</strong> object.
     * 
     * @param name The LocalDate startDate to set the "startDate" LocalDate attribute.
     * @version 1.0
     * @author Karlo1938
     */
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     * <strong>Getter</strong> for the "experience" int attribute of
     * <strong>Manager</strong> object.
     * 
     * @return The "experience" int attribute of the <strong>Manager</strong> object.
     * @version 1.0
     * @author Karlo1938
     */
    public int getExperience() {
        return experience;
    }

    /**
     * <strong>Setter</strong> for the "experience" int attribute of
     * <strong>Manager</strong> object.
     * 
     * @param name The int experience to set the "experience" int attribute.
     * @version 1.0
     * @author Karlo1938
     */
    public void setExperience(int experience) {
        this.experience = experience;
    }

    /**
     * <strong>Getter</strong> for the "hotel" Object attribute of
     * <strong>Manager</strong> object.
     * 
     * @return The "hotel" Object attribute of the <strong>Manager</strong> object.
     * @version 1.0
     * @author Karlo1938
     */
    public Hotel getHotel() {
        return hotel;
    }

    /**
     * <strong>Setter</strong> for the "hotel" Object attribute of
     * <strong>Manager</strong> object.
     * 
     * @param name The Object hotel to set the "hotel" Object attribute.
     * @version 1.0
     * @author Karlo1938
     */
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    /**
     * <strong>Getter</strong> for the "username" String attribute of
     * <strong>Manager</strong> object.
     * 
     * @return The "username" String attribute of the <strong>Manager</strong> object.
     * @version 1.0
     * @author Karlo1938
     */
    public String getUsername() {
        return username;
    }

    /**
     * <strong>Setter</strong> for the "username" String attribute of
     * <strong>Manager</strong> object.
     * 
     * @param name The String username to set the "username" String attribute.
     * @version 1.0
     * @author Karlo1938
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * <strong>Getter</strong> for the "password" String attribute of
     * <strong>Manager</strong> object.
     * 
     * @return The "password" String attribute of the <strong>Manager</strong> object.
     * @version 1.0
     * @author Karlo1938
     */
    public String getPassword() {
        return password;
    }

    /**
     * <strong>Setter</strong> for the "password" String attribute of
     * <strong>Manager</strong> object.
     * 
     * @param name The String password to set the "password" String attribute.
     * @version 1.0
     * @author Karlo1938
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * <strong>Getter</strong> for the "authenticated" boolean attribute of
     * <strong>Manager</strong> object.
     * 
     * @return The "authenticated" boolean attribute of the <strong>Manager</strong>
     *         object.
     * @version 1.0
     * @author Karlo1938
     */
    public boolean isAuthenticated() {
        return authenticated;
    }

    /**
     * <strong>Setter</strong> for the "authenticated" boolean attribute of
     * <strong>Manager</strong> object.
     * 
     * @param name The boolean authenticated variable to set the "authenticated" boolean attribute.
     * @version 1.0
     * @author Karlo1938
     */
    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    ///////////////////////////////////////////// METHODS///////////////////////////////////////////////////

    /**
     * This method changes or add an instance of hotel for one manager Object, this
     * method ensures that
     * the binary relationship one to ona is right.
     * 
     * @param hotel An instant of hotel object that is properly formed.
     * @author Karlo1938
     * @version 1.0
     */
    public void addHotel(Hotel hotel) {
        if (hotel.getManager() != null)
            hotel.setManager(null);
        this.hotel = hotel;
        hotel.setManager(this);
    }

    /**
     * This method changes the boolean authenticated attribute of the Manager object
     * if the credentials
     * are correct or return a false if they arre'nt correct.
     * 
     * @param username An String username variable to validate the login.
     * @param password An String username variable to validate the login.
     * @author Karlo1938
     * @version 1.0
     */
    public boolean validate(String username, String password) {

        if (this.username.equals(username) && this.password.equals(password)) {
            this.authenticated = true;
            return true;
        }
        return false;
    }

    /**
     * This method adds an instance of a Stay object to the list of stay objects
     * in the room instance belonging to the hotel managed by the manager.
     *
     * @param stay A properly formed instance of the Stay object.
     * @return <strong>0</strong> if added successfully, <strong>1</strong> if end date is before start date, <strong>2</strong> if 
     * start date is before 30 minutes prior to current time, or <strong>3</strong> if there are 
     * scheduling conflicts with existing stays.
     * @version 1.0
     * @author Karlo1938
     */
    public int addStayToTheRoom(Stay stay) {

        hotel.setDisponibility();

        if (stay.getEndDate().isBefore(stay.getStartDate()))
            return 1;
        if (stay.getStartDate().isBefore(LocalDateTime.now().minusMinutes(30)))
            return 2;

        Room room = hotel.getRoom(stay.getRoom().getNumber());

        if (room.addStay(stay))
            return 0;

        List<Stay> nextStays = room.nextStays();

        for (int a = 0; a < nextStays.size(); a++) {
            if (!(a >= nextStays.size() - 1) && stay.getStartDate().isAfter(nextStays.get(a).getEndDate())
                    && stay.getEndDate().isBefore(nextStays.get(a + 1).getStartDate())) {
                room.addStayForce(stay);
                return 0;
            }
            if (a >= nextStays.size() - 1 && stay.getStartDate().isAfter(nextStays.get(a).getEndDate())) {
                room.addStayForce(stay);
                return 0;
            }
        }
        return 3;
    }

}
