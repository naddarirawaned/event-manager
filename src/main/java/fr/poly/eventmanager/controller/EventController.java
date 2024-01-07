package fr.poly.eventmanager.controller;

import fr.poly.eventmanager.dto.EventDto;
import fr.poly.eventmanager.entities.Event;
import fr.poly.eventmanager.entities.EventAddress;
import fr.poly.eventmanager.services.EventAddressService;
import fr.poly.eventmanager.services.EventService;
import fr.poly.eventmanager.services.ThemeService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
@RequestMapping("/eventapi")
public class EventController {
    @Autowired
    EventService es;
    @Autowired
    ThemeService ts;
    @Autowired
    EventAddressService as;

    @GetMapping("/all")
    public String getAll(Model model) {
        List<Event> events = es.getAllEvents();
        model.addAttribute("events", events);

        return "events";
    }

    @GetMapping("/addevent")
    public String addEvent(Model m) {
        m.addAttribute("listTheme", ts.getAllThemes());
        return "addevent";
    }

    @GetMapping("/eventmc")
    public String getEventBMC(@RequestParam String mc, Model m) {
        List<Event> events = es.searchByName(mc);
        m.addAttribute("events", events);
        return "events";
    }

    @PostMapping("/saveevent")
    public ModelAndView saveEvent(@ModelAttribute Event e, @RequestParam("file") MultipartFile file, @ModelAttribute EventAddress a) throws IOException {

        as.addAddress(a);
        e.setAddress(a);
        es.saveEvent(e, file);
        return new ModelAndView("redirect:/eventapi/all");
    }


    @GetMapping(value = "/images/{imageNameOnServer}",
        produces = MediaType.IMAGE_JPEG_VALUE)

    public @ResponseBody
    byte[] getImage(@PathVariable String imageNameOnServer) throws IOException {
        InputStream in = new FileInputStream(System.getProperty("user.home") + File.separator + "images2022" + File.separator + imageNameOnServer);
        return IOUtils.toByteArray(in);
    }

    @PostMapping("/deleteevent/{id}")
    public String deleteEvent(@PathVariable int id) {
        es.deleteEvent(id);
        return "redirect:/eventapi/all";

    }

    @GetMapping("/event/{id}")
    public String getEvent(Model m, @PathVariable int id){
        Event event = es.getEvent(id);
        m.addAttribute("listTheme", ts.getAllThemes());
        m.addAttribute("event", event);

        return "event";
    }


    @PostMapping("/event")
    public ModelAndView updateEvent(@ModelAttribute EventDto eventDto, Model m){
        es.update(eventDto);
        return new ModelAndView("redirect:/eventapi/all");
    }

}







