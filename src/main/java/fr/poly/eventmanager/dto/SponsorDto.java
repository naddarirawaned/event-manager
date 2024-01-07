package fr.poly.eventmanager.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SponsorDto {
    private Integer id;
    private String name;
    private Double donation;
    private List<EventDto> Events = new ArrayList<>();
}
