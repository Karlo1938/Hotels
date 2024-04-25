package com.daw.hotels.classes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.springframework.format.annotation.DateTimeFormat;

import com.daw.hotels.classes.enumerations.Enumerations.RoomType;
import com.daw.hotels.classes.interfaces.RoomInterface;

public class Room implements RoomInterface{
    private int number;
    private RoomType tRoom;
    private Hotel hotel;
    private boolean disponibility;
    private ArrayList<Stay> stays;

                //////////////////////////////////////////////TO STRING///////////////////////////////////////////////////

    @Override
    public String toString() {
        return "Room [number=" + number + ", tRoom=" + tRoom + ", hotel=" +hotel + ", disponibility=" + disponibility + "]";
    }

                //////////////////////////////////////////////CONSTRUCTORS///////////////////////////////////////////////////

    public Room(int number, RoomType tRoom, Hotel hotel) {
        this.number = number;
        this.tRoom = tRoom;
        this.hotel = hotel;
        this.stays = new ArrayList<>();
        this.disponibility = true;
    }

                //////////////////////////////////////////////GETTERS AND SETTERS///////////////////////////////////////////////////
    
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public RoomType gettRoom() {
        return tRoom;
    }
    public void settRoom(RoomType tRoom) {
        this.tRoom = tRoom;
    }
    public Hotel getHotel() {
        return hotel;
    }
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
    public ArrayList<Stay> getStays() {
        return stays;
    }
    public void setStays(ArrayList<Stay> stays) {
        this.stays = stays;
    }

    public boolean isDisponibility() {
        return disponibility;
    }

    public void setDisponibility(boolean disponibility) {
        this.disponibility = disponibility;
    }
    
                /////////////////////////////////////////////METHODS///////////////////////////////////////////////////
    
    public boolean addStay (Stay stay){
        if (!this.disponibility) return false;
        stays.add(stay);
        setDiponibility();
        return true;
    }

    public void addStayForce (Stay stay){
        stays.add(stay);
    }

    public void setDiponibility(){
        for (Stay stay : this.stays){
            if (stay.getEndDate().isAfter(LocalDateTime.now()) && stay.getStartDate().isBefore(LocalDateTime.now())) {
                this.disponibility = false;
                return;
            }
        }
        this.disponibility = true;

    }

    public LocalDateTime nextStay(){
        
        if (stays == null) return null;

        for(Stay stay : this.stays) {
            if (stay.getStartDate().isAfter(LocalDateTime.now())) return stay.getStartDate();
        }
        return null;
    }

    public LocalDateTime nextDisponibilty(){
        if (stays == null) return null;
        LocalDateTime nextDisponibility = LocalDateTime.now();

        for(Stay stay : this.stays) {
            if (nextDisponibility.isBefore(stay.getEndDate())) nextDisponibility = stay.getEndDate();
        }
        return nextDisponibility;
    }

    
    
    

}
