package fr.poly.eventmanager.restapi;


import fr.poly.eventmanager.entities.Event;
import fr.poly.eventmanager.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventRestController {

    @Autowired
    private EventService es;

    @GetMapping
    public List<Event> getAllEvents(){
        return es.getAllEvents();
    }

    @GetMapping("/{eventId}")
    public Event getEventById(@PathVariable Integer eventId){
        return es.getEvent(eventId);
    }

    @PostMapping
    public Event addOrUpdateEvent(@RequestBody Event event){
        return es.createOrUpdate(event);
    }

    @DeleteMapping("/{eventId}")
    public void deleteEvent(@PathVariable Integer eventId){
        es.deleteEvent(eventId);
    }
}
