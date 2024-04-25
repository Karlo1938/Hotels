package com.daw.hotels.classes;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.daw.hotels.classes.enumerations.Enumerations;
import com.daw.hotels.classes.interfaces.StayInterface;

public class Stay implements StayInterface {
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private Room room;
        private ArrayList<Guest> guests;
        
                    //////////////////////////////////////////////TO STRING///////////////////////////////////////////////////

        @Override
        public String toString() {
            return "Stay [startDate=" + startDate + ", endDate=" + endDate + ", room=" + room + ", guests=" + guests.toString()
                    + "]";
        }

                    //////////////////////////////////////////////CONSTRUCTORS///////////////////////////////////////////////

        public Stay(LocalDateTime startDate, LocalDateTime endDate, Room room) {
            this.startDate = startDate;
            this.endDate = endDate;
            this.room = room;
            this.guests = new ArrayList<>(3);
        }

                    ///////////////////////////////////////////GETTERS AND SETTERS///////////////////////////////////////////

        public LocalDateTime getStartDate() {
            return startDate;
        }

        public void setStartDate(LocalDateTime startDate) {
            this.startDate = startDate;
        }

        public LocalDateTime getEndDate() {
            return endDate;
        }

        public void setEndDate(LocalDateTime endDate) {
            this.endDate = endDate;
        }

        public Room getRoom() {
            return room;
        }

        public void setRoom(Room room) {
            this.room = room;
        }

        public ArrayList<Guest> getGuests() {
            return guests;
        }

        public void setGuests(ArrayList<Guest> guests) {
            this.guests = guests;
        }

                    /////////////////////////////////////////////METHODS///////////////////////////////////////////////////

        public boolean addGuest(String identifier, String name, String nationality){
            
            if (this.room.gettRoom() == Enumerations.RoomType.Double && guests.size() == 2 ) return false;
            if (this.guests.size() == 3) return false;
            
            Guest guest = this.room.getHotel().getGuestOfStays(identifier);
            if (guest == null) guest = new Guest(identifier, name, nationality);

            guests.add(guest);
            guest.addStay(this);
            
            return true;
        }

        public boolean removeGuest(String identifierGuest){
            
            if ((guests.size() > 0)){
                for (int a=0; a<guests.size(); a++){
                    if (guests.get(a).identifier.equals(identifierGuest)) {
                        guests.remove(a);
                        return true;
                    }
                }
            }
            return false;
        }
}
