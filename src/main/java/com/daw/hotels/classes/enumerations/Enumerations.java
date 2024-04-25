package com.daw.hotels.classes.enumerations;

public class Enumerations {

    public enum HotelCategory{
        One_Star(1),
        Two_Stars(2),
        Three_Stars(3),
        Four_Stars(4),
        Five_Stars(5),
        Six_Stars(6);
        
        private final int number;

    
        private HotelCategory(int number) {
            this.number = number;
        }
        public int getNumero() {
            return number;
        }
    }

    public enum RoomType{
        Individual,
        Double,
        Suite, RoomType
    }

}
