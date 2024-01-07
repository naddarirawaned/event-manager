package fr.poly.eventmanager.controller;

import fr.poly.eventmanager.entities.Theme;
import fr.poly.eventmanager.services.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/themeapi")
public class ThemeController {
    @Autowired
    ThemeService ts;

    @GetMapping("/all")
    public String getAll(Model m) {
        List<Theme> themes = ts.getAllThemes();
        m.addAttribute("themes", themes);

        return "themes";
    }
    @GetMapping("/addtheme")
    public String addTheme() {
        return "addtheme";
    }


    @PostMapping("/savetheme")
    public String saveEvent(Theme t) {
        ts.addTheme(t);
        return ("redirect:/themeapi/all");
    }



    @PostMapping("/deletetheme/{id}")
    public String deleteTheme(@PathVariable int id ){
        ts.deleteTheme(id);

        return ("redirect:/themeapi/all");
    }

}
