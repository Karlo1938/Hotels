package com.daw.hotels.classes.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.cglib.core.Local;

public class Guests {
    private String identifier1;
    private String name1;
    private String nationality1;

    private String identifier2;
    private String name2;
    private String nationality2;

    private String identifier3;
    private String name3;
    private String nationality3;
    
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    public String getIdentifier1() {
        return identifier1;
    }
    public void setIdentifier1(String identifier1) {
        this.identifier1 = identifier1;
    }
    public String getName1() {
        return name1;
    }
    public void setName1(String name1) {
        this.name1 = name1;
    }
    public String getNationality1() {
        return nationality1;
    }
    public void setNationality1(String nationality1) {
        this.nationality1 = nationality1;
    }
    public String getIdentifier2() {
        return identifier2;
    }
    public void setIdentifier2(String identifier2) {
        this.identifier2 = identifier2;
    }
    public String getName2() {
        return name2;
    }
    public void setName2(String name2) {
        this.name2 = name2;
    }
    public String getNationality2() {
        return nationality2;
    }
    public void setNationality2(String nationality2) {
        this.nationality2 = nationality2;
    }
    public String getIdentifier3() {
        return identifier3;
    }
    public void setIdentifier3(String identifier3) {
        this.identifier3 = identifier3;
    }
    public String getName3() {
        return name3;
    }
    public void setName3(String name3) {
        this.name3 = name3;
    }
    public String getNationality3() {
        return nationality3;
    }
    public void setNationality3(String nationality3) {
        this.nationality3 = nationality3;
    }
    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }
    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }
    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }
    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    
}