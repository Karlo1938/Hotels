package com.daw.hotels.classes;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.daw.hotels.classes.enumerations.Enumerations;
import com.daw.hotels.classes.interfaces.StayInterface;

public class Stay implements StayInterface {

    public static int contador = 0;
    private int id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Room room;
    private ArrayList<Guest> guests;

    /////////////////// TO STRING///////////////////////////////

    @Override
    public String toString() {
        return "Stay [startDate=" + startDate + ", endDate=" + endDate + ", room=" + room + ", guests="
                + guests.toString()
                + "]";
    }

    ////////////////////// CONSTRUCTORS ////////////////////////////

    public Stay(LocalDateTime startDate, LocalDateTime endDate, Room room) {
        this.id = contador;
        contador++;
        this.startDate = startDate;
        this.endDate = endDate;
        this.room = room;
        this.guests = new ArrayList<>(3);
    }

    /////////////////// GETTERS AND SETTERS /////////////////////////////

    /**
     * <strong>Getter</strong> for the "startDate" LocalDate attribute of
     * <strong>Stay</strong>
     * object.
     * 
     * @return The "startDate" LocalDate attribute of the <strong>Stay</strong>
     *         object.
     * @version 1.0
     * @author Karlo1938
     */
    public LocalDateTime getStartDate() {
        return startDate;
    }

    /**
     * <strong>Setter</strong> for the "startDate" LocalDate attribute of
     * <strong>Stay</strong> object.
     * 
     * @param number The "startDate" LocalDate to set "startDate" LocalDate
     *               attribute.
     * @version 1.0
     * @author Karlo1938
     */
    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    /**
     * <strong>Getter</strong> for the "endDate" LocalDate attribute of
     * <strong>Stay</strong>
     * object.
     * 
     * @return The "endDate" LocalDate attribute of the <strong>Stay</strong>
     *         object.
     * @version 1.0
     * @author Karlo1938
     */
    public LocalDateTime getEndDate() {
        return endDate;
    }

    /**
     * <strong>Setter</strong> for the "endDate" LocalDate attribute of
     * <strong>Stay</strong> object.
     * 
     * @param number The "endDate" LocalDate to set "endDate" LocalDate attribute.
     * @version 1.0
     * @author Karlo1938
     */
    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    /**
     * <strong>Getter</strong> for the "room" object attribute of
     * <strong>Stay</strong>
     * object.
     * 
     * @return The "room" Room object attribute of the <strong>Stay</strong> object.
     * @version 1.0
     * @author Karlo1938
     */
    public Room getRoom() {
        return room;
    }

    /**
     * <strong>Setter</strong> for the "room" Room object attribute of
     * <strong>Stay</strong> object.
     * 
     * @param number The "room" Room object to set "room" object attribute.
     * @version 1.0
     * @author Karlo1938
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    /**
     * <strong>Getter</strong> for the "guests" ArrayList attribute of
     * <strong>Stay</strong> object.
     * 
     * @return The "guests" ArrayList of guest objects attribute of the
     *         <strong>Stay</strong> object.
     * @version 1.0
     * @author Karlo1938
     */
    public ArrayList<Guest> getGuests() {
        return guests;
    }

    /**
     * <strong>Setter</strong> for the "guests" ArrayList attribute of the
     * <strong>Stay</strong> object.
     * 
     * @param stays The ArrayList of guest objects to set the "guests" Attribute.
     * @version 1.0
     * @author Karlo1938
     */
    public void setGuests(ArrayList<Guest> guests) {
        this.guests = guests;
    }

    /**
     * <strong>Getter</strong> for the "counter" static attribute.
     * 
     * @return The value of the static counter.
     * @version 1.0
     * @author Karlo1938
     */
    public static int getContador() {
        return contador;
    }

    /**
     * <strong>Setter</strong> for the "counter" static attribute.
     * 
     * @return A number integer to set the "counter" static attribute.
     * @version 1.0
     * @author Karlo1938
     */
    public static void setContador(int contador) {
        Stay.contador = contador;
    }

    /**
     * <strong>Getter</strong> for the "id" int attribute of
     * <strong>Stay</strong> object.
     * 
     * @return The "id" int attribute of the <strong>Stay</strong>
     *         object.
     * @version 1.0
     * @author Karlo1938
     */
    public int getId() {
        return id;
    }

    /**
     * <strong>Setter</strong> for the "id" int attribute of
     * <strong>Stay</strong> object.
     * 
     * @param number The "id" int to set "id" int attribute.
     * @version 1.0
     * @author Karlo1938
     */
    public void setId(int id) {
        this.id = id;
    }

    ///////////////////////////////////////////// METHODS///////////////////////////////////////////////////

    /**
     * This method adds a guest to the stay, creating a new guest object or reusing
     * a previous one.
     * 
     * @param identifier  guest identifier
     * @param name        guest name
     * @param nationality guest nationality
     * @return false if the maximum number of guests per stay has already been
     *         reached, checking the room type.
     * @author Karlo1938
     * @version 1.0
     */
    public boolean addGuest(String identifier, String name, String nationality) {

        if (this.room.gettRoom() == Enumerations.RoomType.Double && guests.size() == 2)
            return false;
        if (this.guests.size() == 3)
            return false;

        Guest guest = this.room.getHotel().getGuestOfStays(identifier);
        if (guest == null)
            guest = new Guest(identifier, name, nationality);

        guests.add(guest);
        guest.addStay(this);

        return true;
    }

    /**
     * Removes a guest from the stay, leaving a maximum of one.
     * 
     * @param identifier guest identifier
     * @return false if the maximum number has been reached.
     * @author Karlo1938
     * @version 1.0
     */
    public boolean removeGuest(String identifierGuest) {

        if ((guests.size() > 1)) {
            for (int a = 0; a < guests.size(); a++) {
                if (guests.get(a).identifier.equals(identifierGuest)) {
                    guests.remove(a);
                    return true;
                }
            }
        }
        return false;
    }
}
