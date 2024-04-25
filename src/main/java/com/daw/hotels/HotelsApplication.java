package com.daw.hotels;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.daw.hotels.classes.Hotel;
import com.daw.hotels.classes.Manager;
import com.daw.hotels.classes.enumerations.Enumerations;

@SpringBootApplication
public class HotelsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelsApplication.class, args);
		
	}

}
