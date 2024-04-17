package com.daw.hotels.classes;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.daw.hotels.classes.enumerations.Enumerations.HotelCategory;
import com.daw.hotels.classes.enumerations.Enumerations.RoomType;
import com.daw.hotels.classes.interfaces.HotelInterface;

@Service
public class Hotel implements HotelInterface {
    private String name;
    private String address;
    private String web;
    private HotelCategory category;
    private Room[] rooms;
    private Manager manager;
    
                //////////////////////////////////////////////TO STRING///////////////////////////////////////////////////
    
    @Override
    public String toString() {
        return "Hotel [name=" + name + ", address=" + address + ", web=" + web + ", category=" + category + ", manager=" + manager + "]";
    }

                //////////////////////////////////////////////CONSTRUCTORS///////////////////////////////////////////////////

    public Hotel() {
        this.manager = new Manager("admin", "admin", this);
        this.rooms = new Room[10];
        rooms[0] = new Room(1, RoomType.Individual, this);
        rooms[1] = new Room(2, RoomType.Double, this);
        rooms[2] = new Room(3, RoomType.Individual, this);
        rooms[3] = new Room(4, RoomType.Suite, this);
        rooms[4] = new Room(5, RoomType.Individual, this);
        rooms[5] = new Room(6, RoomType.Double, this);
        rooms[6] = new Room(7, RoomType.Individual, this);
        rooms[7] = new Room(8, RoomType.Suite, this);
        rooms[8] = new Room(9, RoomType.Individual, this);
        rooms[9] = new Room(10, RoomType.Double, this);
    }


    public Hotel(String name, String address, String web, HotelCategory category) {
        this.name = name;
        this.address = address;
        this.web = web;
        this.category = category;
        this.rooms = new Room[10];

        rooms[0] = new Room(1, RoomType.Individual, this);
        rooms[1] = new Room(2, RoomType.Double, this);
        rooms[2] = new Room(3, RoomType.Individual, this);
        rooms[3] = new Room(4, RoomType.Suite, this);
        rooms[4] = new Room(5, RoomType.Individual, this);
        rooms[5] = new Room(6, RoomType.Double, this);
        rooms[6] = new Room(7, RoomType.Individual, this);
        rooms[7] = new Room(8, RoomType.Suite, this);
        rooms[8] = new Room(9, RoomType.Individual, this);
        rooms[9] = new Room(10, RoomType.Double, this);
    }
    
                //////////////////////////////////////////////GETTERS AND SETTERS///////////////////////////////////////////////////

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getWeb() {
        return web;
    }
    public void setWeb(String web) {
        this.web = web;
    }
    public HotelCategory getCategory() {
        return category;
    }
    public void setCategory(HotelCategory category) {
        this.category = category;
    }
    public Room[] getRooms() {
        
        return rooms;
    }
    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }
    public Manager getManager() {
        return manager;
    }
    public void setManager(Manager manager) {
        this.manager = manager;
    }

                /////////////////////////////////////////////METHODS///////////////////////////////////////////////////


    public void addManager(Manager manager){
        if (manager.getHotel() != null) manager.getHotel().setManager(null);
        this.manager = manager;
        manager.setHotel(this);
    }
    
    public Room getRoom(int number){
        
        for (int a=0; a<rooms.length; a++){
            if (rooms[a].getNumber() == number) return rooms[a];
        }
        return null;
    }

    public Guest getGuestOfStays(String identifer){
        for (Room room : rooms){

            for (Stay stay : room.getStays()){
                for (Guest guest : stay.getGuests()){
                    if (guest.getIdentifier().equals(identifer)) return guest;
                }
            }
        }
        return null;
    }

    public void setDisponibility(){
        for (Room room : rooms){
            room.setDiponibility();
        }
    }

    

}
