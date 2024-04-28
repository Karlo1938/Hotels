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

    ////////////////////////////////////////////// TO
    ////////////////////////////////////////////// STRING///////////////////////////////////////////////////

    @Override
    public String toString() {
        return "Hotel [name=" + name + ", address=" + address + ", web=" + web + ", category=" + category + ", manager="
                + manager + "]";
    }

    ////////////////////////////////////////////// CONSTRUCTORS///////////////////////////////////////////////////

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

    ////////////////////////////////////////////// GETTERS AND
    ////////////////////////////////////////////// SETTERS///////////////////////////////////////////////////

    /**
     * <strong>Getter</strong> for the "name" String attribute of
     * <strong>Hotel</strong> object.
     * 
     * @return The "name" String attribute of the <strong>Hotel</strong> object.
     * @version 1.0
     * @author Karlo1938
     */
    public String getName() {
        return name;
    }

    /**
     * <strong>Setter</strong> for the "name" String attribute of
     * <strong>Hotel</strong> object.
     * 
     * @param name The String name to set the "name" String attribute.
     * @version 1.0
     * @author Karlo1938
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <strong>Getter</strong> for the "address" String attribute of
     * <strong>Hotel</strong> object.
     * 
     * @return The "address" String attribute of the <strong>Hotel</strong> object.
     * @version 1.0
     * @author Karlo1938
     */
    public String getAddress() {
        return address;
    }

    /**
     * <strong>Setter</strong> for the "address" String attribute of
     * <strong>Hotel</strong> object.
     * 
     * @param address The String address to set the "address" String attribute.
     * @version 1.0
     * @author Karlo1938
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * <strong>Getter</strong> for the "web" String attribute of
     * <strong>Hotel</strong> object.
     * 
     * @return The "web" String attribute of the <strong>Hotel</strong> object.
     * @version 1.0
     * @author Karlo1938
     */
    public String getWeb() {
        return web;
    }

    /**
     * <strong>Setter</strong> for the "web" String attribute of
     * <strong>Hotel</strong> object.
     * 
     * @param web The String web to set the "web" String attribute.
     * @version 1.0
     * @author Karlo1938
     */
    public void setWeb(String web) {
        this.web = web;
    }

    /**
     * <strong>Getter</strong> for the "category" Enum attribute of
     * <strong>Hotel</strong> object.
     * 
     * @return The "category" Enum attribute of the <strong>Hotel</strong> object.
     * @version 1.0
     * @author Karlo1938
     */
    public HotelCategory getCategory() {
        return category;
    }

    /**
     * <strong>Setter</strong> for the "category" Enum attribute of
     * <strong>Hotel</strong> object.
     * 
     * @param nationality The Enum category to set the "category" Enum attribute.
     * @version 1.0
     * @author Karlo1938
     */
    public void setCategory(HotelCategory category) {
        this.category = category;
    }

    /**
     * <strong>Getter</strong> for the array of rooms objects attribute of
     * <strong>Hotel</strong> object.
     * 
     * @return The array of room object attribute of the <strong>Hotel</strong>
     *         object.
     * @version 1.0
     * @author Karlo1938
     */
    public Room[] getRooms() {

        return rooms;
    }

    /**
     * <strong>Setter</strong> for the array of rooms objects attribute of the
     * <strong>Hotel</strong> object.
     * 
     * @param rooms The array to set the array of rooms objects attribute.
     *              object.
     * @version 1.0
     * @author Karlo1938
     */
    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }

    /**
     * <strong>Getter</strong> for the "manager" object attribute of
     * <strong>Hotel</strong> object.
     * 
     * @return The "manager" object attribute of the <strong>Hotel</strong> object.
     * @version 1.0
     * @author Karlo1938
     */
    public Manager getManager() {
        return manager;
    }

    /**
     * <strong>Setter</strong> for the "manager" object attribute of
     * <strong>Hotel</strong> object.
     * 
     * @param manager The manager object to set for the "manager" object attribute.
     * @version 1.0
     * @author Karlo1938
     */
    public void setManager(Manager manager) {
        this.manager = manager;
    }

    ///////////////////////////////////////////// METHODS///////////////////////////////////////////////////

    /**
     * Assigns or changes the <strong>Manager</strong> object attribute in the
     * <strong>Hotel</strong> object, ensuring
     * that in the manager object, the hotel is also changed, eliminating the
     * previous reference and fulfilling the
     * binary relationship (1..1).
     * 
     * @param manager The manager object to be asigned.
     * @version 1.0
     * @author Karlo1938
     */
    public void addManager(Manager manager) {
        if (manager.getHotel() != null)
            manager.getHotel().setManager(null);
        this.manager = manager;
        manager.setHotel(this);
    }

    /**
     * <strong>Retrieves the Room object</strong> from the rooms array when the room
     * number is specified.
     * 
     * @param number integer number of the room.
     * @return Room object if it exists in the array of room objects attribute of
     *         the <strong>Hotel</strong> object.
     * @version 1.0
     * @author Karlo1938
     */
    public Room getRoom(int number) {

        for (int a = 0; a < rooms.length; a++) {
            if (rooms[a].getNumber() == number)
                return rooms[a];
        }
        return null;
    }

    /**
     * <strong>Searches for a Guest</strong> object within the ArrayList attributes
     * of Guest objects within the Stay objects
     * contained in the ArrayList Stays attribute of the Room objects contained in
     * the array of room objects attribute.
     * 
     * @param identifer The String identifier attribute of Guest object.
     * @return The Guest object corresponding to the provided identifier, or null if
     *         not found.
     * @version 1.0
     * @author Karlo1938
     */
    public Guest getGuestOfStays(String identifer) {
        for (Room room : rooms) {

            for (Stay stay : room.getStays()) {
                for (Guest guest : stay.getGuests()) {
                    if (guest.getIdentifier().equals(identifer))
                        return guest;
                }
            }
        }
        return null;
    }

    /**
     * <strong>Updates the Disponibility attribute of Room objects</strong> in
     * correspondence to the stays at the time of execution.
     * This method adjusts the availability of rooms based on current stays.
     * 
     * @version 1.0
     * @author Karlo1938
     */
    public void setDisponibility() {
        for (Room room : rooms) {
            room.setAvailability();
        }
    }

    public Stay getStay(int id) {
        for (Room room : rooms) {
            for (Stay stay : room.getStays()) {
                if (stay.getId() == id)
                    return stay;
            }
        }

        return null;
    }

}
