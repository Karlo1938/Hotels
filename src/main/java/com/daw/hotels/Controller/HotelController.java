package com.daw.hotels.Controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.daw.hotels.classes.Guest;
import com.daw.hotels.classes.Hotel;
import com.daw.hotels.classes.Manager;
import com.daw.hotels.classes.Person;
import com.daw.hotels.classes.Room;
import com.daw.hotels.classes.Stay;
import com.daw.hotels.classes.DTO.SelectRoom;

import jakarta.servlet.http.HttpSession;

import com.daw.hotels.classes.DTO.Credentials;
import com.daw.hotels.classes.DTO.Guests;
import com.daw.hotels.classes.DTO.PersonDTO;

@Controller
public class HotelController {

        @Autowired
        Hotel hotel;

        @GetMapping("/")
        public String login(Model model, HttpSession session){
            if (hotel.getManager().isAuthenticated()) return "redirect:manager";
            model.addAttribute("credentials", new Credentials());
            return "login";
        }
        @GetMapping("/login")
        public String loginget(Model model, HttpSession session){
            if (hotel.getManager().isAuthenticated()) return "redirect:manager";
            model.addAttribute("credentials", new Credentials());
            return "login";
        }

        @GetMapping("/logout")
        public String logout(HttpSession session){
            
            hotel.getManager().setAuthenticated(false);
            return "redirect: ";
        }

        @PostMapping("/login")
        public String login(Model model, @ModelAttribute Credentials credentials, HttpSession session){
            if (hotel.getManager().isAuthenticated()) return "redirect:manager";

            if (!hotel.getManager().validate(credentials.getUsername(), credentials.getPassword())) {
                model.addAttribute("message", "incorrect credentials");
                System.out.println("bad");
                return "login";
                
            }
            System.out.println("good");
            
            return "redirect:manager";
        }

        @GetMapping("/manager")
        public String manager(Model model){
            
            
            if (!hotel.getManager().isAuthenticated()) return "redirect: ";
            
            return "manager";
        }

        @GetMapping("/addstay")
        public String addStayGet(Model model){
            if (!hotel.getManager().isAuthenticated()) return "redirect: ";
            hotel.setDisponibility();
            
            Room[] rooms = hotel.getRooms();
            model.addAttribute("select_room", new SelectRoom());
            model.addAttribute("rooms", rooms);
            model.addAttribute("now", LocalDateTime.now() );
            return "addstay";
        }

        @PostMapping("/addstay")
        public String addStayPost(Model model, @ModelAttribute SelectRoom select_room, HttpSession session){
            if (!hotel.getManager().isAuthenticated()) return "redirect: ";
                
                session.setAttribute("room_number", select_room.getRoomNumber());
                
                switch (hotel.getRoom(select_room.getRoomNumber()).gettRoom()) {
                    case Individual:
                        session.setAttribute("persons", 1);
                        
                        break;
                    
                    case Double:
                        session.setAttribute("persons", 2);
                            
                        break;
    
                    case Suite:
                        session.setAttribute("persons", 3);
                           
                        break;
                }

            return "redirect:addguests";
        }
        
        @GetMapping("/addguests")
        public String addGuest(Model model, HttpSession session){
            
            model.addAttribute("create_guest", new Guests());
            int room_number = (int)session.getAttribute("room_number");
            Room room = hotel.getRoom(room_number);
            if (room == null) model.addAttribute("message", "habitación no encontrada.");

            model.addAttribute("persons", (int)session.getAttribute("persons"));
            model.addAttribute("nextStays", room.nextStays());
            model.addAttribute("guests", new Guests());

            return "addguest";
        }

