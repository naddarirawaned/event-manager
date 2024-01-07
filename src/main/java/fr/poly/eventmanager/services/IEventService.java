package fr.poly.eventmanager.services;


import fr.poly.eventmanager.entities.Event;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IEventService {
    void saveEvent(Event e, MultipartFile mf) throws IOException;

    List<Event> getAllEvents();

    Event getEvent(int id);

    List<Event> searchByName(String mc);

    void deleteEvent(int id);

    String saveImage(MultipartFile mf) throws IOException;

    byte[] getImage(int id) throws IOException;


    Event createOrUpdate(Event event);
}
