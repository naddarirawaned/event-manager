package fr.poly.eventmanager.dto;

import lombok.Data;


@Data
public class EventDto {
    private int id;
    private String name;
    private double price;
    private String animator;
    private int ThemeId;
    private String ThemeName;
}
