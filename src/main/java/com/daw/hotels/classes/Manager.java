package com.daw.hotels.classes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

import com.daw.hotels.classes.interfaces.ManagerInterface;

public class Manager extends Person implements ManagerInterface{
        
    private LocalDate startDate;
    private int experience;
    private Hotel hotel;
    private String username;
    private String password;
    private boolean authenticated;
    
                //////////////////////////////////////////////TO STRING///////////////////////////////////////////////////

    @Override
    public String toString() {
        return "Manager [startDate=" + startDate + ", experience=" + experience + ", hotel=" + ", username="
                + username + "]";
    }

                //////////////////////////////////////////////CONSTRUCTORS///////////////////////////////////////////////////

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

                //////////////////////////////////////////////GETTERS AND SETTERS///////////////////////////////////////////////////

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

                /////////////////////////////////////////////METHODS///////////////////////////////////////////////////

    public void addHotel(Hotel hotel){
        if (hotel.getManager() != null) hotel.setManager(null);
        this.hotel = hotel;
        hotel.setManager(this);
    }

    public boolean authenticated(String username, String password){

        if (this.username.equals(username) && this.password.equals(password)) {
            this.authenticated = true;
            return true;

        }
        return false;

    }
    
    

    public int addStayToTheRoom(Stay stay){
        hotel.setDisponibility();

        if (stay.getEndDate().isBefore(stay.getStartDate())) return 1;
        if (stay.getStartDate().isBefore(LocalDateTime.now().minusMinutes(30))) return 2;

        Room room =hotel.getRoom(stay.getRoom().getNumber());
        if (!room.addStay(stay)) return 3;
        
        return 0;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public boolean reserveRoom(Stay stay){
        Room room =hotel.getRoom(stay.getRoom().getNumber());
        if (stay.getStartDate().isBefore(room.nextDisponibilty())) return false;
        room.addStayForce(stay);
        return true;

    }


    
    
    

}