        @PostMapping("/addguests")
        public String addGuest(Model model, @ModelAttribute Guests guests, HttpSession session){
            
            model.addAttribute("persons", (int)session.getAttribute("persons"));
            int room_number = (int)session.getAttribute("room_number");
            Room room = hotel.getRoom(room_number);

            
            if (room == null) model.addAttribute("message", "habitación no encontrada.");
            

            String identifier[] = new String[3];
            identifier[0] = guests.getIdentifier1();
            identifier[1] = guests.getIdentifier2();
            identifier[2] = guests.getIdentifier3();
            
            if (identifier[0] == identifier[1] || identifier[0] == identifier[2] || (identifier[1] == identifier[2] && identifier[1]!="" && identifier[1]!=null)){
                model.addAttribute("message", "Identificador repetido");
                return "addguest";
            }

            String name[] = new String[3];
            name[0] = guests.getName1();
            name[1] = guests.getName2();
            name[2] = guests.getName3();

            String nationality[] = new String[3];
            nationality[0] = guests.getNationality1();
            nationality[1] = guests.getNationality2();
            nationality[2] = guests.getNationality3();
            
            LocalDateTime startDateTime = guests.getStartDateTime();
            LocalDateTime endDateTime = guests.getEndDateTime();
            
            Stay stay = new Stay(startDateTime, endDateTime, room);

            for(int a=0; a<3; a++){
                
                if (identifier[a] != "" && identifier[a] != null){
                    
                    if (name[a] == "" && name[a] == null) {
                        model.addAttribute("message", "Introduzca un nombre al huesped "+a+".");
                        return "addguest";
                    }
                    
                    if (nationality[a] == "" && name[a] == null) {
                        model.addAttribute("message", "Introduzca una nacionalidad al huesped "+a+".");
                        return "addguest";
                    }
                    
                    if (!stay.addGuest(identifier[a], name[a], nationality[a])){
                        model.addAttribute("message", "no se puede agregar a más personas.");
                        return "addguest";
                    }
                }
                
            }
            System.out.println(stay);
            int state = hotel.getManager().addStayToTheRoom(stay);

            switch (state) {
                case 1:
                    model.addAttribute("message", "¡La fecha de salida debe ser antes que la fecha de inicio!");
                    return "addguest";
            
                case 2:
                    model.addAttribute("message", "La fecha de inicio puede ser como máximo 30 minutos antes.");
                    return "addguest";
                    
                case 3:
                        model.addAttribute("message", "habitación no disponible en el intervalo de fechas seleccionado.");
                        return "addguest";
            }

            model.addAttribute("nextStays", room.nextStays());

            model.addAttribute("message", "reserva efectuada correctamente.");
            return "addguest";
        }

        @GetMapping("/changemanager")
        public String changemanager(Model model){
            if (!hotel.getManager().isAuthenticated()) return "redirect: ";
            model.addAttribute("persondto", new PersonDTO());

            return "changemanager";
        }

        @PostMapping("/changemanager")
        public String changemanager(Model model, @ModelAttribute PersonDTO persondto){
            if (!hotel.getManager().isAuthenticated()) return "redirect: ";
            model.addAttribute("persondto", new PersonDTO());
            
            String identifier = persondto.getIdentifier();
            
            LocalDate startDate = persondto.getStartDate();

            if (startDate.isAfter(LocalDate.now())) {
                model.addAttribute("message", "la fecha de inicio debe ser menor a la actual.");
                return "changemanager";
            }

            String name = persondto.getName();
            String username = persondto.getUsername();
            String password = persondto.getPassword();

            Manager manager = new Manager(identifier, name, startDate, username, password, hotel);
            hotel.setManager(manager);

            manager.setAuthenticated(false);
            //inicio con nuevo manager.
            return "redirect: ";
        }

        @GetMapping("/modificar")
        public String modifyStay(Model model,@RequestParam(value = "id", required = false) int id, @RequestParam(value = "identifier", required = false) String identifier , @RequestParam(value = "delete", required = false) boolean delete){
            
            model.addAttribute("id", id);
            
            Stay stay = hotel.getStay(id);

            model.addAttribute("guests", stay.getGuests());

            System.out.println(delete);
            System.out.println(identifier);
            System.out.println(id);

            if (delete == true && identifier != null) {
                if (stay.removeGuest(identifier)){
                    model.addAttribute("message", "borrado con exito.");
                    return "modify";
                }
                else {
                    model.addAttribute("message", "No se puede borrar al primer huesped.");
                    return "modify";
                }
            }
            return "modify";
        }




}
